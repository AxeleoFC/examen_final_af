package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repositoy.model.Vuelo;
import com.example.demo.service.IVueloService;

@Controller
@RequestMapping("/vuelo")
public class VueloController {
	
	@Autowired
	private IVueloService vueloService;
	
	@GetMapping("/buscar")
	public String buscarVuelos(Vuelo vuelo) {
		return "vistaBuscarVuelos";
	}
	
	@GetMapping("/buscarVuelos")
	public String verVuelos(Vuelo vuelo, Model model) {
		List<Vuelo> vuelos = this.vueloService
				.buscarVuelosCliente(vuelo.getOrigen(), vuelo.getDestino(), vuelo.getFechaVuelo());
		
		model.addAttribute("vuelos",vuelos);
		
		return "vistaVuelos";
	}

}
