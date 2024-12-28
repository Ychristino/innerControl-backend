package com.innerControl.innerControl.controller.dto;

import com.innerControl.innerControl.models.Contato;
import com.innerControl.innerControl.models.Endereco;
import com.innerControl.innerControl.models.PessoaFisica;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PessoaFisicaDTO {
    private Long id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private List<EnderecoDTO> enderecos;
    private List<ContatoDTO> contatos;

    public PessoaFisicaDTO(Long id, String nome, String cpf, Date dataNascimento, List<Endereco> enderecos, List<Contato> contatos) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.enderecos = enderecos != null
                ? enderecos.stream()
                .map(EnderecoDTO::toDTO)
                .collect(Collectors.toList())
                : null;

        // Mapeando contatos para DTOs
        this.contatos = contatos != null
                ? contatos.stream()
                .map(ContatoDTO::toDTO)
                .collect(Collectors.toList())
                : null;
    }

    public PessoaFisicaDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<EnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoDTO> enderecos) {
        this.enderecos = enderecos;
    }

    public List<ContatoDTO> getContatos() {
        return contatos;
    }

    public void setContatos(List<ContatoDTO> contatos) {
        this.contatos = contatos;
    }

    public static PessoaFisicaDTO toDTO(PessoaFisica pessoaFisica) {
        if (pessoaFisica == null) return null;

        PessoaFisicaDTO dto = new PessoaFisicaDTO();
        dto.setId(pessoaFisica.getId());
        dto.setNome(pessoaFisica.getNome());
        dto.setCpf(pessoaFisica.getCpf());
        dto.setDataNascimento(pessoaFisica.getDataNascimento());

        // Convertendo endereços para DTOs
        if (pessoaFisica.getEnderecos() != null) {
            dto.setEnderecos(pessoaFisica.getEnderecos().stream()
                    .map(EnderecoDTO::toDTO)
                    .toList());
        }

        // Convertendo contatos para DTOs
        if (pessoaFisica.getContatos() != null) {
            dto.setContatos(pessoaFisica.getContatos().stream()
                    .map(ContatoDTO::toDTO)
                    .toList());
        }

        return dto;
    }
}
