package com.javaWeb.webappjava2024.controller;

import com.javaWeb.webappjava2024.model.Mascota;
import com.javaWeb.webappjava2024.service.DuenioService;
import com.javaWeb.webappjava2024.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MascotaViewController {

    @Autowired
    private DuenioService duenioService;
    @Autowired
    private MascotaService mascotaService;

    @GetMapping("/mascotas")
    public String listarMascotas(Model model){
        List<Mascota> mascotas=mascotaService.listarMascotas();
model.addAttribute("mascotas", mascotas);
return "mascotas";
    }
    @GetMapping("/agregarMascota")
    public String mostrarFormularioAgregarMascota(Model model){
        model.addAttribute("duenios",duenioService.listarDuenios());
        return "agregarMascota";
    }
    @PostMapping("/guardarMascota")
    public String guardarDuenio(Mascota mascota, @RequestParam long idDuenio){
mascotaService.guardarMascota(mascota,idDuenio);
return "redirect:/mascotas";
    }
}
