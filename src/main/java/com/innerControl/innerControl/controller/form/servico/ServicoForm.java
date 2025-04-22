package com.innerControl.innerControl.controller.form.servico;

import com.innerControl.innerControl.controller.form.servicoProduto.ServicoProdutoForm;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class ServicoForm {

    private String descricao;
    @NotNull(message = "Data de entrada deve ser informada!")
    private Date dataEntrada;
    @NotNull(message = "Data de entrega deve ser informada!")
    private Date dataEntrega;
    @NotNull(message = "O serviço deve ser atribuiído a uma pessoa!")
    private Long pessoaId;
    @NotNull(message = "Valor do serviço deve ser informado!")
    @Positive(message = "Valor do serviço deve ser positivo!")
    private BigDecimal valor;

    private List<ServicoProdutoForm> produtosUtilizados;

    // Getters e Setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
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
