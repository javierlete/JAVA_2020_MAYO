package com.ipartek.clases;

public class Cuadro {
	private String titulo;
	private String autor;
	private int altura, anchura;
	private int anyo;
	private boolean restaurado;
	private double precio; //En una aplicación real mejor BigDecimal
	
	public Cuadro(String titulo, String autor, int altura, int anchura, int anyo, boolean restaurado, double precio) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.altura = altura;
		this.anchura = anchura;
		this.anyo = anyo;
		this.restaurado = restaurado;
		this.precio = precio;
	}
	
	//Opcional
	public Cuadro() {
		this(null, null, 0, 0, 0, false, 0.0); //Serviría para centralizar
	}

	@Override
	public String toString() {
		return "Cuadro [titulo=" + titulo + ", autor=" + autor + ", altura=" + altura + ", anchura=" + anchura
				+ ", anyo=" + anyo + ", restaurado=" + restaurado + ", precio=" + precio + "]";
	}
	
	
}
