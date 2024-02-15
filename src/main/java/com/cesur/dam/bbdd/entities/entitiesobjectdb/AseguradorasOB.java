package com.cesur.dam.bbdd.entities.entitiesobjectdb;

import javax.persistence.*;
import java.util.List;

@Entity
public class AseguradorasOB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "aseguradora")
    private List<Poliza> polizas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Poliza> getPolizas() {
		return polizas;
	}

	public void setPolizas(List<Poliza> polizas) {
		this.polizas = polizas;
	}

    // Getters and setters
    
}