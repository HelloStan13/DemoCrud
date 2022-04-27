package com.crud.democrud.models;

import javax.persistence.*;

@Entity
@Table(name = "usuario_rol")
public class RolModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_Rol;
    private String Rol;
    private int id_Usuario;

    public Long getId_Rol() {
        return id_Rol;
    }

    public void setId_Rol(Long id_Rol) {
        this.id_Rol = id_Rol;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }
    public RolModel(String rol, int id_usuario) {
        this.Rol = rol;
        this.id_Usuario = id_usuario;
    }
    public RolModel() {
    }
}