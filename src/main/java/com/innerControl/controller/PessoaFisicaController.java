package com.innerControl.controller;

import com.innerControl.controller.form.pessoaFisica.AtualizarPessoaFisicaForm;
import com.innerControl.controller.form.pessoaFisica.PessoaFisicaForm;
import com.innerControl.dto.pessoaFisica.PessoaFisicaDto;
import com.innerControl.erros.PessoaFisicaExistente;
import com.innerControl.models.PessoaFisica;
import com.innerControl.models.repository.PessoaFisicaRepository;
import com.innerControl.service.PessoaFisicaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
@RequestMapping("/pessoa")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @GetMapping
    public Page<PessoaFisicaDto> listar(Long id,
                                        @PageableDefault(size = 10, sort = "nome", direction = Sort.Direction.ASC) Pageable paginacao){
        return pessoaFisicaService.buscarTodos(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaFisicaDto> detalhes(@PathVariable Long id) {
        try {
            PessoaFisicaDto pessoaFisica = pessoaFisicaService.buscarPessoa(id);
            return ResponseEntity.ok(pessoaFisica);
        }
        catch (PessoaFisicaExistente err){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PessoaFisicaDto> cadastrar(@RequestBody @Valid PessoaFisicaForm form, UriComponentsBuilder uriBuilder) {
        PessoaFisica pessoaFisica = form.converter();
        pessoaFisicaService.cadastroPessoa(pessoaFisica);
        URI uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(pessoaFisica.getId()).toUri();
        return ResponseEntity.created(uri).body(new PessoaFisicaDto(pessoaFisica));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PessoaFisicaDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarPessoaFisicaForm form){
        Optional<PessoaFisica> opt = pessoaFisicaRepository.findById(id);
        if (opt.isPresent()){
            PessoaFisica pessoaFisica = form.atualizar(id, pessoaFisicaRepository);
            return ResponseEntity.ok(new PessoaFisicaDto(opt.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        if (pessoaFisicaService.removerPessoa(id)) return ResponseEntity.ok().build();
        else return ResponseEntity.notFound().build();
    }
}