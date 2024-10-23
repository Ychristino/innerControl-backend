package com.innerControl.controller.form.produto;

import com.innerControl.models.Estoque;
import com.innerControl.models.Produto;
import com.innerControl.models.repository.ProdutoRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class AtualizarProdutoForm {
    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    private String descricao;

    @NotNull
    @PositiveOrZero
    private float valorCompra;

    @NotNull
    @PositiveOrZero
    private float valorVenda;

    @NotNull
    @NotEmpty
    private Estoque estoque;
    public Produto converter() { return new Produto(nome, descricao, valorCompra, valorVenda); }

    public Produto atualizar(Long id, ProdutoRepository produtoRepository){
        Produto produto = produtoRepository.getReferenceById(id);

        produto.setNome(this.nome);
        produto.setDescricao(this.descricao);
        produto.setValorCompra(this.valorCompra);
        produto.setValorVenda(this.valorVenda);

        return produto;
    }
}
