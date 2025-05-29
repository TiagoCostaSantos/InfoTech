package br.com.infotech.usecase.produto.impl;

import br.com.infotech.database.entity.CaracteristicaEntity;
import br.com.infotech.database.entity.EstoqueEntity;
import br.com.infotech.database.entity.ProdutoEntity;
import br.com.infotech.database.repository.CaracteristicaRepository;
import br.com.infotech.database.repository.EstoqueRepository;
import br.com.infotech.database.repository.ProdutoRepository;
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

        if(Objects.isNull(uuidProduto)){
            ProdutoEntity pe = new ProdutoEntity();
            pe.setUuid(UUID.randomUUID().toString());
            pe.setDescricao(produtoModel.getDescricao());
            pe.setValor(produtoModel.getValor());
            pe.setDataCadastro(LocalDate.now());
            pe.setEstoque(new EstoqueEntity().setQuantidade(produtoModel.getEstoque().getQuantidade())
                    .setProduto(pe));
            computadorRepository.save(pe);
        } else {
            var produtoOptional = computadorRepository.findByUuid(uuidProduto);
            if(produtoOptional.isEmpty()) throw new RuntimeException("Produto nao encontrado");
            var produtoEntity = produtoOptional.get();
            produtoEntity.setDescricao(produtoModel.getDescricao());
            produtoEntity.setValor(produtoModel.getValor());
            produtoEntity.getEstoque().setQuantidade(produtoModel.getEstoque().getQuantidade());
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
        return new ProdutoModel()
                .setId(produtoEntity.getId())
                .setUuid(produtoEntity.getUuid())
                .setDescricao(produtoEntity.getDescricao())
                .setValor(produtoEntity.getValor())
                .setDataCadastro(produtoEntity.getDataCadastro())
//                .setCaracteristicas(produtoEntity.getCaracteristicas()
//                        .stream()
//                        .map(CaracteristicaEntity::getDescricao)
//                        .toList()
//                );
                .setEstoque(new EstoqueModel().setId(produtoEntity.getEstoque().getId())
                        .setQuantidade(produtoEntity.getEstoque().getQuantidade()));
    }

    /*

    private List<String> caracteristicas;
     */


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

}
