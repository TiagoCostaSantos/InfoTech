package br.com.infotech.usecase.produto.impl;

import br.com.infotech.database.entity.ComputadorEntity;
import br.com.infotech.database.repository.ComputadorRepository;
import br.com.infotech.model.ProdutoModel;
import br.com.infotech.usecase.produto.ProdutoUseCase;
import org.springframework.stereotype.Service;

@Service
public class ProdutoUseCaseImpl implements ProdutoUseCase {

    private final ComputadorRepository computadorRepository;

    public ProdutoUseCaseImpl(ComputadorRepository computadorRepository) {
        this.computadorRepository = computadorRepository;
    }


    public void cadastrarProduto(ProdutoModel produtoModel) {
        ComputadorEntity entity = new ComputadorEntity();
        entity.setDescricao(produtoModel.getDescricao());
        entity.setValor(produtoModel.getValor());
        entity.setCaracteristica(produtoModel.getCaracteristica());
        entity.setDataCadastro(produtoModel.getDataCadastro());
        entity.setGamer(produtoModel.getGamer());
        computadorRepository.save(entity);
    }
}
