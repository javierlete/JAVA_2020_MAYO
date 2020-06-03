package com.ipartek.formacion.ejemplopoo.consola;

import com.ipartek.formacion.ejemplopoo.tipos.Punto;

public class PuntoPresentacion {

	public static void main(String[] args) {
		Punto p = new Punto(1, 2);
		Punto p2 = new Punto(1, 3);

		System.out.println(p); // equivale a System.out.println(p.toString());

		System.out.println(p.equals(p2));
		
		System.out.println(p.hashCode());
		System.out.println(p2.hashCode());
		
		System.out.println(p.sumar(p2));
		System.out.println(p2.sumar(p));
		
		System.out.println(Punto.sumar(p, p2));
		
		System.out.println(p.getX());
		System.out.println(p.getY());
	}

}
