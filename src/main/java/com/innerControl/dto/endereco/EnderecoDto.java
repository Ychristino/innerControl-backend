package com.innerControl.dto.endereco;

import com.innerControl.dto.pessoaFisica.PessoaFisicaDto;
import com.innerControl.models.*;
import org.springframework.data.domain.Page;

import java.util.Set;

public class EnderecoDto{


    private Long id;
    private Pais pais;
    private Estado estado;
    private Cidade cidade;
    private String cep;
    private String logradouro;
    private int numero;
    private String complemento;
    private Set<PessoaFisica> pessoaFisicaSet;

    public EnderecoDto(Endereco endereco){
        this.id = endereco.getId();
        this.pais = endereco.getPais();
        this.estado = endereco.getEstado();
        this.cidade = endereco.getCidade();
        this.cep = endereco.getCep();
        this.logradouro = endereco.getLogradouro();
        this.numero = endereco.getNumero();
        this.complemento = endereco.getComplemento();
        this.pessoaFisicaSet = endereco.getPessoaFisicaSet();
    }

    public Long getId() {
        return id;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public String getCep(){ return cep; }

    public String getLogradouro() {
        return logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public Set<PessoaFisica> getPessoaFisicaSet() {
        return pessoaFisicaSet;
    }

    public static Page<PessoaFisicaDto> converter(Page<PessoaFisica> entity) {
        return entity.map(PessoaFisicaDto::new);
    }

    public static PessoaFisicaDto converter(PessoaFisica entity) {
        return new PessoaFisicaDto(entity);
    }
}
