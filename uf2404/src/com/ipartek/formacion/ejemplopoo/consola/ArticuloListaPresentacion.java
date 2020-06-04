package com.ipartek.formacion.ejemplopoo.consola;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.ipartek.formacion.ejemplopoo.tipos.Articulo;

public class ArticuloListaPresentacion {
	public static void main(String[] args) {
		ArrayList<Articulo> articulos = new ArrayList<Articulo>();
		
		Articulo articulo1 = new Articulo(1L, "Ratón", new BigDecimal("12.3"));
		articulos.add(articulo1);
		
		articulos.add(new Articulo(2L, "Monitor", new BigDecimal("234.2")));
		
		for(Articulo articulo: articulos) {
			System.out.println(articulo);
		}
	}
}
