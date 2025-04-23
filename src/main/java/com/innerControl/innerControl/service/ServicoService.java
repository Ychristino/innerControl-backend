package com.innerControl.innerControl.service;

import com.innerControl.innerControl.controller.form.servico.ServicoForm;
import com.innerControl.innerControl.controller.form.servico.ServicoUpdateForm;
import com.innerControl.innerControl.models.PessoaFisica;
import com.innerControl.innerControl.models.Servico;
import com.innerControl.innerControl.models.repository.ServicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;
    @Autowired
    private PessoaFisicaService pessoaFisicaService;
    @Autowired
    private ServicoProdutoService servicoProdutoService;

    @Transactional
    public Servico criar(ServicoForm form) {
        PessoaFisica pessoa = pessoaFisicaService.buscarPorId(form.getPessoaId());

        if (form.getDataEntrada().after(form.getDataEntrega()))
            throw new IllegalArgumentException("Data de entrega não pode ser anterior a entrada!");

        Servico servico = new Servico();
        servico.setDescricao(form.getDescricao());
        servico.setDataEntrada(form.getDataEntrada());
        servico.setDataEntrega(form.getDataEntrega());
        servico.setValor(form.getValor());
        servico.setPessoa(pessoa);
        servico.setProdutosUtilizados(servicoProdutoService.criar(form.getProdutosUtilizados(), servico));

        return servicoRepository.save(servico);
    }

    @Transactional
    public Servico atualizar(Long id, ServicoUpdateForm form){
        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Serviço não encontrado!"));

        if (form.getDataEntrada().after(form.getDataEntrega()))
            throw new IllegalArgumentException("Data de entrega não pode ser anterior a entrada!");

        servico.setDescricao(form.getDescricao());
        servico.setDataEntrada(form.getDataEntrada());
        servico.setDataEntrega(form.getDataEntrega());
        servico.setValor(form.getValor());
        servico.setProdutosUtilizados(servicoProdutoService.atualizar(form.getProdutosUtilizados(), servico));

        return servicoRepository.save(servico);
    }

    public Page<Servico> listarServicos(Pageable pageable) {
        return servicoRepository.findAll(pageable);
    }

    public List<Servico> listarServicos() {
        return servicoRepository.findAll();
    }

    public Page<Servico> listarServicos(String nome, Date dataEntrada, Date dataEntrega, Pageable pageable) {
        return servicoRepository.findAllByPessoaNomeContainingIgnoreCaseAndDataEntradaAfterAndDataEntregaAfter(nome, dataEntrada, dataEntrega, pageable);
    }
    @Transactional
    public void excluir(Long id) {
        // BUSCA OS ITENS PARA PERMITIR DEVOLVER TUDO PARA O ESTOQUE
        servicoRepository.findById(id).ifPresent((servico)->{
            servico.getProdutosUtilizados().stream().forEach(item->{
                servicoProdutoService.excluir(item.getId());
            });
        });
        servicoRepository.deleteById(id);
    }

    public Servico buscarPorId(Long id){
        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado!"));
        return servico;
    }
}
