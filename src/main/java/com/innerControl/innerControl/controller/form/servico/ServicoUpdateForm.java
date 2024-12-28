package com.innerControl.innerControl.controller.form.servico;

import com.innerControl.innerControl.controller.form.estoque.EstoqueUpdateForm;
import com.innerControl.innerControl.controller.form.servicoProduto.ServicoProdutoForm;
import com.innerControl.innerControl.controller.form.servicoProduto.ServicoProdutoUpdateForm;
import com.innerControl.innerControl.models.Servico;
import com.innerControl.innerControl.service.PessoaFisicaService;
import com.innerControl.innerControl.service.ProdutoService;

import java.math.BigDecimal;
import java.util.List;

public class ServicoUpdateForm {
    private Long id;
    private String descricao;
    private BigDecimal valor;
    private List<ServicoProdutoUpdateForm> produtosUtilizados;

    // Getters e Setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<ServicoProdutoUpdateForm> getProdutosUtilizados() {
        return produtosUtilizados;
    }

    public void setProdutosUtilizados(List<ServicoProdutoUpdateForm> produtosUtilizadosIds) {
        this.produtosUtilizados = produtosUtilizadosIds;
    }
}
