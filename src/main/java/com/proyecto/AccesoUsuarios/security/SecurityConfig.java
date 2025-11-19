package com.proyecto.AccesoUsuarios.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//permisos de los usuarios

@Configuration
@EnableWebSecurity  // <- “Activa la configuración personalizada de seguridad web que yo voy a definir.”
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers( "/","/index", "/inicio","/login", "/css/**", "/js/**", "/img/**").permitAll()  //cualquier usuario sin autenticar
                .requestMatchers("/usuarios/**").hasRole("ADMIN")  // rutas y subrutas, solo permitidas a Perfil ADMIN
                .requestMatchers("/perfil/**").authenticated()    // rutas permitidas para usuarios autenticados : actualiza perfil usuario
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                  .loginPage("/login")  // comportamiento del proceso de inicio de sesión
                .defaultSuccessUrl("/home", true) //cuando el usuario se logea, se dirige al home.html
                .permitAll()   //permitido a cualquier usuario
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll() //permitido a cualquier usuario
            );
            
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


