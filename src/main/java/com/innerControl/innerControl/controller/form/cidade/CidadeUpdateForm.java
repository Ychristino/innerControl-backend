package com.innerControl.innerControl.controller.form.cidade;

import com.innerControl.innerControl.controller.form.estado.EstadoUpdateForm;
import com.innerControl.innerControl.controller.form.pais.PaisUpdateForm;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CidadeUpdateForm {
    private Long id; // Opcional
    @NotNull(message = "Nome da cidade deve ser informado!")
    @NotEmpty(message = "Nome da cidade deve ser informado!")
    private String nome;
    private EstadoUpdateForm estado;
    private PaisUpdateForm pais;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EstadoUpdateForm getEstado() {
        return estado;
    }

    public void setEstado(EstadoUpdateForm estado) {
        this.estado = estado;
    }

    public PaisUpdateForm getPais() {
        return pais;
    }

    public void setPais(PaisUpdateForm pais) {
        this.pais = pais;
    }
}