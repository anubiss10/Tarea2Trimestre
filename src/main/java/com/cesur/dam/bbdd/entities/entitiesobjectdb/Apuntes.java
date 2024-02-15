package com.cesur.dam.bbdd.entities.entitiesobjectdb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Apuntes {
	private static final long serialVersionUID = 1L;
	
    @Id @GeneratedValue
    private Long id;
    private String titulo;
    private String contenido;

    
    public Apuntes(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}

