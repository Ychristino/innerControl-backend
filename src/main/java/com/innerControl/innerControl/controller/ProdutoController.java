package com.innerControl.innerControl.controller;

import com.innerControl.innerControl.controller.dto.ProdutoDTO;
import com.innerControl.innerControl.controller.form.produto.ProdutoForm;
import com.innerControl.innerControl.controller.form.produto.ProdutoUpdateForm;
import com.innerControl.innerControl.models.Produto;
import com.innerControl.innerControl.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoDTO> listarTodos() {
        return produtoService.listarProdutos().stream()
                .map(produto -> ProdutoDTO.toDTO(produto))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> salvar(@RequestBody ProdutoForm form, UriComponentsBuilder uriBuilder) {
        Produto newProduto = produtoService.criar(form);
        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(newProduto.getId()).toUri();
        return ResponseEntity.created(uri).body(ProdutoDTO.toDTO(newProduto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> alterar(@PathVariable Long id, @RequestBody ProdutoUpdateForm form, UriComponentsBuilder uriBuilder) {
        Produto updatedProduto = produtoService.atualizar(id, form);
        return ResponseEntity.ok(ProdutoDTO.toDTO(updatedProduto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        produtoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

