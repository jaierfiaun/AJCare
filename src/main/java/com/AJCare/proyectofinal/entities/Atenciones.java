package com.AJCare.proyectofinal.entities;
import jakarta.persistence.*;

@Entity
public class Atenciones {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private int id;

  @Column
  private String fechaHora;

  @Column
  private String motivo;

  @ManyToOne
  @JoinColumn(name = "id_alumno", referencedColumnName = "id")
  private Alumno idAlumno;

  @ManyToOne
  @JoinColumn(name = "id_enfermero", referencedColumnName = "id")
  private Alumno idEnfermero;
}
