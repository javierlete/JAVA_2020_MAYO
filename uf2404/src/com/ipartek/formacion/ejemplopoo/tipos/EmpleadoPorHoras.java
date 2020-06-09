package com.ipartek.formacion.ejemplopoo.tipos;

import java.math.BigDecimal;

public class EmpleadoPorHoras extends Empleado {
	private int horasMensuales;
	private BigDecimal precioHora;

	public EmpleadoPorHoras(String nombre, String apellidos, String nif, int horasMensuales, BigDecimal precioHora) {
		super(nombre, apellidos, nif);
		this.horasMensuales = horasMensuales;
		this.precioHora = precioHora;
	}

	@Override
	public BigDecimal getSueldoMensual() {
		return precioHora.multiply(new BigDecimal(horasMensuales));
	}
	
	@Override
	public String toString() {
		return "EmpleadoPorHoras [" + super.toString() + ", horasMensuales=" + horasMensuales + ", precioHora="
				+ precioHora + "]";
	}
}
