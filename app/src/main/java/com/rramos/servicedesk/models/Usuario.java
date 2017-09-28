package com.rramos.servicedesk.models;

/**
 * Created by RODRIGO on 25/09/2017.
 */

public class Usuario {

    private String usuario,contrasena,nombres,rol;

    public Usuario(String usuario, String contrasena, String nombres, String rol) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombres = nombres;
        this.rol = rol;
    }

    public Usuario() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuario='" + usuario + '\'' +
                ", contraseña='" + contrasena + '\'' +
                ", nombres='" + nombres + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
