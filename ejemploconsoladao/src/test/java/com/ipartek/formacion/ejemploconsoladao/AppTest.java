package com.ipartek.formacion.ejemploconsoladao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest 
{
	private static final String MENU = "1. Listar\n2. Obtener por id\n3. Insertar\n4. Modificar\n5. Borrar\n0. Salir\n";
	
	@Test
	public void obtenerMenu() {
		assertEquals(MENU, App.obtenerMenu());
	}
}
