package com.innerControl.innerControl.controller;

import com.innerControl.innerControl.controller.dto.EstoqueDTO;
import com.innerControl.innerControl.controller.dto.PessoaFisicaDTO;
import com.innerControl.innerControl.controller.form.estoque.EstoqueUpdateForm;
import com.innerControl.innerControl.models.Estoque;
import com.innerControl.innerControl.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping
    public Page<EstoqueDTO> listarTodos(@PageableDefault(sort = "id", size = 10, direction = Sort.Direction.DESC) Pageable paginacao) {
        return estoqueService.listarEstoque(paginacao)
                .map(EstoqueDTO::toDTO);
    }

    @GetMapping("/{id}")
    public EstoqueDTO detalhes(@PathVariable Long id) {
        return EstoqueDTO.toDTO(estoqueService.buscarEstoquePorProdutoId(id));
    }

    @PutMapping("/comprar/{id}")
    public ResponseEntity<EstoqueDTO> comprar(@PathVariable Long id, @RequestBody EstoqueUpdateForm form, UriComponentsBuilder uriBuilder) {
        Estoque updatedEstoque = estoqueService.comprar(id, form.getQuantidade());
        return ResponseEntity.ok(EstoqueDTO.toDTO(updatedEstoque));
    }

    @PutMapping("/vender/{id}")
    public ResponseEntity<EstoqueDTO> vender(@PathVariable Long id, @RequestBody EstoqueUpdateForm form, UriComponentsBuilder uriBuilder) {
        Estoque updatedEstoque = estoqueService.vender(id, form.getQuantidade());
        return ResponseEntity.ok(EstoqueDTO.toDTO(updatedEstoque));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstoqueDTO> alterar(@PathVariable Long id, @RequestBody EstoqueUpdateForm form, UriComponentsBuilder uriBuilder) {
        Estoque updatedEstoque = estoqueService.atualizar(id, form.getQuantidade());
        return ResponseEntity.ok(EstoqueDTO.toDTO(updatedEstoque));
    }
}

