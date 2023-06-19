package com.argentinaprograma.backend.controladores;

import com.argentinaprograma.backend.excepciones.ResourceNotFoundException;
import com.argentinaprograma.backend.modelo.DatosPersonales;
import com.argentinaprograma.backend.repositorio.DatosPersonalesRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/datospersonales")
@CrossOrigin(origins = "https://front-arg-programa.web.app/")
public class DatosPersonalesController {
    @Autowired
    private DatosPersonalesRepositorio repositorio;

    @GetMapping("/datos")
    public List<DatosPersonales> datosPersonales() {
        return repositorio.findAll();
    }

    @PutMapping("/datos/{id}")
    public ResponseEntity<DatosPersonales> actualizarDatosPersonales(@PathVariable Long id, @RequestBody DatosPersonales datosPersonales_){
        DatosPersonales datosPersonales = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el ID ingresado: " + id));

        datosPersonales.setEdad(datosPersonales_.getEdad());
        datosPersonales.setEmail(datosPersonales_.getEmail());
        datosPersonales.setCargo(datosPersonales_.getCargo());
        datosPersonales.setTelefono(datosPersonales_.getTelefono());
        datosPersonales.setUbicacion(datosPersonales_.getUbicacion());

        DatosPersonales datosActualizado = repositorio.save(datosPersonales);
        return ResponseEntity.ok(datosActualizado);
    }
}
