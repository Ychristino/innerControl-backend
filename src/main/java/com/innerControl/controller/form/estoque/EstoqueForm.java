package com.innerControl.controller.form.estoque;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.innerControl.models.Estoque;
import com.innerControl.models.Produto;
import com.innerControl.service.ProdutoService;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class EstoqueForm {
    @NotNull
    @NotEmpty
    @JsonProperty("quantidade")
    private int quantidade;
    @NotNull
    @NotEmpty
    @JsonProperty("produtoId")
    private Long produtoId;
    public Estoque converter(){
        return new Estoque(
                new ProdutoService().buscarProduto(produtoId),
                quantidade);
    }
}
