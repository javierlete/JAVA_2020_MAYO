package com.ipartek.formacion.spring.ejemploexportarcsv.modelos;

import lombok.Data;

@Data
public class Alumno {
	private Long codigo;
	private String nombre, apellidos, email;
}
