package com.ipartek.formacion.conceptosavanzados.genericos;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Genericos {
	public static void main(String[] args) {
		Punto punto = new Punto(5, 6);
		
		System.out.println(punto);
		
		PuntoGenerico<BigInteger> p;
		
		p = new PuntoGenerico<BigInteger>(new BigInteger("5"), new BigInteger("6"));
		
		System.out.println(p);
		
		//p.setX("5");
		
		PuntoGenerico<String> ps;
		
		ps = new PuntoGenerico<String>("adsgads", "asdfasdf");
		
		System.out.println(ps);
		
		ps.setX("5");
		
		Logueable<Object> log;
		
		log = new LogueadorConsola();
		
		System.out.println(log.formatear(5));
		
		System.out.println(log.formatear(new BigDecimal("5.678")));
		
		Logueable<BigDecimal> logDinero;
		
		logDinero = new LogueadorDinero();
		
		System.out.println(logDinero.formatear(new BigDecimal("5.323")));
		
		//List<String> l = new ArrayList<>();
	}
}
