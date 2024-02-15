package com.cesur.dam.Entidades;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "test")
public class Test {
	
	private int numCorrectos;
	private int numFallos;
	private Date fecha;
	
	//Metodos
	public int getNumCorrectos() {
		return numCorrectos;
	}

	public void setNumCorrectos(int numCorrectos) {
		this.numCorrectos = numCorrectos;
	}

	public int getNumFallos() {
		return numFallos;
	}

	public void setNumFallos(int numFallos) {
		this.numFallos = numFallos;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	//Contructores
	public Test() {
	}
	public Test(int numCorrectos, int numFallos, Date fecha) {
		this.numCorrectos = numCorrectos;
		this.numFallos = numFallos;
		this.fecha = fecha;
	}
}
