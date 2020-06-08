package com.ipartek.clases;

public class Cuadro {
	private String titulo;
	private Autor autor;
	private TamanyoLienzo tamanyoLienzo;
	private int anyo;
	private boolean restaurado;
	private double precio; //En una aplicación real mejor BigDecimal
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public TamanyoLienzo getTamanyoLienzo() {
		return tamanyoLienzo;
	}
	public void setTamanyoLienzo(TamanyoLienzo tamanyoLienzo) {
		this.tamanyoLienzo = tamanyoLienzo;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public boolean isRestaurado() {
		return restaurado;
	}
	public void setRestaurado(boolean restaurado) {
		this.restaurado = restaurado;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Cuadro [titulo=" + titulo + ", autor=" + autor + ", tamanyoLienzo=" + tamanyoLienzo + ", anyo=" + anyo
				+ ", restaurado=" + restaurado + ", precio=" + precio + "]";
	}
}
