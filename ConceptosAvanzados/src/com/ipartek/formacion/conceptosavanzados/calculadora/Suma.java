package com.ipartek.formacion.conceptosavanzados.calculadora;

public class Suma implements Operacion {
	@Override
	public double ejecutar(double op1, double op2) {
		return op1 + op2;
	}
}
