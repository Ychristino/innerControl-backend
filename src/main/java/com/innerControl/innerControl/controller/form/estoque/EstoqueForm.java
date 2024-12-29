package com.innerControl.innerControl.controller.form.estoque;

import com.innerControl.innerControl.controller.form.produto.ProdutoForm;
import jakarta.validation.constraints.PositiveOrZero;

public class EstoqueForm {
    private ProdutoForm produto;
    @PositiveOrZero(message = "Quantidade inicial não pode ser negativa!")
    private Integer quantidadeInicial;

    // Construtores
    public EstoqueForm() {}

    public EstoqueForm(ProdutoForm produto, Integer quantidadeInicial) {
        this.produto = produto;
        this.quantidadeInicial = quantidadeInicial;
    }

    // Getters e Setters
    public ProdutoForm getProduto() {
        return produto;
    }

    public void setProduto(ProdutoForm produto) {
        this.produto = produto;
    }

    public Integer getQuantidadeInicial() {
        return quantidadeInicial;
    }

    public void setQuantidadeInicial(Integer quantidadeInicial) {
        this.quantidadeInicial = quantidadeInicial;
    }
}