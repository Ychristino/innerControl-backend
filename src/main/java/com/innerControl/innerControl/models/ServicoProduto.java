package com.innerControl.innerControl.models;

import jakarta.persistence.*;

@Entity
public class ServicoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private Servico servico; // Relacionamento com o serviço

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto; // Produto utilizado

    private Integer quantidade; // Quantidade do produto utilizado no serviço

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
