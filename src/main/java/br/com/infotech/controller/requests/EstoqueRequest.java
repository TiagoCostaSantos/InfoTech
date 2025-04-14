package br.com.infotech.controller.requests;

import java.util.UUID;

public class EstoqueRequest {

    private Long id;

    //FK - tabela produto
    private UUID idProduto;

    private Double quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(UUID idProduto) {
        this.idProduto = idProduto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}
// id , UUID, qtde

// post
// update