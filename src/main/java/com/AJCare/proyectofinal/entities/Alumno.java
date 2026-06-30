package com.AJCare.proyectofinal.entities;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Alumno")
public class Alumno extends Usuario{

  @Column
  private String telefonoContacto;

  @ManyToOne
  @JoinColumn(name = "id_curso", referencedColumnName = "id")
  private Curso idCurso;

  public Alumno() {
    super();
  }

  public Alumno(String rut, String nombres, String apellidos, String telefonoContacto, Curso idCurso) {
    super(rut, nombres, apellidos);
    this.telefonoContacto = telefonoContacto;
    this.idCurso = idCurso;
  }

  public String getTelefonoContacto() {
    return telefonoContacto;
  }
  public void setTelefonoContacto(String telefonoContacto) {
    this.telefonoContacto = telefonoContacto;
  }
  public Curso getIdCurso() {
    return idCurso;
  }
  public void setIdCurso(Curso idCurso) {
    this.idCurso = idCurso;
  }
}