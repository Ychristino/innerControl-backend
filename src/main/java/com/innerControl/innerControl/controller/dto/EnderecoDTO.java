package com.innerControl.innerControl.controller.dto;

import com.innerControl.innerControl.models.Endereco;

public class EnderecoDTO {
    private Long id;
    private String logradouro;
    private String numero;
    private String cep;
    private String complemento;
    private CidadeDTO cidade;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public CidadeDTO getCidade() {
        return cidade;
    }

    public void setCidade(CidadeDTO cidade) {
        this.cidade = cidade;
    }

    public static EnderecoDTO toDTO(Endereco endereco) {
        if (endereco == null) return null;

        EnderecoDTO dto = new EnderecoDTO();
        dto.setId(endereco.getId());
        dto.setLogradouro(endereco.getLogradouro());
        dto.setNumero(endereco.getNumero());
        dto.setCep(endereco.getCep());
        dto.setComplemento(endereco.getComplemento());
        dto.setCidade(CidadeDTO.toDTO(endereco.getCidade()));
        return dto;
    }

    public static Endereco toEntity(EnderecoDTO dto) {
        if (dto == null) return null;

        Endereco endereco = new Endereco();
        endereco.setLogradouro(dto.getLogradouro());
        endereco.setNumero(dto.getNumero());
        endereco.setCep(dto.getCep());
        endereco.setComplemento(dto.getComplemento());
        endereco.setCidade(CidadeDTO.toEntity(dto.getCidade()));
        return endereco;
    }

}