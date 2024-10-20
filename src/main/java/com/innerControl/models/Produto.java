package com.innerControl.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valorCompra")
    private float valorCompra;

    @Column(name = "valorVenda")
    private float valorVenda;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estoque_id", referencedColumnName = "id")
    private Set<Estoque> estoque;

    public Produto(){}

    public Produto(String nome, float valorCompra, float valorVenda, Set<Estoque> estoque){
        this.nome = nome;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.estoque = estoque;
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

    public float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }
}
