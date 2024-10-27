package com.innerControl.service;

import com.innerControl.erros.EstadoNaoExistente;
import com.innerControl.erros.ProdutoNaoExistente;
import com.innerControl.models.Estado;
import com.innerControl.models.Produto;
import com.innerControl.models.repository.EstadoRepository;
import com.innerControl.models.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto buscarProduto(Long id){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(()-> new ProdutoNaoExistente("Produto não encontrado."));
        return produto;
    }
}
