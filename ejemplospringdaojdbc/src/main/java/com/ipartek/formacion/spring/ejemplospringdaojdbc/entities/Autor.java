package com.ipartek.formacion.spring.ejemplospringdaojdbc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Autor {
	private Long id;
	private String nombre, apellidos;
}
