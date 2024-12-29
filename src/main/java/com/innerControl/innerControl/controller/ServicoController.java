package com.innerControl.innerControl.controller;

import com.innerControl.innerControl.controller.dto.ProdutoDTO;
import com.innerControl.innerControl.controller.dto.ServicoDTO;
import com.innerControl.innerControl.controller.form.produto.ProdutoForm;
import com.innerControl.innerControl.controller.form.produto.ProdutoUpdateForm;
import com.innerControl.innerControl.controller.form.servico.ServicoForm;
import com.innerControl.innerControl.controller.form.servico.ServicoUpdateForm;
import com.innerControl.innerControl.models.Produto;
import com.innerControl.innerControl.models.Servico;
import com.innerControl.innerControl.service.ProdutoService;
import com.innerControl.innerControl.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public List<ServicoDTO> listarTodos() {
        return servicoService.listarServicos().stream()
                .map(servico -> ServicoDTO.toDTO(servico))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ServicoDTO detalhes(@PathVariable Long id) {
        return ServicoDTO.toDTO(servicoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ServicoDTO> salvar(@RequestBody ServicoForm form, UriComponentsBuilder uriBuilder) {
        Servico newServico = servicoService.criar(form);
        URI uri = uriBuilder.path("/servicos/{id}").buildAndExpand(newServico.getId()).toUri();
        return ResponseEntity.created(uri).body(ServicoDTO.toDTO(newServico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoDTO> alterar(@PathVariable Long id, @RequestBody ServicoUpdateForm form, UriComponentsBuilder uriBuilder) {
        Servico updatedServico = servicoService.atualizar(id, form);
        return ResponseEntity.ok(ServicoDTO.toDTO(updatedServico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        servicoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

