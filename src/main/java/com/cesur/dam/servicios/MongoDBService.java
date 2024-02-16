package com.cesur.dam.servicios;

import java.util.List;
import com.cesur.dam.Entidades.Empleado;

public interface MongoDBService {
    public List<Empleado> listar();

    public String anadirEmpleados();
}
