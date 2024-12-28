package com.innerControl.innerControl.controller;

import com.innerControl.innerControl.controller.dto.EstoqueDTO;
import com.innerControl.innerControl.controller.form.estoque.EstoqueUpdateForm;
import com.innerControl.innerControl.models.Estoque;
import com.innerControl.innerControl.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping
    public List<EstoqueDTO> listarTodos() {
        return estoqueService.listarEstoque().stream()
                .map(item -> EstoqueDTO.toDTO(item))
                .collect(Collectors.toList());
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

