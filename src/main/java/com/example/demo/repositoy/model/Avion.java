package com.example.demo.repositoy.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "avion")
public class Avion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "avi_id_seq")
	@SequenceGenerator(name = "avi_id_seq", sequenceName = "avi_id_seq", allocationSize = 1)
	@Column(name = "avio_id")
	private Integer id;
	
	@Column(name = "avio_nombre")
	private String nombre;
	
	@Column(name = "avio_numero_asientos")
	private Integer numeroAsientos;

	//Union de tablas
	@OneToMany(mappedBy = "avion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Vuelo> vuelos;
	
	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroAsientos() {
		return numeroAsientos;
	}

	public void setNumeroAsientos(Integer numeroAsientos) {
		this.numeroAsientos = numeroAsientos;
	}

	public List<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
