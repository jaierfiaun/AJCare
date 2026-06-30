package com.AJCare.proyectofinal.repository;
import com.AJCare.proyectofinal.entities.Alumno;
import com.AJCare.proyectofinal.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
    List<Alumno> findByIdCurso_Id(int idCurso);
    List<Alumno> findByIdCurso(Curso idCurso);
}