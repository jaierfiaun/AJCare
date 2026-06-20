package com.AJCare.proyectofinal.repository;
import com.AJCare.proyectofinal.entities.Enfermero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnfermeroRepository extends JpaRepository <Enfermero, Integer> {
}
