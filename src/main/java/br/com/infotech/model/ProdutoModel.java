package br.com.infotech.model;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProdutoModel {

    private Long id;

    private String uuid;
    private String descricao;
    private BigDecimal valor;
    private EstoqueModel estoque;
    private LocalDate dataCadastro;
    private List<CaracteriscaModel> caracteristicas;

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

    public EstoqueModel getEstoque() {
        return estoque;
    }

    public ProdutoModel setEstoque(EstoqueModel qtdEstoque) {
        this.estoque = qtdEstoque;
        return this;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public ProdutoModel setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
        return this;
    }

    public List<CaracteriscaModel> getCaracteristicas() {
        return caracteristicas;
    }

    public ProdutoModel setCaracteristicas(List<CaracteriscaModel> caracteristicas) {
        this.caracteristicas = caracteristicas != null ?
                new ArrayList<>(caracteristicas) : // Garante que seja mutável
                new ArrayList<>();
        return this;
    }

}
