package com.ipartek.formacion.ejemplopoo.tipos;

import java.util.ArrayList;
import java.util.Date;

public class Oficina {
	private ArrayList<Persona> puestos;
	
	public Oficina(int numeroPuestos) {
		puestos = new ArrayList<Persona>(numeroPuestos);
	}
	
	public Oficina() {
		puestos = new ArrayList<Persona>();
	}
	
	public void sentarEnPuesto(Persona persona, int numeroPuesto) {
		if(puestos.size() < numeroPuesto) {
			puestos.add(numeroPuesto - 1, persona);
		} else {
			puestos.set(numeroPuesto - 1, persona);
		}
		
		System.out.println(
				new Date() + ": se ha sentado " + persona.getNombre() + 
				" en el puesto " + numeroPuesto);
	}
	
	public void vaciarPuesto(int numeroPuesto) {
		System.out.println(
				new Date() + ": se ha marchado " + puestos.get(numeroPuesto - 1).getNombre() + 
				" del puesto " + numeroPuesto);
		puestos.set(numeroPuesto - 1, null);
	}
	
	public Persona obtenerPersona(int numeroPuesto) {
		return puestos.get(numeroPuesto - 1);
	}
	
	public int getNumeroPuestos() {
		return puestos.size();
	}
}
