package com.ipartek.formacion.spring.ejemplospringmvcdaojdbc.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ipartek.formacion.spring.ejemplospringmvcdaojdbc.modelos.Usuario;
import com.ipartek.formacion.spring.ejemplospringmvcdaojdbc.repositorios.UsuarioRepository;

@Controller
public class UsuarioController {
	@Autowired
	UsuarioRepository repo;
	
	@GetMapping("/usuario")
	public String usuario(@ModelAttribute Usuario usuario) {
		return "usuario";
	}
	
	@PostMapping("/usuario")
	//@ResponseBody // Muestra lo que devuelves directamente en el navegador
	public String alta(@ModelAttribute Usuario usuario) {
		if(usuario.getPassword().equals(usuario.getPassword2())) {
			repo.insert(usuario);
			return "index";
		} else {
			return "usuario";
		}
	}
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}
}
