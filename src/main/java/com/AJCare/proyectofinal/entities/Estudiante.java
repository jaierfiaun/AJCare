package com.AJCare.proyectofinal.entities;

import jakarta.persistence.*;

@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column
    private String rut;

    @Column
    private String nombre;

    @Column
    private String apellidos;

    @Column
    private String curso;
}
