package com.innerControl.controller.form.pais;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.innerControl.models.Pais;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PaisForm {
    @NotNull
    @NotEmpty
    @JsonProperty("nome")
    private String nome;
    @NotNull
    @NotEmpty
    @JsonProperty("sigla")
    private String sigla;

    public Pais converter(){ return new Pais(nome, sigla); }
}
