package com.cesur.dam.servicios;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesur.dam.Entidades.*;
import com.cesur.dam.repositorios.*;

@Service
public class MongoServiceNormal implements MongoDBService{

	@Autowired
	protected RepositorioLibros repositorioLibros;

	
	
	@Override
	public List<Libros> listar() {
		
		List<Libros> libros = null; 
		libros = repositorioLibros.findAll();
        System.out.println("asi es, soy tonto");
        for (Libros libro : libros) {
            System.out.println(libro.getId() + " " + libro.getTitulo() + " " + libro.getAutor() + " " + libro.getGenero());
        }
        
        return libros;
	}
	
	  

	  @Override
	  public String anadirLibros() {
	        // Crear HashMap para almacenar información de los libros
	        HashMap<Integer, Libros> libros = new HashMap<>();
	 
	        // Agregar libros al HashMap
	        libros.put(1, new Libros(1, "El Señor de los Anillos", "J.R.R. Tolkien", "Fantasía"));
	        libros.put(2, new Libros(2, "Cien años de soledad", "Gabriel García Márquez", "Realismo mágico"));
	        libros.put(3, new Libros(3, "Harry Potter y la piedra filosofal", "J.K. Rowling", "Fantasía"));
	        libros.put(4, new Libros(4, "1984", "George Orwell", "Distopía"));
	        libros.put(5, new Libros(5, "Orgullo y prejuicio", "Jane Austen", "Novela romántica"));
	        libros.put(6, new Libros(6, "Crónica de una muerte anunciada", "Gabriel García Márquez", "Realismo mágico"));
	        libros.put(7, new Libros(7, "El principito", "Antoine de Saint-Exupéry", "Literatura infantil"));
	        libros.put(8, new Libros(8, "Don Quijote de la Mancha", "Miguel de Cervantes", "Novela picaresca"));
	        libros.put(9, new Libros(9, "Los juegos del hambre", "Suzanne Collins", "Ciencia ficción"));
	        libros.put(10, new Libros(10, "El código Da Vinci", "Dan Brown", "Thriller"));
	 
	        // Mostrar información de los libros en el HashMap
	        for (int id : libros.keySet()) {
	            Libros libro = libros.get(id);
	            System.out.println("ID: " + libro.getId() + ", Título: " + libro.getTitulo() +
	                               ", Autor: " + libro.getAutor() + ", Género: " + libro.getGenero());
	            repositorioLibros.save(libro);
	        }
	        
	        return "Guardado";
	    }

}
