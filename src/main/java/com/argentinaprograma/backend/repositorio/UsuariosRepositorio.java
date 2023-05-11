package com.argentinaprograma.backend.repositorio;

import com.argentinaprograma.backend.modelo.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepositorio extends JpaRepository<Usuarios, Long> {
}
