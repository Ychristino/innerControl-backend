package com.innerControl.controller.form.produto;

import com.innerControl.models.Estoque;
import com.innerControl.models.Produto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class ProdutoForm {

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    private String descricao;

    @NotNull
    @PositiveOrZero
    private float valorCompra;

    @NotNull
    @PositiveOrZero
    private float valorVenda;

    @NotNull
    @NotEmpty
    private Estoque estoque;

    public Produto converter() { return new Produto(nome, descricao, valorCompra, valorVenda); }

}
