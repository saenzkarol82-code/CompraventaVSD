package com.proyecto.AccesoUsuarios.model;


import jakarta.persistence.Table;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Rol")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Rol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "idRol")
    private Integer idRol;

    @Column(name = "nombreRol", nullable = false)
    private String nombreRol;
    

    

}
