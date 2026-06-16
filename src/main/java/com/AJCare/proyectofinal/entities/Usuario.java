package com.AJCare.proyectofinal.entities;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private int id;

  @Column
  private String rut;

  @Column
  private String nombres;

  @Column
  private String apellidos;
}
