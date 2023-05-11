package com.argentinaprograma.backend.repositorio;

import com.argentinaprograma.backend.modelo.Perfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilesRepositorio extends JpaRepository<Perfiles, Long> {
}

