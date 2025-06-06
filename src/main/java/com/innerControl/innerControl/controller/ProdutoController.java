package com.innerControl.innerControl.controller;

import com.innerControl.innerControl.controller.dto.PessoaFisicaDTO;
import com.innerControl.innerControl.controller.dto.ProdutoDTO;
import com.innerControl.innerControl.controller.form.produto.ProdutoForm;
import com.innerControl.innerControl.controller.form.produto.ProdutoUpdateForm;
import com.innerControl.innerControl.models.Produto;
import com.innerControl.innerControl.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public Page<ProdutoDTO> listarTodos(@RequestParam(required = false, defaultValue = "") String nome,
                                        @PageableDefault(sort = "id", size = 10, direction = Sort.Direction.DESC) Pageable paginacao) {
        if (nome.isBlank() || nome.isEmpty())
            return produtoService.listarProdutos(paginacao)
                    .map(ProdutoDTO::toDTO);
        else
            return produtoService.listarProdutosPorNome(nome, paginacao)
                    .map(ProdutoDTO::toDTO);
    }

    @GetMapping("/nopaginated")
    public List<ProdutoDTO> listarTodos() {
        return produtoService.listarProdutos()
                .stream().map(ProdutoDTO::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProdutoDTO detalhes(@PathVariable Long id) {
        return ProdutoDTO.toDTO(produtoService.buscarPorId(id));
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

