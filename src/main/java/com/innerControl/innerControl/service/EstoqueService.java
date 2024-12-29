package com.innerControl.innerControl.service;

import com.innerControl.innerControl.models.Estoque;
import com.innerControl.innerControl.models.Produto;
import com.innerControl.innerControl.models.repository.EstoqueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Transactional
    public Estoque criar(Produto produto, int quantidadeInicial){
        estoqueRepository.findByProduto(produto).ifPresent(estoque -> {
            throw new RuntimeException("Produto já existe no estoque!");
        });

        Estoque estoque = new Estoque();
        estoque.setProduto(produto);
        estoque.setQuantidade(quantidadeInicial);
        return estoqueRepository.save(estoque);
    }

    @Transactional
    public Estoque atualizar(Long id, int quantidade){
        Estoque estoque = estoqueRepository.findByProdutoId(id).orElseThrow(() -> new RuntimeException("Produto não encontrado no estoque!"));
        estoque.setQuantidade(quantidade);
        return estoqueRepository.save(estoque);
    }

    @Transactional
    public Estoque comprar(Long id, int quantidade){
        Estoque estoque = estoqueRepository.findByProdutoId(id).orElseThrow(() -> new RuntimeException("Produto não encontrado no estoque!"));
        estoque.comprarItens(quantidade);
        return estoqueRepository.save(estoque);
    }

    @Transactional
    public Estoque vender(Long id, int quantidade){
        Estoque estoque = estoqueRepository.findByProdutoId(id).orElseThrow(() -> new RuntimeException("Produto não encontrado no estoque!"));
        estoque.venderItens(quantidade);
        return estoqueRepository.save(estoque);
    }

    public List<Estoque> listarEstoque() {
        return estoqueRepository.findAll();
    }

    public Estoque buscarEstoquePorProdutoId(Long id) {
        Estoque estoque = estoqueRepository.findByProdutoId(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado no estoque!"));
        return estoque;
    }

    @Transactional
    public Estoque devolver(Long id, int quantidade){
        Estoque estoque = estoqueRepository.findByProdutoId(id).orElseThrow(() -> new RuntimeException("Produto não encontrado no estoque!"));
        estoque.devolverItens(quantidade);
        return estoqueRepository.save(estoque);
    }
}
