package com.argentinaprograma.backend.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "habilidades")
public class Habilidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "porcentaje", nullable = false)
    private String porcentaje;

    public Habilidades() {
    }

    public Habilidades(Long id, String nombre, String porcentaje) {
        this.id = id;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }
}