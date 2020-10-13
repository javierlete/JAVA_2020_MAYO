package com.ipartek.formacion.spring.ejemplospring.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorRest {
	@GetMapping("/saludar")
	public String saludar(String nombre, String apellidos) {
		return "¡Hola " + nombre + " " + apellidos + ", que tal!";
	}
}
