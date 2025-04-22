package com.innerControl.innerControl.controller.form.Usuario;

import com.innerControl.innerControl.models.Usuario;
import com.innerControl.innerControl.models.repository.UsuarioRepository;

public class AtualizarUsuarioForm {
    private String nome;
    private String email;
    private String senha;

    public Usuario toEntity() {
        Usuario usuario = new Usuario();
        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        usuario.setPassword(this.senha);
        return usuario;
    }

    public Usuario atualizar(Long id, UsuarioRepository usuarioRepository){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setPassword(senha);

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