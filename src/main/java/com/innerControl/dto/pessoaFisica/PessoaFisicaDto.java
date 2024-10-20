package com.innerControl.dto.pessoaFisica;

import com.innerControl.dto.mapper.PessoaFisicaMapper;
import com.innerControl.dto.produto.ProdutoDto;
import com.innerControl.models.Contato;
import com.innerControl.models.Endereco;
import com.innerControl.models.PessoaFisica;
import com.innerControl.models.Produto;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.Set;

public class PessoaFisicaDto{

    private Long id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private Set<Endereco> endereco;
    private Set<Contato> contato;

    public PessoaFisicaDto(PessoaFisica pessoaFisica){
        this.id = pessoaFisica.getId();
        this.nome = pessoaFisica.getNome();
        this.cpf = pessoaFisica.getCpf();
        this.dataNascimento = pessoaFisica.getDataNascimento();
        this.endereco = pessoaFisica.getEndereco();
        this.contato = pessoaFisica.getContato();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Set<Endereco> getEndereco() {
        return endereco;
    }

    public Set<Contato> getContato() {
        return contato;
    }

    public static Page<PessoaFisicaDto> converter(Page<PessoaFisica> entity) {
        return entity.map(PessoaFisicaDto::new);
    }

    public static PessoaFisicaDto converter(PessoaFisica entity) {
        return new PessoaFisicaDto(entity);
    }

}
