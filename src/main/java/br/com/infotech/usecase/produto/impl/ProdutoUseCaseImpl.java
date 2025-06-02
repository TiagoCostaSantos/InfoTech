package br.com.infotech.usecase.produto.impl;

import br.com.infotech.database.entity.CaracteristicaEntity;
import br.com.infotech.database.entity.EstoqueEntity;
import br.com.infotech.database.entity.ProdutoEntity;
import br.com.infotech.database.repository.CaracteristicaRepository;
import br.com.infotech.database.repository.EstoqueRepository;
import br.com.infotech.database.repository.ProdutoRepository;
import br.com.infotech.model.CaracteriscaModel;
import br.com.infotech.model.EstoqueModel;
import br.com.infotech.model.ProdutoModel;
import br.com.infotech.usecase.produto.ProdutoUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProdutoUseCaseImpl implements ProdutoUseCase {

    private final ProdutoRepository computadorRepository;

    private final EstoqueRepository estoqueRepository;

    private final CaracteristicaRepository caracteristicaRepository;

    public ProdutoUseCaseImpl(ProdutoRepository computadorRepository,
                              EstoqueRepository estoqueRepository,
                              CaracteristicaRepository caracteristicaRepository) {
        this.computadorRepository = computadorRepository;
        this.estoqueRepository = estoqueRepository;
        this.caracteristicaRepository = caracteristicaRepository;
    }

    @Transactional
    public void cadastrarProduto(ProdutoModel produtoModel) {
        String uuidProduto = "".equals(produtoModel.getUuid()) ? null : produtoModel.getUuid();
        limparCaracteristicasVazias(produtoModel);
        if(Objects.isNull(uuidProduto)){
            ProdutoEntity pe = new ProdutoEntity();
            pe.setUuid(UUID.randomUUID().toString());
            pe.setDescricao(produtoModel.getDescricao());
            pe.setValor(produtoModel.getValor());
            pe.setDataCadastro(LocalDate.now());
            pe.setEstoque(new EstoqueEntity().setQuantidade(produtoModel.getEstoque().getQuantidade())
                    .setProduto(pe));
            pe.setCaracteristicas(produtoModel.getCaracteristicas()
                    .stream().map(cm -> new CaracteristicaEntity()
                            .setId(cm.getId())
                            .setDescricao(cm.getDescricao())
                            .setUuid(cm.getUuid())
                            .setProduto(pe))
                    .collect(Collectors.toList()));
            computadorRepository.save(pe);
        } else {
            var produtoOptional = computadorRepository.findByUuid(uuidProduto);
            if(produtoOptional.isEmpty()) throw new RuntimeException("Produto nao encontrado");
            var produtoEntity = produtoOptional.get();
            produtoEntity.setDescricao(produtoModel.getDescricao());
            produtoEntity.setValor(produtoModel.getValor());
            produtoEntity.getEstoque().setQuantidade(produtoModel.getEstoque().getQuantidade());
            validarCaracteristicas(produtoModel.getCaracteristicas(), produtoEntity);

            computadorRepository.save(produtoEntity);
        }


    }

    @Override
    public List<ProdutoModel> listarTodos() {
        List<ProdutoEntity> entities = computadorRepository.findAll();
        return entities.stream().map(this::entityToModel).collect(Collectors.toList());
    }

    @Override
    public ProdutoModel buscarProduto(String uuid) {
        var entity = computadorRepository.findByUuid(uuid);
        if(entity.isEmpty()){
            throw new RuntimeException("Nao encontrou produto");
        }
        var produtoEntity = entity.get();
        ProdutoModel p = new ProdutoModel()
                .setId(produtoEntity.getId())
                .setUuid(produtoEntity.getUuid())
                .setDescricao(produtoEntity.getDescricao())
                .setValor(produtoEntity.getValor())
                .setDataCadastro(produtoEntity.getDataCadastro())
                .setEstoque(new EstoqueModel().setId(produtoEntity.getEstoque().getId())
                        .setQuantidade(produtoEntity.getEstoque().getQuantidade()));
        return p.setCaracteristicas(produtoEntity.getCaracteristicas()
                .stream().map(cm -> new CaracteriscaModel()
                        .setId(cm.getId())
                        .setDescricao(cm.getDescricao())
                        .setUuid(cm.getUuid())
                        .setProduto(p))
                .collect(Collectors.toList()));
    }

    private ProdutoModel entityToModel(ProdutoEntity entity) {
        ProdutoModel model = new ProdutoModel();
        model.setId(entity.getId());
        model.setUuid(entity.getUuid());
        model.setDescricao(entity.getDescricao());
        model.setValor(entity.getValor());
        model.setDataCadastro(entity.getDataCadastro());
        model.setEstoque(new EstoqueModel().setId(entity.getEstoque().getId())
                .setQuantidade(entity.getEstoque().getQuantidade())
                .setProduto(model));

        return model;
    }

    private void limparCaracteristicasVazias(ProdutoModel produtoModel){
        if (produtoModel.getCaracteristicas() != null) {
            var caracteristicasValidas = produtoModel.getCaracteristicas()
                    .stream()
                    .filter(c -> c != null && c.getDescricao() != null && !c.getDescricao().trim().isEmpty())
                    .collect(Collectors.toList());
            produtoModel.setCaracteristicas(caracteristicasValidas);
        }
    }

    private void validarCaracteristicas(List<CaracteriscaModel> caracteristicasTela, ProdutoEntity produtoEntity){
        caracteristicasTela.forEach(tela -> {
            if(Objects.isNull(tela.getUuid())){
                produtoEntity.getCaracteristicas().add(new CaracteristicaEntity()
                        .setUuid(UUID.randomUUID().toString())
                        .setDescricao(tela.getDescricao())
                        .setProduto(produtoEntity));
            } else  {
                var caracteristicaEntityOpt = caracteristicaRepository.findByUuid(tela.getUuid());
                if(caracteristicaEntityOpt.isEmpty()) throw new RuntimeException("Caracteristica nao localizada");
                var caracteristicaEntity = caracteristicaEntityOpt.get();
                if(caracteristicaEntity.getUuid().equals(tela.getUuid()) && !caracteristicaEntity.getDescricao().equals(tela.getDescricao())){
                    produtoEntity.getCaracteristicas()
                            .stream()
                            .filter(c -> c.getUuid().equals(tela.getUuid()))
                            .forEach(c2 -> c2.setDescricao(tela.getDescricao()));
                }

            }
        });
    }

}
