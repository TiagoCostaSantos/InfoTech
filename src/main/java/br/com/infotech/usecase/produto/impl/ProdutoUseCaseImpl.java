package br.com.infotech.usecase.produto.impl;

import br.com.infotech.database.entity.ProdutoEntity;
import br.com.infotech.database.repository.ProdutoRepository;
import br.com.infotech.model.ProdutoModel;
import br.com.infotech.usecase.produto.ProdutoUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoUseCaseImpl implements ProdutoUseCase {

    private final ProdutoRepository computadorRepository;

    public ProdutoUseCaseImpl(ProdutoRepository computadorRepository) {
        this.computadorRepository = computadorRepository;
    }


    public void cadastrarProduto(ProdutoModel produtoModel) {
        ProdutoEntity entity = new ProdutoEntity();
        entity.setDescricao(produtoModel.getDescricao());
        entity.setValor(produtoModel.getValor());
        entity.setCaracteristica(produtoModel.getCaracteristica());
        entity.setDataCadastro(produtoModel.getDataCadastro());
        entity.setGamer(produtoModel.getGamer());
        entity.setUuid(produtoModel.getUuid());
        computadorRepository.save(entity);
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
        model.setCaracteristica(entity.getCaracteristica());
        model.setDataCadastro(entity.getDataCadastro());
        model.setGamer(entity.getGamer());
        return model;
    }
}
