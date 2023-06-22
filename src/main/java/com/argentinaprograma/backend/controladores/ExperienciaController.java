package com.argentinaprograma.backend.controladores;

import com.argentinaprograma.backend.excepciones.ResourceNotFoundException;
import com.argentinaprograma.backend.modelo.Experiencia;
import com.argentinaprograma.backend.repositorio.ExperienciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/experiencia")
public class ExperienciaController {
    @Autowired
    private ExperienciaRepositorio repositorio;

    @GetMapping("/datos")
    public List<Experiencia> experiencias() { return repositorio.findAll(); }

    @PostMapping("/datos")
    public Experiencia guardarExperiencia(@RequestBody Experiencia experiencia) {
        return repositorio.save(experiencia);
    }

    @PutMapping("/datos/{id}")
    public ResponseEntity<Experiencia> actualizarDatosExperiencia(@PathVariable Long id, @RequestBody Experiencia datosExperiencia){
        Experiencia experiencia = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el ID ingresado: " + id));

        experiencia.setCargo(datosExperiencia.getCargo());
        experiencia.setLugar(datosExperiencia.getLugar());
        experiencia.setPeriodo(datosExperiencia.getPeriodo());
        experiencia.setDescripcion(datosExperiencia.getDescripcion());

        Experiencia expActualizado = repositorio.save(experiencia);
        return ResponseEntity.ok(expActualizado);
    }

    @DeleteMapping("/datos/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarExperiencia(@PathVariable Long id){
        Experiencia experiencia = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el ID ingresado: " + id));

        repositorio.delete(experiencia);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
