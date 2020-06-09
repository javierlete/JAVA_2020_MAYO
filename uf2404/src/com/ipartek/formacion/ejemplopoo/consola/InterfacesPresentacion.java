package com.ipartek.formacion.ejemplopoo.consola;

import java.util.ArrayList;

import com.ipartek.formacion.ejemplopoo.tipos.interfaces.Balon;
import com.ipartek.formacion.ejemplopoo.tipos.interfaces.Comestible;
import com.ipartek.formacion.ejemplopoo.tipos.interfaces.Esferico;
import com.ipartek.formacion.ejemplopoo.tipos.interfaces.Naranja;

public class InterfacesPresentacion {

	public static void main(String[] args) {
		ArrayList<Esferico> esfericos = new ArrayList<>();
		
		esfericos.add(new Naranja());
		esfericos.add(new Balon());
		
		for(Esferico esferico: esfericos) {
			esferico.rodar();
			
			if(esferico instanceof Comestible) {
				//((Comestible) esferico).comer();
				Comestible comestible = (Comestible)esferico;
				comestible.comer();
			}
		}
	}
}
