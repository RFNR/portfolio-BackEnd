package com.argentinaprograma.backend.repositorio;

import com.argentinaprograma.backend.modelo.DatosPersonales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatosPersonalesRepositorio extends JpaRepository<DatosPersonales, Long> {
}
