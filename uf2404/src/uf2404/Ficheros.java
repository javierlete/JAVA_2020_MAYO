package uf2404;

import java.io.*;

public class Ficheros {

	private static final String PRUEBA_TXT = "prueba.txt";

	public static void main(String[] args) {
		try {
			FileWriter fw = null;
			PrintWriter pw = null;

			try {
				System.out.println("Escribiendo en fichero prueba.txt");

				fw = new FileWriter(PRUEBA_TXT, true);
				pw = new PrintWriter(fw, true);

				pw.println("Prueba 2 de escritura de fichero desde Java");
				pw.println("Otra línea");

				// pw.flush();
			} catch (IOException e) {
				System.out.println("No se ha podido escribir el fichero");
				System.out.println(e.getMessage());
			} finally {
				if (pw != null) {
					pw.close();
				}
				if (fw != null) {
					try {
						fw.close();
					} catch (IOException e) {
						System.out.println("Error al cerrar el fichero de escritura");
					}
				}
			}

			// FileReader fr = null;
			// BufferedReader br = null;

			try (FileReader fr = new FileReader(PRUEBA_TXT)) { // try-with-resources Java 7
				// fr = new FileReader(PRUEBA_TXT);
				try (BufferedReader br = new BufferedReader(fr)) {

//					int[] arr = new int[2];
//					arr[2] = 10;

					String linea;

					while ((linea = br.readLine()) != null) {
						System.out.println(linea);
					}
				} catch (IOException e) {
					System.out.println("No se ha podido leer el fichero");
					System.out.println(e.getMessage());
				}
			} catch (FileNotFoundException e) {
				System.out.println("No se ha encontrado el fichero a leer");
				System.out.println(e.getMessage());
//			} catch (IOException e) {
//				System.out.println("No se ha podido leer el fichero");
//				System.out.println(e.getMessage());
//		} finally {
//			if (br != null) {
//				try {
//					br.close();
//				} catch (IOException e) {
//					System.out.println("Error al cerrar la lectura del fichero");
//				}
//			}
//			if (fr != null) {
//				try {
//					fr.close();
//				} catch (IOException e) {
//					System.out.println("Error al cerrar el fichero de lectura");
//				}
//			}
			}
		} catch (Exception e) {
			System.out.println("ERROR NO ESPERADO");
			System.out.println(e.getClass().getName());
			System.out.println(e.getMessage());
		}

	}

}
