package com.ipartek.formacion.ejemplopoo.consola;

import com.ipartek.formacion.ejemplopoo.tipos.Persona;

public class PresentacionConsola {

	public static void main(String[] args) {
		Persona p; // Se busca una zona de memoria para almacenar la dirección 0 (null) (64bits)
		
		p = new Persona(); // Llamada al constructor
		
		p.setNombre("     Javier              ");
		p.setApellidos("Lete");
		
		System.out.println(p.getNombre());
		System.out.println(p.getApellidos());
		
		Persona p2 = new Persona("Pepe", "Pérez");
		
		System.out.println(p2.getNombre());
		System.out.println(p2.getApellidos());
		
		Persona p3 = new Persona("Otro");
		
		System.out.println(p3.getNombre());
		System.out.println(p3.getApellidos());
		
		Persona p4 = new Persona();
		
		System.out.println(p4.getNombre());
		System.out.println(p4.getApellidos());
		
		System.out.println(p.getNombreCompleto());
	}

}
