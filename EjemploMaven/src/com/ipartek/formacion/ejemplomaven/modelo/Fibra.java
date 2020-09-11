package com.ipartek.formacion.ejemplomaven.modelo;

import java.math.BigDecimal;

public class Fibra extends Servicio {
	private int anchoDeBandaEnMb;

	public Fibra(Long id, String nombre, int mesesPromocion, BigDecimal precioMensualPromocion,
			BigDecimal precioMensual, int anchoDeBandaEnMb) {
		super(id, nombre, mesesPromocion, precioMensualPromocion, precioMensual);
		this.anchoDeBandaEnMb = anchoDeBandaEnMb;
	}

	public int getAnchoDeBandaEnMb() {
		return anchoDeBandaEnMb;
	}

	public void setAnchoDeBandaEnMb(int anchoDeBandaEnMb) {
		this.anchoDeBandaEnMb = anchoDeBandaEnMb;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + anchoDeBandaEnMb;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fibra other = (Fibra) obj;
		if (anchoDeBandaEnMb != other.anchoDeBandaEnMb)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fibra [anchoDeBandaEnMb=" + anchoDeBandaEnMb + ", getId()=" + getId() + ", getNombre()=" + getNombre()
				+ ", getMesesPromocion()=" + getMesesPromocion() + ", getPrecioMensualPromocion()="
				+ getPrecioMensualPromocion() + ", getPrecioMensual()=" + getPrecioMensual() + "]";
	}

	
}
