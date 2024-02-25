package com.cesur.dam.Entidades;

public class Persona {
    private String nombre;
    private String apellido; // Cambiado de 'apellido' a 'apellidos'
    private String telefono;
    private String email;

    // Constructor
    public Persona(String nombre, String apellidos, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellidos; // Actualizado el nombre del parámetro
        this.telefono = telefono;
        this.email = email;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() { // Cambiado de 'getApellido' a 'getApellidos'
        return apellido;
    }

    public void setApellidos(String apellidos) { // Cambiado de 'setApellido' a 'setApellidos'
        this.apellido = apellidos;
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

    // toString() para representación de la clase
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
