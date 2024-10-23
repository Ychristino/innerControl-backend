package com.innerControl.controller.form.usuario;

import com.innerControl.models.Usuario;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioForm {
    @NotNull
    @NotEmpty
    @NotBlank
    private String nome;
    @NotNull
    @NotEmpty
    @NotBlank
    private String email;
    @NotNull
    @NotEmpty
    @NotBlank
    private String senha;

    public Usuario converter(){ return new Usuario(nome, email, senha); }


}
