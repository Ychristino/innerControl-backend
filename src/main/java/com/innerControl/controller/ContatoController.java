package com.innerControl.controller;

import com.innerControl.controller.form.contato.AtualizarContatoForm;
import com.innerControl.controller.form.contato.ContatoForm;
import com.innerControl.dto.contato.ContatoDto;
import com.innerControl.models.Contato;
import com.innerControl.models.repository.ContatoRepository;
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
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @GetMapping
    public Page<ContatoDto> listar(Long id,
                                  @PageableDefault(size = 10, sort = "contato", direction = Sort.Direction.ASC) Pageable paginacao){

        Page<Contato> contatos = contatoRepository.findAll(paginacao);
        return ContatoDto.converter(contatos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoDto> detalhes(@PathVariable Long id) {
        Optional<Contato> contato = contatoRepository.findById(id);
        if (contato.isPresent()){
            return ResponseEntity.ok(new ContatoDto(contato.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ContatoDto> cadastrar(@RequestBody @Valid ContatoForm form, UriComponentsBuilder uriBuilder) {
        Contato contato = form.converter();
        contatoRepository.save(contato);

        URI uri = uriBuilder.path("/contato/{id}").buildAndExpand(contato.getId()).toUri();

        return ResponseEntity.created(uri).body(new ContatoDto(contato));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ContatoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarContatoForm form){
        Optional<Contato> opt = contatoRepository.findById(id);
        if (opt.isPresent()){
            Contato contato = form.atualizar(id, contatoRepository);
            return ResponseEntity.ok(new ContatoDto(opt.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Contato> opt = contatoRepository.findById(id);
        if (opt.isPresent()) {
            contatoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}