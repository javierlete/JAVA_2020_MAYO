package com.ipartek.formacion.ejerciciospoo.tipos;

import java.util.Arrays;
import java.util.Scanner;

public class Alumno {
	private String nombre;

	private int[] notas = new int[5];

	/**
	 * Mete los datos del array e inicializa también el nombre con los valores
	 * introducidos por teclado.
	 */
	public Alumno() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);

		System.out.print("Nombre del alumno: ");
		nombre = s.nextLine();

		for (int i = 0; i < notas.length; i++) {
			System.out.print("Nota " + (i + 1) + ": ");
			notas[i] = s.nextInt();
			s.nextLine();
		}

		// s.close(); // Lo omitimos para permitir que el Scanner se pueda utilizar también en el main
	}

	/**
	 * Opción extra que recibe todos los datos directamente como parámetros
	 * @param nombre Nombre del alumno
	 * @param notas Array completamente rellenado con todas las notas del alumno
	 */
	public Alumno(String nombre, int[] notas) {
		this.nombre = nombre;
		this.notas = notas;
	}
	
	public Alumno(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return la mejor nota
	 */
	public int mejorNota() {
		int mejor = notas[0];

		for (int i = 1; i < notas.length; i++) {
			if (notas[i] > mejor) {
				mejor = notas[i];
			}
		}

		return mejor;
	}

	/**
	 * @return la menor de las notas
	 */
	public int menor() {
		int[] notasOrdenadas = notas.clone();
		
		Arrays.sort(notasOrdenadas);
		
		return notasOrdenadas[0];

//		return Arrays.stream(notas).min().getAsInt();
	}

	/**
	 * Muestra el nombre del alumno seguido de su nota media. 
	 */
	
	public double media() {
		double total = 0, media;

		for (int nota : notas) {
			total += nota;
		}

		media = total / notas.length;
		
		return media;
		
		// return Arrays.stream(notas).average().getAsDouble();
	}
	
	/**
	 * @return nombre del alumno seguido de su nota media
	 */
	
	public void mostrar() {
		System.out.println(nombre + ": nota media de " + media());
	}
	
	/* public|protected|private|(NADA) static|(NADA) UNTIPO|void NOMBREFUNCION */
	
	/**
	 * Lo necesitamos para poder acceder al nombre desde otro programa
	 * @return nombre almacenado
	 */
	public String getNombre() {
		return nombre;
	}
	
	// Extras para ampliar información
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int[] getNotas() {
		return notas;
	}
	
	public void setNotas(int[] notas) {
		this.notas = notas;
	}
	
	public int getNota(int posicion) {
		return notas[posicion];
	}
	
	public void setNota(int posicion, int nota) {
		notas[posicion] = nota;
	}
	// FIN Extras para ampliar información
	
	/**
	 * Interesante para poder echar un vistazo global a todos los valores de la clase
	 */
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", notas=" + Arrays.toString(notas) + "]";
	}
}
