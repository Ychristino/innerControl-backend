package com.innerControl.controller.form.pessoaFisica;

import com.innerControl.controller.form.contato.ContatoForm;
import com.innerControl.controller.form.endereco.EnderecoForm;
import com.innerControl.models.Contato;
import com.innerControl.models.Endereco;
import com.innerControl.models.PessoaFisica;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

public class PessoaFisicaForm {

    @NotNull
    @NotBlank(message = "O campo nome deve ser informado")
    private String nome;

    @NotNull
    @NotBlank
    private String cpf;

    @NotNull
    @NotBlank
    private Date dataNascimento;

    private Set<Endereco> endereco;

    private Set<Contato> contato;
    public PessoaFisica converter(){
        return new PessoaFisica(nome, cpf, dataNascimento, endereco, contato);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEndereco(Set<Endereco> endereco) {
        this.endereco = endereco;
    }

    public void setContato(Set<Contato> contato) {
        this.contato = contato;
    }
}
