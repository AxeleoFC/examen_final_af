package com.example.demo.service;

import com.example.demo.repositoy.model.Avion;

public interface IAvionService {
	
	public void ingresar(Avion a);
	public Avion buscarId(Integer id);

}
