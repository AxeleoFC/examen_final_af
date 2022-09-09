package com.example.demo.service;

import com.example.demo.repositoy.model.Cliente;

public interface IClienteService {
	
	public void ingresar(Cliente c);
	public Cliente buscarId(Integer id);
	public Cliente buscar(String cedula);

}
