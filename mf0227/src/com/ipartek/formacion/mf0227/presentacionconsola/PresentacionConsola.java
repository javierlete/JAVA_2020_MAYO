package com.ipartek.formacion.mf0227.presentacionconsola;

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.formacion.mf0227.modelo.Libro;

public class PresentacionConsola {

	private static Scanner s = new Scanner(System.in);

	private static ArrayList<Libro> libros = new ArrayList<>();

	public static void main(String[] args) {
		libros.add(new Libro("1", "Mi libro", "123.12", "23", "Javier Lete", "milibro.jpg"));
		libros.add(new Libro("2", "Mi segundo libro", "23.12", "3", "Pepe", "pelibro.jpg"));

		String opcion;

		do {
			p("1. Listar");
			p("2. Insertar");
			p("3. Borrar");
			p("4. Salir");
			p();

			opcion = s();

			switch (opcion) {
			case "1":
				listar();
				break;
			case "2":
				insertar();
				break;
			case "3":
				borrar();
				break;
			case "4":
				p("Abandonando la aplicación");
				break;
			}

		} while (!opcion.equals("4"));

		p("¡Hasta otra!");
	}

	private static void borrar() {
		listar();

		p("¿Id del libro a borrar?");
		Long id = Long.parseLong(s());

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

		do {
			libro.setCorrecto(true);

			p("Id:");
			libro.setId(s()); // se pide por consola el ID y se guarda como texto. Eso provoca la validación del texto

			if (libro.isCorrecto()) { // libro.isCorrecto() == true
				for (Libro l : libros) {
					if (l.getId() == libro.getId()) { // si uno de los libros de la lista tiene el mismo ID que el ID que nos acaban de introducir
						libro.setErrorId("Ese ID ya existe. Elige otro.");
						p(libro.getErrorId());
					}
				}
			} else {
				p(libro.getErrorId());
			}

		} while (!libro.isCorrecto());

		do {
			libro.setCorrecto(true);

			p("Nombre:");
			libro.setNombre(s());

			if (!libro.isCorrecto()) {
				p(libro.getErrorNombre());
			}
		} while (!libro.isCorrecto());

		do {
			libro.setCorrecto(true);

			p("Precio:");
			libro.setPrecio(s());

			if (!libro.isCorrecto()) {
				p(libro.getErrorPrecio());
			}
		} while (!libro.isCorrecto());

		do {
			libro.setCorrecto(true);

			p("Descuento:");
			libro.setDescuento(s());

			if (!libro.isCorrecto()) {
				p(libro.getErrorDescuento());
			}
		} while (!libro.isCorrecto());

		p("Autor:");
		libro.setAutor(s());

		p("Imagen:");
		libro.setImagen(s());

		libros.add(libro);
	}

	private static void listar() {
		for (Libro libro : libros) {
			p(libro);
		}
	}

	private static void p(Object o) {
		System.out.println(o);
	}

	private static void p() {
		System.out.println();
	}

	private static String s() {
		return s.nextLine();
	}
}
