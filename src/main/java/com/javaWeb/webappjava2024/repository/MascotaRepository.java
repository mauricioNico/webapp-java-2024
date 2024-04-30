package com.javaWeb.webappjava2024.repository;

import com.javaWeb.webappjava2024.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota,Long> {
//TODO: Implementar metodos personalizados
}
