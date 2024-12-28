package com.innerControl.innerControl.controller.form.servico;

import com.innerControl.innerControl.controller.form.servicoProduto.ServicoProdutoForm;

import java.math.BigDecimal;
import java.util.List;


public class ServicoForm {

    private String descricao;
    private Long pessoaId;
    private BigDecimal valor;
    private List<ServicoProdutoForm> produtosUtilizados;

    // Getters e Setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<ServicoProdutoForm> getProdutosUtilizados() {
        return produtosUtilizados;
    }

    public void setProdutosUtilizados(List<ServicoProdutoForm> produtosUtilizadosIds) {
        this.produtosUtilizados = produtosUtilizadosIds;
    }
}