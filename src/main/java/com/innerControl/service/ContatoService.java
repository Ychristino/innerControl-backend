package com.innerControl.service;

import com.innerControl.erros.ContatoExistente;
import com.innerControl.models.Contato;
import com.innerControl.models.PessoaFisica;
import com.innerControl.models.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public Contato cadastroContato(Contato contato, PessoaFisica pessoaFisica){
        contatoRepository.findByTipoContatoAndContatoAndPessoaFisicaNot(contato.getTipoContato(), contato.getContato(), pessoaFisica)
                .ifPresent(c -> {
                    throw new ContatoExistente("Contato já existente.");
                });
        contatoRepository.save(contato);

        return contato;
    }
}
