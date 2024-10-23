package com.innerControl.controller.form.servico;

import com.innerControl.models.PessoaFisica;
import com.innerControl.models.Produto;
import com.innerControl.models.Servico;
import com.innerControl.models.repository.ServicoRepository;

import java.util.Set;

public class AtualizarServicoForm {

    private PessoaFisica pessoaFisicas;
    private float valorServico;
    private Set<Produto> produtos;

    public Servico converter(){ return new Servico(pessoaFisicas, valorServico, produtos); }

    public Servico atualizar(Long id, ServicoRepository servicoRepository){
        Servico servico = servicoRepository.getReferenceById(id);

        servico.setPessoaFisicas(this.pessoaFisicas);
        servico.setValorServico(this.valorServico);
        servico.setProdutos(this.produtos);

        return servico;
    }
}
