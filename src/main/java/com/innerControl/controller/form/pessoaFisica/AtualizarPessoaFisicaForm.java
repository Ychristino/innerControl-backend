package com.innerControl.controller.form.pessoaFisica;

import com.innerControl.models.Contato;
import com.innerControl.models.Endereco;
import com.innerControl.models.PessoaFisica;
import com.innerControl.models.repository.PessoaFisicaRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

public class AtualizarPessoaFisicaForm {

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    private String cpf;

    @NotNull
    @NotBlank
    private Date dataNascimento;

    @NotNull
    @NotBlank
    @NotEmpty
    private Set<Endereco> endereco;

    @NotNull
    @NotBlank
    @NotEmpty
    private Set<Contato> contato;

    public PessoaFisica converter(){
        return new PessoaFisica(nome, cpf, dataNascimento, endereco, contato);
    }

    public PessoaFisica atualizar(Long id, PessoaFisicaRepository pessoaFisicaRepository){
        PessoaFisica pessoaFisica = pessoaFisicaRepository.getReferenceById(id);

        pessoaFisica.setNome(this.nome);
        pessoaFisica.setCpf(this.cpf);
        pessoaFisica.setDataNascimento(this.dataNascimento);
        pessoaFisica.setContato(this.contato);
        pessoaFisica.setEndereco(this.endereco);

        return pessoaFisica;
    }
}