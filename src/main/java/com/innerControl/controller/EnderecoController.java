package com.innerControl.controller;

import com.innerControl.controller.form.endereco.AtualizarEnderecoForm;
import com.innerControl.controller.form.endereco.EnderecoForm;
import com.innerControl.dto.endereco.EnderecoDto;
import com.innerControl.models.Endereco;
import com.innerControl.models.repository.EnderecoRepository;
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
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public Page<EnderecoDto> listar(Long id,
                                   @PageableDefault(size = 10, sort = "nome", direction = Sort.Direction.ASC) Pageable paginacao){

        Page<Endereco> enderecos = enderecoRepository.findAll(paginacao);
        return EnderecoDto.converter(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDto> detalhes(@PathVariable Long id) {
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if (endereco.isPresent()){
            return ResponseEntity.ok(new EnderecoDto(endereco.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EnderecoDto> cadastrar(@RequestBody @Valid EnderecoForm form, UriComponentsBuilder uriBuilder) {
        Endereco endereco = form.converter();
        enderecoRepository.save(endereco);

        URI uri = uriBuilder.path("/endereco/{id}").buildAndExpand(endereco.getId()).toUri();

        return ResponseEntity.created(uri).body(new EnderecoDto(endereco));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EnderecoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarEnderecoForm form){
        Optional<Endereco> opt = enderecoRepository.findById(id);
        if (opt.isPresent()){
            Endereco endereco = form.atualizar(id, enderecoRepository);
            return ResponseEntity.ok(new EnderecoDto(opt.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Endereco> opt = enderecoRepository.findById(id);
        if (opt.isPresent()) {
            enderecoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}