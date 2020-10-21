package com.ipartek.formacion.conceptosavanzados;

public class Sumatorio {
	public static void main(String[] args) {
		double[] arr1 = new double[3];
		
		arr1[0] = 5;
		arr1[1] = 8;
		arr1[2] = 9;
		
		System.out.println(sumatorio(arr1));
		
		//double[] arr2 = new double[] {5, 8, 9};
		double[] arr2 = {5, 8, 9};
		
		System.out.println(sumatorio(arr2));
		
		System.out.println(sumatorio(new double[] {5, 8, 9}));
		
		System.out.println(sumatorio(5, 8, 9));
		
		System.out.println(sumatorio(5, 67, 5, 4, 3, 4, 67));
		
		System.out.println(sumatorio());
	}
	
	// Java 5
	private static double sumatorio(double... datos) { //double[] datos
		double total = 0;
		
		System.out.println(datos.length > 0 ? datos[0] : "No hay primero");
		
		for(double dato: datos) {
			total += dato; // total = total + dato;
		}
		
		return total;
	}
}
