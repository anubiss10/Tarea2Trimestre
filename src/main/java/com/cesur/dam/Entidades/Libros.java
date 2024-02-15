package com.cesur.dam.Entidades;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "libros")
public class Libros {

	@Field(name = "id")
	public int id;
	@Field(name = "titulo")
	public String titulo;
	@Field(name = "autor")
	public String autor;
	@Field(name = "genero")
	public String genero;
    
	public Libros(int id, String titulo, String autor, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }
 
    public int getId() {
        return id;
    }
 
    public String getTitulo() {
        return titulo;
    }
 
    public String getAutor() {
        return autor;
    }
 
    public String getGenero() {
        return genero;
    }
}
