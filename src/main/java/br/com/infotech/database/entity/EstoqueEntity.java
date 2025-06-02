package br.com.infotech.database.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "estoque")
public class EstoqueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantidade;

    @OneToOne@JoinColumn(name = "produto_id")
    private ProdutoEntity produto;

    public Long getId() {
        return id;
    }

    public EstoqueEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public EstoqueEntity setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public ProdutoEntity getProduto() {
        return produto;
    }

    public EstoqueEntity setProduto(ProdutoEntity produto) {
        this.produto = produto;
        return this;
    }
}
