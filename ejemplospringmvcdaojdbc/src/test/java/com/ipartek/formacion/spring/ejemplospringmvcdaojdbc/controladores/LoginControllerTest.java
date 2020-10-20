package com.ipartek.formacion.spring.ejemplospringmvcdaojdbc.controladores;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ipartek.formacion.spring.ejemplospringmvcdaojdbc.modelos.Usuario;

@SpringBootTest
public class LoginControllerTest {
	@Autowired
	LoginController login;
	
	@Test
	public void loginGet() {
		assertThat(login.loginGet(new Usuario(null, null, null))).isEqualTo("login");
	}
	
	@Test
	public void loginPost() {
		Usuario usuarioOK = new Usuario(null, "javier@ipartek.com", "contra");
		Usuario usuarioKO = new Usuario(null, "lakjsdlkfjasd@lkajshdlf.a", "lkajsdflk");
		assertThat(login.loginPost(usuarioOK)).isEqualTo("index");
		assertThat(login.loginPost(usuarioKO)).isEqualTo(null);
	}
}
