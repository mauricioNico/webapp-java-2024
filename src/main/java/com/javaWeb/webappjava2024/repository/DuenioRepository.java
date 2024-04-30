package com.javaWeb.webappjava2024.repository;

import com.javaWeb.webappjava2024.model.Duenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuenioRepository extends JpaRepository<Duenio,Long> {
//TODO: Implementar metodos personalizados
}
