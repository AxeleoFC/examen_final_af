package com.example.demo.repositoy;

import com.example.demo.repositoy.model.Avion;

public interface IAvionRepository {
	public void ingresar(Avion avion);
	public void actualiza(Avion avion);
	public Avion buscar(String numero);
	public Avion buscarId(Integer id);
}
