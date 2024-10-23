package com.innerControl.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "cidade",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"pais_id", "estado_id", "nome"})
        })public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = true)
    private Estado estado;

    @OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL)
    private Set<Endereco> enderecoSet;

    private String nome;

    public Cidade(){}

    public Cidade(Pais pais, Estado estado, Set<Endereco> enderecoSet, String nome){
        this.pais = pais;
        this.estado = estado;
        this.enderecoSet = enderecoSet;
        this.nome = nome;
    }

    public Cidade(Pais pais, Estado estado, String nome) {
        this.pais = pais;
        this.estado = estado;
        this.nome = nome;
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
}
