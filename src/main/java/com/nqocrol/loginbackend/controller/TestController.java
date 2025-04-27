package com.nqocrol.loginbackend.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/privado")
@CrossOrigin(origins = "*")
public class TestController {

    // Ruta accesible para cualquier usuario autenticado (USER o ADMIN)
    @GetMapping("/public")
    public String publicAccess() {
        return "Esta es una ruta pública para cualquier usuario autenticado.";
    }

    // Ruta accesible solo para usuarios con rol USER
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String userAccess() {
        return "Esta es una ruta exclusiva para usuarios con rol USER.";
    }

    // Ruta accesible solo para usuarios con rol ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String adminAccess() {
        return "Esta es una ruta exclusiva para usuarios con rol ADMIN.";
    }
}
