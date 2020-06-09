package com.ipartek.formacion.ejemplopoo.consola;

import java.math.BigDecimal;

import com.ipartek.formacion.ejemplopoo.tipos.Empleado;
import com.ipartek.formacion.ejemplopoo.tipos.EmpleadoIndefinido;
import com.ipartek.formacion.ejemplopoo.tipos.EmpleadoPorHoras;
import com.ipartek.formacion.ejemplopoo.tipos.Oficina;
import com.ipartek.formacion.ejemplopoo.tipos.Persona;

public class EmpleadoPresentacion {

	public static void main(String[] args) {
		Empleado empleado1 = 
				new EmpleadoIndefinido("Javier", "Lete", "12345678Z", 14, new BigDecimal("20000"));
		
		System.out.println(empleado1);
		System.out.println(empleado1.getSueldoMensual());
		
		Oficina oficina = new Oficina();
		
		oficina.sentarEnPuesto(empleado1, 1);
		
		Empleado empleado2 = new EmpleadoPorHoras("Pepe", "Pérez", "87654231X", 80, new BigDecimal("20"));
		
		oficina.sentarEnPuesto(empleado2, 2);
		
		BigDecimal total = BigDecimal.ZERO;
		Empleado empleado;
		Persona persona;
		
		for(int i = 1; i <= oficina.getNumeroPuestos(); i++) {
			persona = oficina.obtenerPersona(i);
			
			System.out.print(persona);
			
			if(persona instanceof Empleado) {
				empleado = (Empleado)persona;
				
				total = total.add(empleado.getSueldoMensual());
				
				System.out.print(", sueldoMensual = " + empleado.getSueldoMensual());
			}
			
			System.out.println();
		}
		
		System.out.println(total);
	}

}
