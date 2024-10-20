package com.innerControl.dto.servico;

import com.innerControl.models.PessoaFisica;
import com.innerControl.models.Estoque;
import com.innerControl.models.Servico;

import java.util.Set;

public class ServicoDto {
    private Long id;
    private PessoaFisica pessoaFisicas;
    private Set<Estoque> estoque;

    public ServicoDto(Servico servico){
        this.id = servico.getId();
        this.pessoaFisicas = servico.getPessoaFisica();
        this.estoque = servico.getEstoque();
    }

    public Long getId() {
        return id;
    }

    public PessoaFisica getPessoaFisicas() {
        return pessoaFisicas;
    }

    public Set<Estoque> getEstoque() {
        return estoque;
    }
}
