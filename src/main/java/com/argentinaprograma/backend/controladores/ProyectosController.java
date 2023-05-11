package com.argentinaprograma.backend.controladores;

import com.argentinaprograma.backend.excepciones.ResourceNotFoundException;
import com.argentinaprograma.backend.modelo.Proyecto;
import com.argentinaprograma.backend.repositorio.ProyectoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProyectosController {
    @Autowired
    private ProyectoRepositorio repositorio;

    @GetMapping("/datos")
    public List<Proyecto> proyectos() {
        return repositorio.findAll();
    }

    @PostMapping("/datos")
    public Proyecto guardarProyectos(@RequestBody Proyecto proyecto) {
        return repositorio.save(proyecto);
    }

    @PutMapping("/datos/{id}")
    public ResponseEntity<Proyecto> actualizarDatosProyecto(@PathVariable Long id, @RequestBody Proyecto datosProyecto){
        Proyecto proyecto = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el ID ingresado: " + id));

        proyecto.setImg(datosProyecto.getImg());
        proyecto.setNombre(datosProyecto.getNombre());
        proyecto.setLink(datosProyecto.getLink());
        proyecto.setDescripcion(datosProyecto.getDescripcion());

        Proyecto proyectoActualizado = repositorio.save(proyecto);
        return ResponseEntity.ok(proyectoActualizado);
    }

    @DeleteMapping("/datos/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarProyecto(@PathVariable Long id){
        Proyecto proyecto = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el ID ingresado: " + id));

        repositorio.delete(proyecto);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}