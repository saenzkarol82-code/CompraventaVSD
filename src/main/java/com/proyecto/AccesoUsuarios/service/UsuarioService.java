package com.proyecto.AccesoUsuarios.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyecto.AccesoUsuarios.model.Usuario;
import com.proyecto.AccesoUsuarios.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario registrar(Usuario u) {
        if (repo.existsByCorreoUsuario(u.getCorreoUsuario())) {
            throw new IllegalArgumentException("El correo ya está registrado");
        }
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        u.setRol("CLIENTE"); // rol fijo en registro
        return repo.save(u);
    }
}

