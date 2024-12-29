package com.innerControl.innerControl.controller.form.pessoaFisica;

import com.innerControl.innerControl.controller.form.contato.ContatoForm;
import com.innerControl.innerControl.controller.form.endereco.EnderecoForm;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.util.Date;
import java.util.List;

public class PessoaFisicaForm {
    @NotNull(message = "Nome da pessoa deve ser informado!")
    @NotEmpty(message = "Nome da pessoa deve ser informado!")
    private String nome;
    @NotNull(message = "CPF deve ser informado!")
    @NotEmpty(message = "CPF deve ser informado!")
    private String cpf;
    @NotNull(message = "Data de nascimento deve ser informada!")
    @Past(message = "Data de nascimento não pode ser futura!")
    private Date dataNascimento;
    private List<EnderecoForm> enderecos;
    private List<ContatoForm> contatos;

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<EnderecoForm> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoForm> enderecos) {
        this.enderecos = enderecos;
    }

    public List<ContatoForm> getContatos() {
        return contatos;
    }

    public void setContatos(List<ContatoForm> contatos) {
        this.contatos = contatos;
    }
}