package com.innerControl.innerControl.controller.form.estoque;

import com.innerControl.innerControl.controller.form.produto.ProdutoForm;

public class EstoqueForm {
    private ProdutoForm produto;
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