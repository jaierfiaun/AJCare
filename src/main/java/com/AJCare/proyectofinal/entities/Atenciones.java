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
  private Enfermero idEnfermero;

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public void setIdEnfermero(Enfermero idEnfermero) {
        this.idEnfermero = idEnfermero;
    }
}
