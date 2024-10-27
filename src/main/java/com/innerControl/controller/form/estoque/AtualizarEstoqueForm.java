package com.innerControl.controller.form.estoque;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.innerControl.config.validacao.NoSuchItemError;
import com.innerControl.models.Estoque;
import com.innerControl.models.Produto;
import com.innerControl.models.repository.EstoqueRepository;
import com.innerControl.service.ProdutoService;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class AtualizarEstoqueForm {
    @NotNull
    @NotEmpty
    @JsonProperty("quantidade")
    private int quantidade;
    @NotNull
    @NotEmpty
    @JsonProperty("produtoId")
    private Long produtoId;
    public Estoque converter(){
        return new Estoque(
                new ProdutoService().buscarProduto(produtoId),
                quantidade);
    }

    public Estoque adicionarItens(Long id, EstoqueRepository estoqueRepository) {
        Estoque estoque = estoqueRepository.getReferenceById(id);
        estoque.setQuantidade(estoque.getQuantidade() + this.quantidade);
        return estoque;
    }

    public Estoque consumirItens(Long id, EstoqueRepository estoqueRepository) {
        Estoque estoque = estoqueRepository.getReferenceById(id);

        if (quantidade > estoque.getQuantidade()) {
            estoque.setQuantidade(estoque.getQuantidade() - this.quantidade);
        }
        else{
            throw new NoSuchItemError("Não existem itens suficientes em estoque para o item " + estoque.getProduto().getNome());
        }
        return estoque;
    }

    public Estoque ajustarQuantidade(Long id, EstoqueRepository estoqueRepository){
        Estoque estoque = estoqueRepository.getReferenceById(id);
        estoque.setQuantidade(this.quantidade);
        return estoque;
    }
}
