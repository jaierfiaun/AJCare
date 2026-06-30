package com.AJCare.proyectofinal.entities;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
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

  public Usuario() {}

  public Usuario(String rut, String nombres, String apellidos) {
    this.rut = rut;
    this.nombres = nombres;
    this.apellidos = apellidos;
  }

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getRut() {
    return rut;
  }
  public void setRut(String rut) {
    this.rut = rut;
  }
  public String getNombres() {
    return nombres;
  }
  public void setNombres(String nombres) {
    this.nombres = nombres;
  }
  public String getApellidos() {
    return apellidos;
  }
  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

}
