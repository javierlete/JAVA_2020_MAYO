package com.ipartek.formacion.ejemplopoo.consola;

import java.util.ArrayList;
import java.util.Scanner;

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
		
		Persona[] arrPersonas = new Persona[2];
		
		arrPersonas[0] = p;
		arrPersonas[1] = new Persona("Array", "Arrayez");
		
		for(Persona persona: arrPersonas) {
			System.out.println(persona.getNombreCompleto());
		}
		
		ArrayList<Persona> personas = new ArrayList<Persona>();
		
		personas.add(p);
		personas.add(p2);
		personas.add(p3);
		personas.add(p4);
		personas.add(new Persona("Juan", "González"));
		personas.add(new Persona("Yepa"));
		personas.add(new Persona());
		
		for(Persona persona: personas) {
			System.out.println(persona.getNombreCompleto());
		}
		
		Scanner s = new Scanner(System.in);
		
		String nombre;
		String textoErrorNombre;
		
		boolean correcto, salir;
		
		do {
			salir = true;
			do {
				correcto = true;
				
				System.out.print("Introduce un nombre: ");
				nombre = s.nextLine();
				
				// DRY: Don't Repeat Yourself
				textoErrorNombre = Persona.obtenerTextoErrorNombre(nombre);
				
				if(textoErrorNombre != null) {
					correcto = false;
					System.err.println(textoErrorNombre);
				}
			} while(!correcto);
			
			if(!"salir".equals(nombre)) {
				personas.add(new Persona(nombre));
				salir = false;
			}
		} while(!salir);
		
		for(Persona persona: personas) {
			System.out.println(persona.getNombreCompleto());
		}
		
		s.close();
	}

}
