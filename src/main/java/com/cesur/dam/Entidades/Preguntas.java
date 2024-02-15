package com.cesur.dam.Entidades;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "preguntas")
public class Preguntas {
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
