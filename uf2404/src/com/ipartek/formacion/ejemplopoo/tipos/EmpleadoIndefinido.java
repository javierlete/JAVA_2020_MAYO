package com.ipartek.formacion.ejemplopoo.tipos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EmpleadoIndefinido extends Empleado {
	private int numeroPagas;
	private BigDecimal sueldoAnual;

	public EmpleadoIndefinido(String nombre, String apellidos, String nif, int numeroPagas, BigDecimal sueldoAnual) {
		super(nombre, apellidos, nif);
		this.numeroPagas = numeroPagas;
		this.sueldoAnual = sueldoAnual;
	}

	@Override
	public BigDecimal getSueldoMensual() {
		return sueldoAnual.divide(new BigDecimal(numeroPagas), 2, RoundingMode.HALF_UP);
	}

	@Override
	public String toString() {
		return "EmpleadoIndefinido [" + super.toString() + ", numeroPagas=" + numeroPagas + ", sueldoAnual="
				+ sueldoAnual + "]";
	}
}
