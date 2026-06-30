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
import org.springframework.web.bind.annotation.*;
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

  @GetMapping ("/agregar-alumno")
  public String agregarAlumno (Model model) {
    model.addAttribute("cursos", cursoRepository.findAll());
    return "agregar-alumno";
  }

  @PostMapping ("/insertar-alumno")
  public String insertarAlumno (@RequestParam String rut, @RequestParam String nombres, @RequestParam String apellidos, @RequestParam String telefonoContacto, @RequestParam(name = "cursoId", required = false) Integer cursoId) {
    Curso cursoObjeto = cursoRepository.findById(cursoId).orElse(null);
    Alumno nuevoAlumno = new Alumno(rut, nombres, apellidos, telefonoContacto, cursoObjeto);
    alumnoRepository.save(nuevoAlumno);
    return "redirect:/gestion";
  }

  @GetMapping ("/eliminar-alumno/{id}")
  public String eliminarAlumno (@PathVariable("id") int id) {
    alumnoRepository.deleteById(id);
    return "redirect:/gestion";
  }

  @GetMapping ("/editar-alumno/{id}")
  public String editarAlumno (@PathVariable("id") int id, Model model) {
    Alumno alumno = alumnoRepository.findById(id).orElse(null);
    model.addAttribute("alumno", alumno);
    return "editar-alumno";
  }

  @PostMapping ("/actualizar-alumno")
  public String actualizarAlumno (@ModelAttribute("alumno") Alumno alumno) {

    alumnoRepository.save(alumno);
    return "redirect:/gestion";
  }
}
