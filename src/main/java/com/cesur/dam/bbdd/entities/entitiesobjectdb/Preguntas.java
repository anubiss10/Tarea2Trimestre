package com.cesur.dam.bbdd.entities.entitiesobjectdb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Preguntas {
	private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    private Long id;
    
    public String pregunta;
	public int fktema;
	
	//Metodos
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String texto) {
		this.pregunta = texto;
	}
	public int getFktema() {
		return fktema;
	}
	public void setFktema(int fktema) {
		this.fktema = fktema;
	}

	//Contructores
	public Preguntas() {
	}
	public Preguntas(String pregunta, int fktema) {
		this.pregunta = pregunta;
		this.fktema = fktema;
	}
}
