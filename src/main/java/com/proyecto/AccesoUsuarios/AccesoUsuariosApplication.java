package com.proyecto.AccesoUsuarios;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableJpaRepositories(basePackages = "com.proyecto.AccesoUsuarios.repository")
@SpringBootApplication(scanBasePackages = "com.proyecto.AccesoUsuarios")


public class AccesoUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccesoUsuariosApplication.class, args);
	}

}
