package com.innerControl.innerControl.controller.form.pessoaFisica;

import com.innerControl.innerControl.controller.form.contato.ContatoForm;
import com.innerControl.innerControl.controller.form.endereco.EnderecoForm;

import java.util.Date;
import java.util.List;

public class PessoaFisicaForm {
    private String nome;
    private String cpf;
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