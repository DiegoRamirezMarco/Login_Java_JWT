package com.nqocrol.loginbackend.controller;

import com.nqocrol.loginbackend.dto.JwtResponseDTO;
import com.nqocrol.loginbackend.dto.LoginDTO;
import com.nqocrol.loginbackend.dto.UsuarioRegisterDTO;
import com.nqocrol.loginbackend.model.Usuario;
import com.nqocrol.loginbackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public Usuario register(@RequestBody UsuarioRegisterDTO dto) {
        return authService.registrarUsuario(dto.getUsername(), dto.getPassword(), dto.getRol());
    }

    @PostMapping("/login")
    public JwtResponseDTO login(@RequestBody LoginDTO dto) {
        return authService.login(dto.getUsername(), dto.getPassword());
    }
}