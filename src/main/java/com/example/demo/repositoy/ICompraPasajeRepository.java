package com.example.demo.repositoy;

import java.util.List;

import com.example.demo.repositoy.model.CompraPasaje;

public interface ICompraPasajeRepository {
	
	public void ingresar(CompraPasaje compraPasaje);
	public void actualiza(CompraPasaje compraPasaje);
	public CompraPasaje buscar(String numero);
	public List<CompraPasaje> buscarTodos();

}
