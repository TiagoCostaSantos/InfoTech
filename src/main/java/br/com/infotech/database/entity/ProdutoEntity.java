package br.com.infotech.database.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String descricao;
    @Column(nullable = false, length = 50)
    private BigDecimal valor;
    private LocalDate dataCadastro;
    private String uuid;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estoque_id")
    private EstoqueEntity estoque;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CaracteristicaEntity> caracteristicas = new ArrayList<>();

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

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public EstoqueEntity getEstoque() {
        return estoque;
    }

    public void setEstoque(EstoqueEntity estoque) {
        this.estoque = estoque;
//        if (estoque != null){
//            estoque.setProduto(this);
//        }
    }

    public List<CaracteristicaEntity> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<CaracteristicaEntity> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}
