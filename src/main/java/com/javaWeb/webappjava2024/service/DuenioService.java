package com.javaWeb.webappjava2024.service;

import com.javaWeb.webappjava2024.model.Duenio;
import com.javaWeb.webappjava2024.repository.DuenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuenioService {
    @Autowired
    private DuenioRepository duenioRepository;

    public List<Duenio> listarDuenios(){
        return duenioRepository.findAll();
    }
    public Duenio guardarDuenio(Duenio duenio){
        return duenioRepository.save(duenio);
    }
}
