package com.nqocrol.loginbackend.controller;

import com.nqocrol.loginbackend.dto.JwtResponseDTO;
import com.nqocrol.loginbackend.dto.LoginDTO;
import com.nqocrol.loginbackend.dto.UsuarioRegisterDTO;
import com.nqocrol.loginbackend.model.Usuario;
import com.nqocrol.loginbackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public ResponseEntity<JwtResponseDTO> login(@RequestBody LoginDTO dto) {
        JwtResponseDTO response = authService.login(dto.getUsername(), dto.getPassword());
        if (response != null) {
            return ResponseEntity.ok(response); // <-- esto garantiza que responde con JSON
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/quien-soy")
    public String quienSoy() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        return "Usuario: " + auth.getName() + ", Roles: " + auth.getAuthorities();
    }


}