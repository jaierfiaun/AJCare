package com.AJCare.proyectofinal.entities;

import com.AJCare.proyectofinal.enums.Jornada;
import com.AJCare.proyectofinal.enums.Nivel;
import jakarta.persistence.*;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String curso;

    @Column
    private Nivel nivel;

    @Column
    private Jornada jornada;
}
