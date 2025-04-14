package br.com.infotech.controller.requests;

import java.util.List;
import java.util.UUID;

public class CaracteristicaRequest {

    //FK
    private UUID idProduto;

    private List<String> descricao;

    public UUID getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(UUID idProduto) {
        this.idProduto = idProduto;
    }

    public List<String> getDescricao() {
        return descricao;
    }

    public void setDescricao(List<String> descricao) {
        this.descricao = descricao;
    }
}

