package uf2404;

import java.util.Scanner;

public class ScannerProblemas {

	public static void main(String[] args) {
		int entero;
		String texto, texto2;
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Introduce un entero: ");
		entero = s.nextInt(); // "5" (53) 13 10 -> 5
		
		System.out.print("Introduce un texto: ");
		texto = s.nextLine(); // (13 10) -> "" (Carriage Return Line Feed)
		
		System.out.print("Introduce un texto2: ");
		texto2 = s.nextLine(); // "Un texto" (.......13 10) -> "Un texto"
		
		System.out.println("Entero = '" + entero + "'");
		System.out.println("Texto = '" + texto + "'");
		System.out.println("Texto2 = '" + texto2 + "'");
		
		s.close();
	}

}
