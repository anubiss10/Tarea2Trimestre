package com.cesur.dam.bbdd.entities.entitiesobjectdb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Temas {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
    private Long id;
	
	public int numTema;
	public int fktest;
	
	//Metodos
	public int getNumTema() {
		return numTema;
	}
	public void setNumTema(int numTema) {
		this.numTema = numTema;
	}
	public int getFktest() {
		return fktest;
	}
	public void setFktest(int fktest) {
		this.fktest = fktest;
	}
	//Contructores
	public Temas() {
	}
	public Temas(int numTema) {
		this.numTema = numTema;
	}
}
