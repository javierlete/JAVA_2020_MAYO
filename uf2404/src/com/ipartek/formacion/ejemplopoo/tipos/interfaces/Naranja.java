package com.ipartek.formacion.ejemplopoo.tipos.interfaces;

public class Naranja extends Fruto implements Esferico, Comestible {

	@Override
	public void comer() {
		System.out.println("¡Ñam, que rica!");
	}

	@Override
	public void rodar() {
		System.out.println("Naranja rodando");
	}
}
