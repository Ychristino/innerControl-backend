package com.innerControl.innerControl.controller.dto;

import com.innerControl.innerControl.models.Produto;

import java.math.BigDecimal;

public class ProdutoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal precoCusto;
    private BigDecimal precoVenda;

    // Construtores
    public ProdutoDTO() {}

    public ProdutoDTO(Long id, String nome, String descricao, BigDecimal precoCusto, BigDecimal precoVenda) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    // Método para converter Produto para ProdutoDTO
    public static ProdutoDTO toDTO(Produto produto) {
        return new ProdutoDTO(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPrecoCusto(),
                produto.getPrecoVenda()
        );
    }
}
