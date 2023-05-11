package com.argentinaprograma.backend.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "redes_sociales")
public class RedesSociales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "facebook", nullable = false)
    private String facebook;

    @Column(name = "instagram", nullable = false)
    private String instagram;

    @Column(name = "linkedin", nullable = false)
    private String linkedin;

    @Column(name = "correo_electronico", nullable = false)
    private String correoElectronico;

    public RedesSociales() {
    }

    public RedesSociales(Long id, String facebook, String instagram, String linkedin, String correoElectronico) {
        this.id = id;
        this.facebook = facebook;
        this.instagram = instagram;
        this.linkedin = linkedin;
        this.correoElectronico = correoElectronico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
