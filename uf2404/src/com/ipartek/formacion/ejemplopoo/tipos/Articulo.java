package com.ipartek.formacion.ejemplopoo.tipos;

import java.math.BigDecimal;

public class Articulo {
	private Long id;
	private String nombre;
	private BigDecimal precio;
	
	public Articulo(Long id, String nombre, BigDecimal precio) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}	
}
