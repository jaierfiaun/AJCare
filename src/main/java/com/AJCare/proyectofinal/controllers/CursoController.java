package com.AJCare.proyectofinal.controllers;
import com.AJCare.proyectofinal.entities.Curso;
import com.AJCare.proyectofinal.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CursoController {

  @Autowired
  private CursoRepository cursoRepository;

  @GetMapping("/gestion")
  public String gestion (Model model) {
    List<Curso> cursos = cursoRepository.findAll();
    model.addAttribute("cursos", cursos);
    return "gestion";
  }
}
