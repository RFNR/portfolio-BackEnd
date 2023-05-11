package com.argentinaprograma.backend.repositorio;

import com.argentinaprograma.backend.modelo.InformacionSobreMi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformacionSobreMiRepositorio extends JpaRepository<InformacionSobreMi, Long> {
}
