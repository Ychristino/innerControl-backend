package com.innerControl.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "cidade_id", nullable = false)
    private Cidade cidade;

    @Column
    private String cep;

    @Column(name="logradouro")
    private String logradouro;

    @Column(name="numero")
    private int numero;

    @Column(name="complemento")
    private String complemento;

    @ManyToMany(mappedBy = "endereco")
    private Set<PessoaFisica> pessoaFisicaSet;

    public Endereco(){}

    public Endereco(Pais pais, Estado estado, Cidade cidade, String cep, String logradouro, int numero, String complemento, Set<PessoaFisica> pessoaFisicaSet){
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.pessoaFisicaSet = pessoaFisicaSet;
    }

    public Long getId() {
        return id;
    }
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setCep(String cep) { this.cep = cep;}
    public String getCep() { return this.cep; }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Set<PessoaFisica> getPessoaFisicaSet() {
        return pessoaFisicaSet;
    }

    public void setPessoaFisicaSet(Set<PessoaFisica> pessoaFisicaSet) {
        this.pessoaFisicaSet = pessoaFisicaSet;
    }
}
