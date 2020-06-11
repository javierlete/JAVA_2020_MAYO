package com.ipartek.formacion.ejemplopoo.tipos;

// Clase: arquetipo, "modelo", plantilla, molde
public class Persona {
	// Constantes (variables final static)
	private static final String NOMBRE_POR_DEFECTO = "Anónimo";
	private static final String ERROR_NOMBRE_VACIO = "El nombre debe estar rellenado";
	
	// Variables estáticas ("de clase")
	private static int contadorInstancias = 0;
	
	// Variables de instancia (normalmente privadas)
	// Atributos
	// Campos
	private String nombre;
	private String apellidos;
	
	// Constructores
	public Persona(String nombre, String apellidos) {
		setNombre(nombre);
		setApellidos(apellidos);
		
		setContadorInstancias(getContadorInstancias() + 1);
	}
	
	public Persona(String nombre) {
		this(nombre, null);
	}
	
	public Persona() {
		this(NOMBRE_POR_DEFECTO, null);
	}
	
	// Destructor (MUY RARO QUE SE UTILICE)
	@Override
	protected void finalize() throws Throwable {
		System.out.println("DESTRUIDO " + getNombreCompleto());
	}
	
	// Métodos de instancia
	public String getNombreCompleto() {
		return nombre + (apellidos == null ? "" : " " + apellidos);
	}
	
	// Métodos estáticos ("de clase")
	public static String obtenerTextoErrorNombre(String nombre) {
		if(nombre == null || nombre.trim().length() == 0) {
			return ERROR_NOMBRE_VACIO;
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
			throw new TiposException(textoErrorNombre);
		}
		
		this.nombre = nombre.trim();
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public static int getContadorInstancias() {
		return contadorInstancias;
	}

	public static void setContadorInstancias(int contadorInstancias) {
		Persona.contadorInstancias = contadorInstancias;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
}
