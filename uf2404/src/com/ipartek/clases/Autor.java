package com.ipartek.clases;

public class Autor {
	private String nombre;
	private String apellidos;
	private boolean fallecido;
	private int anyoNacimiento;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public boolean isFallecido() {
		return fallecido;
	}
	public void setFallecido(boolean fallecido) {
		this.fallecido = fallecido;
	}
	public int getAnyoNacimiento() {
		return anyoNacimiento;
	}
	public void setAnyoNacimiento(int anyoNacimiento) {
		this.anyoNacimiento = anyoNacimiento;
	}
	
	@Override
	public String toString() {
		return "Autor [nombre=" + nombre + ", apellidos=" + apellidos + ", fallecido=" + fallecido + ", anyoNacimiento="
				+ anyoNacimiento + "]";
	}
}
