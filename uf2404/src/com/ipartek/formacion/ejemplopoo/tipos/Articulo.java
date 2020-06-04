package com.ipartek.formacion.ejemplopoo.tipos;

import java.math.BigDecimal;

public class Articulo {
	private Long id;
	private String nombre;
	private BigDecimal precio;
	
	public Articulo(Long id, String nombre, BigDecimal precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Articulo [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}	
}
