package br.com.infotech.model;


import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoModel {

    private Long id;

    private String descricao;
    private BigDecimal valor;
    private String caracteristica;
    private LocalDate dataCadastro;
    private Boolean gamer;



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

}

//id INT AUTO_INCREMENT PRIMARY KEY,
//descricao VARCHAR(50) NOT NULL,
//valor VARCHAR(50) NOT NULL,
//caracteristica VARCHAR(36) NOT NULL,
//data_cadastro DATE,
//gamer INT(1),
//foto LONGTEXT,
//CONSTRAINT uq_caracteristica UNIQUE (caracteristica)