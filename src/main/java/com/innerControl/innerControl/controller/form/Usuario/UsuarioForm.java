package com.innerControl.innerControl.controller.form.Usuario;

import com.innerControl.innerControl.models.Cidade;
import com.innerControl.innerControl.models.Estado;
import com.innerControl.innerControl.models.Pais;
import com.innerControl.innerControl.models.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UsuarioForm {
    @NotNull(message = "Nome deve ser informado!")
    @NotEmpty(message = "Nome não pode ser <<vazio>>!")
    @NotBlank(message = "Nome não pode ser <<branco>>!")
    private String nome;
    @NotNull(message = "Email deve ser informado!")
    @NotEmpty(message = "Email não pode ser <<vazio>>!")
    @NotBlank(message = "Email não pode ser <<branco>>!")
    private String email;
    @NotNull(message = "Senha deve ser informado!")
    @NotEmpty(message = "Senha não pode ser <<vazio>>!")
    @NotBlank(message = "Senha não pode ser <<branco>>!")
    private String senha;

    public Usuario toEntity() {
        Usuario usuario = new Usuario();
        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        usuario.setPassword(this.senha);
        return usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}