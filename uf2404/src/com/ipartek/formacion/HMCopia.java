package com.ipartek.formacion;



import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.math.BigDecimal;

import java.math.BigInteger;

import java.util.ArrayList;

import java.util.Scanner;



public class HMCopia {

	@SuppressWarnings("unused")

	public static void main(String[] args) throws IOException {

		/*

		 * Comentario multilínea

		 */



		// Comentario de línea



		System.out.println("Hola mundo"); // Escribe Hola mundo en pantalla



		int enteroDe32Bits;

		byte enteroDe8Bits;

		short año = 2020;

		byte día = 27;



		System.out.println("Año = " + año + ", día = " + día);



		byte dia;

		short anno, anyo = 2020, anio, ano;



		long l = 123123123123123123L;



		boolean b = false;



		char c = 'a';

		char enter = '\n';

		char tab = '\t';



		System.out.println("Texto" + enter + "Tabulador" + tab + "Otra cosa");



		System.out.println("C:\\nuevos\\trabajos.txt");



		float f = 4.0F;

		double d = 4.3;



		String nombre;



		nombre = "    Javier Lete        ";



		nombre = nombre.trim().toUpperCase().substring(0, 6);



		System.out.println("Hola, " + nombre + ". Estamos en " + anyo);



		Integer numero = 5; // Anterior a 1.5: Integer numero = new Integer(5);



		int num = numero; // int num = numero.intValue();



		d = 4.7;

		int i = (int) d;



		System.out.println(d);

		System.out.println(i);



		System.out.println(Math.round(d));



		double d2 = i;



		System.out.println(d2);



		BigInteger bi = new BigInteger("123123123123123123123");



		System.out.println(bi);



		BigDecimal bd = new BigDecimal("123123123123123123123.123123123123123123");



		System.out.println(bd.add(new BigDecimal("1")));



		double dbd = 123123123123123123123.123123123123123123;



		System.out.println(dbd + 1);



		System.out.println("Texto".charAt(1));



		System.out.println("Javier".compareToIgnoreCase("javier"));



		String nombre1 = new String("Javier");

		String nombre2 = "Javier";



		System.out.println(nombre1 == nombre2); // MAAAAAAL



		System.out.println(nombre1.equals(nombre2));



		System.out.println("En un lugar de la Mancha".indexOf("lugar"));



		System.out.println("Hola".length());



		System.out.println("X2123123A".matches("^[XYZxyz\\d]\\d{7}[A-Za-z]$"));



		System.out.println("Javier Lete".replace("Lete", "Profe"));



		System.out.println("uno dos tres cuatro".split(" ")[1]);



		System.out.println("Texto largo que te pasas".substring(3, 11));



		System.out.println("Javier".toUpperCase());



		System.out.println("Javier".toLowerCase());



		System.out.println("      Texto escrito por usuario en cuadro de texto   ".trim());



		int[] arr = new int[2];



		arr[0] = 5;

		arr[1] = 7;

		// arr[2] = 6;



		System.out.println(arr[0]);

		System.out.println(arr[1]);

		System.out.println(arr.length);



		int tamanyo = 2;



		String[] textos = new String[tamanyo];



		textos[0] = "Un texto";

		textos[1] = "Otro texto";



		System.out.println(textos[1]);



		char[][] tablero = new char[8][8];



		tablero[0][0] = 'T';

		tablero[1][0] = 'p';

		tablero[0][1] = 'C';



		ArrayList<String> usuarios = new ArrayList<String>();



		usuarios.add("Javier");

		usuarios.add("Lete");

		usuarios.add("Pepe");



		usuarios.remove(1);



		System.out.println(usuarios.size());



		System.out.println(usuarios.get(1));



		ArrayList<ArrayList<String>> bidi = new ArrayList<ArrayList<String>>();



		ArrayList<String> fila1 = new ArrayList<String>();



		fila1.add("Dato fila 1 columna 1");



		bidi.add(fila1);



		System.out.println(5 ^ 3);



		System.out.println(5 + 3 + 2);



		int x = 5;



		System.out.println(1 <= x && x <= 10);



		System.out.println(x++);

		System.out.println(x);



		x = 5;



		System.out.println(++x);

		System.out.println(x);



		System.out.println(5 & 3);

		System.out.println(5 | 3);

		System.out.println(5 ^ 3);

		System.out.println(~5);



		System.out.println(-5 >> 2); // Desplaza rellenando con bit de signo

		System.out.println(-5 >>> 2); // Desplaza rellenando siempre con 0's

		System.out.println(-5 << 2);



		boolean estaArrancado = true;



		System.out.println(estaArrancado ? "Arrancado" : "Parado");



		int n1 = 1, n2 = 2, max;



		max = n1 > n2 ? n1 : n2; // SI(n1 > n2; n1; n2) IIF(n1 > n2, n1, n2)

		

		System.out.println(max);



		if (!estaArrancado) {

			System.out.println("Parado");

			System.out.println("¡Qué bien!");

		}

		

		System.out.println(estaArrancado);

		

		int dias, mes = 4;

		

		switch(mes) {

		case 2: dias = 28; break;

		case 4: System.out.println("Abril!");

		case 6:

		case 9:

		case 11: dias = 30; break;

		default: dias = 31;

		}

		

		System.out.println(dias);

		

		int contador = 0;

		while(contador < 10) {

			System.out.println(++contador);

		}

		

		contador = 0;

		do {

			System.out.println(++contador);

		} while(contador < 10);

		

		for(contador = 1; contador <= 10; contador++) {

			System.out.println(contador);

		}

		

		for(i = 0; i < usuarios.size(); i++) {

			System.out.println(usuarios.get(i));

		}

		

		for(String usuario : usuarios) {

			System.out.println(usuario);

		}

		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		

		System.out.print("Dime tu nombre: ");

		

		nombre = br.readLine();

		

		System.out.println("Hola " + nombre);

		

		Scanner s = new Scanner(System.in);

		

		System.out.print("Dime tu rol: ");

		

		String rol = s.nextLine();

		

		System.out.println("Tu rol es " + rol);

		

		System.out.print("Dime qué día es: ");

		

		dia = s.nextByte();

		

		System.out.println("Día: " + dia);

		

		s.close();

		

		String numeroEnTexto = "45";

		

		int numeroEnEntero = Integer.parseInt(numeroEnTexto);

		

		String numeroOtraVezEnTexto = String.valueOf(numeroEnEntero);

		numeroOtraVezEnTexto = "" + numeroEnEntero;

	}

}