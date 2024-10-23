package com.innerControl.controller;

import com.innerControl.controller.form.pais.AtualizarPaisForm;
import com.innerControl.controller.form.pais.PaisForm;
import com.innerControl.dto.pais.PaisDto;
import com.innerControl.models.Pais;
import com.innerControl.models.repository.PaisRepository;
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
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @GetMapping
    public Page<PaisDto> listar(Long id,
                                @PageableDefault(size = 10, sort = "nome", direction = Sort.Direction.ASC) Pageable paginacao){

        Page<Pais> paises = paisRepository.findAll(paginacao);
        return PaisDto.converter(paises);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaisDto> detalhes(@PathVariable Long id) {
        Optional<Pais> pais = paisRepository.findById(id);
        if (pais.isPresent()){
            return ResponseEntity.ok(new PaisDto(pais.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PaisDto> cadastrar(@RequestBody @Valid PaisForm form, UriComponentsBuilder uriBuilder) {
        Pais pais = form.converter();
        paisRepository.save(pais);

        URI uri = uriBuilder.path("/pais/{id}").buildAndExpand(pais.getId()).toUri();

        return ResponseEntity.created(uri).body(new PaisDto(pais));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PaisDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarPaisForm form){
        Optional<Pais> opt = paisRepository.findById(id);
        if (opt.isPresent()){
            Pais pais = form.atualizar(id, paisRepository);
            return ResponseEntity.ok(new PaisDto(opt.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Pais> opt = paisRepository.findById(id);
        if (opt.isPresent()) {
            paisRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}