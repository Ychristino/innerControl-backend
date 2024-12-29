package com.innerControl.innerControl.controller.dto;

import com.innerControl.innerControl.models.Servico;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ServicoDTO {

    private Long id;
    private String descricao;
    private Date dataEntrada;
    private Date dataEntrega;
    private Long pessoaId;
    private String pessoaNome;
    private BigDecimal valor;
    private List<ServicoProdutoDTO> produtosUtilizados;

    public ServicoDTO(Long id, String descricao, Date dataEntrada, Date dataEntrega, Long pessoaId, String pessoaNome, BigDecimal valor, List<ServicoProdutoDTO> produtosUtilizados) {
        this.id = id;
        this.descricao = descricao;
        this.dataEntrada = dataEntrada;
        this.dataEntrega = dataEntrega;
        this.pessoaId = pessoaId;
        this.pessoaNome = pessoaNome;
        this.valor = valor;
        this.produtosUtilizados = produtosUtilizados;
    }

    // Método para converter a entidade Servico em um ServicoDTO
    public static ServicoDTO toDTO(Servico servico) {
        List<ServicoProdutoDTO> servicoProdutoDTO = servico.getProdutosUtilizados().stream()
                .map(ServicoProdutoDTO::toDTO)
                .collect(Collectors.toList());

        return new ServicoDTO(
                servico.getId(),
                servico.getDescricao(),
                servico.getDataEntrada(),
                servico.getDataEntrega(),
                servico.getPessoa().getId(),
                servico.getPessoa().getNome(),
                servico.getValor(),
                servicoProdutoDTO
        );
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getPessoaNome() {
        return pessoaNome;
    }

    public void setPessoaNome(String pessoaNome) {
        this.pessoaNome = pessoaNome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<ServicoProdutoDTO> getProdutosUtilizados() {
        return produtosUtilizados;
    }

    public void setProdutosUtilizados(List<ServicoProdutoDTO> produtosUtilizados) {
        this.produtosUtilizados = produtosUtilizados;
    }
}
