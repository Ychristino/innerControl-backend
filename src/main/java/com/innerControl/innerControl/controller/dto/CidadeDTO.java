package com.innerControl.innerControl.controller.dto;

import com.innerControl.innerControl.models.Cidade;

public class CidadeDTO {
    private Long id;
    private String nome;
    private EstadoDTO estado;
    private PaisDTO pais;

    // Getters e Setters

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

    public EstadoDTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoDTO estado) {
        this.estado = estado;
    }

    public PaisDTO getPais() {
        return pais;
    }

    public void setPais(PaisDTO pais) {
        this.pais = pais;
    }

    public static CidadeDTO toDTO(Cidade cidade) {
        if (cidade == null) return null;

        CidadeDTO dto = new CidadeDTO();
        dto.setId(cidade.getId());
        dto.setNome(cidade.getNome());
        dto.setEstado(EstadoDTO.toDTO(cidade.getEstado()));
        dto.setPais(PaisDTO.toDTO(cidade.getPais()));
        return dto;
    }

    public static Cidade toEntity(CidadeDTO dto) {
        if (dto == null) return null;
        Cidade cidade = new Cidade();
        cidade.setNome(dto.getNome());
        cidade.setEstado(EstadoDTO.toEntity(dto.getEstado()));
        cidade.setPais(PaisDTO.toEntity(dto.getPais()));
        return cidade;
    }

}