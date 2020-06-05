package com.ipartek.formacion.biblioteca;

import java.util.Scanner;

public class Consola {
	private static Scanner s = new Scanner(System.in);
	
	public static String leerString(String mensaje) {
		mostrar(mensaje);
		return s.nextLine();
	}
	
	public static int leerInt(String mensaje) {
		mostrar(mensaje);
		int i = s.nextInt();
		s.nextLine();
		return i;
	}
	
	public static double leerDouble(String mensaje) {
		mostrar(mensaje);
		double d = s.nextDouble();
		s.nextLine();
		return d;
	}
	
	public static boolean leerBoolean(String mensaje) {
		mostrar(mensaje + " (sí/NO)");
		return s.nextLine().matches("^[sS][iIíÍ]?$");
	}
	
	private static void mostrar(String mensaje) {
		System.out.print(mensaje + ": ");
	}
}
