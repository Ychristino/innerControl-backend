package com.innerControl.innerControl.controller.form.pessoaFisica;

import com.innerControl.innerControl.controller.form.contato.ContatoUpdateForm;
import com.innerControl.innerControl.controller.form.endereco.EnderecoUpdateForm;
import com.innerControl.innerControl.models.PessoaFisica;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.util.Date;
import java.util.List;

public class PessoaFisicaUpdateForm {
    private Long id;
    @NotNull(message = "Nome da pessoa deve ser informado!")
    @NotEmpty(message = "Nome da pessoa deve ser informado!")
    private String nome;
    @NotNull(message = "CPF deve ser informado!")
    @NotEmpty(message = "CPF deve ser informado!")
    private String cpf;
    @NotNull(message = "Data de nascimento deve ser informada!")
    @Past(message = "Data de nascimento não pode ser futura!")
    private Date dataNascimento;
    private List<EnderecoUpdateForm> enderecos;
    private List<ContatoUpdateForm> contatos;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<EnderecoUpdateForm> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoUpdateForm> enderecos) {
        this.enderecos = enderecos;
    }

    public List<ContatoUpdateForm> getContatos() {
        return contatos;
    }

    public void setContatos(List<ContatoUpdateForm> contatos) {
        this.contatos = contatos;
    }

    public PessoaFisica toEntity(PessoaFisica pessoaFisica) {
        pessoaFisica.setNome(this.nome);
        pessoaFisica.setCpf(this.cpf);
        pessoaFisica.setDataNascimento(this.dataNascimento);
        return pessoaFisica;
    }
}