package com.innerControl.models;

import jakarta.persistence.*;

@Entity
@Table(name = "contato")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoContato tipoContato;

    @ManyToOne
    @JoinColumn(name = "pessoaFisica_id", nullable = false)
    private PessoaFisica pessoaFisica;

    @Column(name = "contato")
    private String contato;

    public Contato(){}

    public Contato(TipoContato tipoContato, PessoaFisica pessoaFisica, String contato){
        this.tipoContato = tipoContato;
        this.pessoaFisica = pessoaFisica;
        this.contato = contato;
    }

    public Long getId() {
        return id;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
