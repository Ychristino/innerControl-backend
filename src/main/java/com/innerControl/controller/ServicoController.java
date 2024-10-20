package com.innerControl.controller;

import com.innerControl.controller.form.servico.AtualizarServicoForm;
import com.innerControl.controller.form.servico.ServicoForm;
import com.innerControl.dto.servico.ServicoDto;
import com.innerControl.models.Servico;
import com.innerControl.models.repository.ServicoRepository;
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
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoRepository servicoRepository;

    @GetMapping
    public Page<ServicoDto> listar(Long id,
                                   @PageableDefault(size = 10, sort = "nome", direction = Sort.Direction.ASC) Pageable paginacao){

        Page<Servico> servicos = servicoRepository.findAll(paginacao);
        return ServicoDto.converter(servicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoDto> detalhes(@PathVariable Long id) {
        Optional<Servico> servico = servicoRepository.findById(id);
        if (servico.isPresent()){
            return ResponseEntity.ok(new ServicoDto(servico.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ServicoDto> cadastrar(@RequestBody @Valid ServicoForm form, UriComponentsBuilder uriBuilder) {
        Servico servico = form.converter();
        servicoRepository.save(servico);

        URI uri = uriBuilder.path("/servico/{id}").buildAndExpand(servico.getId()).toUri();

        return ResponseEntity.created(uri).body(new ServicoDto(servico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ServicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarServicoForm form){
        Optional<Servico> opt = servicoRepository.findById(id);
        if (opt.isPresent()){
            Servico servico = form.atualizar(id, servicoRepository);
            return ResponseEntity.ok(new ServicoDto(opt.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Servico> opt = servicoRepository.findById(id);
        if (opt.isPresent()) {
            servicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}