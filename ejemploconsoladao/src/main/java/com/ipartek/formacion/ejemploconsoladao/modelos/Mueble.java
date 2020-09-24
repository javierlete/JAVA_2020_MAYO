package com.ipartek.formacion.ejemploconsoladao.modelos;

public class Mueble {
	private Long id;
	private String nombre;
	private Double largo, ancho, alto;
	
	public Mueble() {}
	
	public Mueble(Long id, String nombre, Double largo, Double ancho, Double alto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.largo = largo;
		this.ancho = ancho;
		this.alto = alto;
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

	public Double getLargo() {
		return largo;
	}

	public void setLargo(Double largo) {
		this.largo = largo;
	}

	public Double getAncho() {
		return ancho;
	}

	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}

	public Double getAlto() {
		return alto;
	}

	public void setAlto(Double alto) {
		this.alto = alto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alto == null) ? 0 : alto.hashCode());
		result = prime * result + ((ancho == null) ? 0 : ancho.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((largo == null) ? 0 : largo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Mueble other = (Mueble) obj;
		if (alto == null) {
			if (other.alto != null)
				return false;
		} else if (!alto.equals(other.alto))
			return false;
		if (ancho == null) {
			if (other.ancho != null)
				return false;
		} else if (!ancho.equals(other.ancho))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (largo == null) {
			if (other.largo != null)
				return false;
		} else if (!largo.equals(other.largo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mueble [id=" + id + ", nombre=" + nombre + ", largo=" + largo + ", ancho=" + ancho + ", alto=" + alto
				+ "]";
	}
}
