package com.proyecto.AccesoUsuarios.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collections;

import com.proyecto.AccesoUsuarios.model.Usuario;
import com.proyecto.AccesoUsuarios.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String correoUsuario) throws UsernameNotFoundException {
        System.out.println("🔍 Buscando usuario con correo: " + correoUsuario);

        Usuario usuario = usuarioRepository.findByCorreoUsuario(correoUsuario);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + correoUsuario);
        }

        return new User(
                usuario.getCorreoUsuario(),
                usuario.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + usuario.getRol()))
        );
    }
}

