package com.innerControl.controller.form.endereco;

import com.innerControl.models.Cidade;
import com.innerControl.models.Endereco;
import com.innerControl.models.Estado;
import com.innerControl.models.Pais;

public class EnderecoForm {
    private Pais pais;
    private Estado estado;
    private Cidade cidade;
    private String cep;
    private String logradouro;
    private int numero;
    private String complemento;

    public Endereco converter(){ return new Endereco(pais, estado, cidade, cep, logradouro, numero, complemento); }
}
