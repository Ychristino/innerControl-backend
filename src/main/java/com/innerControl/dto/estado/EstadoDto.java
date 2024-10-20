package com.innerControl.dto.estado;

import com.innerControl.models.Cidade;
import com.innerControl.models.Endereco;
import com.innerControl.models.Estado;
import com.innerControl.models.Pais;

import java.util.Set;

public class EstadoDto {

    private Long id;
    private Pais pais;
    private Set<Cidade> cidadeSet;
    private Set<Endereco> enderecoSet;
    private String nome;
    private String sigla;

    public EstadoDto(Estado estado){
        this.id = estado.getId();
        this.pais = estado.getPais();
        this.cidadeSet = estado.getCidadeSet();
        this.enderecoSet = estado.getEnderecoSet();
        this.nome = estado.getNome();
        this.sigla = estado.getSigla();
    }

    public Long getId() {
        return id;
    }

    public Pais getPais() {
        return pais;
    }

    public Set<Cidade> getCidadeSet() {
        return cidadeSet;
    }

    public Set<Endereco> getEnderecoSet() {
        return enderecoSet;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }
}
