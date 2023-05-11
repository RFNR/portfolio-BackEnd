package com.argentinaprograma.backend.repositorio;

import com.argentinaprograma.backend.modelo.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepositorio extends JpaRepository<Experiencia, Long> {
}
