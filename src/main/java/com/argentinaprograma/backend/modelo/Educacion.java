package com.argentinaprograma.backend.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "educacion")
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "area", nullable = false)
    private String area;

    @Column(name = "establecimiento", nullable = false)
    private String establecimiento;

    @Column(name = "periodo", nullable = false)
    private String periodo;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    public Educacion() {
    }

    public Educacion(Long id, String area, String establecimiento, String periodo, String descripcion) {
        this.id = id;
        this.area = area;
        this.establecimiento = establecimiento;
        this.periodo = periodo;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
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
