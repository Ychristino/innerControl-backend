package com.innerControl.innerControl.controller.dto;

import com.innerControl.innerControl.models.Servico;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ServicoDTO {

    private Long id;
    private String descricao;
    private Long pessoaId;
    private String pessoaNome;
    private BigDecimal valor;
    private List<ServicoProdutoDTO> produtosUtilizados;

    public ServicoDTO(Long id, String descricao, Long pessoaId, String pessoaNome, BigDecimal valor, List<ServicoProdutoDTO> produtosUtilizados) {
        this.id = id;
        this.descricao = descricao;
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
