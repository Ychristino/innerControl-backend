package com.innerControl.innerControl.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;
    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().toUpperCase();
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}