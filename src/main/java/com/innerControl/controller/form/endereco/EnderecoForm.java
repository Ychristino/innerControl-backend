package com.innerControl.controller.form.endereco;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.innerControl.models.Cidade;
import com.innerControl.models.Endereco;
import com.innerControl.models.Estado;
import com.innerControl.models.Pais;
import com.innerControl.service.CidadeService;
import com.innerControl.service.EstadoService;
import com.innerControl.service.PaisService;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EnderecoForm {
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
    @JsonProperty("cidadeId")
    private Long cidadeId;
    @NotNull
    @NotEmpty
    @JsonProperty("cep")
    private String cep;
    @NotNull
    @NotEmpty
    @JsonProperty("logradouro")
    private String logradouro;
    @NotNull
    @NotEmpty
    @JsonProperty("numero")
    private int numero;
    @NotNull
    @NotEmpty
    @JsonProperty("complemento")
    private String complemento;

    public Endereco converter(){
        return new Endereco(
                new PaisService().buscarPais(this.paisId),
                new EstadoService().buscarEstado(this.estadoId),
                new CidadeService().buscarCidade(this.cidadeId),
                cep,
                logradouro,
                numero,
                complemento);
    }
}
