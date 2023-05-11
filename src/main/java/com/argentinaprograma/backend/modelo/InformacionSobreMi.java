package com.argentinaprograma.backend.modelo;

import jakarta.persistence.*;
@Entity
@Table(name = "informacion_sobre_mi")
public class InformacionSobreMi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mi_texto", nullable = false)
    private String mi_texto;

    public InformacionSobreMi() {
    }

    public InformacionSobreMi(Long id, String mi_texto) {
        this.id = id;
        this.mi_texto = mi_texto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMi_texto() {
        return mi_texto;
    }

    public void setMi_texto(String mi_texto) {
        this.mi_texto = mi_texto;
    }
}
