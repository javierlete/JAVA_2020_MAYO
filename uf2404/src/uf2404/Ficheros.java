package uf2404;

import java.io.*;

public class Ficheros {

	public static void main(String[] args) throws IOException {
		System.out.println("Escribiendo en fichero prueba.txt");
		
		FileWriter fw = new FileWriter("prueba.txt", true);
		PrintWriter pw = new PrintWriter(fw, true);
		
		pw.println("Prueba 2 de escritura de fichero desde Java");
		pw.println("Otra línea");
		
		// pw.flush();
		
		pw.close();
		fw.close();
		
		FileReader fr = new FileReader("prueba.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String linea;
		
		while( ( linea = br.readLine() ) != null) {
			System.out.println(linea);
		}
		
		br.close();
		fr.close();
	}

}
