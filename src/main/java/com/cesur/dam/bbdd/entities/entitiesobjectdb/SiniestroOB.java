package com.cesur.dam.bbdd.entities.entitiesobjectdb;

import javax.persistence.*;
import java.util.List;
import com.cesur.dam.bbdd.entities.entitiesobjectdb.*;
@Entity
public class SiniestroOB{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClientesOB cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ClientesOB getCliente() {
		return cliente;
	}

	public void setCliente(ClientesOB cliente) {
		this.cliente = cliente;
	}


}
