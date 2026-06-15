package com.AJCare.proyectofinal.entities;
import jakarta.persistence.*;

@Entity
public class Medicamento {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private int id;

  @Column
  private String nombre;

  @Column
  private String horaAdministracion;

  @ManyToOne
  @JoinColumn(name = "id_alumno", referencedColumnName = "id")
  private Alumno idAlumno;
}
