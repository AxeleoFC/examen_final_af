package com.example.demo.service;

import java.util.List;

import com.example.demo.repositoy.model.Vuelo;

public interface IVueloService {
	
	public void ingresar(Vuelo v);
	public Vuelo buscarPorNumero(String numero);
	public List<Vuelo> buscarVuelosCliente(String origen, String destino, String fechaVuelo);


}
