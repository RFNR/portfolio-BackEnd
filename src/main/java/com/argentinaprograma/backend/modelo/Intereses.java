package com.argentinaprograma.backend.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "intereses")
public class Intereses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "interes", nullable = false)
    private String interes;

    @Column(name = "icono", nullable = false)
    private String icono;

    public Intereses() {
    }

    public Intereses(Long id, String interes, String icono) {
        this.id = id;
        this.interes = interes;
        this.icono = icono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInteres() {
        return interes;
    }

    public void setInteres(String interes) {
        this.interes = interes;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
}
