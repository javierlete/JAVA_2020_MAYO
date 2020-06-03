package com.ipartek.formacion.ejemplopoo.tipos;

import java.util.Date;

public class Oficina {
	private Persona[] puestos;
	
	public Oficina(int numeroPuestos) {
		puestos = new Persona[numeroPuestos];
	}
	
	public void sentarEnPuesto(Persona persona, int numeroPuesto) {
		puestos[numeroPuesto - 1] = persona;
		System.out.println(
				new Date() + ": se ha sentado " + persona.getNombre() + 
				" en el puesto " + numeroPuesto);
	}
	
	public void vaciarPuesto(int numeroPuesto) {
		System.out.println(
				new Date() + ": se ha marchado " + puestos[numeroPuesto - 1].getNombre() + 
				" del puesto " + numeroPuesto);
		puestos[numeroPuesto - 1] = null;
	}
	
	public Persona obtenerPersona(int numeroPuesto) {
		return puestos[numeroPuesto - 1];
	}
	
	public int getNumeroPuestos() {
		return puestos.length;
	}
}
