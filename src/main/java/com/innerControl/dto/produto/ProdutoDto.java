package com.innerControl.dto.produto;

import com.innerControl.models.Estoque;
import com.innerControl.models.Produto;
import org.springframework.data.domain.Page;

import java.util.Set;

public class ProdutoDto{

    private Long id;
    private String nome;
    private float valorCompra;
    private float valorVenda;
    private Set<Estoque> estoque;

    public ProdutoDto(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.valorCompra = produto.getValorCompra();
        this.valorVenda = produto.getValorVenda();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public Set<Estoque> getEstoque() {
        return estoque;
    }

    public static Page<ProdutoDto> converter(Page<Produto> entity) {
        return entity.map(ProdutoDto::new);
    }

    public static ProdutoDto converter(Produto entity) {
        return new ProdutoDto(entity);
    }
}
