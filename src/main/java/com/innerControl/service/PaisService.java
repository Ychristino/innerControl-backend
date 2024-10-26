package com.innerControl.service;

import com.innerControl.dto.pais.PaisDto;
import com.innerControl.erros.PaisNaoExistente;
import com.innerControl.models.Pais;
import com.innerControl.models.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService {
    @Autowired
    private PaisRepository paisRepository;

    public PaisDto buscarPais(Long id){
        Pais pais = paisRepository.findById(id)
                .orElseThrow(()-> new PaisNaoExistente("País não encontrado."));
        return new PaisDto(pais);
    }
}
