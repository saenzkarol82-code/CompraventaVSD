package com.proyecto.AccesoUsuarios.config;

import com.proyecto.AccesoUsuarios.model.Usuario;
import com.proyecto.AccesoUsuarios.repository.UsuarioRepository;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration  //comandLineRunner comoponente que se ejecuta automaticamente al arrancar la aplicacion.
public class DataInitializer {
     @Bean
public CommandLineRunner initDatabase(UsuarioRepository usuarioRepo) {
    return args -> {
        // Usuario ADMIN
        if (usuarioRepo.findByCorreoUsuario("admin@correo.com").isEmpty()) {
            Usuario admin = new Usuario();
            admin.setCorreoUsuario("admin@correo.com");
            admin.setPassword(new BCryptPasswordEncoder().encode("123"));
            admin.setRol("ADMIN");
            usuarioRepo.save(admin);
            System.out.println("✅ Usuario admin creado con éxito");
        } else {
                System.out.println("ℹ️ Usuario admin ya existe");
        }

        // Usuario CLIENTE
        if (usuarioRepo.findByCorreoUsuario("cliente@correo.com").isEmpty()) {
            Usuario cliente = new Usuario();
            cliente.setCorreoUsuario("cliente@correo.com");
            cliente.setPassword(new BCryptPasswordEncoder().encode("123"));
            cliente.setRol("CLIENTE");
            usuarioRepo.save(cliente);
            System.out.println("✅ Usuario cliente creado con éxito");
        } else {
                System.out.println("ℹ️ Usuario cliente ya existe");
        }

        // Usuario VENDEDOR
        if (usuarioRepo.findByCorreoUsuario("vendedor@correo.com").isEmpty()) {
            Usuario vendedor = new Usuario();
            vendedor.setCorreoUsuario("vendedor@correo.com");
            vendedor.setPassword(new BCryptPasswordEncoder().encode("123"));
            vendedor.setRol("VENDEDOR");
            usuarioRepo.save(vendedor);
            System.out.println("✅ Usuario vendedor creado con éxito");
        }
         else {
                System.out.println("ℹ️ Usuario vendedor ya existe");
        }
    };
}

}

