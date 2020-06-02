package com.ipartek.formacion.ejemplopoo.tipos;

// Clase: arquetipo, "modelo", plantilla, molde
public class Persona {
	// Variables de instancia (normalmente privadas)
	// Atributos
	// Campos
	private String nombre;
	private String apellidos;
	
	// Constructores
	public Persona(String nombre, String apellidos) {
		setNombre(nombre);
		setApellidos(apellidos);
	}
	
	public Persona(String nombre) {
		this(nombre, null);
	}
	
	public Persona() {
		this("Anónimo", null);
	}
	
	// Métodos de instancia
	public String getNombreCompleto() {
		return nombre + (apellidos == null ? "" : " " + apellidos);
	}
	
	// Métodos estáticos ("de clase")
	public static String obtenerTextoErrorNombre(String nombre) {
		if(nombre == null || nombre.trim().length() == 0) {
			return "El nombre debe estar rellenado";
		} else {
			return null;
		}
	}
	
	// Métodos de acceso: "setters" y "getters"
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		String textoErrorNombre = obtenerTextoErrorNombre(nombre);
		
		if(textoErrorNombre != null) {
			throw new RuntimeException(textoErrorNombre);
		}
		
		this.nombre = nombre.trim();
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
}
