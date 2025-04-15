package br.com.infotech.controller.requests;

import java.util.List;
import java.util.UUID;

public class CaracteristicaRequest {

    //FK
    private UUID idProduto;

    //FK representada como um UUID
    private UUID foreignKeyId;

    private List<String> descricao;

    public UUID getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(UUID idProduto) {
        this.idProduto = idProduto;
    }

    public UUID getForeignKeyId() {
        return foreignKeyId;
    }

    public void setForeignKeyId(UUID foreignKeyId) {
        this.foreignKeyId = foreignKeyId;
    }

    public List<String> getDescricao() {
        return descricao;
    }

    public void setDescricao(List<String> descricao) {
        this.descricao = descricao;
    }
}

//create - post
//read - get
//update - patch