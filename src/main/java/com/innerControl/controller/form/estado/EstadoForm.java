package com.innerControl.controller.form.estado;

import com.innerControl.models.Estado;
import com.innerControl.models.Pais;

public class EstadoForm {
    private Pais pais;
    private String nome;
    private String sigla;

    public Estado converter(){ return new Estado(pais, nome, sigla); }
}
