package com.innerControl.innerControl.controller.form.produto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public class ProdutoUpdateForm {
    private Long id;
    @NotEmpty(message = "Nome do produto deve ser informado!")
    @NotNull(message = "Nome do produto deve ser informado!")
    private String nome;
    private String descricao;
    @Positive(message = "Preço de venda deve ser positivo!")
    private BigDecimal precoVenda;
    @Positive(message = "Preço de custo deve ser positivo!")
    private BigDecimal precoCusto;
    @PositiveOrZero(message = "Quantidade não pode ser negativa!")
    private Integer quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
