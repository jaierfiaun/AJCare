package com.AJCare.proyectofinal.entities;
import jakarta.persistence.*;

@Entity
public class RegistroMedicamento {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private int id;

  @Column
  private String fechaHora;

  @ManyToOne
  @JoinColumn(name = "id_medicamento", referencedColumnName = "id")
  private Medicamento idMedicamento;
}
