package com.innerControl.controller.form.cidade;

import com.innerControl.models.Cidade;
import com.innerControl.models.Estado;
import com.innerControl.models.Pais;

public class CidadeForm {
    private Pais pais;
    private Estado estado;
    private String nome;

    public Cidade converter(){ return new Cidade(pais, estado, nome); }
}
