package com.AJCare.proyectofinal.controllers;
import com.AJCare.proyectofinal.entities.Alumno;
import com.AJCare.proyectofinal.entities.Curso;
import com.AJCare.proyectofinal.entities.Enfermero;
import com.AJCare.proyectofinal.repository.AlumnoRepository;
import com.AJCare.proyectofinal.repository.CursoRepository;
import com.AJCare.proyectofinal.repository.EnfermeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlumnoController {

  @Autowired
  private AlumnoRepository alumnoRepository;

  @Autowired
  private CursoRepository cursoRepository;

  @Autowired
  private EnfermeroRepository enfermeroRepository;

  @GetMapping ("/gestion")
  public String verAlumnos (@RequestParam(name = "cursoId", required = false) Integer cursoId, Model model) {
    model.addAttribute("cursos", cursoRepository.findAll());

    List<Alumno> listaAlumnos;
    if (cursoId != null) {
      Curso cursoObjeto = cursoRepository.findById(cursoId).orElse(null);
      listaAlumnos = alumnoRepository.findByIdCurso(cursoObjeto);
      model.addAttribute("cursoSeleccionadoId", cursoId);
    } else {
      listaAlumnos = new ArrayList<>();
    }
    model.addAttribute("alumnos", listaAlumnos);

    List<Enfermero> enfermeros = enfermeroRepository.findAll();
    model.addAttribute("enfermeros", enfermeros);
    return "gestion";
  }
}
