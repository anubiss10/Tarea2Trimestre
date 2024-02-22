package com.cesur.dam.Entidades;

import jakarta.xml.bind.annotation.XmlElement;

public class EmpleadoEB {

    private String nombre;
    private String puesto;
    private String salario; // Cambiado de int a String

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @XmlElement
    public String getSalario() { // Cambiado de int a String
        return salario;
    }

    public void setSalario(String salario) { // Cambiado de int a String
        this.salario = salario;
    }
}
