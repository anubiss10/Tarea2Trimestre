package com.cesur.dam.bbdd.services;

import java.util.List;

import com.cesur.dam.bbdd.entities.entitiesobjectdb.*;

public interface ObjectdbService {
	
	 
     AseguradorasOB crearAseguradora(AseguradorasOB aseguradora);
     List<Poliza> obtenerPolizasPorCliente(Long clienteId);
     public void crearCliente(ClientesOB cliente);
     public void crearDatosDeEjemplo();
     List<SiniestroOB> obtenerSiniestrosPorCliente(Long clienteId);

}
