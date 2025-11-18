 package com.proyecto.AccesoUsuarios.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collections;
import com.proyecto.AccesoUsuarios.model.Usuario;
import com.proyecto.AccesoUsuarios.repository.UsuarioRepository;

// Módulo: Servicio de autenticación    
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correoUsuario)  throws UsernameNotFoundException {
        // Buscar el usuario en la base de datos
        Usuario usuario = usuarioRepository.findByCorreoUsuario(correoUsuario)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + correoUsuario));

        // Crea un objeto Authentication y lo guarda en el SecurityContext.
        // A partir de aquí, cada petición del usuario ya está autenticada.
        return new User(
        usuario.getCorreoUsuario(),
        usuario.getPassword(),
        Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + usuario.getRol())));
    }
}


