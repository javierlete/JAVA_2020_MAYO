package com.ipartek.formacion.uf2406.ejercicio3.accesodatos;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.uf2406.ejercicio3.modelos.Libro;

public class LibroListDao implements Dao<Libro> {

	private static List<Libro> libros = new ArrayList<>();
	
	// PATRÓN SINGLETON
	private LibroListDao() {
		libros.add(new Libro("1", "Libro1", "123", "10"));
		libros.add(new Libro("2", "Libro2", "234", "20"));
	}
	
	private static LibroListDao instancia = new LibroListDao();
	
	public static LibroListDao getInstancia() {
		return instancia;
	}
	// FIN PATRÓN SINGLETON
	
	/*
	// CONSTRUCTOR ESTÁTICO QUE SE GENERA AUTOMÁTICAMENTE CON LAS INICIALIZACIONES DE VARIABLES ESTÁTICAS
	static {
		libros = new ArrayList<>();
		instancia = new LibroListDao();
	}
	*/
	
	@Override
	public List<Libro> obtenerTodos() {
		return libros;
	}

	@Override
	public void insertar(Libro libro) {
		libros.add(libro);
	}
	
}
