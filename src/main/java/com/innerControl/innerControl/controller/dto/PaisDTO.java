package com.innerControl.innerControl.controller.dto;

import com.innerControl.innerControl.models.Pais;

public class PaisDTO {
    private Long id;
    private String nome;
    private String sigla;

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

    public static PaisDTO toDTO(Pais pais) {
        if (pais == null) return null;

        PaisDTO dto = new PaisDTO();
        dto.setId(pais.getId());
        dto.setNome(pais.getNome());
        dto.setSigla(pais.getSigla());
        return dto;
    }

    public static Pais toEntity(PaisDTO dto) {
        if (dto == null) return null;
        Pais pais = new Pais();
        pais.setNome(dto.getNome());
        pais.setSigla(dto.getSigla());
        return pais;
    }

}