package br.com.infotech.model;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "computador")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String descricao;
    @Column(nullable = false, length = 50)
    private BigDecimal valor;
    @Column(nullable = false, length = 36, unique = true)
    private String caracteristica;
    private LocalDate data_cadastro;
    private Boolean gamer;

    @Lob
    private String foto;

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

    public LocalDate getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDate data_cadastro) {
        this.data_cadastro = data_cadastro;
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

    public void setDataCadastro(LocalDate dataCadastro) {
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