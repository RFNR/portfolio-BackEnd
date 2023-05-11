package com.argentinaprograma.backend.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "experiencia")
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cargo", nullable = false)
    private String cargo;

    @Column(name = "lugar", nullable = false)
    private String lugar;

    @Column(name = "periodo", nullable = false)
    private String periodo;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    public Experiencia() {
    }

    public Experiencia(Long id, String cargo, String lugar, String periodo, String descripcion) {
        this.id = id;
        this.cargo = cargo;
        this.lugar = lugar;
        this.periodo = periodo;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
