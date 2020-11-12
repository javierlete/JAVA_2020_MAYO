package com.ipartek.formacion.spring.ejemplofinalspring.presentacion.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FacturaController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
