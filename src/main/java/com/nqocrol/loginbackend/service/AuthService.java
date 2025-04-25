package com.nqocrol.loginbackend.service;

import com.nqocrol.loginbackend.dto.JwtResponseDTO;
import com.nqocrol.loginbackend.model.Rol;
import com.nqocrol.loginbackend.model.Usuario;
import com.nqocrol.loginbackend.repository.RolRepository;
import com.nqocrol.loginbackend.repository.UsuarioRepository;
import com.nqocrol.loginbackend.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public Usuario registrarUsuario(String username, String password, String nombreRol) {
        Rol rol = rolRepository.findByNombre(nombreRol);
        if (rol == null) {
            rol = new Rol(nombreRol);
            rol = rolRepository.save(rol);
        }

        String passwordEncriptada = passwordEncoder.encode(password);
        Usuario usuario = new Usuario(username, passwordEncriptada, rol);
        return usuarioRepository.save(usuario);
    }

    public JwtResponseDTO login(String username, String password) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario != null && passwordEncoder.matches(password, usuario.getPassword())) {
            String token = jwtUtil.generateToken(usuario.getUsername(), usuario.getRol().getNombre());
            return new JwtResponseDTO(token);
        }
        return null;
    }
}