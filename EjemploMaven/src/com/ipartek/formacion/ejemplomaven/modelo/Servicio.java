package com.ipartek.formacion.ejemplomaven.modelo;

import java.math.BigDecimal;

public class Servicio {
	private Long id;
	private String nombre;
	private Integer mesesPromocion;
	private BigDecimal precioMensualPromocion;
	private BigDecimal precioMensual;
	
	public Servicio(Long id, String nombre, Integer mesesPromocion, BigDecimal precioMensualPromocion,
			BigDecimal precioMensual) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.mesesPromocion = mesesPromocion;
		this.precioMensualPromocion = precioMensualPromocion;
		this.precioMensual = precioMensual;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getMesesPromocion() {
		return mesesPromocion;
	}

	public void setMesesPromocion(Integer mesesPromocion) {
		this.mesesPromocion = mesesPromocion;
	}

	public BigDecimal getPrecioMensualPromocion() {
		return precioMensualPromocion;
	}

	public void setPrecioMensualPromocion(BigDecimal precioMensualPromocion) {
		this.precioMensualPromocion = precioMensualPromocion;
	}

	public BigDecimal getPrecioMensual() {
		return precioMensual;
	}

	public void setPrecioMensual(BigDecimal precioMensual) {
		this.precioMensual = precioMensual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + mesesPromocion;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precioMensual == null) ? 0 : precioMensual.hashCode());
		result = prime * result + ((precioMensualPromocion == null) ? 0 : precioMensualPromocion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servicio other = (Servicio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mesesPromocion != other.mesesPromocion)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precioMensual == null) {
			if (other.precioMensual != null)
				return false;
		} else if (!precioMensual.equals(other.precioMensual))
			return false;
		if (precioMensualPromocion == null) {
			if (other.precioMensualPromocion != null)
				return false;
		} else if (!precioMensualPromocion.equals(other.precioMensualPromocion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Servicio [id=" + id + ", nombre=" + nombre + ", mesesPromocion=" + mesesPromocion
				+ ", precioMensualPromocion=" + precioMensualPromocion + ", precioMensual=" + precioMensual + "]";
	}
	
	
}
