package com.javaWeb.webappjava2024.service;

import com.javaWeb.webappjava2024.model.Duenio;
import com.javaWeb.webappjava2024.model.Mascota;
import com.javaWeb.webappjava2024.repository.DuenioRepository;
import com.javaWeb.webappjava2024.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Mascota obtenerMascotaPorId(long id){
        return mascotaRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró la mascota"));
    }
    public void eliminarMascota(long id){
    Optional<Mascota> mascotaOptional=mascotaRepository.findById(id);
    if(mascotaOptional.isPresent()){
        //Mascota mascotaExistente=mascotaOptional.get();
        mascotaRepository.delete(mascotaOptional.get());
    }
else
    {
       throw new RuntimeException("No se encontró la mascota");
    }
    }
    public void actualizarMascota(long id, Mascota mascotaActualizada){
        Optional<Mascota> mascotaOptional=mascotaRepository.findById(id);
        if(mascotaOptional.isPresent()){
            Mascota mascotaExistente=mascotaOptional.get();
mascotaExistente.setNombre(mascotaActualizada.getNombre());
mascotaExistente.setEdad(mascotaActualizada.getEdad());
mascotaExistente.setEspecie(mascotaActualizada.getEspecie());
mascotaExistente.setDuenio(mascotaActualizada.getDuenio());
mascotaRepository.save(mascotaExistente);
        }
        else
        {
            throw new RuntimeException("No se encontró la mascota al momento de la actualización");
        }
    }
}
