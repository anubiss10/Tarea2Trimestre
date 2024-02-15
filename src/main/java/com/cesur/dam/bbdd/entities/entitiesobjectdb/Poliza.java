package com.cesur.dam.bbdd.entities.entitiesobjectdb;

import javax.persistence.*;
import java.util.List;
import com.cesur.dam.bbdd.entities.entitiesobjectdb.*;
@Entity
public class Poliza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    @ManyToOne
    @JoinColumn(name = "aseguradora_id")
    private AseguradorasOB aseguradora;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClientesOB cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public AseguradorasOB getAseguradora() {
		return aseguradora;
	}

	public void setAseguradora(AseguradorasOB aseguradora) {
		this.aseguradora = aseguradora;
	}

	public ClientesOB getCliente() {
		return cliente;
	}

	public void setCliente(ClientesOB cliente) {
		this.cliente = cliente;
	}

    
}