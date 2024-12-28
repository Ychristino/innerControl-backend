package com.innerControl.innerControl.models;

import com.innerControl.innerControl.utils.ContatoEnum;
import jakarta.persistence.*;

@Entity
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ContatoEnum tipo; // Ex: Telefone, Email
    private String valor;

    @ManyToOne
    @JoinColumn(name = "pessoa_fisica_id")
    private PessoaFisica pessoaFisica;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public ContatoEnum getTipo() {
        return tipo;
    }

    public void setTipo(ContatoEnum tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }
}
