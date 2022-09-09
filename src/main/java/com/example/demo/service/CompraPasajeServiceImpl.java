package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositoy.ICompraPasajeRepository;
import com.example.demo.repositoy.IVueloRepository;
import com.example.demo.repositoy.model.Cliente;
import com.example.demo.repositoy.model.CompraPasaje;
import com.example.demo.repositoy.model.Vuelo;
@Service
public class CompraPasajeServiceImpl implements ICompraPasajeService {

	@Autowired
	private ICompraPasajeRepository compraPasajeRepository;
	@Autowired
	private IVueloRepository vueloRepository;
	@Autowired
	private IClienteService clienteService;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public CompraPasaje buscarPasaje(String numero) {
		// TODO Auto-generated method stub
		return this.compraPasajeRepository.buscar(numero);
	}


	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void ingresar(String numVuelo, Integer numAsientosComprados, String cedula) {
		// TODO Auto-generated method stub
		CompraPasaje compraPasaje=new CompraPasaje();
		Cliente cliente=this.clienteService.buscar(cedula);
		compraPasaje.setFechaCompra(LocalDateTime.now());
		compraPasaje.setCantidadAsientos(numAsientosComprados);
		List<CompraPasaje> totalPasajes=this.compraPasajeRepository.buscarTodos();
		if(totalPasajes.size()==0) {
			compraPasaje.setNumero("A1");
		}else {
			Integer num=totalPasajes.size()+1;
			compraPasaje.setNumero("A"+num);
		}
		
		compraPasaje.setEstado("RES");
		Vuelo vuelo=this.vueloRepository.buscar(numVuelo);
		compraPasaje.setVuelo(vuelo);
		if(vuelo.getAsientosDisponibles()>=compraPasaje.getCantidadAsientos()) {
			vuelo.setAsientosDisponibles(vuelo.getAsientosDisponibles()-compraPasaje.getCantidadAsientos());
			vuelo.setAsientosOcupados(vuelo.getAsientosDisponibles()+compraPasaje.getCantidadAsientos());
			if(vuelo.getAsientosDisponibles()==0) {
				vuelo.setVueloEstado(numVuelo);
			}
		}
		compraPasaje.setCliente(cliente);
		this.vueloRepository.actualiza(vuelo);
		this.compraPasajeRepository.ingresar(compraPasaje);
		
	}

}
