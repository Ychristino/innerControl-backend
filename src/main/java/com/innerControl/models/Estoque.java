package com.innerControl.models;

import jakarta.persistence.*;

@Entity
@Table(name = "estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "quantidade")
    private int quantidade;
    @OneToOne(mappedBy = "estoque")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private Servico servico;

    public Estoque() {}

    public Estoque(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
        this.servico = servico;
    }

    public Estoque(Produto produto, int quantidade, Servico servico){
        this.produto = produto;
        this.quantidade = quantidade;
        this.servico = servico;
    }

    public Long getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
