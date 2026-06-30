package com.AJCare.proyectofinal.controllers;

import com.AJCare.proyectofinal.entities.Alumno;
import com.AJCare.proyectofinal.entities.Atencion;
import com.AJCare.proyectofinal.entities.Enfermero;
import com.AJCare.proyectofinal.repository.AlumnoRepository;
import com.AJCare.proyectofinal.repository.AtencionRepository;
import com.AJCare.proyectofinal.repository.CursoRepository;
import com.AJCare.proyectofinal.repository.EnfermeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AtencionController {

    @Autowired
    private AtencionRepository atencionRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private EnfermeroRepository enfermeroRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/agregar-atencion")
    public String agregarAtencion(
            @RequestParam(required = false) Integer cursoId,
            Model model) {

        model.addAttribute("cursos", cursoRepository.findAll());
        model.addAttribute("enfermeros", enfermeroRepository.findAll());

        if (cursoId != null) {
            model.addAttribute("alumnos", alumnoRepository.findByIdCurso_Id(cursoId));
            model.addAttribute("cursoSeleccionado", cursoId);
        } else {
            model.addAttribute("alumnos", List.of());
        }

        return "agregar-atencion";
    }

    @PostMapping("/insertar-atencion")
    public String insertarAtencion(
            @RequestParam String motivo,
            @RequestParam Integer alumnoId,
            @RequestParam Integer enfermeroId) {

        Alumno alumno = alumnoRepository.findById(alumnoId).orElse(null);
        Enfermero enfermero = enfermeroRepository.findById(enfermeroId).orElse(null);

        Atencion nueva = new Atencion(LocalDateTime.now(), motivo, alumno, enfermero);
        atencionRepository.save(nueva);
        return "redirect:/index";
    }

    @GetMapping("/eliminar-atencion/{id}")
    public String eliminarAtencion(@PathVariable("id") int id) {
        atencionRepository.deleteById(id);
        return "redirect:/index";
    }
}