package com.innerControl.innerControl.controller.form.contato;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ContatoForm {
    private String tipo;
    @NotNull(message = "Valor do contato deve ser informado!")
    @NotEmpty(message = "Valor do contato deve ser informado!")
    private String valor;

    // Getters e Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}