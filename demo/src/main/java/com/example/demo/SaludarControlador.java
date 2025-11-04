package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SaludarControlador {
    @RequestMapping("/plantilla")
        public String plantilla(Model modelo){
            modelo.addAttribute("mensaje", "paso de prmts");
            return "saludar";
        }
}
