package com.innerControl.innerControl.service;

import com.innerControl.innerControl.controller.form.estado.EstadoForm;
import com.innerControl.innerControl.controller.form.estado.EstadoUpdateForm;
import com.innerControl.innerControl.controller.form.pais.PaisUpdateForm;
import com.innerControl.innerControl.models.Estado;
import com.innerControl.innerControl.models.Pais;
import com.innerControl.innerControl.models.repository.EstadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    @Transactional
    public Estado criar(EstadoForm estadoForm, Pais pais){

        Estado estado = estadoRepository.findByNomeAndSiglaAndPais(
                estadoForm.getNome(),
                estadoForm.getSigla(),
                pais
        ).orElse(null);

        if (estado != null){
            estado.setPais(pais);
            estado.setNome(estadoForm.getNome());
            estado.setSigla(estadoForm.getSigla());
        }
        else {
            estado = new Estado();
            estado.setNome(estadoForm.getNome());
            estado.setSigla(estadoForm.getSigla());
            estado.setPais(pais);
            estado = estadoRepository.save(estado);
        }
        return estado;

    }

    @Transactional
    public Estado atualizar(EstadoUpdateForm estadoForm, Pais pais){

        Estado estado = estadoRepository.findByNomeAndSiglaAndPais(
                estadoForm.getNome(),
                estadoForm.getSigla(),
                pais
        ).orElse(null);

        if (estado != null){
            estado.setPais(pais);
            estado.setNome(estadoForm.getNome());
            estado.setSigla(estadoForm.getSigla());
        }
        else {
            estado = new Estado();
            estado.setNome(estadoForm.getNome());
            estado.setSigla(estadoForm.getSigla());
            estado.setPais(pais);
            estado = estadoRepository.save(estado);
        }
        return estado;

    }
}
