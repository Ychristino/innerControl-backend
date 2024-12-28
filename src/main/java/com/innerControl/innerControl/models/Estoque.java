package com.innerControl.innerControl.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantidade;

    @OneToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        if (quantidade > 0)
            this.quantidade = quantidade;
        else throw new IllegalArgumentException("Quantidade de itens deve ser maior que zero!");
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void comprarItens(Integer quantidade) {
        if (quantidade > 0)
            this.quantidade += quantidade;
        else throw new IllegalArgumentException("Quantidade de itens comprados deve ser maior que zero!");
    }

    public void venderItens(Integer quantidade) {
        if (quantidade > 0)
            if ((this.quantidade - quantidade) > 0)
                this.quantidade -= quantidade;
            else throw new RuntimeException(String.format("Não há itens suficientes em estoque para: %s!",(produto.getNome())));
        else throw new IllegalArgumentException("Quantidade de itens vendidos deve ser maior que zero!");
    }

    public void devolverItens(int quantidade) {
        if (quantidade > 0)
            this.quantidade += quantidade;
        else throw new IllegalArgumentException("Quantidade de itens devolvidos deve ser maior que zero!");

    }
}
