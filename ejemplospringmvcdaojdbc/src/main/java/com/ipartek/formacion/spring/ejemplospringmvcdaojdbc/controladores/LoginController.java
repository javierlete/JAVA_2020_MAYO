package com.ipartek.formacion.spring.ejemplospringmvcdaojdbc.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ipartek.formacion.spring.ejemplospringmvcdaojdbc.modelos.Usuario;
import com.ipartek.formacion.spring.ejemplospringmvcdaojdbc.repositorios.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	@Autowired
	UsuarioRepository repo;
	
	@GetMapping("/login")
	public String loginGet(@ModelAttribute Usuario usuario) {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginPost(@ModelAttribute Usuario usuario) {
		log.info(usuario.toString());
		
		Usuario usuarioBD = repo.getByEmail(usuario.getEmail());
		
		if(usuarioBD != null && usuario.getPassword().equals(usuarioBD.getPassword())) {
			return "index";
		}
		
		return null;
	}
}
