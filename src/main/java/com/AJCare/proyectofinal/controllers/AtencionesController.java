package com.AJCare.proyectofinal.controllers;

import com.AJCare.proyectofinal.repository.AlumnoRepository;
import com.AJCare.proyectofinal.repository.AtencionesRepository;
import com.AJCare.proyectofinal.services.AtencionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AtencionesController {
    @Autowired
    private AtencionesRepository atencionesRepository;
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private AtencionesService atencionesService;

    @GetMapping("/atenciones")
    public String listar (Model model){
        model.addAttribute("atenciones", atencionesRepository.findAll());
        model.addAttribute("alumnos", alumnoRepository.findAll());
        return "atenciones";

    }

    @PostMapping("atenciones")
    public String crearAtencion(@RequestParam int idAlumno, @RequestParam int idEnfermero,
                                @RequestParam String motivo){

        atencionesService.registrarAtencion(idAlumno, idEnfermero, motivo);
        return "redirect:/atenciones";
    }

}
