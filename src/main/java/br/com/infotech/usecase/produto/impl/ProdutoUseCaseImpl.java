package br.com.infotech.usecase.produto.impl;

import br.com.infotech.database.entity.ProdutoEntity;
import br.com.infotech.database.repository.ProdutoRepository;
import br.com.infotech.model.ProdutoModel;
import br.com.infotech.usecase.produto.ProdutoUseCase;
import org.springframework.stereotype.Service;

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
        computadorRepository.save(entity);
    }
}
