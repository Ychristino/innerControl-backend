package com.innerControl.controller.form.endereco;

import com.innerControl.models.*;
import com.innerControl.models.repository.CidadeRepository;
import com.innerControl.models.repository.EnderecoRepository;

import java.util.Set;

public class AtualizarEnderecoForm {
    private Pais pais;
    private Estado estado;
    private Cidade cidade;
    private String cep;
    private String logradouro;
    private int numero;
    private String complemento;

    public Endereco converter(){ return new Endereco(pais, estado, cidade, cep, logradouro, numero, complemento); }

    public Endereco atualizar(Long id, EnderecoRepository enderecoRepository){
        Endereco endereco = enderecoRepository.getReferenceById(id);
        endereco.setPais(this.pais);
        endereco.setEstado(this.estado);
        endereco.setCidade(this.cidade);
        endereco.setCep(this.cep);
        endereco.setLogradouro(this.logradouro);
        endereco.setNumero(this.numero);
        endereco.setComplemento(this.complemento);
        return endereco;
    }
}
