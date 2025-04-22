package com.innerControl.innerControl.service;

import com.innerControl.innerControl.controller.form.servicoProduto.ServicoProdutoForm;
import com.innerControl.innerControl.controller.form.servicoProduto.ServicoProdutoUpdateForm;
import com.innerControl.innerControl.models.Servico;
import com.innerControl.innerControl.models.ServicoProduto;
import com.innerControl.innerControl.models.repository.ServicoProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoProdutoService {
    @Autowired
    private ServicoProdutoRepository servicoProdutoRepository;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private EstoqueService estoqueService;

    @Transactional
    public List<ServicoProduto> criar(List<ServicoProdutoForm> listaProdutos, Servico servico) {

        List<ServicoProduto> produtosUtilizados = listaProdutos.stream().map(item ->{
            if (item.getQuantidade() <= 0)
                throw new IllegalArgumentException("Quantidade de itens deve ser maior que zero!");

            estoqueService.vender(item.getIdProduto(), item.getQuantidade());

            ServicoProduto newServicoProduto = new ServicoProduto();
            newServicoProduto.setProduto(produtoService.buscarPorId(item.getIdProduto()));
            newServicoProduto.setQuantidade(item.getQuantidade());
            newServicoProduto.setValorProduto(item.getValorProduto());
            newServicoProduto.setServico(servico);

            return newServicoProduto;

        }).collect(Collectors.toList());

        return produtosUtilizados;
    }

    @Transactional
    public List<ServicoProduto> atualizar(List<ServicoProdutoUpdateForm> listaProdutos, Servico servico) {
        List<ServicoProduto> produtosUtilizadosAtuais = servico.getProdutosUtilizados();

        List<ServicoProduto> novosProdutosUtilizados = listaProdutos.stream().map(item ->{
            if (item.getQuantidade() <= 0)
                throw new IllegalArgumentException("Quantidade de itens deve ser maior que zero!");

            ServicoProduto servicoProduto = null;

            // SE NÃO INFORMAR ID JÁ CADASTRADO NO BANCO, BUSCA O ID DO PRODUTO
            if (item.getId() == null)
                servicoProduto = servicoProdutoRepository.findByProdutoId(item.getIdProduto())
                        .orElse(null);

            // SE INFORMAR, ACESSA O DADO PARA ATUALIZAR OS DADOS...
            // PARA REDUNDANCIA, CASO O ID ESTEJA INCORRETO, BUSCA O ID DO PRODUTO
            else
                servicoProduto = servicoProdutoRepository.findByIdAndServicoId(item.getId(), servico.getId())
                        .orElse(
                                servicoProdutoRepository.findByServicoIdAndProdutoId(servico.getId(), item.getIdProduto())
                                .orElse(null)
                        );

            // SE ESTIVER INCLUINDO UM NOVO ITEM
            if (servicoProduto == null){
                estoqueService.vender(item.getIdProduto(), item.getQuantidade());
                servicoProduto = new ServicoProduto();
                servicoProduto.setServico(servico);
                servicoProduto.setProduto(produtoService.buscarPorId(item.getIdProduto()));
            }
            // SE ESTIVER ATUALIZANDO UM ITEM JÁ EXISTENTE
            else {
                // SE ATUALIZAR PARA DIMINUIR A QUANTIDADE DE ITEM
                if (servicoProduto.getQuantidade() > item.getQuantidade()){
                    estoqueService.devolver(item.getIdProduto(), (servicoProduto.getQuantidade() - item.getQuantidade()));
                }
                // SE NÃO, ADICIONA O QUE FALTOU NA VENDA, SE NECESSÁRIO
                else if (item.getQuantidade() > servicoProduto.getQuantidade()){
                    estoqueService.vender(item.getIdProduto(), item.getQuantidade() - servicoProduto.getQuantidade());
                }
            }
            servicoProduto.setQuantidade(item.getQuantidade());
            servicoProduto.setValorProduto(item.getValorProduto());

            return servicoProduto;

        }).collect(Collectors.toList());

        // Remover itens que não estão mais na lista
        produtosUtilizadosAtuais.stream()
                .filter(i -> novosProdutosUtilizados.stream().noneMatch(n -> n.getId() != null && n.getId().equals(i.getId())))
                .forEach(item -> {
                    // Devolver os produtos ao estoque
                    estoqueService.devolver(item.getProduto().getId(), item.getQuantidade());
                    servicoProdutoRepository.delete(item);
                });

        return novosProdutosUtilizados;
    }

    @Transactional
    public void excluir(Long id) {
        servicoProdutoRepository.findById(id).ifPresent(servicoProduto->{
                            estoqueService.devolver(servicoProduto.getProduto().getId(), servicoProduto.getQuantidade());
                        });
        servicoProdutoRepository.deleteById(id);
    }
}
