package com.ipartek.formacion.conceptosavanzados.calculadora;

public class Calculadora {

	public static void main(String[] args) {
		Operacion operacion;

		double a = 5.2, b = 7.8;

		operacion = new Resta();

		System.out.println(operacion.ejecutar(a, b));

		mostrarResultado(operacion, a, b);

		mostrarResultado(new Suma(), a, b);

		// Aquí se crea un objeto basado en una clase anónima que implementa Operacion
		mostrarResultado(new Operacion() {
			@Override
			public double ejecutar(double op1, double op2) {
				return op1 * op2;
			}
		}, a, b);

		mostrarResultado((op1, op2) -> op1 * op2, a, b);

		mostrarResultado((op1, op2) -> {
			System.out.println("Haciendo una suma");
			return op1 + op2;
		}, a, b);

		mostrarResultado((op1, op2) -> {
			System.out.println("Logueando: " + (a + b));
			return a + b;
		}, a, b);
	}

	public static void mostrarResultado(Operacion operacion, double a, double b) {
		System.out.println("Resultado: " + operacion.ejecutar(a, b));
	}
}
