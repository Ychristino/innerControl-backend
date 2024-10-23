package com.innerControl.controller;

import com.innerControl.controller.form.cidade.AtualizarCidadeForm;
import com.innerControl.controller.form.cidade.CidadeForm;
import com.innerControl.dto.cidade.CidadeDto;
import com.innerControl.models.Cidade;
import com.innerControl.models.repository.CidadeRepository;
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
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping
    public Page<CidadeDto> listar(Long id,
                                  @PageableDefault(size = 10, sort = "nome", direction = Sort.Direction.ASC) Pageable paginacao){

        Page<Cidade> cidades = cidadeRepository.findAll(paginacao);
        return CidadeDto.converter(cidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CidadeDto> detalhes(@PathVariable Long id) {
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        if (cidade.isPresent()){
            return ResponseEntity.ok(new CidadeDto(cidade.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CidadeDto> cadastrar(@RequestBody @Valid CidadeForm form, UriComponentsBuilder uriBuilder) {
        Cidade cidade = form.converter();
        cidadeRepository.save(cidade);

        URI uri = uriBuilder.path("/cidade/{id}").buildAndExpand(cidade.getId()).toUri();

        return ResponseEntity.created(uri).body(new CidadeDto(cidade));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CidadeDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarCidadeForm form){
        Optional<Cidade> opt = cidadeRepository.findById(id);
        if (opt.isPresent()){
            Cidade cidade = form.atualizar(id, cidadeRepository);
            return ResponseEntity.ok(new CidadeDto(opt.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Cidade> opt = cidadeRepository.findById(id);
        if (opt.isPresent()) {
            cidadeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}