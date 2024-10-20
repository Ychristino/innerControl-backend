package com.innerControl.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private PessoaFisica pessoaFisicas;

    @OneToMany(mappedBy = "servico", cascade = CascadeType.ALL)
    private Set<Estoque> estoque;

    public Servico(){}

    public Servico(PessoaFisica pessoaFisica, Set<Estoque> estoque){
        this.pessoaFisicas = pessoaFisica;
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisicas;
    }

    public void setPessoaFisicas(PessoaFisica pessoaFisicas) {
        this.pessoaFisicas = pessoaFisicas;
    }

    public Set<Estoque> getEstoque() {
        return estoque;
    }

    public void setEstoque(Set<Estoque> estoque) {
        this.estoque = estoque;
    }
}
