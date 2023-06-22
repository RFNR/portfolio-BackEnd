package com.argentinaprograma.backend.controladores;

import com.argentinaprograma.backend.excepciones.ResourceNotFoundException;
import com.argentinaprograma.backend.modelo.RedesSociales;
import com.argentinaprograma.backend.repositorio.RedesSocialesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redes")
public class RedesSocialesController {

    @Autowired
    private RedesSocialesRepositorio repositorio;

    @GetMapping("/redsocial/{id}")
    public ResponseEntity<RedesSociales> obtenerRedes(@PathVariable Long id){
        RedesSociales redesSociales = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el perfil con el ID : " + id));
        return ResponseEntity.ok(redesSociales);
    }

    @PutMapping("/redsocial/{id}")
    public ResponseEntity<RedesSociales> actualizarRedes(@PathVariable Long id, @RequestBody RedesSociales registro){
        RedesSociales redesSociales = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el src con el ID : " + id));

        redesSociales.setFacebook(registro.getFacebook());
        redesSociales.setInstagram(registro.getInstagram());
        redesSociales.setCorreoElectronico(registro.getCorreoElectronico());
        redesSociales.setLinkedin(registro.getLinkedin());

        RedesSociales registroActualizado = repositorio.save(redesSociales);
        return ResponseEntity.ok(registroActualizado);
    }
}