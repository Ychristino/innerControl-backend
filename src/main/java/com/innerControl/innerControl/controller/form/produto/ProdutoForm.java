package com.innerControl.innerControl.controller.form.produto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public class ProdutoForm {

    @NotEmpty(message = "Nome do produto deve ser informado!")
    @NotNull(message = "Nome do produto deve ser informado!")
    private String nome;
    private String descricao;
    @Positive(message = "Preço de venda deve ser positivo!")
    private BigDecimal precoVenda;
    @Positive(message = "Preço de custo deve ser positivo!")
    private BigDecimal precoCusto;
    @PositiveOrZero(message = "Quantidade inicial não pode ser negativa!")
    private Integer quantidadeInicial;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Integer getQuantidadeInicial() {
        return quantidadeInicial;
    }

    public void setQuantidadeInicial(Integer quantidadeInicial) {
        this.quantidadeInicial = quantidadeInicial;
    }
}
