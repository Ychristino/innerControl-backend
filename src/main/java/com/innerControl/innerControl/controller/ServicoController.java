package com.innerControl.innerControl.controller;

import com.innerControl.innerControl.controller.dto.ServicoDTO;;
import com.innerControl.innerControl.controller.form.servico.ServicoForm;
import com.innerControl.innerControl.controller.form.servico.ServicoUpdateForm;
import com.innerControl.innerControl.models.Servico;
import com.innerControl.innerControl.service.ServicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;import java.net.URI;


@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public Page<ServicoDTO> listarTodos(@PageableDefault(sort = "dataEntrega", size = 10, direction = Sort.Direction.DESC) Pageable paginacao) {
        return servicoService.listarServicos(paginacao)
                .map(ServicoDTO::toDTO);
    }

    @GetMapping("/{id}")
    public ServicoDTO detalhes(@PathVariable Long id) {
        return ServicoDTO.toDTO(servicoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ServicoDTO> salvar(@RequestBody @Valid ServicoForm form, UriComponentsBuilder uriBuilder) {
        Servico newServico = servicoService.criar(form);
        URI uri = uriBuilder.path("/servicos/{id}").buildAndExpand(newServico.getId()).toUri();
        return ResponseEntity.created(uri).body(ServicoDTO.toDTO(newServico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoDTO> alterar(@PathVariable Long id, @RequestBody @Valid ServicoUpdateForm form, UriComponentsBuilder uriBuilder) {
        Servico updatedServico = servicoService.atualizar(id, form);
        return ResponseEntity.ok(ServicoDTO.toDTO(updatedServico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        servicoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

