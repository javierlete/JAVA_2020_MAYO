package uf2404;

import java.util.Scanner;

public class ScannerSolucion {

	public static void main(String[] args) {
		int entero, entero2, entero3;
		String texto, texto2;
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Introduce un entero: ");
		entero = s.nextInt(); // "5" (53) 13 10 -> 5
		s.nextLine(); // (13 10)
		
		entero2 = leerEntero(s, "Introduce el entero2: ");
		
		System.out.print("Introduce el entero3: ");
		entero3 = Integer.parseInt(s.nextLine());
		// Si se introduce algo más que un número separado por espacio por ejemplo, fallará con un NumberFormatException
		
		System.out.print("Introduce un texto: ");
		texto = s.nextLine();
		
		System.out.print("Introduce un texto2: ");
		texto2 = s.nextLine();
		
		System.out.println("Entero = '" + entero + "'");
		System.out.println("Entero2 = '" + entero2 + "'");
		System.out.println("Entero3 = '" + entero3 + "'");
		System.out.println("Texto = '" + texto + "'");
		System.out.println("Texto2 = '" + texto2 + "'");
		
		s.close();
	}
	
	private static int leerEntero(Scanner s, String texto) {
		int entero;
		
		System.out.print(texto);
		entero = s.nextInt(); // "5" (53) 13 10 -> 5
		s.nextLine(); // (13 10)
		
		return entero;
	}

}
