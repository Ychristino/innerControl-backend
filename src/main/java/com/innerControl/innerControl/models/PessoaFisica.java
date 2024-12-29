package com.innerControl.innerControl.models;

import com.innerControl.innerControl.utils.Validador;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class PessoaFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private Date dataNascimento;

    @OneToMany(mappedBy = "pessoaFisica", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "pessoaFisica", cascade = CascadeType.ALL)
    private List<Contato> contatos;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (Validador.validarCpf(cpf))
            this.cpf = cpf;
        else
            throw new IllegalArgumentException("CPF informado não é válido!");
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().toUpperCase();;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
}
