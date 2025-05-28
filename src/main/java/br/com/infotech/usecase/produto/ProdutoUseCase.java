package br.com.infotech.usecase.produto;

import br.com.infotech.model.ProdutoModel;

import java.util.List;

public interface ProdutoUseCase {

    void cadastrarProduto(ProdutoModel produtoModel);

    List<ProdutoModel> listarTodos();

}
