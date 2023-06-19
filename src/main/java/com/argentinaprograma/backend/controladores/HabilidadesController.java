package com.argentinaprograma.backend.controladores;

import com.argentinaprograma.backend.excepciones.ResourceNotFoundException;
import com.argentinaprograma.backend.modelo.Habilidades;
import com.argentinaprograma.backend.repositorio.HabilidadesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/habilidades")
@CrossOrigin(origins = "https://front-arg-programa.web.app/")
public class HabilidadesController {
    @Autowired
    private HabilidadesRepositorio repositorio;

    @GetMapping("/datos")
    public List<Habilidades> habilidades() {
        return repositorio.findAll();
    }

    @PostMapping("/datos")
    public Habilidades guardarHabilidades(@RequestBody Habilidades habilidades) {
        return repositorio.save(habilidades);
    }

    @PutMapping("/datos/{id}")
    public ResponseEntity<Habilidades> actualizarDatosHabilidades(@PathVariable Long id, @RequestBody Habilidades datosHabilidades){
        Habilidades habilidades = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el ID ingresado: " + id));

        habilidades.setNombre(datosHabilidades.getNombre());
        habilidades.setPorcentaje(datosHabilidades.getPorcentaje());

        Habilidades habilidadesActualizadas = repositorio.save(habilidades);
        return ResponseEntity.ok(habilidadesActualizadas);
    }

    @DeleteMapping("/datos/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarHabilidad(@PathVariable Long id){
        Habilidades habilidades = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el ID ingresado: " + id));

        repositorio.delete(habilidades);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
