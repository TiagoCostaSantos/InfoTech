package br.com.infotech.usecase.produto.impl;

import br.com.infotech.database.entity.CaracteristicaEntity;
import br.com.infotech.database.entity.EstoqueEntity;
import br.com.infotech.database.entity.ProdutoEntity;
import br.com.infotech.database.repository.CaracteristicaRepository;
import br.com.infotech.database.repository.EstoqueRepository;
import br.com.infotech.database.repository.ProdutoRepository;
import br.com.infotech.model.ProdutoModel;
import br.com.infotech.usecase.produto.ProdutoUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        ProdutoEntity pe = new ProdutoEntity();
        pe.setId(produtoModel.getId());
        pe.setDescricao(produtoModel.getDescricao());
        pe.setValor(produtoModel.getValor());
        pe.setDataCadastro(produtoModel.getDataCadastro());
        pe.setUuid(produtoModel.getUuid());

        var produto = computadorRepository.save(pe);

        EstoqueEntity et = new EstoqueEntity();
        et.setQuantidade(produtoModel.getQtdEstoque());
        et.setProduto(produto);
        var estoque = estoqueRepository.save(et);
        produto.setEstoque(estoque);

        List<CaracteristicaEntity> caracteristicasEntity = new ArrayList<>();

        produtoModel.getCaracteristicas().forEach(descricao -> {
            caracteristicasEntity.add(new CaracteristicaEntity().setDescricao(descricao).setProduto(pe));
        });

        var caracs = caracteristicaRepository.saveAll(caracteristicasEntity);
        pe.setCaracteristicas(caracs);


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
                .setQtdEstoque(produtoEntity.getEstoque().getQuantidade())
                .setDataCadastro(produtoEntity.getDataCadastro())
                .setCaracteristicas(produtoEntity.getCaracteristicas()
                        .stream()
                        .map(CaracteristicaEntity::getDescricao)
                        .toList()
                );
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
        model.setQtdEstoque(entity.getEstoque().getQuantidade());
        model.setDataCadastro(entity.getDataCadastro());
        return model;
    }


}
