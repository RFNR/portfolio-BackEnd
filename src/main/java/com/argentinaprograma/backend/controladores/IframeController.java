package com.argentinaprograma.backend.controladores;

import com.argentinaprograma.backend.excepciones.ResourceNotFoundException;
import com.argentinaprograma.backend.modelo.LinkIframe;
import com.argentinaprograma.backend.repositorio.IframeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/iframe")
@CrossOrigin(origins = "http://https://front-arg-programa.web.app/")
public class IframeController {
    @Autowired
    private IframeRepositorio repositorio;

    @GetMapping("/src")
    public List<LinkIframe> linkIframe() {
        return repositorio.findAll();
    }

    // agregar un src
    @PostMapping("/src")
    public LinkIframe guardarLink(@RequestBody LinkIframe linkIframe) {
        return repositorio.save(linkIframe);
    }

    //este metodo sirve para buscar un src por id
    @GetMapping("/src/{id}")
    public ResponseEntity<LinkIframe> obtenerSrcPorId(@PathVariable Long id){
        LinkIframe linkIframe = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el src con el ID : " + id));
        return ResponseEntity.ok(linkIframe);
    }

    //este metodo sirve para actualizar el src
    @PutMapping("/src/{id}")
    public ResponseEntity<LinkIframe> actualizarSrc(@PathVariable Long id, @RequestBody LinkIframe detallesSrc){
        LinkIframe linkIframe = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el src con el ID : " + id));

        linkIframe.setSrc(detallesSrc.getSrc());

        LinkIframe srcActualizado = repositorio.save(linkIframe);
        return ResponseEntity.ok(srcActualizado);
    }
}
