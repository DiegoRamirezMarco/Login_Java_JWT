package com.nqocrol.loginbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/privado")
public class TestController {

    @GetMapping
    public String rutaProtegida() {
        return "¡Has accedido a una ruta protegida con JWT!";
    }
}
