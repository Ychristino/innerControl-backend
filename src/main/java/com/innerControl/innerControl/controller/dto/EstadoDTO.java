package com.innerControl.innerControl.controller.dto;

import com.innerControl.innerControl.models.Estado;

public class EstadoDTO {
    private Long id;
    private String nome;
    private String sigla;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public PaisDTO getPais() {
        return pais;
    }

    public void setPais(PaisDTO pais) {
        this.pais = pais;
    }

    public static EstadoDTO toDTO(Estado estado) {
        if (estado == null) return null;
        EstadoDTO dto = new EstadoDTO();
        dto.setId(estado.getId());
        dto.setNome(estado.getNome());
        dto.setSigla(estado.getSigla());
        dto.setPais(PaisDTO.toDTO(estado.getPais()));
        return dto;
    }

    public static Estado toEntity(EstadoDTO dto) {
        if (dto == null) return null;

        Estado estado = new Estado();
        estado.setNome(dto.getNome());
        estado.setSigla(dto.getSigla());
        estado.setPais(PaisDTO.toEntity(dto.getPais()));
        return estado;
    }

}