package com.ipartek.formacion.repasodaosimple.dao;

import java.util.ArrayList;

import com.ipartek.formacion.repasodaosimple.modelos.Casa;

//DAO: Data Access Object (Objeto de acceso a datos)
public class CasaDaoArrayList {
	//Creamos el objeto casas a nivel de toda la clase
	private static ArrayList<Casa> casas = new ArrayList<>();
	
	//Constructor estático
	//Es un constructor que se ejecuta al mencionar por primera vez la clase en cualquier parte del código
	//No se usa new para invocarlo
	static {
		casas.add(new Casa(1L, "Bizkaia", "48000", "Gran Vía", "7B", "3", "Izquierda"));
		casas.add(new Casa(2L, "Araba", "28000", "Autonomía", "20", "Bajo", "3ª"));
	}
	
	/**
	 * Obtención de todas las casas disponibles
	 * @return casas disponibles
	 */
	public static ArrayList<Casa> obtenerTodas() {
		return casas;
	}
}
