package com.example.demo.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositoy.IAvionRepository;
import com.example.demo.repositoy.model.Avion;
@Service
public class AvionServiceImpl implements IAvionService{

	@Autowired
	private IAvionRepository avionRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void ingresar(Avion a) {
		// TODO Auto-generated method stub
		this.avionRepository.ingresar(a);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Avion buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.avionRepository.buscarId(id);
	}

}
