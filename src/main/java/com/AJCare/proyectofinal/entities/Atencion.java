package com.AJCare.proyectofinal.entities;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;


@Entity
public class Atencion {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private int id;

  @Column
  private LocalDateTime fechaHora;

  @Column
  private String motivo;

  @ManyToOne
  @JoinColumn(name = "id_alumno", referencedColumnName = "id")
  private Alumno idAlumno;

  @ManyToOne
  @JoinColumn(name = "id_enfermero", referencedColumnName = "id")
  private Enfermero idEnfermero;

    public Atencion(LocalDateTime fechaHora, String motivo, Alumno idAlumno, Enfermero idEnfermero) {
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.idAlumno = idAlumno;
        this.idEnfermero = idEnfermero;
    }

    public Atencion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Enfermero getIdEnfermero() {
        return idEnfermero;
    }

    public void setIdEnfermero(Enfermero idEnfermero) {
        this.idEnfermero = idEnfermero;
    }
}
