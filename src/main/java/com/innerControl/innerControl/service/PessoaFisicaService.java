package com.innerControl.innerControl.service;

import com.innerControl.innerControl.controller.form.pessoaFisica.PessoaFisicaForm;
import com.innerControl.innerControl.controller.form.pessoaFisica.PessoaFisicaUpdateForm;
import com.innerControl.innerControl.models.PessoaFisica;
import com.innerControl.innerControl.models.repository.PessoaFisicaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaFisicaService {
    @Autowired
    private final PessoaFisicaRepository pessoaFisicaRepository;
    @Autowired
    private CidadeService cidadeService;
    @Autowired
    private ContatoService contatoService;
    @Autowired
    private EnderecoService enderecoService;

    public PessoaFisicaService(PessoaFisicaRepository pessoaRepository) {
        this.pessoaFisicaRepository = pessoaRepository;
    }

    public List<PessoaFisica> listarTodos() {
        return pessoaFisicaRepository.findAll();
    }

    @Transactional
    public PessoaFisica salvar(PessoaFisicaForm form) {
        pessoaFisicaRepository.findByCpf(form.getCpf()).ifPresent(pessoaFisica -> {
            throw new RuntimeException("Já existe CPF na base...");
        });
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setNome(form.getNome());
        pessoaFisica.setCpf(form.getCpf());
        pessoaFisica.setDataNascimento(form.getDataNascimento());
        pessoaFisica.setContatos(contatoService.criar(form.getContatos(), pessoaFisica));
        pessoaFisica.setEnderecos(enderecoService.criar(form.getEnderecos(), pessoaFisica));

        return pessoaFisicaRepository.save(pessoaFisica);
    }

    @Transactional
    public PessoaFisica atualizar(Long id, PessoaFisicaUpdateForm form) {
        PessoaFisica pessoaFisica = pessoaFisicaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa Física não encontrada"));
        if (id != form.getId())
            throw new IllegalArgumentException("ID de atualização da pessoa incorreto...");

        // Atualizar os dados principais
        pessoaFisica.setNome(form.getNome());
        pessoaFisica.setDataNascimento(form.getDataNascimento());

        // Atualizar Endereços
        pessoaFisica.setEnderecos(enderecoService.atualizar(form.getEnderecos(), pessoaFisica));

        // Atualizar Contatos
        pessoaFisica.setContatos(contatoService.atualizar(form.getContatos(), pessoaFisica));

        // Salvar Pessoa Física
        return pessoaFisicaRepository.save(pessoaFisica);
    }
    public void excluir(Long id) {
        pessoaFisicaRepository.deleteById(id);
    }
}
