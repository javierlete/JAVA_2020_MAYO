package com.ipartek.clases;

import com.ipartek.formacion.biblioteca.Consola;

//Yo reservaría ese nombre para clases que representan un conjunto de datos
//No suelo utilizar nombres en plural
public class Cuadros {
	public static void main(String[] args) {
		Cuadro[] cuadros = new Cuadro[10];
		
		int i = 0;
		
		boolean repetir;
		
		//Probablemente sería más recomendable crear un cuadro vacío y utilizar
		//los setter para guardar los datos (usaríamos la clase Cuadro como un modelo)
		// Cuadro cuadro = new Cuadro();
		String titulo, autor;
		int altura, anchura, anyo;
		boolean restaurado;
		double precio;
		
		do {
			repetir = Consola.leerBoolean("¿Quieres introducir un cuadro?");
			
			if(repetir) {
				titulo = Consola.leerString("Titular");
				autor = Consola.leerString("Autor");
				altura = Consola.leerInt("Altura");
				anchura = Consola.leerInt("Anchura");
				anyo = Consola.leerInt("Año");
				restaurado = Consola.leerBoolean("Restaurado");
				// cuadro.setRestaurado("sí".equalsIgnoreCase(s.nextLine());
				// cuadro.setRestaurado(leerBooleano("Restaurado");
				precio = Consola.leerDouble("Precio");
				
				cuadros[i++] = new Cuadro(titulo, autor, altura, anchura, anyo, restaurado, precio);
				
				if(i >= cuadros.length) {
					repetir = false;
				}
			}
		} while(repetir);
		
		i = 0;
		
		while(cuadros[i] != null) {
			System.out.println(cuadros[i++]);
		} 
	}
}















