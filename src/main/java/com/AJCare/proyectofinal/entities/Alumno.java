package com.AJCare.proyectofinal.entities;
import jakarta.persistence.*;

@Entity
public class Alumno extends Usuario{

  @Column
  private String telefonoContacto;

  @ManyToOne
  @JoinColumn(name = "id_curso", referencedColumnName = "id")
  private Curso idCurso;

}