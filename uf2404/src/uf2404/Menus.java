package uf2404;

import java.util.Scanner;

public class Menus {

	private static final int MENU_SALUDAR = 2;
	private static final int MENU_HOLA = 1;
	private static final int MENU_SALIR = 0;

	public static void main(String[] args) {
		int opcion;

		Scanner s = new Scanner(System.in);

		do {
			mostrarMenu();

			opcion = pedirOpcion(s);

			switch (opcion) {
			case MENU_SALIR: 
				salir();
				break;
			case MENU_HOLA:
				decirHola();
				break;
			case MENU_SALUDAR:
				saludar(s);
				break;
			default:
				opcionIncorrecta();
				break;
			}
		} while (opcion != MENU_SALIR);

		s.close();
	}

	private static void mostrarMenu() {
		System.out.println("---------------------");
		System.out.println("1. Decir hola");
		System.out.println("2. Saludar con nombre");
		System.out.println("0. Salir");
		System.out.println("---------------------");
	}

	private static int pedirOpcion(Scanner s) {
		int opcion;
		System.out.print("Elige una opcion: ");
		opcion = s.nextInt();
		s.nextLine();
		return opcion;
	}

	private static void opcionIncorrecta() {
		System.out.println("Opción no reconocida");
	}

	private static void salir() {
		System.out.println("Saliendo");
	}

	private static void decirHola() {
		System.out.println("Hola");
	}

	private static void saludar(Scanner s) {
		System.out.print("Dime tu nombre: ");
		String nombre = s.nextLine();
		System.out.println("Hola " + nombre);
	}

}
