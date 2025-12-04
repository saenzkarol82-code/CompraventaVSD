package com.proyecto.AccesoUsuarios.repository; 

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.AccesoUsuarios.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByCorreoUsuario(String correoUsuario); // 🔥 AGREGA ESTO

    Usuario findByCorreoUsuario(String correoUsuario); // opcional, si lo usas
}

 