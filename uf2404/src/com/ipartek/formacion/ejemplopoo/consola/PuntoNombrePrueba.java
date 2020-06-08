package com.ipartek.formacion.ejemplopoo.consola;

import java.util.ArrayList;

import com.ipartek.formacion.ejemplopoo.tipos.Punto;
import com.ipartek.formacion.ejemplopoo.tipos.PuntoNombre;

public class PuntoNombrePrueba {

	public static void main(String[] args) {
		ArrayList<Punto> poligono = new ArrayList<>();

		poligono.add(new Punto(1, 2));
		poligono.add(new Punto(3, 4));

		PuntoNombre ptn = new PuntoNombre("Bilbao", 5, 6);
//		ptn.setX(5);
//		ptn.setY(6);
//		ptn.setNombre("Bilbao");

		poligono.add(ptn);
		poligono.add(new PuntoNombre());

		for (Punto punto : poligono) {
			System.out.println(punto);
		}

		Punto p = ptn; // (Punto)ptn;

		// System.out.println(p.getNombre()); // No se puede, porque Punto no tiene ese
		// método
		p.setX(10);
		System.out.println("p = " + p.toString());

		if (p instanceof PuntoNombre) {
			System.out.println("Es un PuntoNombre");
			PuntoNombre ptn2 = (PuntoNombre) p;
			System.out.println(ptn2.getNombre());
		} else {
			System.out.println("No es un PuntoNombre");
		}
		
		Object o = ptn;
		
		System.out.println(o.getClass().getName() + "@" + Integer.toHexString(o.hashCode()));
		
		//PuntoNombre ptn3 = (PuntoNombre) new Punto(8,9); // ClassCastException
		
		//ptn3.setNombre("Otro nombre");
	}

}
