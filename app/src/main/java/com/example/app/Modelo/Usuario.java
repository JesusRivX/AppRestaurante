package com.example.app.Modelo;

public class Usuario {
    private String nombreUsuario;
    private String correo;
    private String password;

    public Usuario(String nombreUsuario, String correo, String password) {
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.password = password;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
