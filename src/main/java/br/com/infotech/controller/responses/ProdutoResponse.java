package br.com.infotech.controller.responses;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoResponse {

    private Long id;
    private String descricao;
    private BigDecimal valor;
    private String caracteristica;
    private LocalDate dataCadastro;
    private Boolean gamer;
    private String foto;

    public ProdutoResponse(Long id, String descricao, BigDecimal valor, String caracteristica, LocalDate dataCadastro, Boolean gamer, String foto){
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.caracteristica = caracteristica;
        this.dataCadastro = dataCadastro;
        this.gamer = gamer;
        this.foto = foto;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Boolean getGamer() {
        return gamer;
    }

    public void setGamer(Boolean gamer) {
        this.gamer = gamer;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
//private String valor BIGdecimal;