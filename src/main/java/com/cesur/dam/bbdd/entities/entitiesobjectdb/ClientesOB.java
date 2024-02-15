package com.cesur.dam.bbdd.entities.entitiesobjectdb;

import javax.persistence.*;
import java.util.List;
import com.cesur.dam.bbdd.entities.entitiesobjectdb.*;
@Entity
public class ClientesOB {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "cliente")
    private List<Poliza> polizas;

    @OneToMany(mappedBy = "cliente")
    private List<SiniestroOB> siniestros;

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

	public List<SiniestroOB> getSiniestros() {
		return siniestros;
	}

	public void setSiniestros(List<SiniestroOB> siniestros) {
		this.siniestros = siniestros;
	}

}
