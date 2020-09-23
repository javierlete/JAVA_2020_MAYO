package com.ipartek.formacion.mf0227.presentacionconsola;

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.formacion.mf0227.modelo.Libro;

/**
 * Clase pensada para arrancar la aplicación desde consola.
 * @author JavierLete
 *
 */
public class PresentacionConsola {

	private static Scanner s = new Scanner(System.in);

	private static ArrayList<Libro> libros = new ArrayList<>();

	public static void main(String[] args) {
		libros.add(new Libro("1", "Mi libro", "123.12", "23", "Javier Lete", "milibro.jpg"));
		libros.add(new Libro("2", "Mi segundo libro", "23.12", "3", "Pepe", "pelibro.jpg"));

		// Pruebas del setId(Long)
		p(libros.get(0).isCorrecto());
		
		libros.get(0).setId(0L);
		
		p(libros.get(0).isCorrecto());
		
		p(libros.get(0).getErrorId());
		// Fin pruebas del setId(Long)
		
		String opcion;

		do {
			// Mostramos el menú
			p("1. Listar");
			p("2. Insertar");
			p("3. Modificar");
			p("4. Borrar");
			p("0. Salir");
			p();

			// Pedimos al usuario que seleccione una opción
			opcion = s();

			// Redireccionamos la petición a un método concreto
			switch (opcion) {
			case "1":
				listar();
				break;
			case "2":
				insertar();
				break;
			case "3":
				modificar();
				break;
			case "4":
				borrar();
				break;
			case "0":
				p("Abandonando la aplicación");
				break;
			}

		} while (!opcion.equals("0")); // Repetimos mientras la opción no sea salir

		p("¡Hasta otra!");
	}

	private static void modificar() {
		listar();

		p("¿Id del libro a modificar?");
		Long id = Long.parseLong(s());

		// Busca el libro a modificar y sustituye los datos de ese libro por los introducidos
		for (int i = 0; i < libros.size(); i++) {
			if (libros.get(i).getId() == id) {
				pedirDatosLibro(libros.get(i)); // La otra opción hubiera sido en este formato: libros.set(i, pedirDatosLibro());
				return;
			}
		}

		p("No se ha encontrado ese ID");
	}

	private static void borrar() {
		listar();

		p("¿Id del libro a borrar?");
		Long id = Long.parseLong(s());

		// Busca el libro a borrar y si lo encuentra lo borra
		for (int i = 0; i < libros.size(); i++) {
			if (libros.get(i).getId() == id) {
				libros.remove(i);
				return;
			}
		}

		p("No se ha encontrado ese ID");
	}

	private static void insertar() {
		Libro libro = new Libro();

		pedirDatosLibro(libro);

		libros.add(libro);
	}

	private static void pedirDatosLibro(Libro libro) {
		// ID
		// Si el libro no tiene id, asumimos que hay que introducirlo
		if (libro.getId() == null) {
			do {
				libro.setCorrecto(true);

				p("Id:");
				libro.setId(s()); // se pide por consola el ID y se guarda como texto. Eso provoca la validación
									// del texto

				if (libro.isCorrecto()) { // libro.isCorrecto() == true
					// Buscamos si ya se ha usado el id previamente, y mostrarmos error en caso de que sí
					for (Libro l : libros) {
						if (l.getId() == libro.getId()) { // si uno de los libros de la lista tiene el mismo ID que el
															// ID que nos acaban de introducir
							libro.setErrorId("Ese ID ya existe. Elige otro.");
							p(libro.getErrorId());
						}
					}
				} else {
					p(libro.getErrorId());
				}

			} while (!libro.isCorrecto());
		}
		
		// NOMBRE
		if(libro.getNombre() != null) {
			p("Nombre actual: " + libro.getNombre());
		}
		
		do {
			libro.setCorrecto(true);

			p("Nombre:");
			libro.setNombre(s());

			if (!libro.isCorrecto()) {
				p(libro.getErrorNombre());
			}
		} while (!libro.isCorrecto());

		// PRECIO
		if(libro.getPrecio() != null) {
			p("Precio actual: " + libro.getPrecio());
		}
		
		do {
			libro.setCorrecto(true);

			p("Precio:");
			libro.setPrecio(s());

			if (!libro.isCorrecto()) {
				p(libro.getErrorPrecio());
			}
		} while (!libro.isCorrecto());

		// DESCUENTO
		if(libro.getDescuento() != null) {
			p("Descuento actual: " + libro.getDescuento());
		}
		
		do {
			libro.setCorrecto(true);

			p("Descuento:");
			libro.setDescuento(s());

			if (!libro.isCorrecto()) {
				p(libro.getErrorDescuento());
			}
		} while (!libro.isCorrecto());

		// AUTOR
		if(libro.getAutor() != null) {
			p("Autor actual: " + libro.getAutor());
		}
		
		p("Autor:");
		libro.setAutor(s());

		// IMAGEN
		if(libro.getImagen() != null) {
			p("Imagen actual: " + libro.getImagen());
		}
		
		p("Imagen:");
		libro.setImagen(s());
	}

	private static void listar() {
		for (Libro libro : libros) {
			p(libro);
		}
	}

	/**
	 * Método resumido de println(Object)
	 * @param o
	 */
	private static void p(Object o) {
		System.out.println(o);
	}

	/**
	 * Método resumido de println()
	 */
	private static void p() {
		System.out.println();
	}

	/**
	 * Método resumido de nextLine()
	 * @return
	 */
	private static String s() {
		return s.nextLine();
	}
}
