package com.innerControl.controller.form.estoque;

import com.innerControl.models.Estoque;
import com.innerControl.models.Produto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class EstoqueForm {
    @NotNull
    @PositiveOrZero
    private int quantidade;

    @NotNull
    @NotEmpty
    private Produto produto;

    public Estoque converter(){
        return new Estoque(produto, quantidade);
    }
}
