package com.innerControl.controller;

import com.innerControl.controller.form.estoque.AtualizarEstoqueForm;
import com.innerControl.controller.form.estoque.EstoqueForm;
import com.innerControl.dto.estoque.EstoqueDto;
import com.innerControl.models.Estoque;
import com.innerControl.models.repository.EstoqueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @GetMapping
    public Page<EstoqueDto> listar(Long id,
                                   @PageableDefault(size = 10, sort = "nome", direction = Sort.Direction.ASC) Pageable paginacao){

        Page<Estoque> estoque = estoqueRepository.findAll(paginacao);
        return EstoqueDto.converter(estoque);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstoqueDto> detalhes(@PathVariable Long id) {
        Optional<Estoque> estoque = estoqueRepository.findById(id);
        if (estoque.isPresent()){
            return ResponseEntity.ok(new EstoqueDto(estoque.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EstoqueDto> cadastrar(@RequestBody @Valid EstoqueForm form, UriComponentsBuilder uriBuilder) {
        Estoque estoque = form.converter();
        estoqueRepository.save(estoque);

        URI uri = uriBuilder.path("/estoque/{id}").buildAndExpand(estoque.getId()).toUri();

        return ResponseEntity.created(uri).body(new EstoqueDto(estoque));
    }

    @PutMapping("consumir/{id}")
    @Transactional
    public ResponseEntity<EstoqueDto> consumir(@PathVariable Long id, @RequestBody @Valid AtualizarEstoqueForm form){
        Optional<Estoque> opt = estoqueRepository.findById(id);
        if (opt.isPresent()){
            Estoque estoque = form.consumirItens(id, estoqueRepository);
            return ResponseEntity.ok(new EstoqueDto(opt.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("adicionar/{id}")
    @Transactional
    public ResponseEntity<EstoqueDto> adicionar(@PathVariable Long id, @RequestBody @Valid AtualizarEstoqueForm form){
        Optional<Estoque> opt = estoqueRepository.findById(id);
        if (opt.isPresent()){
            Estoque estoque = form.adicionarItens(id, estoqueRepository);
            return ResponseEntity.ok(new EstoqueDto(opt.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("atualizar/{id}")
    @Transactional
    public ResponseEntity<EstoqueDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarEstoqueForm form){
        Optional<Estoque> opt = estoqueRepository.findById(id);
        if (opt.isPresent()){
            Estoque estoque = form.ajustarQuantidade(id, estoqueRepository);
            return ResponseEntity.ok(new EstoqueDto(opt.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Estoque> opt = estoqueRepository.findById(id);
        if (opt.isPresent()) {
            estoqueRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
