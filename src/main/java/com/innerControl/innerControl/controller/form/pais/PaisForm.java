package com.innerControl.innerControl.controller.form.pais;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class PaisForm {
    private Long id;
    @NotNull(message = "Nome do país deve ser informado!")
    @NotEmpty(message = "Nome do país deve ser informado!")
    private String nome;
    @NotNull(message = "Sigla do país deve ser informada!")
    @NotEmpty(message = "Sigla do país deve ser informada!")
    private String sigla;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
