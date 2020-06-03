package com.ipartek.formacion.ejemplopoo.consola;

import com.ipartek.formacion.ejemplopoo.tipos.Oficina;
import com.ipartek.formacion.ejemplopoo.tipos.Persona;

public class OficinaPresentacion {

	public static void main(String[] args) {
		Oficina oficina = new Oficina(2);
		
		oficina.sentarEnPuesto(new Persona("Javier"), 1);
		oficina.sentarEnPuesto(new Persona("Pepe"), 2);
		
		oficina.vaciarPuesto(1);
		
		Persona persona;
		
		for(int numeroPuesto = 1; numeroPuesto <= oficina.getNumeroPuestos(); numeroPuesto++) {
			persona = oficina.obtenerPersona(numeroPuesto);
			
			System.out.print(numeroPuesto + ": ");
			
			if(persona != null) {
				System.out.print(persona.getNombre());
			} else {
				System.out.print("DISPONIBLE");
			}
			
			System.out.println();
		}
	}

}
