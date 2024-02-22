package com.cesur.dam.Entidades;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "empleados")
public class EmpleadosEB {

    private Empleado[] empleados;

    @XmlElement(name = "empleado")
    public Empleado[] getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado[] empleados) {
        this.empleados = empleados;
    }
}
