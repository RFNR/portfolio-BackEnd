package com.argentinaprograma.backend.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "perfiles")
public class Perfiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "perfil", nullable = false)
    private String perfil;

    @Column(name = "banner", nullable = false)
    private String banner;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "profesion", nullable = false)
    private String profesion;

    public Perfiles() {
    }

    public Perfiles(Long id, String perfil, String banner, String nombre, String profesion) {
        this.id = id;
        this.perfil = perfil;
        this.banner = banner;
        this.nombre = nombre;
        this.profesion = profesion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
}
