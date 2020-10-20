package com.ipartek.formacion.spring.ejemplospringmvcdaojdbc.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Usuario {
	private Long id;
	private String email, password;
}
