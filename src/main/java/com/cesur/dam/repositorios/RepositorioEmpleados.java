package com.cesur.dam.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cesur.dam.Entidades.Empleado;

@Repository
public interface RepositorioEmpleados extends MongoRepository<Empleado, String> {

}
