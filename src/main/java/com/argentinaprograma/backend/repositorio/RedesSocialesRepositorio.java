package com.argentinaprograma.backend.repositorio;

import com.argentinaprograma.backend.modelo.RedesSociales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedesSocialesRepositorio extends JpaRepository<RedesSociales, Long> {
}


