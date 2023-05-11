package com.argentinaprograma.backend.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "datos_personales")
public class DatosPersonales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "edad", nullable = false)
    private String edad;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    @Column(name = "cargo", nullable = false)
    private String cargo;

    public DatosPersonales() {
    }

    public DatosPersonales(Long id, String edad, String telefono, String email, String ubicacion, String cargo) {
        this.id = id;
        this.edad = edad;
        this.telefono = telefono;
        this.email = email;
        this.ubicacion = ubicacion;
        this.cargo = cargo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}