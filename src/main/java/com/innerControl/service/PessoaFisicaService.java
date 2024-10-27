package com.innerControl.service;

import com.innerControl.dto.pessoaFisica.PessoaFisicaDto;
import com.innerControl.erros.*;
import com.innerControl.models.Contato;
import com.innerControl.models.Endereco;
import com.innerControl.models.PessoaFisica;
import com.innerControl.models.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PessoaFisicaService {
    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;
    @Autowired
    private ContatoService contatoService;
    @Autowired
    private EnderecoService enderecoService;

    public PessoaFisicaDto cadastroPessoa(PessoaFisica pessoaFisica){
        pessoaFisicaRepository.findByCpf(pessoaFisica.getCpf())
                .ifPresent(p -> {
                    throw new PessoaFisicaExistente("CPF já existente.");
                });

        pessoaFisicaRepository.save(pessoaFisica);
        return new PessoaFisicaDto(pessoaFisica);
    }

    public Page<PessoaFisicaDto> buscarTodos(Pageable paginacao){
        return PessoaFisicaDto.converter(pessoaFisicaRepository.findAll(paginacao));
    }

    public PessoaFisica buscarPessoa(Long id) {
        PessoaFisica pessoaFisica = pessoaFisicaRepository.findById(id)
                .orElseThrow(()-> new PessoaFisicaExistente("Pessoa não encontrado."));
        return pessoaFisica;
    }

    public boolean removerPessoa(Long id){
        Optional<PessoaFisica> opt = pessoaFisicaRepository.findById(id);
        if (opt.isPresent()) {
            pessoaFisicaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
