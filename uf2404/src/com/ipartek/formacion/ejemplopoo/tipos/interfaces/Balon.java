package com.ipartek.formacion.ejemplopoo.tipos.interfaces;

public class Balon extends ObjetoDeporte implements Esferico {

	@Override
	public void rodar() {
		System.out.println("Balón rodando");
	}
}
