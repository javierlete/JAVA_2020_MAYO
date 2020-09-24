package com.ipartek.formacion.ejemploconsoladao;

import java.util.Scanner;

import com.ipartek.formacion.ejemploconsoladao.accesodatos.MuebleDAO;
import com.ipartek.formacion.ejemploconsoladao.modelos.Mueble;

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
		
		for(Mueble mueble: MuebleDAO.obtenerTodos()) {
			mostrar(mueble);
		}
	}

	private static void obtenerPorId() {
		System.out.println("OBTENER POR ID");
		
		System.out.print("¿Qué id quieres ver? ");
		Long id = Long.parseLong(s.nextLine());
		
		mostrar(MuebleDAO.obtenerPorId(id));
	}

	private static void insertar() {
		System.out.println("INSERTAR");
		
		String nombre = pedirLinea("Nombre");
		Double largo = pedirDouble("Largo");
		Double ancho = pedirDouble("Ancho");
		Double alto = pedirDouble("Alto");
		
		MuebleDAO.insertar(new Mueble(null, nombre, largo, ancho, alto));
		
		listar();
	}

	

	private static void modificar() {
		System.out.println("MODIFICAR");
		
		Long id = pedirLong("Id");
		
		mostrar(MuebleDAO.obtenerPorId(id));
		
		String nombre = pedirLinea("Nombre");
		Double largo = pedirDouble("Largo");
		Double ancho = pedirDouble("Ancho");
		Double alto = pedirDouble("Alto");
		
		MuebleDAO.modificar(new Mueble(id, nombre, largo, ancho, alto));
		
		mostrar(MuebleDAO.obtenerPorId(id));
	}

	private static void borrar() {
		System.out.println("BORRAR");
		
		Long id = pedirLong("Id");
		
		MuebleDAO.borrar(id);
		
		listar();
	}

	public static String obtenerMenu() {
		return MENU;
	}
	
	private static String pedirLinea(String mensaje) {
		System.out.print(mensaje + ": ");
		return s.nextLine();
	}
	
	private static Double pedirDouble(String mensaje) {
		return new Double(pedirLinea(mensaje));
	}
	
	private static Long pedirLong(String mensaje) {
		return new Long(pedirLinea(mensaje));
	}
	
	private static void mostrar(Mueble mueble) {
		System.out.println(obtenerFormatoMueble(mueble));
	}
	
	private static String obtenerFormatoMueble(Mueble mueble) {
		return mueble.toString();
	}
}
