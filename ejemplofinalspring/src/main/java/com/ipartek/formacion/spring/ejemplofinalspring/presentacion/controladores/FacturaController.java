package com.ipartek.formacion.spring.ejemplofinalspring.presentacion.controladores;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Factura;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class FacturaController {
	@GetMapping
	public String get() {
		return "index";
	}
	
	@PostMapping
	public String post(@Valid @ModelAttribute Factura factura, BindingResult bindingResult) {
		log.trace(factura.toString());
		
		if(bindingResult.hasErrors()) {
			return "index";
		}
		
		return "facturalineas";
	}
}
