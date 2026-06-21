package com.AJCare.proyectofinal.entities;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Enfermero")
public class Enfermero extends Usuario{

  public Enfermero() {
    super();
  }

  public Enfermero(String rut, String nombres, String apellidos) {
    super(rut, nombres, apellidos);
  }
}
