package com.AJCare.proyectofinal.entities;
import jakarta.persistence.*;

@Entity
public class Curso {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private int id;

  @Column
  private String nombre;


  public int getId() {
    return id;
  }
  public String getNombre() {
    return nombre;
  }
}
