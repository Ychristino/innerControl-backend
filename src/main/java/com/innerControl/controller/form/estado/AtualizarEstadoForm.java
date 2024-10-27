package com.innerControl.controller.form.estado;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.innerControl.models.Estado;
import com.innerControl.models.Pais;
import com.innerControl.models.repository.EstadoRepository;
import com.innerControl.models.repository.PaisRepository;
import com.innerControl.service.PaisService;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class AtualizarEstadoForm {
    @NotNull
    @NotEmpty
    @JsonProperty("paisId")
    private Long paisId;
    @NotNull
    @NotEmpty
    @JsonProperty("nome")
    private String nome;
    @NotNull
    @NotEmpty
    @JsonProperty("sigla")
    private String sigla;

    public Estado converter(){
        return new Estado(
                new PaisService().buscarPais(this.paisId),
                nome,
                sigla);
    }

    public Estado atualizar(Long id, EstadoRepository estadoRepository){
        Estado estado = estadoRepository.getReferenceById(id);
        estado.setNome(this.nome);
        estado.setSigla(this.sigla);
        estado.setPais(new PaisService().buscarPais(this.paisId));
        return estado;
    }
}
