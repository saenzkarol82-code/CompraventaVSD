package com.proyecto.AccesoUsuarios.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyecto.AccesoUsuarios.model.Usuario;
import com.proyecto.AccesoUsuarios.repository.UsuarioRepository;

@Service
public class UsuarioService {

    // Repositorio para acceder a la tabla usuario
    private final UsuarioRepository usuarioRepo;

    // Encoder para cifrar contraseñas
    private final PasswordEncoder passwordEncoder;

    // Inyección por constructor (la mejor práctica en Spring Boot)
    public UsuarioService(UsuarioRepository usuarioRepo, PasswordEncoder passwordEncoder) {
        this.usuarioRepo = usuarioRepo;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Método para registrar un nuevo usuario
     */
    public Usuario registrar(Usuario u) {
        // Verifica si ya existe un usuario con el mismo correo
        if (usuarioRepo.existsByCorreoUsuario(u.getCorreoUsuario())) {
            throw new IllegalArgumentException("El correo ya está registrado");
        }

        // Encripta la contraseña antes de guardarla
        u.setPassword(passwordEncoder.encode(u.getPassword()));

        // Asigna el rol por defecto
        u.setRol("CLIENTE");

        // Guarda el usuario en la base de datos
        return usuarioRepo.save(u);
    }
}

