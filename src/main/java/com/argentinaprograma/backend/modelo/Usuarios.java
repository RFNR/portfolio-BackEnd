package com.argentinaprograma.backend.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_de_usuario", nullable = false)
    private String nombre_de_usuario;

    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;

    public Usuarios() {
    }

    public Usuarios(Long id, String nombre_de_usuario, String contrasenia) {
        this.id = id;
        this.nombre_de_usuario = nombre_de_usuario;
        this.contrasenia = contrasenia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_de_usuario() {
        return nombre_de_usuario;
    }

    public void setNombre_de_usuario(String nombre_de_usuario) {
        this.nombre_de_usuario = nombre_de_usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
