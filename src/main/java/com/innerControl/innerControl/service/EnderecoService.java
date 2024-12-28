package com.innerControl.innerControl.service;

import com.innerControl.innerControl.controller.form.endereco.EnderecoForm;
import com.innerControl.innerControl.controller.form.endereco.EnderecoUpdateForm;
import com.innerControl.innerControl.models.Endereco;
import com.innerControl.innerControl.models.PessoaFisica;
import com.innerControl.innerControl.models.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private CidadeService cidadeService;

    @Transactional
    public List<Endereco> criar(List<EnderecoForm> forms, PessoaFisica pessoaFisica) {

        List<Endereco> novosEnderecos = forms.stream().map(form -> {
            Endereco novoEndereco = new Endereco();
            novoEndereco.setLogradouro(form.getLogradouro());
            novoEndereco.setNumero(form.getNumero());
            novoEndereco.setComplemento(form.getComplemento());
            novoEndereco.setCep(form.getCep());
            novoEndereco.setCidade(cidadeService.criar(form.getCidade()));
            novoEndereco.setPessoaFisica(pessoaFisica);
            return novoEndereco;
        }).collect(Collectors.toList());

        return novosEnderecos;
    }

    @Transactional
    public List<Endereco> atualizar(List<EnderecoUpdateForm> forms, PessoaFisica pessoaFisica) {
        List<Endereco> enderecosAtuais = pessoaFisica.getEnderecos();

        // Atualizar ou criar novos endereços
        List<Endereco> novosEnderecos = forms.stream().map(form -> {
            if (form.getId() != null) {
                // Atualizar endereço existente
                Endereco endereco = enderecoRepository.findById(form.getId())
                        .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado: " + form.getId()));
                endereco.setLogradouro(form.getLogradouro());
                endereco.setNumero(form.getNumero());
                endereco.setComplemento(form.getComplemento());
                endereco.setCep(form.getCep());
                endereco.setCidade(cidadeService.atualizar(form.getCidade()));
                return endereco;
            } else {
                // Criar novo endereço
                Endereco novoEndereco = new Endereco();
                novoEndereco.setCep(form.getCep());
                novoEndereco.setCidade(cidadeService.atualizar(form.getCidade()));
                novoEndereco.setLogradouro(form.getLogradouro());
                novoEndereco.setNumero(form.getNumero());
                novoEndereco.setComplemento(form.getComplemento());
                novoEndereco.setPessoaFisica(pessoaFisica);
                return novoEndereco;
            }
        }).collect(Collectors.toList());

        enderecosAtuais.stream()
                .filter(e -> novosEnderecos.stream().noneMatch(n -> n.getId() != null && n.getId().equals(e.getId())))
                .forEach(enderecoRepository::delete);

        return novosEnderecos;
    }
}
