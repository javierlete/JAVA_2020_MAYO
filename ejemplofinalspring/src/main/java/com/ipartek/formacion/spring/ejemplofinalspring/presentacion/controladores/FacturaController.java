package com.ipartek.formacion.spring.ejemplofinalspring.presentacion.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Factura;
import com.ipartek.formacion.spring.ejemplofinalspring.entidades.LineaFactura;
import com.ipartek.formacion.spring.ejemplofinalspring.servicios.FacturaService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class FacturaController {
	@Autowired
	private FacturaService servicio;
	
	@GetMapping
	public String get(Factura factura) {
		return "index";
	}
	
	@PostMapping
	public String post(@Valid @ModelAttribute Factura factura, BindingResult bindingResult) {
		log.trace(factura.toString());
		
		if(bindingResult.hasErrors()) {
			return "index";
		}
		
		servicio.crearNuevaFactura(factura);
		
		return "redirect:/factura/" + factura.getId();
	}
	
	@GetMapping("/factura/{id}")
	public String factura(@PathVariable Long id, Model modelo, LineaFactura lineaFactura) {
		modelo.addAttribute("factura", servicio.obtenerFacturaPorId(id));
		modelo.addAttribute("productos", servicio.obtenerProductos());
		
		return "factura";
	}
	
	@PostMapping("/factura/agregarlinea")
	public String agregarLinea(Long idFactura, LineaFactura lineaFactura) {
		System.out.println("EN MI METODO AGREGAR LINEA");
		
		log.trace(idFactura.toString());
		log.trace(lineaFactura.toString());
		
		Factura factura = servicio.obtenerFacturaPorId(idFactura);
		
		factura.getLineas().add(lineaFactura);
		
		servicio.modificarFactura(factura);
		
		return "redirect:/factura/" + idFactura;
	}
	
	@GetMapping("/facturas")
	public String facturas(Model modelo) {
		modelo.addAttribute("facturas", servicio.obtenerFacturas());
		return "facturas";
	}
}
