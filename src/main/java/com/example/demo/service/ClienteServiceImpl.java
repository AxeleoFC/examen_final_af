package com.example.demo.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositoy.IClienteRepository;
import com.example.demo.repositoy.model.Cliente;
@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteRepository clienteRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void ingresar(Cliente c) {
		// TODO Auto-generated method stub
		this.clienteRepository.ingresar(c);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Cliente buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.clienteRepository.buscarId(id);
	}

	@Override
	public Cliente buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.clienteRepository.buscar(cedula);
	}

}
