package com.ipartek.formacion.ejemploconsoladao;

import java.util.Scanner;

public class App {
	private static final String MENU = "1. Listar\n2. Obtener por id\n3. Insertar\n4. Modificar\n5. Borrar\n0. Salir\n";

	private static final Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		String opcion;

		do {
			System.out.println(obtenerMenu());

			opcion = s.nextLine();

			switch (opcion) {
			case "1":
				listar();
				break;
			case "2":
				obtenerPorId();
				break;
			case "3":
				insertar();
				break;
			case "4":
				modificar();
				break;
			case "5":
				borrar();
				break;
			case "0":
				System.out.println("¡Hasta otra!");
				break;
			default:
				System.out.println("No conozco esa opción");
			}
		} while (!"0".equals(opcion));

	}

	private static void listar() {
		System.out.println("LISTAR");
	}

	private static void obtenerPorId() {
		System.out.println("OBTENER POR ID");
	}

	private static void insertar() {
		System.out.println("INSERTAR");
	}

	private static void modificar() {
		System.out.println("MODIFICAR");
	}

	private static void borrar() {
		System.out.println("BORRAR");
	}

	public static Object obtenerMenu() {
		return MENU;
	}
}
