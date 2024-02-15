package com.cesur.dam.bbdd.entities.entitiesobjectdb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Respuestas {
	private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    private Long id;
    
    public String texto;
	public boolean correcta;
	public String explicacion;
	public int fkpreguntas;
	
	public Respuestas(String texto, boolean correcta, String explicacion, int fkpreguntas) {
		this.texto = texto;
		this.correcta = correcta;
		this.explicacion = explicacion;
		this.fkpreguntas = fkpreguntas;
	}
	public Respuestas() {
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public boolean isCorrecta() {
		return correcta;
	}
	public void setCorrecta(boolean correcta) {
		this.correcta = correcta;
	}
	public String getExplicacion() {
		return explicacion;
	}
	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}
	public int getFkpreguntas() {
		return fkpreguntas;
	}
	public void setFkpreguntas(int fkpreguntas) {
		this.fkpreguntas = fkpreguntas;
	}
    
}
