package com.innerControl.controller.form.servico;

import com.innerControl.models.PessoaFisica;
import com.innerControl.models.Produto;
import com.innerControl.models.Servico;

import java.util.Set;

public class ServicoForm {

    private PessoaFisica pessoaFisicas;
    private float valorServico;
    private Set<Produto> produtos;

    public Servico converter(){ return new Servico(pessoaFisicas, valorServico, produtos); }
}
