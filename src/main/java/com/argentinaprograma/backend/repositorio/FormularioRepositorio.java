package com.argentinaprograma.backend.repositorio;

import com.argentinaprograma.backend.modelo.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormularioRepositorio extends JpaRepository<Formulario, Long> {
}
