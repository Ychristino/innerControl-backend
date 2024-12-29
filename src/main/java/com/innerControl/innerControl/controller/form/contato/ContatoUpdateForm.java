package com.innerControl.innerControl.controller.form.contato;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ContatoUpdateForm {
    private Long id;
    private String tipo;
    @NotNull(message = "Valor do contato deve ser informado!")
    @NotEmpty(message = "Valor do contato deve ser informado!")
    private String valor;
    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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