package com.ipartek.formacion.repasodaosimple.dao;

import java.util.ArrayList;

import com.ipartek.formacion.repasodaosimple.modelos.Casa;

//DAO: Data Access Object (Objeto de acceso a datos)
public class CasaDaoArrayList {
	// Creamos el objeto casas a nivel de toda la clase
	private static ArrayList<Casa> casas = new ArrayList<>();

	// Constructor estático
	// Es un constructor que se ejecuta al mencionar por primera vez la clase en
	// cualquier parte del código
	// No se usa new para invocarlo
	static {
		casas.add(new Casa(1L, "Bizkaia", "48000", "Gran Vía", "7B", "3", "Izquierda"));
		casas.add(new Casa(2L, "Araba", "28000", "Autonomía", "20", "Bajo", "3ª"));
	}

	/**
	 * Obtención de todas las casas disponibles
	 * 
	 * @return casas disponibles
	 */
	public static ArrayList<Casa> obtenerTodas() {
		return casas;
	}

	public static void insertar(Casa casa) {
		// Buscar el id más grande y sumarle uno

		Long max = 0L;

		for (Casa c : casas) {
			// max = c.getId() > max ? c.getId(): max;

			if (c.getId() > max) {
				max = c.getId();
			}
		}

		// El id a insertar es el máximo que haya más uno
		Long id = max + 1;

		// Rellenar el id en la casa recibida
		casa.setId(id);

		casas.add(casa);
	}

	public static void borrar(Long id) {
		casas.remove(obtenerPorId(id));
	}

	public static Casa obtenerPorId(long id) {
		for (Casa casa : casas) {
			if (casa.getId() == id) {
				return casa;
			}
		}
		
		return null;
	}

	public static void modificar(Casa casa) {
		Casa c = null;
		
		for (int i = 0; i < casas.size(); i++) {
			c = casas.get(i);
			if (c.getId() == casa.getId()) {
				casas.set(i, casa);
				return;
			}
		}
	}
}
