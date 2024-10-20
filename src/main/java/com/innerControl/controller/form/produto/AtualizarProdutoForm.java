package com.innerControl.controller.form.produto;

import com.innerControl.models.Estoque;
import com.innerControl.models.Produto;
import com.innerControl.models.repository.ProdutoRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Set;

public class AtualizarProdutoForm {
    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @PositiveOrZero
    private float valorCompra;

    @NotNull
    @PositiveOrZero
    private float valorVenda;

    @NotNull
    @NotEmpty
    private Set<Estoque> estoque;

    public Produto converter() { return new Produto(nome, valorCompra, valorVenda, estoque); }

    public Produto atualizar(Long id, ProdutoRepository produtoRepository){
        Produto produto = produtoRepository.getReferenceById(id);

        produto.setNome(this.nome);
        produto.setValorCompra(this.valorCompra);
        produto.setValorVenda(this.valorVenda);

        return produto;
    }
}
