package com.innerControl.controller.form.contato;

import com.innerControl.models.Contato;
import com.innerControl.models.PessoaFisica;
import com.innerControl.models.TipoContato;

public class ContatoForm {
    private TipoContato tipoContato;
    private PessoaFisica pessoaFisica;
    private String contato;

    public Contato converter(){ return new Contato(tipoContato, pessoaFisica, contato); }
}
