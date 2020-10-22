package com.ipartek.formacion.spring.ejemplospringmvcdaojdbc.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Usuario {
	private Long id;
	private String email, password, password2;
	
	public Usuario(Long id, String email, String password) {
		this(id, email, password, null);
	}
}
