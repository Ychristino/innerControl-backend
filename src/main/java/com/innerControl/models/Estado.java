package com.innerControl.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private Set<Cidade> cidadeSet;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private Set<Endereco> enderecoSet;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sigla")
    private String sigla;

    public Estado(){}

    public Estado(Pais pais, String nome, String sigla, Set<Cidade> cidadeSet, Set<Endereco> enderecoSet){
        this.pais = pais;
        this.nome = nome;
        this.sigla = sigla;
        this.cidadeSet = cidadeSet;
        this.enderecoSet = enderecoSet;
    }

    public Pais getPais() {
        return pais;
    }
    public Long getId() {
        return id;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Set<Cidade> getCidadeSet() {
        return cidadeSet;
    }

    public void setCidadeSet(Set<Cidade> cidadeSet) {
        this.cidadeSet = cidadeSet;
    }

    public Set<Endereco> getEnderecoSet() {
        return enderecoSet;
    }

    public void setEnderecoSet(Set<Endereco> enderecoSet) {
        this.enderecoSet = enderecoSet;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
