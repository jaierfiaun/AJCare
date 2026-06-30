package com.AJCare.proyectofinal.repository;

import com.AJCare.proyectofinal.entities.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtencionRepository extends JpaRepository<Atencion, Integer> {

    @Query("SELECT a FROM Atencion a WHERE YEAR(a.fechaHora) = :anio AND MONTH(a.fechaHora) = :mes")
    List<Atencion> findByMes(@Param("anio") int anio, @Param("mes") int mes);
}