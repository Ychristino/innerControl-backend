package com.innerControl.controller.form.servico;

import com.innerControl.models.PessoaFisica;
import com.innerControl.models.Estoque;
import com.innerControl.models.Servico;
import com.innerControl.models.repository.ServicoRepository;

import java.util.Set;

public class AtualizarServicoForm {

    private Long id;
    private PessoaFisica pessoaFisicas;
    private Set<Estoque> estoque;

    public Servico converter(){ return new Servico(pessoaFisicas, estoque); }

    public Servico atualizar(Long id, ServicoRepository servicoRepository){
        Servico servico = servicoRepository.getReferenceById(id);

        servico.setPessoaFisicas(this.pessoaFisicas);
        servico.setEstoque(this.estoque);

        return servico;
    }
}
