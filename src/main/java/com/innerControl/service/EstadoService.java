package com.innerControl.service;

import com.innerControl.dto.estado.EstadoDto;
import com.innerControl.erros.EstadoNaoExistente;
import com.innerControl.models.Estado;
import com.innerControl.models.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    public EstadoDto buscarEstado(Long id){
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(()-> new EstadoNaoExistente("Estado não encontrado."));
        return new EstadoDto(estado);
    }
}
