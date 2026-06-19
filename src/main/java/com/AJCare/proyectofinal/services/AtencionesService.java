package com.AJCare.proyectofinal.services;

import com.AJCare.proyectofinal.entities.Alumno;
import com.AJCare.proyectofinal.entities.Atenciones;
import com.AJCare.proyectofinal.entities.Enfermero;
import com.AJCare.proyectofinal.repository.AlumnoRepository;
import com.AJCare.proyectofinal.repository.AtencionesRepository;
import com.AJCare.proyectofinal.repository.EnfermeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class AtencionesService {
    @Autowired
    private AtencionesRepository atencionesRepository;
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private EnfermeroRepository enfermeroRepository;

    public Atenciones registrarAtencion(int idAlumno, int idEnfermero, String motivo){
        Alumno alumno = alumnoRepository.findById(idAlumno)
                .orElseThrow(()-> new RuntimeException("Alumno no encontrado"));
        Enfermero enfermero = enfermeroRepository.findById(idEnfermero)
                .orElseThrow(() -> new RuntimeException("Enfermero no encontrado")) ;

        String fechaYHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm"));


        Atenciones atencion = new Atenciones();
        atencion.setIdAlumno(alumno);
        atencion.setIdEnfermero(enfermero);
        atencion.setMotivo(motivo);
        atencion.setFechaHora(fechaYHora);

        return atencionesRepository.save(atencion);
    }
}
