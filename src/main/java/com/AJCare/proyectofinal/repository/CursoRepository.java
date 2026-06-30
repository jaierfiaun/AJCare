package com.AJCare.proyectofinal.repository;
import com.AJCare.proyectofinal.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository <Curso, Integer> {
}
