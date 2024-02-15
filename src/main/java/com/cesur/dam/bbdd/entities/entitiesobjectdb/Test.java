package com.cesur.dam.bbdd.entities.entitiesobjectdb;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Test {
	private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    private Long id;
	
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
