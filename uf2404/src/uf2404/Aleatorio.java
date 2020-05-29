package uf2404;

import java.util.Date;

public class Aleatorio {

	public static void main(String[] args) {
		Date d = new Date();
		
		System.out.println(d);
		
		System.out.println(d.getTime());
		
		System.out.println(new Date(24 * 3600000));
		
		System.out.println(dado());
	}

	private static int dado(int caras) {
		return (int)(Math.random() * caras) + 1;
	}
	
	private static int dado() {
		return dado(6);
	}

}
