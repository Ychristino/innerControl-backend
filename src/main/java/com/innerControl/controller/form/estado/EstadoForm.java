package com.innerControl.controller.form.estado;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.innerControl.models.Estado;
import com.innerControl.models.Pais;
import com.innerControl.service.PaisService;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EstadoForm {
    @NotNull
    @NotEmpty
    @JsonProperty("paisId")
    private Long paisId;
    @NotNull
    @NotEmpty
    @JsonProperty("nome")
    private String nome;
    @NotNull
    @NotEmpty
    @JsonProperty("sigla")
    private String sigla;

    public Estado converter(){
        return new Estado(
                new PaisService().buscarPais(this.paisId),
                nome,
                sigla);
    }
}
