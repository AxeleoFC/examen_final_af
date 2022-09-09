package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repositoy.model.CompraTo;
import com.example.demo.repositoy.model.Vuelo;
import com.example.demo.service.ICompraPasajeService;
import com.example.demo.service.IVueloService;

@Controller
@RequestMapping("/pasaje")
public class PasajeController {
	
	@Autowired
	private ICompraPasajeService compraPasajeService;
	@Autowired
	private IVueloService vueloService;
	
	@GetMapping("/revisar")
	public String revisarPasajes(Vuelo vuelo) {
		return "vistaRevisar";
	}
	
	@GetMapping("/comprar")
	public String comprarPasajes(Vuelo vuelo, CompraTo compraTo, Model model) {
		Vuelo vuel=this.vueloService.buscarPorNumero(vuelo.getNumero());
		model.addAttribute("vueloB", vuel);
		return "vistaCompra";
	}
	
	@PostMapping("/insertarPasaje")
	public String insertarPasaje(CompraTo compraTo) {
		//Metodo de generar compra
		this.compraPasajeService.ingresar(compraTo.getNumVuelo(), compraTo.getNumAsientosComprados(), compraTo.getCedula());
		return "vistaGestor";
	}
	

}
