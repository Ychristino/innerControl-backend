package com.innerControl.innerControl.controller.dto;

import com.innerControl.innerControl.models.Estoque;
import com.innerControl.innerControl.models.Produto;

public class EstoqueDTO {
    private Long id;
    private ProdutoDTO produto;
    private Integer quantidade;

    // Construtores
    public EstoqueDTO() {}

    public EstoqueDTO(Long id, ProdutoDTO produto, Integer quantidade) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    // Método para converter Estoque para EstoqueDTO
    public static EstoqueDTO toDTO(Estoque estoque) {
        return new EstoqueDTO(
                estoque.getId(),
                ProdutoDTO.toDTO(estoque.getProduto()),
                estoque.getQuantidade()
        );
    }
}
