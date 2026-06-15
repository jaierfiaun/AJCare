package com.AJCare.proyectofinal.entities;
import jakarta.persistence.*;

@Entity
public class Curso {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column
  private String nombre;

}
