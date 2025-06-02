package br.com.infotech.model;

public class CaracteriscaModel {

    private Long id;

    private String descricao;

    private String uuid;

    private ProdutoModel produto;

    public Long getId() {
        return id;
    }

    public CaracteriscaModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public CaracteriscaModel setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public CaracteriscaModel setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public CaracteriscaModel setProduto(ProdutoModel produto) {
        this.produto = produto;
        return this;
    }
}
