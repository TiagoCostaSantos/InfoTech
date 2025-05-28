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
    private List<String> caracteristicas;

    public Long getId() {
        return id;
    }

    public ProdutoModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public ProdutoModel setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public ProdutoModel setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public ProdutoModel setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public ProdutoModel setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
        return this;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public ProdutoModel setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
        return this;
    }

    public List<String> getCaracteristicas() {
        return caracteristicas;
    }

    public ProdutoModel setCaracteristicas(List<String> caracteristicas) {

        this.caracteristicas = (caracteristicas == null ? List.of() :
                caracteristicas.stream()
                        .filter(c -> c != null && !c.trim().isEmpty())
                        .toList());
        return this;
    }

}
