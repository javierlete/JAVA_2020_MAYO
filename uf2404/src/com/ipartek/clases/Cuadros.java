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
		Autor autor;
		TamanyoLienzo tamanyoLienzo;
		
		do {
			repetir = Consola.leerBoolean("¿Quieres introducir un cuadro?");
			
			if(repetir) {
				cuadro = new Cuadro();
				autor = new Autor();
				tamanyoLienzo = new TamanyoLienzo();
				
				cuadro.setTitulo(Consola.leerString("Titular"));
				
				System.out.println("DATOS DEL AUTOR");
				
				autor.setNombre(Consola.leerString("Nombre"));
				autor.setApellidos(Consola.leerString("Apellidos"));
				autor.setFallecido(Consola.leerBoolean("Fallecido"));
				autor.setAnyoNacimiento(Consola.leerInt("Año nacimiento"));
				
				cuadro.setAutor(autor);
				
				System.out.println("---------------");
				
				System.out.println("Tamaño de lienzo");
				
				tamanyoLienzo.setAltura(Consola.leerInt("Altura"));
				tamanyoLienzo.setAnchura(Consola.leerInt("Anchura"));
				
				cuadro.setTamanyoLienzo(tamanyoLienzo);
				
				System.out.println("----------------");
				
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















