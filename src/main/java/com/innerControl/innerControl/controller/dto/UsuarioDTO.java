package com.innerControl.innerControl.controller.dto;

import com.innerControl.innerControl.models.Usuario;

public class UsuarioDTO {

    private String nome;
    private String email;

    public UsuarioDTO(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}