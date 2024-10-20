package com.innerControl.dto.cidade;

import com.innerControl.dto.contato.ContatoDto;
import com.innerControl.dto.mapper.CidadeMapper;
import com.innerControl.models.*;
import org.springframework.data.domain.Page;

import java.util.Set;

public class CidadeDto{

    private Long id;
    private Pais pais;
    private Estado estado;
    private Set<Endereco> enderecoSet;
    private String nome;

    public CidadeDto(Cidade cidade){
        this.id = cidade.getId();
        this.pais = cidade.getPais();
        this.estado = cidade.getEstado();
        this.enderecoSet = cidade.getEnderecoSet();
        this.nome = cidade.getNome();
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

    public Set<Endereco> getEnderecoSet() {
        return enderecoSet;
    }

    public String getNome() {
        return nome;
    }


    public static Page<CidadeDto> converter(Page<Cidade> entity) {
        return entity.map(CidadeDto::new);
    }

    public static CidadeDto converter(Cidade entity) {
        return new CidadeDto(entity);
    }
}
