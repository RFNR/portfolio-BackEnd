package com.argentinaprograma.backend.controladores;

import com.argentinaprograma.backend.excepciones.ResourceNotFoundException;
import com.argentinaprograma.backend.modelo.Educacion;
import com.argentinaprograma.backend.repositorio.EducacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/educacion")
public class EducacionController {
    @Autowired
    private EducacionRepositorio repositorio;

    @GetMapping("/datos")
    public List<Educacion> educacions() {
        return repositorio.findAll();
    }

    @PostMapping("/datos")
    public Educacion guardarEducacion(@RequestBody Educacion educacion) {
        return repositorio.save(educacion);
    }

    @PutMapping("/datos/{id}")
    public ResponseEntity<Educacion> actualizarDatosEducacion(@PathVariable Long id, @RequestBody Educacion datosEducacion){
        Educacion educacion = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el ID ingresado: " + id));

        educacion.setArea(datosEducacion.getArea());
        educacion.setEstablecimiento(datosEducacion.getEstablecimiento());
        educacion.setPeriodo(datosEducacion.getPeriodo());
        educacion.setDescripcion(datosEducacion.getDescripcion());

        Educacion educActualizado = repositorio.save(educacion);
        return ResponseEntity.ok(educActualizado);
    }

    @DeleteMapping("/datos/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarEducacion(@PathVariable Long id){
        Educacion educacion = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el ID ingresado: " + id));

        repositorio.delete(educacion);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
