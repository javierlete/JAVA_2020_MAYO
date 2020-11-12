package com.ipartek.formacion.spring.ejemplofinalspring.presentacion.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	public String post(@ModelAttribute Factura factura) {
		log.trace(factura.toString());
		
		return factura.toString();
	}
}
