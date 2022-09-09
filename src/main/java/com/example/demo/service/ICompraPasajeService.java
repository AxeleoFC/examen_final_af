package com.example.demo.service;

import com.example.demo.repositoy.model.CompraPasaje;

public interface ICompraPasajeService {
	
	public void ingresar(String numVuelo, Integer numAsientosComprados, String cedula);
	public CompraPasaje buscarPasaje(String numero);
	

}
