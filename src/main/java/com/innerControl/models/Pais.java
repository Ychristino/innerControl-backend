package com.innerControl.models;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.util.Set;

@Entity
@Table(name = "pais",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"nome", "sigla"})
        })
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
    private Set<Estado> estadoSet;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
    private Set<Cidade> cidadeSet;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
    private Set<Endereco> enderecoSet;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sigla")
    private String sigla;

    public Pais(){}

    public Pais(String nome, String sigla, Set<Estado> estadoSet, Set<Cidade> cidadeSet, Set<Endereco> enderecoSet){
        this.nome = nome;
        this.sigla = sigla;
        this.estadoSet = estadoSet;
        this.cidadeSet = cidadeSet;
        this.enderecoSet = enderecoSet;
    }

    public Pais(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public Long getId() {
        return id;
    }

    public Set<Estado> getEstadoSet() {
        return estadoSet;
    }

    public void setEstadoSet(Set<Estado> estadoSet) {
        this.estadoSet = estadoSet;
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
