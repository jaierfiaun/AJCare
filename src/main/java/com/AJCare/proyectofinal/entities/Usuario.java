package com.AJCare.proyectofinal.entities;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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

  public String getRut() {
    return rut;
  }
  public String getNombres() {
    return nombres;
  }
  public String getApellidos() {
    return apellidos;
  }
}
