package com.innerControl.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="pessoaFisica")
public class PessoaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "dataNascimento")
    private Date dataNascimento;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "pessoa_endereco",
            joinColumns = @JoinColumn(name = "pessoaFisica_id"),
            inverseJoinColumns = @JoinColumn(name = "endereco_id")
    )
    private Set<Endereco> endereco;

    @OneToMany(mappedBy = "pessoaFisica", cascade = CascadeType.ALL)
    private Set<Contato> contato;

    public PessoaFisica(){}

    public PessoaFisica(String nome, String cpf, Date dataNascimento, Set<Endereco> endereco, Set<Contato> contato){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.contato = contato;
    }

    public Long getId() {
        return id;
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

    public Set<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(Set<Endereco> endereco) {
        this.endereco = endereco;
    }

    public Set<Contato> getContato() {
        return contato;
    }

    public void setContato(Set<Contato> contato) {
        this.contato = contato;
    }
}