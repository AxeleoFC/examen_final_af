package com.example.demo.repositoy;

import com.example.demo.repositoy.model.Cliente;

public interface IClienteRepository {
	
	public void ingresar(Cliente cliente);
	public void actualiza(Cliente cliente);
	public Cliente buscar(String cedula);
	public Cliente buscarId(Integer id);

}
