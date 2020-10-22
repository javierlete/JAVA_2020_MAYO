package com.ipartek.formacion.spring.ejemplospringmvcdaojdbc.criptografia;

import java.math.BigInteger;
import java.security.MessageDigest;

public class AlgoritmosHash {
	public static String sha512(String texto) {
		String toReturn = null;
		try {
		    MessageDigest digest = MessageDigest.getInstance("SHA-512");
		    digest.reset();
		    digest.update(texto.getBytes("utf8"));
		    toReturn = String.format("%0128x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return toReturn;
	}
	
	public static void main(String[] args) {
		System.out.println(sha512("prueba"));
		System.out.println(sha512("prueba").length());
	}
}
