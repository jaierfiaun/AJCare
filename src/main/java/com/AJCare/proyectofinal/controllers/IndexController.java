package com.AJCare.proyectofinal.controllers;
import com.AJCare.proyectofinal.entities.Atencion;
import com.AJCare.proyectofinal.repository.AtencionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private AtencionRepository atencionRepository;

    @GetMapping("/index")
    public String index(Model model) {
        List<Atencion> atenciones = atencionRepository.findAll();
        model.addAttribute("atenciones", atenciones);
        return "index";
    }
}
