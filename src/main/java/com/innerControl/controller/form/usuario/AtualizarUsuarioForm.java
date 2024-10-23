package com.innerControl.controller.form.usuario;

import com.innerControl.models.Usuario;
import com.innerControl.models.repository.UsuarioRepository;

public class AtualizarUsuarioForm {
    private String nome;
    private String email;
    private String senha;

    public Usuario converter(){ return new Usuario(nome, email, senha); }

    public Usuario atualizar(Long id, UsuarioRepository usuarioRepository){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setPassword(senha);

        return usuario;
    }
}
