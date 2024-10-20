package com.innerControl.dto.pais;

import com.innerControl.dto.mapper.PaisMapper;
import com.innerControl.dto.pessoaFisica.PessoaFisicaDto;
import com.innerControl.models.*;
import org.springframework.data.domain.Page;

import java.util.Set;

public class PaisDto{

    private Long id;
    private Set<Estado> estadoSet;
    private Set<Cidade> cidadeSet;
    private Set<Endereco> enderecoSet;
    private String nome;
    private String sigla;

    public PaisDto(Pais pais){
        this.id = pais.getId();
        this.estadoSet = pais.getEstadoSet();
        this.cidadeSet = pais.getCidadeSet();
        this.enderecoSet = pais.getEnderecoSet();
        this.nome = pais.getNome();
        this.sigla = pais.getSigla();
    }

    public Long getId() {
        return id;
    }

    public Set<Estado> getEstadoSet() {
        return estadoSet;
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
    public static Page<PaisDto> converter(Page<Pais> entity) {
        return entity.map(PaisDto::new);
    }

    public static PaisDto converter(Pais entity) {
        return new PaisDto(entity);
    }
}
