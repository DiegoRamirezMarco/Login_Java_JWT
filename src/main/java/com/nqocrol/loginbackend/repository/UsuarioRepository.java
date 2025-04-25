package com.nqocrol.loginbackend.repository;

import com.nqocrol.loginbackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //Los metodos para CRUD ya estan implementados automaticamente aun que no se vean
    Usuario findByUsername(String username);
}
