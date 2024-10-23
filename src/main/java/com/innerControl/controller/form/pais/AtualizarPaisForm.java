package com.innerControl.controller.form.pais;

import com.innerControl.models.*;
import com.innerControl.models.repository.PaisRepository;

import java.util.Set;

public class AtualizarPaisForm {
    private String nome;
    private String sigla;

    public Pais converter(){ return new Pais(nome, sigla); }

    public Pais atualizar(Long id, PaisRepository paisRepository){
        Pais pais = paisRepository.getReferenceById(id);
        pais.setNome(this.nome);
        pais.setSigla(this.sigla);
        return pais;
    }
}
