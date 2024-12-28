package com.innerControl.innerControl.controller.form.endereco;

import com.innerControl.innerControl.controller.form.cidade.CidadeUpdateForm;

public class EnderecoUpdateForm {
    private Long id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private CidadeUpdateForm cidade;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public CidadeUpdateForm getCidade() {
        return cidade;
    }

    public void setCidade(CidadeUpdateForm cidade) {
        this.cidade = cidade;
    }

}
