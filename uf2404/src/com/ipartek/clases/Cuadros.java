package com.ipartek.clases;

import com.ipartek.formacion.biblioteca.Consola;

//Yo reservaría ese nombre para clases que representan un conjunto de datos
//No suelo utilizar nombres en plural
public class Cuadros {
	public static void main(String[] args) {
		Cuadro[] cuadros = new Cuadro[10];
		
		int i = 0;
		
		boolean repetir;
		
		Cuadro cuadro;
		
		do {
			repetir = Consola.leerBoolean("¿Quieres introducir un cuadro?");
			
			if(repetir) {
				cuadro = new Cuadro();
				
				cuadro.setTitulo(Consola.leerString("Titular"));
				cuadro.setAutor(Consola.leerString("Autor"));
				cuadro.setAltura(Consola.leerInt("Altura"));
				cuadro.setAnchura(Consola.leerInt("Anchura"));
				cuadro.setAnyo(Consola.leerInt("Año"));
				cuadro.setRestaurado(Consola.leerBoolean("Restaurado"));
				cuadro.setPrecio(Consola.leerDouble("Precio"));
				
				cuadros[i++] = cuadro;
				
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















