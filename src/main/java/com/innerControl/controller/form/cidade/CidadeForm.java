package com.innerControl.controller.form.cidade;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.innerControl.models.Cidade;
import com.innerControl.service.EstadoService;
import com.innerControl.service.PaisService;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class CidadeForm {
    @NotNull
    @NotEmpty
    @JsonProperty("paisId")
    private Long paisId;
    @NotNull
    @NotEmpty
    @JsonProperty("estadoId")
    private Long estadoId;
    @NotNull
    @NotEmpty
    @JsonProperty("nome")
    private String nome;

    public Cidade converter(){
        return new Cidade(
                new PaisService().buscarPais(paisId),
                new EstadoService().buscarEstado(estadoId),
                nome);
    }
}
