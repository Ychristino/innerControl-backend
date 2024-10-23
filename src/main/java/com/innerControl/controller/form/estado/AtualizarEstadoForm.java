package com.innerControl.controller.form.estado;

import com.innerControl.models.Estado;
import com.innerControl.models.Pais;
import com.innerControl.models.repository.EstadoRepository;
import com.innerControl.models.repository.PaisRepository;

import java.util.Set;

public class AtualizarEstadoForm {
    private Pais pais;
    private String nome;
    private String sigla;

    public Estado converter(){ return new Estado(pais, nome, sigla); }

    public Estado atualizar(Long id, EstadoRepository estadoRepository){
        Estado estado = estadoRepository.getReferenceById(id);
        estado.setNome(this.nome);
        estado.setSigla(this.sigla);
        estado.setPais(this.pais);
        return estado;
    }
}
