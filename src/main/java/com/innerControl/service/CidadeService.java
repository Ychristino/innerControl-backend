package com.innerControl.service;

import com.innerControl.erros.EstadoNaoExistente;
import com.innerControl.models.Cidade;
import com.innerControl.models.Estado;
import com.innerControl.models.repository.CidadeRepository;
import com.innerControl.models.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade buscarCidade(Long id){
        Cidade cidade = cidadeRepository.findById(id)
                .orElseThrow(()-> new EstadoNaoExistente("Cidade não encontrado."));
        return cidade;
    }
}
