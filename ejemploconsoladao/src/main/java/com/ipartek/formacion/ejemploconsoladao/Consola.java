package com.ipartek.formacion.ejemploconsoladao;

import java.util.Scanner;

public class Consola {
	private static final Scanner s = new Scanner(System.in);

	public static String pedirLinea(String mensaje) {
		System.out.print(mensaje + ": ");
		return s.nextLine();
	}
	
	public static Double pedirDouble(String mensaje) {
		Double d = null;
		boolean correcto;
		
		do {
			correcto = true;
			try {
				d = new Double(pedirLinea(mensaje));
			} catch (NumberFormatException e) {
				correcto = false;
				System.out.println("No es un número. Por favor, inténtalo otra vez.");
			}
		} while(!correcto);
		
		return d;
	}
	
	public static Long pedirLong(String mensaje) {
		Long l = null;
		boolean correcto;
		
		do {
			correcto = true;
			try {
				l = new Long(pedirLinea(mensaje));
			} catch (NumberFormatException e) {
				correcto = false;
				System.out.println("No es un número. Por favor, inténtalo otra vez.");
			}
		} while(!correcto);
		
		return l;
	}
}
