package com.argentinaprograma.backend.controladores;

import com.argentinaprograma.backend.modelo.Usuarios;
import com.argentinaprograma.backend.repositorio.UsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "https://front-arg-programa.web.app/")
public class UsuarioControlador {
    @Autowired
    private UsuariosRepositorio repositorio;

    @GetMapping("/usuarios")
    public List<Usuarios> listarTodosLosUsuarios() {
        return repositorio.findAll();
    }

}
