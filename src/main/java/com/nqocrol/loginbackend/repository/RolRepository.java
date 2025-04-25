package com.nqocrol.loginbackend.repository;

import com.nqocrol.loginbackend.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
    //Los metodos para CRUD ya estan implementados automaticamente aun que no se vean
    Rol findByNombre(String nombre);
}
