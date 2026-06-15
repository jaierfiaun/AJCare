package com.AJCare.proyectofinal.entities;
import jakarta.persistence.*;

@Entity
public class Alumno {
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

  @Column
  private String telefonoContacto;

  @ManyToOne
  @JoinColumn(name = "id_curso", referencedColumnName = "id")
  private Curso idCurso;
}
