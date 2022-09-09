package com.example.demo.repositoy.model;

public class CompraTo {
	
	private Integer numAsientosComprados;
	private String cedula;
	private String numVuelo;
	
	//SET y GET
	public Integer getNumAsientosComprados() {
		return numAsientosComprados;
	}
	public void setNumAsientosComprados(Integer numAsientosComprados) {
		this.numAsientosComprados = numAsientosComprados;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNumVuelo() {
		return numVuelo;
	}
	public void setNumVuelo(String numVuelo) {
		this.numVuelo = numVuelo;
	}

}
