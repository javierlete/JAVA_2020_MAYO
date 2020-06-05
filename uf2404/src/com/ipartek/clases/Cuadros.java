package com.ipartek.clases;

import java.util.ArrayList;

import com.ipartek.formacion.biblioteca.Consola;

//Yo reservaría ese nombre para clases que representan un conjunto de datos
//No suelo utilizar nombres en plural
public class Cuadros {
	public static void main(String[] args) {
		ArrayList<Cuadro> cuadros = new ArrayList<Cuadro>();
		
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
				
				cuadros.add(cuadro);
			}
		} while(repetir);
		
		for(Cuadro c: cuadros) {
			System.out.println(c);
		} 
	}
}















