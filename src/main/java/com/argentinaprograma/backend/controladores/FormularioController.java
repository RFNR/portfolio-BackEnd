package com.argentinaprograma.backend.controladores;

import com.argentinaprograma.backend.modelo.Formulario;
import com.argentinaprograma.backend.repositorio.FormularioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/formulario")
@CrossOrigin(origins = "http://localhost:4200/")
public class FormularioController {
    @Autowired
    private FormularioRepositorio repositorio;

    @PostMapping("/datos")
    public Formulario guardarFormulario(@RequestBody Formulario formulario) {
        return repositorio.save(formulario);
    }
}
