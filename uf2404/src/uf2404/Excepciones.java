package uf2404;

public class Excepciones {

	@SuppressWarnings("null") // Quito el error porque quiero que surja para verlo como excepción
	public static void main(String[] args) {
		int a = 5, b = 0, div;
		
		try {
			System.out.println("Bienvenido");
			
			int[] arr = new int[2];
			
			arr[2] = 5;
			
			String prueba = null;
			
			System.out.println(prueba.toUpperCase());
			
			div = a / b;
			
			System.out.println(div);
		} catch (ArithmeticException e) {
			System.out.println("Ha habido un error en la división");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Índice de array fuera de límites");
//		} catch (Exception e) {
//			System.out.println("ERROR NO ESPERADO");
//			e.printStackTrace();
		} finally {
			System.out.println("Me ejecuto SIEMPRE");
		}
		
		System.out.println("FIN");
	}

}
