package com.innerControl.controller.form.contato;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.innerControl.models.Contato;
import com.innerControl.models.TipoContato;
import com.innerControl.service.PessoaFisicaService;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ContatoForm {
    @NotNull
    @NotEmpty
    @JsonProperty("tipoContato")
    private TipoContato tipoContato;
    @NotNull
    @NotEmpty
    @JsonProperty("pessoaFisicaId")
    private Long pessoaFisicaId;
    @NotNull
    @NotEmpty
    @JsonProperty("contato")
    private String contato;

    public Contato converter(){
        return new Contato(
                this.tipoContato,
                new PessoaFisicaService().buscarPessoa(this.pessoaFisicaId),
                this.contato);
    }
}
