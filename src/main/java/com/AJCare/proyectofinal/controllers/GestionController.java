package com.AJCare.proyectofinal.controllers;
import com.AJCare.proyectofinal.entities.Curso;
import com.AJCare.proyectofinal.entities.Enfermero;
import com.AJCare.proyectofinal.repository.CursoRepository;
import com.AJCare.proyectofinal.repository.EnfermeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class GestionController {

  @Autowired
  private CursoRepository cursoRepository;

  @Autowired
  private EnfermeroRepository enfermeroRepository;

  @GetMapping("/gestion")
  public String gestion (Model model) {
    List<Curso> cursos = cursoRepository.findAll();
    model.addAttribute("cursos", cursos);

    List<Enfermero> enfermeros = enfermeroRepository.findAll();
    model.addAttribute("enfermeros", enfermeros);
    return "gestion";
  }
}
