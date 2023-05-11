package com.argentinaprograma.backend.repositorio;

import com.argentinaprograma.backend.modelo.Habilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadesRepositorio extends JpaRepository<Habilidades, Long> {
}
