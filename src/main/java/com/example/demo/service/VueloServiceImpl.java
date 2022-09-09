package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositoy.IVueloRepository;
import com.example.demo.repositoy.model.Vuelo;
@Service
public class VueloServiceImpl implements IVueloService {

	@Autowired
	private IVueloRepository vueloRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void ingresar(Vuelo v) {
		// TODO Auto-generated method stub
		this.vueloRepository.ingresar(v);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Vuelo> buscarVuelosCliente(String origen, String destino, String fechaVuelo) {
		// TODO Auto-generated method stub
		return this.vueloRepository.buscarVuelos(origen, destino, fechaVuelo).stream()
				.filter(vuel -> vuel.getVueloEstado().equals("DIS")).toList();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Vuelo buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.vueloRepository.buscar(numero);
	}


}
