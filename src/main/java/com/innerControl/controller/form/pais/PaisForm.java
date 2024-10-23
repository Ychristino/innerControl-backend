package com.innerControl.controller.form.pais;

import com.innerControl.models.Pais;

public class PaisForm {
    private String nome;
    private String sigla;

    public Pais converter(){ return new Pais(nome, sigla); }
}
