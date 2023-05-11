package com.argentinaprograma.backend.controladores;

import com.argentinaprograma.backend.excepciones.ResourceNotFoundException;
import com.argentinaprograma.backend.modelo.InformacionSobreMi;
import com.argentinaprograma.backend.repositorio.InformacionSobreMiRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/informacionsobremi")
@CrossOrigin(origins = "http://localhost:4200/")
public class InformacionSobreMiController {
    @Autowired
    private InformacionSobreMiRepositorio repositorio;

    @GetMapping("/datos")
    public List<InformacionSobreMi> informacion() {
        return repositorio.findAll();
    }

    @PutMapping("/datos/{id}")
    public ResponseEntity<InformacionSobreMi> actualizarInformacionSobreMi(@PathVariable Long id, @RequestBody InformacionSobreMi datosInformacionSobreMi){
        InformacionSobreMi informacionSobreMi = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el ID ingresado: " + id));

        informacionSobreMi.setMi_texto(datosInformacionSobreMi.getMi_texto());

        InformacionSobreMi datosActualizado = repositorio.save(datosInformacionSobreMi);
        return ResponseEntity.ok(datosActualizado);
    }
}
