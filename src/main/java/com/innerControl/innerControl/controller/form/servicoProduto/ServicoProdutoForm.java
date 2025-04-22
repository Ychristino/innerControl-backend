package com.innerControl.innerControl.controller.form.servicoProduto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ServicoProdutoForm {
    private Long idProduto;
    @NotNull(message = "Quantidade de itens deve ser informada!")
    @Positive(message = "Quantidade de itens deve ser positivo!")
    private int quantidade;
    @NotNull(message = "Valor do produto deve ser informado!")
    @Positive(message = "Valor do produto deve ser positivo!")
    private Float valorProduto;

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(Float valorProduto) {
        this.valorProduto = valorProduto;
    }
}
