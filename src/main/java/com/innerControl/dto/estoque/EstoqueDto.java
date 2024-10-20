package com.innerControl.dto.estoque;

import com.innerControl.models.Estoque;
import com.innerControl.models.Produto;
import org.springframework.data.domain.Page;

public class EstoqueDto{

    private Long id;
    private int quantidade;
    private Produto produto;

    public EstoqueDto(Estoque estoque){
        this.id = estoque.getId();
        this.quantidade = estoque.getQuantidade();
        this.produto = estoque.getProduto();
    }

    public Long getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }
    public static Page<EstoqueDto> converter(Page<Estoque> entity) {
        return entity.map(EstoqueDto::new);
    }

    public static EstoqueDto converter(Estoque entity) {
        return new EstoqueDto(entity);
    }
}
