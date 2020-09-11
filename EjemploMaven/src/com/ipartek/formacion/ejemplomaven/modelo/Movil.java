package com.ipartek.formacion.ejemplomaven.modelo;

import java.math.BigDecimal;

public class Movil extends Servicio {
	private int datosEnGb;

	public Movil(Long id, String nombre, int mesesPromocion, BigDecimal precioMensualPromocion,
			BigDecimal precioMensual, int datosEnGb) {
		super(id, nombre, mesesPromocion, precioMensualPromocion, precioMensual);
		this.datosEnGb = datosEnGb;
	}

	public int getDatosEnGb() {
		return datosEnGb;
	}

	public void setDatosEnGb(int datosEnGb) {
		this.datosEnGb = datosEnGb;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + datosEnGb;
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
		Movil other = (Movil) obj;
		if (datosEnGb != other.datosEnGb)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movil [datosEnGb=" + datosEnGb + ", getId()=" + getId() + ", getNombre()=" + getNombre()
				+ ", getMesesPromocion()=" + getMesesPromocion() + ", getPrecioMensualPromocion()="
				+ getPrecioMensualPromocion() + ", getPrecioMensual()=" + getPrecioMensual() + "]";
	}
	
	
}
