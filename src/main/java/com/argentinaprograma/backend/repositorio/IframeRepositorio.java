package com.argentinaprograma.backend.repositorio;

import com.argentinaprograma.backend.modelo.LinkIframe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IframeRepositorio extends JpaRepository<LinkIframe, Long> {
}
