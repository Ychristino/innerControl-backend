package com.innerControl.controller.form.servico;

import com.innerControl.models.PessoaFisica;
import com.innerControl.models.Estoque;
import com.innerControl.models.Servico;

import java.util.Set;

public class ServicoForm {

    private Long id;
    private PessoaFisica pessoaFisicas;
    private Set<Estoque> estoque;

    public Servico converter(){ return new Servico(pessoaFisicas, estoque); }
}
