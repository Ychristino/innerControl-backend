package com.innerControl.innerControl.controller.form.estado;

import com.innerControl.innerControl.controller.form.pais.PaisUpdateForm;

public class EstadoUpdateForm {
    private Long id;
    private String nome;
    private String sigla;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public PaisUpdateForm getPais() {
        return pais;
    }

    public void setPais(PaisUpdateForm pais) {
        this.pais = pais;
    }
}