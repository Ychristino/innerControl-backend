package com.innerControl.controller.form.cidade;

import com.innerControl.models.Cidade;
import com.innerControl.models.Estado;
import com.innerControl.models.Pais;
import com.innerControl.models.repository.CidadeRepository;
import com.innerControl.models.repository.EstadoRepository;

import java.util.Set;

public class AtualizarCidadeForm {
    private Pais pais;
    private Estado estado;
    private String nome;

    public Cidade converter(){ return new Cidade(pais, estado, nome); }

    public Cidade atualizar(Long id, CidadeRepository cidadeRepository){
        Cidade cidade = cidadeRepository.getReferenceById(id);
        cidade.setPais(this.pais);
        cidade.setEstado(this.estado);
        cidade.setNome(this.nome);
        return cidade;
    }
}
