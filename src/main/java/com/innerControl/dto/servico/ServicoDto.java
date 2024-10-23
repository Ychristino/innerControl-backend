package com.innerControl.dto.servico;

import com.innerControl.models.PessoaFisica;
import com.innerControl.models.Produto;
import com.innerControl.models.Servico;
import org.springframework.data.domain.Page;

import java.util.Set;

public class ServicoDto{
    private Long id;
    private PessoaFisica pessoaFisicas;
    private Set<Produto> produtos;

    public ServicoDto(Servico servico){
        this.id = servico.getId();
        this.pessoaFisicas = servico.getPessoaFisica();
        this.produtos = servico.getProdutos();
    }

    public Long getId() {
        return id;
    }

    public PessoaFisica getPessoaFisicas() {
        return pessoaFisicas;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }


    public static Page<ServicoDto> converter(Page<Servico> entity) {
        return entity.map(ServicoDto::new);
    }

    public static ServicoDto converter(Servico entity) {
        return new ServicoDto(entity);
    }
}
