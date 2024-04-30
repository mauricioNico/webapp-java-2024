package com.javaWeb.webappjava2024.service;

import com.javaWeb.webappjava2024.model.Duenio;
import com.javaWeb.webappjava2024.model.Mascota;
import com.javaWeb.webappjava2024.repository.DuenioRepository;
import com.javaWeb.webappjava2024.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private DuenioRepository duenioRepository;

public List<Mascota> listarMascotas(){
    return mascotaRepository.findAll();
    }
public void guardarMascota(Mascota mascota, long idDuenio)
{
    Duenio duenio=duenioRepository.findById(idDuenio).orElseThrow(() -> new RuntimeException("No se encontró el dueño"));
   mascota.setDuenio(duenio);
mascotaRepository.save(mascota);
}
}
