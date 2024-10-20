package com.innerControl.dto.servico;

import com.innerControl.dto.cidade.CidadeDto;
import com.innerControl.dto.mapper.ServicoMapper;
import com.innerControl.models.Cidade;
import com.innerControl.models.PessoaFisica;
import com.innerControl.models.Estoque;
import com.innerControl.models.Servico;
import org.springframework.data.domain.Page;

import java.util.Set;

public class ServicoDto{
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


    public static Page<ServicoDto> converter(Page<Servico> entity) {
        return entity.map(ServicoDto::new);
    }

    public static ServicoDto converter(Servico entity) {
        return new ServicoDto(entity);
    }
}
