package uf2404;

public class DniEjemplo {

	public static void main(String[] args) {
		// Seguimos las pautas del Ministerior del Interior
		// http://www.interior.gob.es/web/servicios-al-ciudadano/dni/calculo-del-digito-de-control-del-nif-nie
		
		final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";
		
		// Cálculo de letra de DNI
		String dni = "Y2345678";
		
		dni = dni.replace("X", "0").replace("Y", "1").replace("Z", "2"); // Para NIEs
		
		char letra = LETRAS.charAt(Integer.parseInt(dni) % 23);
		
		System.out.println(letra);
		
		// Comprobación de letra de DNI
		String dni2 = "Y2345679S";
		
		String strNumeroDNI = dni2.substring(0, 8);
		
		strNumeroDNI = strNumeroDNI.replace("X", "0").replace("Y", "1").replace("Z", "2"); // Para NIEs
		
		int numeroDNI = Integer.parseInt(strNumeroDNI);		
		char letraDNI = dni2.charAt(8);
		char letraCalculada = LETRAS.charAt(numeroDNI % 23);
		
		if(letraDNI == letraCalculada) {
			System.out.println("DNI correcto");
		} else {
			System.out.println("DNI INCORRECTO");
		}
	}

}
