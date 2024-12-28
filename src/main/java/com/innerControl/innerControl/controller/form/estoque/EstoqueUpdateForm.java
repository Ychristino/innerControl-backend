package com.innerControl.innerControl.controller.form.estoque;

import com.innerControl.innerControl.controller.form.produto.ProdutoForm;

public class EstoqueUpdateForm {
    private Long id;
    private Integer quantidade;

    // Construtores
    public EstoqueUpdateForm() {}

    public EstoqueUpdateForm(Long id, Integer quantidadeInicial) {
        this.id = id;
        this.quantidade = quantidadeInicial;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}