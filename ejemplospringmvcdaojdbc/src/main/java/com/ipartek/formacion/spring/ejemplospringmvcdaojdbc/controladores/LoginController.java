package com.ipartek.formacion.spring.ejemplospringmvcdaojdbc.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.ejemplospringmvcdaojdbc.criptografia.AlgoritmosHash;
import com.ipartek.formacion.spring.ejemplospringmvcdaojdbc.modelos.Usuario;
import com.ipartek.formacion.spring.ejemplospringmvcdaojdbc.repositorios.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Controller // Spring entiende esta anotación como que cuando arranque su servlet front controller utilizará
@Slf4j // Lombok crea una variable estática log con ese nombre a nivel de esta clase
public class LoginController {
	@Autowired
	UsuarioRepository repo;
	
	@RequestMapping({"/sha512/{dato}", "/sha512"})
	public String prueba(Model modelo, @PathVariable(required = false) String dato) {
		modelo.addAttribute("dato", dato != null ? AlgoritmosHash.sha512(dato) : "Pasa por URL como path extra el dato que quieres convertir");
		return "sha512";
	}
	
	@GetMapping("/login")
	public String loginGet(@ModelAttribute Usuario usuario) {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginPost(@ModelAttribute Usuario usuario, Model modelo) {
		log.info(usuario.toString());
		
		Usuario usuarioBD = repo.getByEmail(usuario.getEmail());
		
		if(usuarioBD != null && AlgoritmosHash.sha512(usuario.getPassword()).equals(usuarioBD.getPassword())) {
			return "index";
		}
		
		modelo.addAttribute("error", "El usuario y contraseña son incorrectos ❌");
		modelo.addAttribute("errorimg", "/imgs/imagen.png");
		
		return null;
	}
}
