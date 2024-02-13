package com.cesur.dam.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesur.dam.repositorios.ConexionRepository;
@Service

//Servicio usado para conectar a la BBDD mediante JDBC
public class ConexionService {
	@Autowired
	protected ConexionRepository ConexionRepository;
	public String devolverTests() {
		return ConexionRepository.confirmarConexion();
	}
}
