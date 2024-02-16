package com.cesur.dam.servicios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesur.dam.Entidades.Empleado;
import com.cesur.dam.repositorios.RepositorioEmpleados;

@Service
public class MongoServiceNormal implements MongoDBService {

    @Autowired
    protected RepositorioEmpleados repositorioEmpleados;

    @Override
    public List<Empleado> listar() {
        List<Empleado> empleados = repositorioEmpleados.findAll();
        System.out.println("Lista de empleados:");
        for (Empleado empleado : empleados) {
            System.out.println("ID: " + empleado.getId() + ", Nombre: " + empleado.getNombre() + ", Cargo: "
                    + empleado.getCargo() + ", Departamento: " + empleado.getDepartamento());
        }

        return empleados;
    }

    @Override
    public String anadirEmpleados() {
        // Crear un HashMap para almacenar temporalmente los empleados
        Map<Integer, Empleado> empleadosMap = new HashMap<>();

        // Agregar empleados al HashMap
        empleadosMap.put(1, new Empleado("Julian", "Desarrollador", "Tecnología"));
        empleadosMap.put(2, new Empleado("Gonzalo", "Gerente de Proyecto", "Tecnología"));

        // Guardar los empleados del HashMap en la base de datos
        for (Empleado empleado : empleadosMap.values()) {
            repositorioEmpleados.save(empleado);
        }

        return "Empleados añadidos exitosamente.";
    }
}
