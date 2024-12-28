package com.innerControl.innerControl.controller.form.endereco;

import com.innerControl.innerControl.controller.form.cidade.CidadeForm;
import com.innerControl.innerControl.models.Cidade;
import com.innerControl.innerControl.models.Endereco;

public class EnderecoForm {
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private CidadeForm cidade;

    public Endereco toEntity(Cidade cidade) {
    Endereco endereco = new Endereco();
    endereco.setLogradouro(this.logradouro);
    endereco.setNumero(this.numero);
    endereco.setComplemento(this.complemento);
    endereco.setCep(this.cep);
    endereco.setCidade(cidade);
    return endereco;
    }

    // Getters e Setters

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public CidadeForm getCidade() {
        return cidade;
    }

    public void setCidade(CidadeForm cidade) {
        this.cidade = cidade;
    }
}

