package com.innerControl.innerControl.controller;

import com.innerControl.innerControl.controller.dto.PessoaFisicaDTO;
import com.innerControl.innerControl.controller.form.pessoaFisica.PessoaFisicaForm;
import com.innerControl.innerControl.controller.form.pessoaFisica.PessoaFisicaUpdateForm;
import com.innerControl.innerControl.models.PessoaFisica;
import com.innerControl.innerControl.service.PessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoas")
public class PessoaFisicaController {
    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @GetMapping
    public List<PessoaFisicaDTO> listarTodos() {
        return pessoaFisicaService.listarTodos().stream()
                .map(pessoaFisica -> PessoaFisicaDTO.toDTO(pessoaFisica))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<PessoaFisicaDTO> salvar(@RequestBody PessoaFisicaForm form, UriComponentsBuilder uriBuilder) {
        PessoaFisica newPessoaFisica = pessoaFisicaService.criar(form);
        URI uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(newPessoaFisica.getId()).toUri();
        return ResponseEntity.created(uri).body(PessoaFisicaDTO.toDTO(newPessoaFisica));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaFisicaDTO> alterar(@PathVariable Long id, @RequestBody PessoaFisicaUpdateForm form, UriComponentsBuilder uriBuilder) {
        PessoaFisica updatedPessoaFisica = pessoaFisicaService.atualizar(id, form);
        return ResponseEntity.ok(PessoaFisicaDTO.toDTO(updatedPessoaFisica));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        pessoaFisicaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

