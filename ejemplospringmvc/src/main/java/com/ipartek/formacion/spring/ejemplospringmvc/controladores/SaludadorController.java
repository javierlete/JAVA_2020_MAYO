package com.ipartek.formacion.spring.ejemplospringmvc.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SaludadorController {
	@GetMapping({ "/saludar", "/saludar/{tipoSaludo}" })
	public String saludar(@PathVariable(required = false) String tipoSaludo,
			@RequestParam(name = "nombre", defaultValue = "desconocido") String nombre, Model model) {
		model.addAttribute("nombre", nombre);
		
		if(tipoSaludo == null) {
			tipoSaludo = "Hola";
		}
		
		model.addAttribute("tipoSaludo", tipoSaludo);
		return "saludar";
	}
}
