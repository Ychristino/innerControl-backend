package com.innerControl.controller.form.endereco;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.innerControl.models.*;
import com.innerControl.models.repository.CidadeRepository;
import com.innerControl.models.repository.EnderecoRepository;
import com.innerControl.service.CidadeService;
import com.innerControl.service.EstadoService;
import com.innerControl.service.PaisService;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class AtualizarEnderecoForm {
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

    public Endereco atualizar(Long id, EnderecoRepository enderecoRepository){
        Endereco endereco = enderecoRepository.getReferenceById(id);
        endereco.setPais(new PaisService().buscarPais(this.paisId));
        endereco.setEstado(new EstadoService().buscarEstado(this.estadoId));
        endereco.setCidade(new CidadeService().buscarCidade(this.cidadeId));
        endereco.setCep(this.cep);
        endereco.setLogradouro(this.logradouro);
        endereco.setNumero(this.numero);
        endereco.setComplemento(this.complemento);
        return endereco;
    }
}
