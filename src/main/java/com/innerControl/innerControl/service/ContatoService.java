package com.innerControl.innerControl.service;

import com.innerControl.innerControl.controller.form.contato.ContatoForm;
import com.innerControl.innerControl.controller.form.contato.ContatoUpdateForm;
import com.innerControl.innerControl.models.Contato;
import com.innerControl.innerControl.models.PessoaFisica;
import com.innerControl.innerControl.models.repository.ContatoRepository;
import com.innerControl.innerControl.utils.ContatoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Transactional
    public List<Contato> criar(List<ContatoForm> forms, PessoaFisica pessoaFisica) {

        List<Contato> novosContatos = forms.stream().map(form -> {
            Contato novoContato = new Contato();
            novoContato.setTipo(ContatoEnum.fromString(form.getTipo()));
            novoContato.setValor(form.getValor());
            novoContato.setPessoaFisica(pessoaFisica);
            return novoContato;
        }).collect(Collectors.toList());

        return novosContatos;
    }

    @Transactional
    public List<Contato> atualizar(List<ContatoUpdateForm> forms, PessoaFisica pessoaFisica) {
        List<Contato> contatosAtuais = pessoaFisica.getContatos();

        // Atualizar ou criar novos contatos
        List<Contato> novosContatos = forms.stream().map(form -> {
            if (form.getId() != null) {
                // Atualizar contato existente
                Contato contato = contatoRepository.findById(form.getId())
                        .orElseThrow(() -> new IllegalArgumentException("Contato não encontrado: " + form.getId()));
                contato.setTipo(ContatoEnum.fromString(form.getTipo()));
                contato.setValor(form.getValor());
                return contato;
            } else {
                // Criar novo contato
                Contato novoContato = new Contato();
                novoContato.setTipo(ContatoEnum.fromString(form.getTipo()));
                novoContato.setValor(form.getValor());
                novoContato.setPessoaFisica(pessoaFisica);
                return novoContato;
            }
        }).collect(Collectors.toList());

        // Remover contatos que não estão mais na lista
        contatosAtuais.stream()
                .filter(c -> novosContatos.stream().noneMatch(n -> n.getId() != null && n.getId().equals(c.getId())))
                .forEach(contatoRepository::delete);

        return novosContatos;
    }
}
