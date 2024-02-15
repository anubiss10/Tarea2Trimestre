package com.cesur.dam.servicios;

import java.util.List;
import com.cesur.dam.Entidades.*;
public interface MongoDBService {
	
	 public List<Libros> listar();

	 public String anadirLibros();
	 
}
