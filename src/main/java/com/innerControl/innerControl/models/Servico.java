package com.innerControl.innerControl.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private Date dataEntrada;
    private Date dataEntrega;
    @ManyToOne
    @JoinColumn(name = "pessoa_fisica_id", nullable = false)
    private PessoaFisica pessoa;

    private BigDecimal valor;

    @OneToMany(mappedBy = "servico", cascade = CascadeType.ALL)
    private List<ServicoProduto> produtosUtilizados;


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

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public PessoaFisica getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaFisica pessoa) {
        this.pessoa = pessoa;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<ServicoProduto> getProdutosUtilizados() {
        return produtosUtilizados;
    }

    public void setProdutosUtilizados(List<ServicoProduto> produtosUtilizados) {
        this.produtosUtilizados = produtosUtilizados;
    }
}
