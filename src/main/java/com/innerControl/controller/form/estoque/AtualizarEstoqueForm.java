package com.innerControl.controller.form.estoque;

import com.innerControl.config.validacao.NoSuchItemError;
import com.innerControl.models.Estoque;
import com.innerControl.models.Produto;
import com.innerControl.models.repository.EstoqueRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class AtualizarEstoqueForm {
    @NotNull
    @NotEmpty
    private Produto produto;
    @NotNull
    @PositiveOrZero
    private int quantidade;
    public Estoque converter(){
        return new Estoque(produto, quantidade);
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
