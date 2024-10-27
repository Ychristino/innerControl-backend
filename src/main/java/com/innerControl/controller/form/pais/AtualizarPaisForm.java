package com.innerControl.controller.form.pais;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.innerControl.models.*;
import com.innerControl.models.repository.PaisRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class AtualizarPaisForm {
    @NotNull
    @NotEmpty
    @JsonProperty("nome")
    private String nome;
    @NotNull
    @NotEmpty
    @JsonProperty("sigla")
    private String sigla;

    public Pais converter(){ return new Pais(nome, sigla); }

    public Pais atualizar(Long id, PaisRepository paisRepository){
        Pais pais = paisRepository.getReferenceById(id);
        pais.setNome(this.nome);
        pais.setSigla(this.sigla);
        return pais;
    }
}
