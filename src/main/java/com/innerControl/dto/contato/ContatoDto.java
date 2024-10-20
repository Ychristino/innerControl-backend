package com.innerControl.dto.contato;

import com.innerControl.models.Contato;
import com.innerControl.models.PessoaFisica;
import com.innerControl.models.TipoContato;

public class ContatoDto {

    private Long id;
    private TipoContato tipoContato;
    private PessoaFisica pessoaFisica;
    private String contato;

    public ContatoDto(Contato contato){
        this.id = contato.getId();
        this.tipoContato = contato.getTipoContato();
        this.pessoaFisica = contato.getPessoaFisica();
        this.contato = contato.getContato();
    }

    public Long getId() {
        return id;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public String getContato() {
        return contato;
    }
}
