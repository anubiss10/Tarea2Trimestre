package com.cesur.dam.Entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "empleados")
public class Empleado {

    @Id
    private String id;

    private String nombre;
    private String cargo;
    private String departamento;

    // Constructor, getters y setters
    public Empleado() {
    }

    public Empleado(String nombre, String cargo, String departamento) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.departamento = departamento;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
