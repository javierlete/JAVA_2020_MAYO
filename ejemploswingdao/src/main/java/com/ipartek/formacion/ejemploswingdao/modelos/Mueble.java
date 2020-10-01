package com.ipartek.formacion.ejemploswingdao.modelos;

public class Mueble {
	private static final String ERROR_LARGO = "El largo debe ser un número positivo";
	private static final String ERROR_ANCHO = "El ancho debe ser un número positivo";
	private static final String ERROR_ALTO = "El alto debe ser un número positivo";
	
	private Long id;
	private String nombre;
	private Double largo, ancho, alto;

	private boolean correcto = true;

	private String errorId, errorNombre, errorLargo, errorAncho, errorAlto;

	public Mueble() {
	}

	public Mueble(String id, String nombre, String largo, String ancho, String alto) {
		setId(id);
		setNombre(nombre);
		setLargo(largo);
		setAncho(ancho);
		setAlto(alto);
	}

	public Mueble(Long id, String nombre, Double largo, Double ancho, Double alto) {
		setId(id);
		setNombre(nombre);
		setLargo(largo);
		setAncho(ancho);
		setAlto(alto);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setId(String id) {
		try {
			if(id == null || id.trim().length() == 0) {
				this.id = null;
				return;
			}
			this.id = Long.parseLong(id);
		} catch (NumberFormatException e) {
			setErrorId("El id debe ser numérico");
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().length() == 0) {
			setErrorNombre("El nombre es obligatorio");
		}
		this.nombre = nombre;
	}

	public Double getLargo() {
		return largo;
	}

	public void setLargo(String largo) {
		if (largo == null || largo.trim().length() == 0) {
			this.largo = null;
			return;
		}

		try {
			setLargo(Double.parseDouble(largo));
		} catch (NumberFormatException e) {
			setErrorLargo(ERROR_LARGO);
		}
	}

	public void setLargo(Double largo) {
		this.largo = largo;

		if(largo == null) {
			return;
		}
		
		if (this.largo <= 0) {
			setErrorLargo(ERROR_LARGO);
		}
	}

	public Double getAncho() {
		return ancho;
	}

	public void setAncho(String ancho) {
		if (ancho == null || ancho.trim().length() == 0) {
			this.ancho = null;
			return;
		}

		try {
			setAncho(Double.parseDouble(ancho));
		} catch (NumberFormatException e) {
			setErrorAncho(ERROR_ANCHO);
		}
	}

	public void setAncho(Double ancho) {
		this.ancho = ancho;

		if(ancho == null) {
			return;
		}
		
		if (this.ancho <= 0) {
			setErrorAncho(ERROR_ANCHO);
		}
	}

	public Double getAlto() {
		return alto;
	}

	public void setAlto(String alto) {
		if (alto == null || alto.trim().length() == 0) {
			this.alto = null;
			return;
		}

		try {
			setAlto(Double.parseDouble(alto));
		} catch (NumberFormatException e) {
			setErrorAlto(ERROR_ALTO);
		}
	}

	public void setAlto(Double alto) {
		this.alto = alto;

		if(alto == null) {
			return;
		}
		
		if (this.alto <= 0) {
			setErrorAlto(ERROR_ALTO);
		}
	}

	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		correcto = false;
		this.errorId = errorId;
	}

	public String getErrorNombre() {
		return errorNombre;
	}

	public void setErrorNombre(String errorNombre) {
		correcto = false;
		this.errorNombre = errorNombre;
	}

	public String getErrorLargo() {
		return errorLargo;
	}

	public void setErrorLargo(String errorLargo) {
		correcto = false;
		this.errorLargo = errorLargo;
	}

	public String getErrorAncho() {
		return errorAncho;
	}

	public void setErrorAncho(String errorAncho) {
		correcto = false;
		this.errorAncho = errorAncho;
	}

	public String getErrorAlto() {
		return errorAlto;
	}

	public void setErrorAlto(String errorAlto) {
		correcto = false;
		this.errorAlto = errorAlto;
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
