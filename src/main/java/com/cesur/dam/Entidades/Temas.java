package com.cesur.dam.Entidades;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "temas")
public class Temas {

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
