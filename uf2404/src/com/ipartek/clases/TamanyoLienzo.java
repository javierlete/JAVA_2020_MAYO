package com.ipartek.clases;

public class TamanyoLienzo {
	private int altura, anchura;

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getAnchura() {
		return anchura;
	}

	public void setAnchura(int anchura) {
		this.anchura = anchura;
	}

	@Override
	public String toString() {
		return "TamanyoLienzo [altura=" + altura + ", anchura=" + anchura + "]";
	}
}
