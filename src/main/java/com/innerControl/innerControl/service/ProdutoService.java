package com.innerControl.innerControl.service;

import com.innerControl.innerControl.controller.form.produto.ProdutoForm;
import com.innerControl.innerControl.controller.form.produto.ProdutoUpdateForm;
import com.innerControl.innerControl.models.Produto;
import com.innerControl.innerControl.models.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstoqueService estoqueService;

    @Transactional
    public Produto criar(ProdutoForm form) {
        produtoRepository.findByNome(form.getNome())
                .ifPresent(produto -> {
                    throw new RuntimeException("Produto já cadastrado!");
                });

        Produto novoProduto = new Produto();
        novoProduto.setNome(form.getNome());
        novoProduto.setDescricao(form.getDescricao());
        novoProduto.setPrecoCusto(form.getPrecoCusto());
        novoProduto.setPrecoVenda(form.getPrecoVenda());
        novoProduto = produtoRepository.save(novoProduto);

        novoProduto.setEstoque(estoqueService.criar(novoProduto, form.getQuantidadeInicial()));

        return novoProduto;
    }

    @Transactional
    public Produto atualizar(Long id, ProdutoUpdateForm form) {
        // Buscar pelo ID
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

        // Verificar se o nome já está sendo usado por outro produto
        produtoRepository.findByNome(form.getNome())
                .ifPresent(outroProduto -> {
                    if (!outroProduto.getId().equals(id)) {
                        throw new RuntimeException("Produto já cadastrado!");
                    }
                });

        // Atualizar os dados do produto
        produto.setNome(form.getNome());
        produto.setDescricao(form.getDescricao());
        produto.setPrecoCusto(form.getPrecoCusto());
        produto.setPrecoVenda(form.getPrecoVenda());

        // Salvar e retornar o produto atualizado
        return produtoRepository.save(produto);
    }

    public Produto buscarProduto(Long id){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
        return produto;
    }
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @Transactional
    public void excluir(Long id) {
        produtoRepository.deleteById(id);
    }
}
