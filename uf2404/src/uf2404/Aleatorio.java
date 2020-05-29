package uf2404;

import java.util.Date;

public class Aleatorio {

	public static void main(String[] args) {
		// Ejemplo de fechas
		Date d = new Date();
		
		System.out.println(d);
		
		System.out.println(d.getTime());
		
		// Ejemplo de aleatorios
		System.out.println(new Date(30 * 24 * 60 * 60 * 1000));
		
		System.out.println(dado());
	}

	private static int dado(int caras) {
		return (int)(Math.random() * caras) + 1;
	}
	
	private static int dado() {
		return dado(6);
	}

}
