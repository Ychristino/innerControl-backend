package com.innerControl.controller.form.cidade;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.innerControl.models.Cidade;
import com.innerControl.models.Estado;
import com.innerControl.models.Pais;
import com.innerControl.models.repository.CidadeRepository;
import com.innerControl.models.repository.EstadoRepository;
import com.innerControl.service.EstadoService;
import com.innerControl.service.PaisService;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class AtualizarCidadeForm {
    @NotNull
    @NotEmpty
    @JsonProperty("paisId")
    private Long paisId;
    @NotNull
    @NotEmpty
    @JsonProperty("estadoId")
    private Long estadoId;
    @NotNull
    @NotEmpty
    @JsonProperty("nome")
    private String nome;

    public Cidade converter(){
        return new Cidade(
                new PaisService().buscarPais(this.paisId),
                new EstadoService().buscarEstado(this.estadoId),
                this.nome);
    }

    public Cidade atualizar(Long id, CidadeRepository cidadeRepository){
        Cidade cidade = cidadeRepository.getReferenceById(id);
        cidade.setPais(new PaisService().buscarPais(this.paisId));
        cidade.setEstado(new EstadoService().buscarEstado(this.estadoId));
        cidade.setNome(this.nome);
        return cidade;
    }
}
