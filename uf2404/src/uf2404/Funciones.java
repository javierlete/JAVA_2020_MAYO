package uf2404;

import java.math.BigDecimal;

// Funciones.main

public class Funciones {

	public static void main(String[] args) {
		int resultado, x = 1, y = 2;

		resultado = sumar(x, y);

		mostrar(resultado);

		mostrar(x);
		mostrar(y);

		String[] mensajes = { "Uno", "Dos" };

		mostrarYModificarArray(mensajes);

		for (String mensaje : mensajes) {
			System.out.println(mensaje);
		}

		mensajes[0] = mensajes[0].replace("U", "E");

		System.out.println(mensajes[0]);

		System.out.println(factorialIterativo(5));

		System.out.println(factorialRecursivo(5));

		System.out.println(buscarEnArray(new int[] { 1, 5, 8, 4, 3 }, 8));

		System.out.println(buscarEnArrayPurista(new int[] { 1, 5, 8, 4, 3 }, 9));

		System.out.println(sumatorioPares(new int[] { 1, 2, 3, 4, 5 }));

		System.out.println(buscarEnArrayReal(new int[] { 1, 5, 8, 4, 3 }, 9));

		double[] numeros = new double[] { 1.1, 3.3, 5.6, 2.4, 3.2 };

		double numeroABuscar = new BigDecimal("1.1").multiply(new BigDecimal("3")).doubleValue();
		
		System.out.println(numeroABuscar);
		
		boolean encontrado = buscarEnArrayReal(numeros, numeroABuscar);
		
		System.out.println(encontrado);
		
		System.out.println(buscarEnArrayReal(new int[] { 1, 5, 8, 4, 3 }));

	}

	private static int sumatorioPares(int[] numeros) {
		int total = 0;

		for (int numero : numeros) {
			if (numero % 2 != 0) {
				continue;
			}

			total += numero;
		}

		return total;
	}

	private static boolean buscarEnArrayPurista(int[] arr, int numeroABuscar) {
		boolean encontrado = false;

		int i;

		int numero;

		for (i = 0; i < arr.length && !encontrado; i++) {

			numero = arr[i];

			if (numero == numeroABuscar) {
				encontrado = true;
			} else {
				System.out.println(numero);
			}
		}

		if (encontrado) {
			System.out.println("Se ha encontrado el número");
		}

		return encontrado;
	}

	private static boolean buscarEnArray(int[] arr, int numeroABuscar) {
		// TODO Pendiente de implementación (Ejemplo)

		// Ejemplo de error si no está implementado
		// throw new UnsupportedOperationException("No implementado");

		boolean encontrado = false;

		repetitivaArray: for (int numero : arr) {
			if (numero == numeroABuscar) {
				encontrado = true;
				break repetitivaArray;
			}

			System.out.println(numero);
		}

		if (encontrado) {
			System.out.println("Se ha encontrado el número");
		}

		return encontrado;
	}

	private static boolean buscarEnArrayReal(int[] arr, int numeroABuscar) {
		for (int numero : arr) {
			if (numero == numeroABuscar) {
				return true;
			}
		}

		return false;
	}

	private static boolean buscarEnArrayReal(int[] arr) {
		return buscarEnArray(arr, 0);
	}
	
	private static boolean buscarEnArrayReal(double[] arr, double numeroABuscar) {
		// CUIDADO CON LA COMPARACIÓN DE IGUALDAD ENTRE DOUBLES
		// PUEDE FALLAR
		
		for (double numero : arr) {
			if (numero == numeroABuscar) {
				return true;
			}
		}

		return false;
	}

	private static String[] mostrarYModificarArray(String[] textos) {
		String[] copia = textos.clone();

		System.out.println(copia);

		for (String texto : copia) {
			mostrar(texto);
		}

		copia[1] = "Javi";

		return copia;
	}

	private static void separador() {
		System.out.println("------------------------");
	}

	public static void mostrar(Object objeto) {
		separador();
		System.out.println(objeto);
	}

	private static int sumar(int a, int b) {
		int suma = a + b;
		return suma;
	}

	// 5! = 5 * 4 * 3 * 2 * 1
	// 5! = 5 * 4!
	// 4! = 4 * 3!
	// 3! = 3 * 2!
	// 2! = 2 * 1!
	// 1! = 1

	private static long factorialRecursivo(long numero) {
		if (numero == 1L) {
			return 1L;
		}

		return numero * factorialRecursivo(numero - 1L);
	}

	private static long factorialIterativo(long numero) {
		long total = 1;

		for (int c = 2; c <= numero; c++) {
			total *= c;
		}

		return total;
	}
}
