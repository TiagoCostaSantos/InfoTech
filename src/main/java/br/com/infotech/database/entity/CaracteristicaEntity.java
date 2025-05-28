package br.com.infotech.database.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "caracteristica")
public class CaracteristicaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private ProdutoEntity produto;

    public Long getId() {
        return id;
    }

    public CaracteristicaEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public CaracteristicaEntity setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public ProdutoEntity getProduto() {
        return produto;
    }

    public CaracteristicaEntity setProduto(ProdutoEntity produto) {
        this.produto = produto;
        return this;
    }
}
