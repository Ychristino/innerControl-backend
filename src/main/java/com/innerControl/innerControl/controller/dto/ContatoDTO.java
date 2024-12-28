package com.innerControl.innerControl.controller.dto;

import com.innerControl.innerControl.models.Contato;
import com.innerControl.innerControl.utils.ContatoEnum;

public class ContatoDTO {
    private Long id;
    private ContatoEnum tipo;
    private String valor;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContatoEnum getTipo() {
        return tipo;
    }

    public void setTipo(ContatoEnum tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public static ContatoDTO toDTO(Contato contato) {
        if (contato == null) return null;

        ContatoDTO dto = new ContatoDTO();
        dto.setId(contato.getId());
        dto.setTipo(contato.getTipo());
        dto.setValor(contato.getValor());
        return dto;
    }
}
