package com.example.demo.repositoy;

import java.util.List;

import com.example.demo.repositoy.model.Vuelo;

public interface IVueloRepository {
	
	public void ingresar(Vuelo vuelo);
	public void actualiza(Vuelo vuelo);
	public Vuelo buscar(String numero);
	public List<Vuelo> buscarVuelos(String origen, String destino, String fecha);

}
