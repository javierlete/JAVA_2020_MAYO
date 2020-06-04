package com.ipartek.formacion.ejerciciospoo.consola;

import java.util.Scanner;

import com.ipartek.formacion.ejerciciospoo.tipos.Alumno;

/**
 * Realizar un programa que haga uso de dicha clase. Para ello se creara un menú
 * que nos solicite si deseamos introducir un alumno. Si la respuesta es ‘s’ o
 * ‘S’ se creara un alumno, pidiendo todos sus datos por teclado y se mostrara
 * la siguiente información: • El nombre del alumno • Su mejor nota • Su peor
 * nota • Su nota media
 * 
 * @author javaee
 *
 */
public class AlumnoPresentacion {

	/**
	 * Solución de la parte de ejercicio de main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String respuesta;
		Scanner s = new Scanner(System.in);
		boolean repetir;

		do {
			System.out.print("¿Deseas introducir un alumno? (s/N) ");
			respuesta = s.nextLine();

			if ("s".equalsIgnoreCase(respuesta)) { // if("s".equals(respuesta) || "S".equals(respuesta)) {
				repetir = true;

				Alumno alumno = new Alumno();

				System.out.println("Nombre: " + alumno.getNombre());
				System.out.println("Mejor nota: " + alumno.mejorNota());
				System.out.println("Peor nota: " + alumno.menor());
				System.out.println("Media: " + alumno.media());
			} else {
				repetir = false;
			}
		} while (repetir);

		s.close();
	}

	/**
	 * Extras de cómo se pueden hacer ciertas operaciones
	 * 
	 * @param args
	 */
	public static void mainAvanzado(String[] args) {
		String nombre = "Javier";

		Alumno alumno = new Alumno(nombre);

		alumno.getNotas()[0] = 1;
		alumno.getNotas()[1] = 5;

		int[] notas = alumno.getNotas();

		notas[3] = 7;

		System.out.println(alumno);

		notas = new int[] { 1, 2, 5, 3 };

		alumno.setNotas(notas);

		System.out.println(alumno);

		alumno.setNota(2, 10);

		System.out.println(alumno);
	}

	/**
	 * Pruebas básicas de funcionamiento de la clase
	 * 
	 * @param args
	 */
	public static void mainPruebas(String[] args) {
		Alumno alumno = new Alumno();

		System.out.println(alumno);

		System.out.println(alumno.mejorNota());

		System.out.println(alumno.menor());

		System.out.println(alumno.media());

		alumno.mostrar();

		System.out.println(alumno);
	}

}
