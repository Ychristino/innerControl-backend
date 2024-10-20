package com.innerControl.controller;

import com.innerControl.controller.form.produto.AtualizarProdutoForm;
import com.innerControl.controller.form.produto.ProdutoForm;
import com.innerControl.dto.produto.ProdutoDto;
import com.innerControl.models.Produto;
import com.innerControl.models.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public Page<ProdutoDto> listar(Long id,
                                   @PageableDefault(size = 10, sort = "nome", direction = Sort.Direction.ASC) Pageable paginacao){

        Page<Produto> produtos = produtoRepository.findAll(paginacao);
        return ProdutoDto.converter(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> detalhes(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()){
            return ResponseEntity.ok(new ProdutoDto(produto.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoDto> cadastrar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder) {
        Produto produto = form.converter();
        produtoRepository.save(produto);

        URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(new ProdutoDto(produto));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProdutoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarProdutoForm form){
        Optional<Produto> opt = produtoRepository.findById(id);
        if (opt.isPresent()){
            Produto produto = form.atualizar(id, produtoRepository);
            return ResponseEntity.ok(new ProdutoDto(opt.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Produto> opt = produtoRepository.findById(id);
        if (opt.isPresent()) {
            produtoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}