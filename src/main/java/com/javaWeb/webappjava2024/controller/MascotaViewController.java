package com.javaWeb.webappjava2024.controller;

import com.javaWeb.webappjava2024.model.Mascota;
import com.javaWeb.webappjava2024.service.DuenioService;
import com.javaWeb.webappjava2024.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

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
    public String guardarDuenio(@ModelAttribute Mascota mascota, @RequestParam long idDuenio){
mascotaService.guardarMascota(mascota,idDuenio);
return "redirect:/mascotas";
    }
  @GetMapping("/eliminarMascota/{id}")
public String eliminarEliminarMascota(@PathVariable long id){
        mascotaService.eliminarMascota(id);
        return "redirect:/mascotas";
  }
@GetMapping("/actualizarMascota/{id}")
    public String mostarFormuarioActualizarMascota(@PathVariable long id, Model model){
        Mascota mascota=mascotaService.obtenerMascotaPorId(id);
        model.addAttribute("mascota", mascota);
        model.addAttribute("duenios",duenioService.listarDuenios());
        return "actualizarMascota";
}
@PostMapping("/actualizarMascota/{id}")
    public String actualizarMascota(@PathVariable long id, @ModelAttribute Mascota mascotaActualizada, @RequestParam long idDuenio){
        mascotaActualizada.setDuenio(duenioService.obtenerDuenioPorId(idDuenio));
        mascotaService.actualizarMascota(id,mascotaActualizada);
        return "redirect:/mascotas";
}

}
