package com.innerControl.innerControl.controller.dto;

import com.innerControl.innerControl.models.ServicoProduto;

public class ServicoProdutoDTO {
    private Long id;
    private Long produtoId;
    private String nomeProduto;
    private Integer quantidade;

    // Construtores
    public ServicoProdutoDTO() {
    }

    public ServicoProdutoDTO(Long id, Long produtoId, String nomeProduto, Integer quantidade) {
        this.id = id;
        this.produtoId = produtoId;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    // Método para criar o DTO a partir de ServicoProduto
    public static ServicoProdutoDTO toDTO(ServicoProduto servicoProduto) {
        return new ServicoProdutoDTO(
                servicoProduto.getId(),
                servicoProduto.getProduto().getId(),
                servicoProduto.getProduto().getNome(),
                servicoProduto.getQuantidade()
        );
    }
}
