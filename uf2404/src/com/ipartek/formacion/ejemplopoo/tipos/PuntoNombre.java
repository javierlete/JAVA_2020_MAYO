package com.ipartek.formacion.ejemplopoo.tipos;

public class PuntoNombre extends Punto {
	
	private String nombre;
	
	public PuntoNombre() {
		this("Anónimo", X_POR_DEFECTO, Y_POR_DEFECTO);
		//super(); // this() del padre
	}
	
	public PuntoNombre(String nombre, double x, double y) {
		super(x, y);
		setNombre(nombre);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "PuntoNombre [nombre=" + nombre + ", x=" + getX() + ", y=" + getY() + "]";
	}
	
}
