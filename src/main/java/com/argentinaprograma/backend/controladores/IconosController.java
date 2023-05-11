package com.argentinaprograma.backend.controladores;

import com.argentinaprograma.backend.modelo.Iconos;
import com.argentinaprograma.backend.repositorio.IconosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/iconos")
@CrossOrigin(origins = "http://localhost:4200/")
public class IconosController {
    @Autowired
    private IconosRepositorio repositorio;

    @GetMapping("/datos")
    public List<Iconos> iconos() {
        return repositorio.findAll();
    }

}
