package com.proyecto.AccesoUsuarios.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; 

@Entity 
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario") // PK de la tabla
    private Long idUsuario;

    @Column(name = "documentoUsuario", nullable = false)
    private String documentoUsuario;

    @Column(name = "nombreUsuario", nullable = false)
    private String nombreUsuario;

    @Column(name = "apellidoUsuario", nullable = false)
    private String apellidoUsuario;

    @Column(name = "telefonoUsuario", nullable = false)
    private Integer telefonoUsuario;

    @Column(name = "correoUsuario", unique = true)
    private String correoUsuario;

    @Column(name = "contraseñaUsuario", nullable = false)
    private String password;

    private String rol;



    

    

    
}

