package com.argentinaprograma.backend.controladores;

import com.argentinaprograma.backend.excepciones.ResourceNotFoundException;
import com.argentinaprograma.backend.modelo.Perfiles;
import com.argentinaprograma.backend.repositorio.PerfilesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/perfiles")
@CrossOrigin(origins = "http://https://front-arg-programa.web.app/")
public class PerfilesController {

    @Autowired
    private PerfilesRepositorio repositorio;

    @GetMapping("/perfil/{id}")
    public ResponseEntity<Perfiles> obtenerPerfilPorId(@PathVariable Long id){
        Perfiles perfiles = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el perfil con el ID : " + id));
        return ResponseEntity.ok(perfiles);
    }

    @PutMapping("/perfil/{id}")
    public ResponseEntity<Perfiles> actualizarRegistro(@PathVariable Long id, @RequestBody Perfiles registro){
        Perfiles perfiles = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el src con el ID : " + id));

        perfiles.setPerfil(registro.getPerfil());
        perfiles.setProfesion(registro.getProfesion());
        perfiles.setBanner(registro.getBanner());
        perfiles.setNombre(registro.getNombre());

        Perfiles registroActualizado = repositorio.save(perfiles);
        return ResponseEntity.ok(registroActualizado);
    }
}
