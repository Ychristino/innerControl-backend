package com.innerControl.controller.form.servico;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.innerControl.models.PessoaFisica;
import com.innerControl.models.Produto;
import com.innerControl.models.Servico;
import com.innerControl.models.repository.ServicoRepository;
import com.innerControl.service.PessoaFisicaService;
import com.innerControl.service.ProdutoService;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.stream.Collectors;

public class AtualizarServicoForm {
    @NotNull
    @NotEmpty
    @JsonProperty("pessoaFisicaId")
    private Long pessoaFisicaId;
    @NotNull
    @NotEmpty
    @JsonProperty("valorServico")
    private float valorServico;
    @NotNull
    @NotEmpty
    @JsonProperty("listaProdutosId")
    private Set<Long> produtosId;
    public Servico converter(){
        return new Servico(
                new PessoaFisicaService().buscarPessoa(pessoaFisicaId),
                valorServico,
                produtosId.stream()
                        .map(produto ->{ return new ProdutoService().buscarProduto(produto); })
                        .collect(Collectors.toSet()));
    }

    public Servico atualizar(Long id, ServicoRepository servicoRepository){
        Servico servico = servicoRepository.getReferenceById(id);
        servico.setPessoaFisicas(new PessoaFisicaService().buscarPessoa(pessoaFisicaId));
        servico.setValorServico(this.valorServico);
        servico.setProdutos(produtosId.stream()
                .map(produto ->{ return new ProdutoService().buscarProduto(produto); })
                .collect(Collectors.toSet()));
        return servico;
    }
}
