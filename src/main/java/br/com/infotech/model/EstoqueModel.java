package br.com.infotech.model;

public class EstoqueModel {

    private Long id;

    private Integer quantidade;

    private ProdutoModel produto;

    public Long getId() {
        return id;
    }

    public EstoqueModel setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public EstoqueModel setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public EstoqueModel setProduto(ProdutoModel produto) {
        this.produto = produto;
        return this;
    }

}
