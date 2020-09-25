package com.ipartek.formacion.ejemploconsoladao;

import static com.ipartek.formacion.ejemploconsoladao.Consola.pedirDouble;
import static com.ipartek.formacion.ejemploconsoladao.Consola.pedirLinea;
import static com.ipartek.formacion.ejemploconsoladao.Consola.pedirLong;

import com.ipartek.formacion.ejemploconsoladao.accesodatos.MuebleDAO;
import com.ipartek.formacion.ejemploconsoladao.modelos.Mueble;

public class App {
	private static final String MENU = "1. Listar\n2. Obtener por id\n3. Insertar\n4. Modificar\n5. Borrar\n0. Salir\n";

	public static void main(String[] args) {

		try {
			String opcion;

			do {
				System.out.println(obtenerMenu());

				opcion = pedirLinea("Introduce la opción");

				try {
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

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} while (!"0".equals(opcion));
		} catch (Exception e) {
			System.out.println("Error no esperado");
		}

	}

	private static void listar() {
		System.out.println("LISTAR");

		for (Mueble mueble : MuebleDAO.obtenerTodos()) {
			mostrar(mueble);
		}
	}

	private static void obtenerPorId() {
		System.out.println("OBTENER POR ID");

		mostrar(pedirMueblePorId());
	}

	private static void insertar() {
		System.out.println("INSERTAR");

		Mueble muebleAInsertar = pedirDatosMueble();

		MuebleDAO.insertar(muebleAInsertar);

		listar();
	}

	private static void modificar() {
		System.out.println("MODIFICAR");

		Mueble mueble = pedirMueblePorId();

		mostrar(mueble);

		Mueble muebleConDatosModificado = pedirDatosMueble();

		muebleConDatosModificado.setId(mueble.getId());

		MuebleDAO.modificar(muebleConDatosModificado);

		mostrar(MuebleDAO.obtenerPorId(mueble.getId()));
	}

	private static void borrar() {
		System.out.println("BORRAR");

		Long id = pedirLong("Id");

		MuebleDAO.borrar(id);

		listar();
	}

	private static Mueble pedirDatosMueble() {
		String nombre = pedirLinea("Nombre");
		Double largo = pedirDouble("Largo");
		Double ancho = pedirDouble("Ancho");
		Double alto = pedirDouble("Alto");

		return new Mueble(null, nombre, largo, ancho, alto);
	}

	private static Mueble pedirMueblePorId() {
		Mueble mueble;
		Long id;

		do {
			id = pedirLong("Id");
			mueble = MuebleDAO.obtenerPorId(id);

			if (mueble == null) {
				System.out.println("No se ha encontrado ese id. Prueba otra vez.");
				listar();
			}
		} while (mueble == null);

		return mueble;
	}

	public static String obtenerMenu() {
		return MENU;
	}

	private static void mostrar(Mueble mueble) {
		System.out.println(obtenerFormatoMueble(mueble));
	}

	private static String obtenerFormatoMueble(Mueble mueble) {
		return mueble.toString();
	}
}
