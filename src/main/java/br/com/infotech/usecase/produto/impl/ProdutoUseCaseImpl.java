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


        CaracteristicaEntity ce = new CaracteristicaEntity();
        ce.setDescricao("Uma das caracs aqui");
        ce.setProduto(pe);

        CaracteristicaEntity ce2 = new CaracteristicaEntity();
        ce2.setDescricao("OF THE KING OF THE POWER DOES MATCH");
        ce2.setProduto(pe);

        CaracteristicaEntity ce3 = new CaracteristicaEntity();
        ce3.setDescricao("FRULLY FRULLA COM Y E SEM Y PARA COM LIMITE DE PELO MENOS DUZENTO E CINQUENTA E CINCO CARACTERES");
        ce3.setProduto(pe);

        List<CaracteristicaEntity> todasCaracsAqui = List.of(ce, ce2, ce3);

        var caracs = caracteristicaRepository.saveAll(todasCaracsAqui);
        pe.setCaracteristicas(caracs);


    }

    @Override
    public List<ProdutoModel> listarTodos() {
        List<ProdutoEntity> entities = computadorRepository.findAll();
        return entities.stream().map(this::entityToModel).collect(Collectors.toList());
    }

    private ProdutoModel entityToModel(ProdutoEntity entity) {
        ProdutoModel model = new ProdutoModel();
        model.setId(entity.getId());
        model.setDescricao(entity.getDescricao());
        model.setValor(entity.getValor());
        model.setDataCadastro(entity.getDataCadastro());
        return model;
    }


}
