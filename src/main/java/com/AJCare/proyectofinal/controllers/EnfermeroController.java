package com.AJCare.proyectofinal.controllers;
import com.AJCare.proyectofinal.repository.EnfermeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnfermeroController {

  @Autowired
  private EnfermeroRepository enfermeroRepository;

  @GetMapping ("/agregar-enfermero")
  public String agregarEnfermo () {
    return "agregar-enfermero";
  }

}
