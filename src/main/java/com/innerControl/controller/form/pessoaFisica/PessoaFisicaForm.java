package com.innerControl.controller.form.pessoaFisica;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.innerControl.controller.form.contato.ContatoForm;
import com.innerControl.controller.form.endereco.EnderecoForm;
import com.innerControl.models.Contato;
import com.innerControl.models.Endereco;
import com.innerControl.models.PessoaFisica;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

public class PessoaFisicaForm {
    @NotNull
    @NotEmpty
    @JsonProperty("nome")
    private String nome;
    @NotNull
    @NotEmpty
    @JsonProperty("cpf")
    private String cpf;
    @NotNull
    @NotEmpty
    @JsonProperty("dataNascimento")
    private Date dataNascimento;
    @NotNull
    @NotEmpty
    @JsonProperty("listaEndereco")
    private Set<Endereco> endereco;
    @NotNull
    @NotEmpty
    @JsonProperty("listaContato")
    private Set<Contato> contato;
    public PessoaFisica converter(){
        return new PessoaFisica(nome, cpf, dataNascimento, endereco, contato);
    }

}
