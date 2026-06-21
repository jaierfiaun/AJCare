package com.AJCare.proyectofinal.controllers;
import com.AJCare.proyectofinal.entities.Enfermero;
import com.AJCare.proyectofinal.repository.EnfermeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EnfermeroController {

  @Autowired
  private EnfermeroRepository enfermeroRepository;

  @GetMapping ("/agregar-enfermero")
  public String agregarEnfermo () {
    return "agregar-enfermero";
  }

  @PostMapping ("/insertar-enfermero")
  public String insertarEnfermero (@RequestParam String rut, @RequestParam String nombres, @RequestParam String apellidos) {
    Enfermero nuevoEnfermero = new Enfermero(rut, nombres, apellidos);
    enfermeroRepository.save(nuevoEnfermero);
    return "redirect:/gestion";
  }

  @GetMapping ("/eliminar-enfermero/{id}")
  public String eliminarEnfermero (@PathVariable("id") int id) {
    enfermeroRepository.deleteById(id);
    return "redirect:/gestion";
  }

  @GetMapping ("/editar-enfermero/{id}")
  public String editarEnfermero (@PathVariable("id") int id, Model model) {
    Enfermero enfermero = enfermeroRepository.findById(id).orElse(null);
    model.addAttribute("enfermero", enfermero);
    return "editar-enfermero";
  }

  @PostMapping ("/actualizar-enfermero")
  public String actualizarEnfermero (@ModelAttribute("enfermero") Enfermero enfermero) {
    enfermeroRepository.save(enfermero);
    return "redirect:/gestion";
  }
}
