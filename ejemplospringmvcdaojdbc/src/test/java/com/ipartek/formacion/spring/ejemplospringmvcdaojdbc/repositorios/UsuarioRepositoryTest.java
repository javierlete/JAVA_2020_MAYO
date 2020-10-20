package com.ipartek.formacion.spring.ejemplospringmvcdaojdbc.repositorios;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ipartek.formacion.spring.ejemplospringmvcdaojdbc.modelos.Usuario;

@SpringBootTest
public class UsuarioRepositoryTest {
	@Autowired
	UsuarioRepository repo;
	
	@Test
	public void getByEmail() {
		Usuario usuario = repo.getByEmail("javier@ipartek.com");
		
		assertThat(usuario).isEqualTo(new Usuario(1L, "javier@ipartek.com", "contra"));
		
		usuario = repo.getByEmail("aldksjlaksjdf");
		
		assertThat(usuario).isNull();
	}
	
}
