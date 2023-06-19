package com.argentinaprograma.backend.controladores;

import com.argentinaprograma.backend.excepciones.ResourceNotFoundException;
import com.argentinaprograma.backend.modelo.Intereses;
import com.argentinaprograma.backend.repositorio.InteresesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/intereses")
@CrossOrigin(origins = "https://front-arg-programa.web.app/")
public class InteresesController {
    @Autowired
    private InteresesRepositorio repositorio;

    @GetMapping("/datos")
    public List<Intereses> intereses() {
        return repositorio.findAll();
    }

    @PostMapping("/datos")
    public Intereses guardarIntereses(@RequestBody Intereses intereses) {
        return repositorio.save(intereses);
    }
    @DeleteMapping("/datos/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarInteres(@PathVariable Long id){
        Intereses intereses = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el ID ingresado: " + id));

        repositorio.delete(intereses);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
