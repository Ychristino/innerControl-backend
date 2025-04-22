package com.innerControl.innerControl.controller;

import com.innerControl.innerControl.controller.dto.UsuarioDTO;
import com.innerControl.innerControl.controller.form.Usuario.AtualizarUsuarioForm;
import com.innerControl.innerControl.controller.form.Usuario.UsuarioForm;
import com.innerControl.innerControl.models.Usuario;
import com.innerControl.innerControl.models.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> detalhes(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()){
            return ResponseEntity.ok(new UsuarioDTO(usuario.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder) {
        if (usuarioRepository.findByEmail(form.getEmail()).isPresent()){
            throw new IllegalArgumentException("Usuário já existe na base de dados!");
        }

        Usuario usuario = form.toEntity();
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
        URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new UsuarioDTO(usuario));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UsuarioDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarUsuarioForm form){
        Optional<Usuario> opt = usuarioRepository.findById(id);
        if (opt.isPresent()){
            Usuario usuario = form.atualizar(id, usuarioRepository);
            return ResponseEntity.ok(new UsuarioDTO(opt.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Usuario> opt = usuarioRepository.findById(id);
        if (opt.isPresent()) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}