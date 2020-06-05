package com.ipartek.clases;

import java.util.Scanner;

//Yo reservaría ese nombre para clases que representan un conjunto de datos
//No suelo utilizar nombres en plural
public class Cuadros {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		Cuadro[] cuadros = new Cuadro[10];
		
		int i = 0;
		
		boolean repetir;
		
		String respuesta;
		
		//Probablemente sería más recomendable crear un cuadro vacío y utilizar
		//los setter para guardar los datos (usaríamos la clase Cuadro como un modelo)
		// Cuadro cuadro = new Cuadro();
		String titulo, autor;
		int altura, anchura, anyo;
		boolean restaurado;
		double precio;
		
		do {
			repetir = false;
			
			System.out.print("¿Quieres introducir un cuadro? (sí/NO)");
			respuesta = s.nextLine();
			
			if("sí".equalsIgnoreCase(respuesta)) {
				repetir = true;
				
				System.out.print("Titular: ");
				// cuadro.setTitulo(s.nextLine());
				titulo = s.nextLine();
				
				System.out.print("Autor: ");
				autor = s.nextLine();

				System.out.print("Altura: ");
				altura = s.nextInt();
				s.nextLine();
				
				System.out.print("Anchura: ");
				anchura = s.nextInt();
				s.nextLine();
				
				System.out.print("Año: ");
				anyo = s.nextInt();
				s.nextLine();
				
				System.out.print("Restaurado (sí/no): ");
				// cuadro.setRestaurado("sí".equalsIgnoreCase(s.nextLine());
				// cuadro.setRestaurado(leerBooleano("Restaurado");
				restaurado = "sí".equalsIgnoreCase(s.nextLine());
				
//				if("sí".equalsIgnoreCase(s.nextLine())) {
//					restaurado = true;
//				} else {
//					restaurado = false;
//				}
				
				System.out.print("Precio: ");
				precio = s.nextDouble();
				s.nextLine();
				
				cuadros[i++] = new Cuadro(titulo, autor, altura, anchura, anyo, restaurado, precio);
				
				if(i >= cuadros.length) {
					repetir = false;
				}
			}
		} while(repetir);
		
		i = 0;
		
		do {
			System.out.println(cuadros[i++]);
		} while(cuadros[i] != null);
		
		s.close();
	}
}















