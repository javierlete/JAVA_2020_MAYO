package com.ipartek.formacion.ejemplopoo.tipos;

import java.math.BigDecimal;

public abstract class Empleado extends Persona {
	private String nif;
	
	public Empleado(String nombre, String apellidos, String nif) {
		super(nombre, apellidos);
		this.nif = nif;
	}

	public abstract BigDecimal getSueldoMensual();

	@Override
	public String toString() {
		return "Empleado [ " + super.toString() + ", nif=" + nif + "]";
	}
}
