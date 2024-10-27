package com.innerControl.controller.form.produto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.innerControl.models.Estoque;
import com.innerControl.models.Produto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class ProdutoForm {
    @NotNull
    @NotEmpty
    @JsonProperty("nome")
    private String nome;
    @NotNull
    @NotEmpty
    @JsonProperty("descricao")
    private String descricao;
    @NotNull
    @NotEmpty
    @JsonProperty("valorCompra")
    private float valorCompra;
    @NotNull
    @NotEmpty
    @JsonProperty("valorVenda")
    private float valorVenda;

    public Produto converter() { return new Produto(nome, descricao, valorCompra, valorVenda); }

}
