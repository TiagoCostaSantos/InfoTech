package br.com.infotech.model;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ProdutoModel {

    private Long id;

    private String uuid;
    private String descricao;
    private BigDecimal valor;
    private Integer qtdEstoque;
    private LocalDate dataCadastro;
    private Boolean gamer;
    private List<String> caracteristicas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
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

    public List<String> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<String> caracteristicas) {

        this.caracteristicas = (caracteristicas == null ? List.of() :
                caracteristicas.stream()
                        .filter(c -> c != null && !c.trim().isEmpty())
                        .toList());
    }
}
