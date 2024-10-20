package com.innerControl.controller.form.produto;

import com.innerControl.models.Estoque;
import com.innerControl.models.Produto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Set;

public class ProdutoForm {

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @PositiveOrZero
    private float valorCompra;

    @NotNull
    @PositiveOrZero
    private float valorVenda;

    @NotNull
    @NotEmpty
    private Set<Estoque> estoque;

    public Produto converter() { return new Produto(nome, valorCompra, valorVenda, estoque); }

}
