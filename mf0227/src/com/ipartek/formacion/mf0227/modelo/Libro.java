package com.ipartek.formacion.mf0227.modelo;

import java.math.BigDecimal;

public class Libro {
	private Long id; // numérico
	private String nombre; // Cadena de texto que contiene nombre + descripción, mínimo 2 letras máximo 150
	private BigDecimal precio; // número mayor que cero y con dos decimales
	private Integer descuento; // valor numérico entre 0 y 100
	private String autor; // Cadena texto, si no se pone "anónimo"
	private String imagen; // cadena texto con la url de la imagen, no validar, si no es correcta una por
							// defecto

	private boolean correcto = true;
	private String errorId, errorNombre, errorPrecio, errorDescuento;

	public Libro() {}
	
	/**
	 * Constructor que recibe todo String para poder llamarlo directamente con los datos recibidos en parámetros de una web
	 * @param id
	 * @param nombre
	 * @param precio
	 * @param descuento
	 * @param autor
	 * @param imagen
	 */
	public Libro(String id, String nombre, String precio, String descuento, String autor, String imagen) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio); // setPrecio(String)
		setDescuento(descuento); // setDescuento(String)
		setAutor(autor);
		setImagen(imagen);
	}

	/**
	 * Constructor con id Long y resto de tipos String
	 * @param id
	 * @param nombre
	 * @param precio
	 * @param descuento
	 * @param autor
	 * @param imagen
	 */
	public Libro(Long id, String nombre, String precio, String descuento, String autor, String imagen) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio); // setPrecio(String)
		setDescuento(descuento); // setDescuento(String)
		setAutor(autor);
		setImagen(imagen);
	}

	/**
	 * Constructor principal que usa los tipos originales
	 * @param id
	 * @param nombre
	 * @param precio
	 * @param descuento
	 * @param autor
	 * @param imagen
	 */
	public Libro(Long id, String nombre, BigDecimal precio, Integer descuento, String autor, String imagen) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio); // setPrecio(BigDecimal)
		setDescuento(descuento); // setDescuento(Integer)
		setAutor(autor);
		setImagen(imagen);
	}

	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @param id no debe ser nulo, ni un número positivo o excesivamente largo
	 */
	public void setId(String id) {
		if (id == null) {
			setErrorId("Se debe introducir un id");
		} else if (!id.matches("\\d+")) {
			setErrorId("El id debe ser un número positivo");
		} else {
			try {
				setId(Long.parseLong(id));
			} catch (NumberFormatException e) {
				setErrorId("Número excesivamente largo");
			}
		}
	}
	
	/**
	 * 
	 * @param id debe ser positivo
	 */
	public void setId(Long id) {
		if(id < 0) {
			setErrorId("El id no puede ser negativo");
		}
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre no debe ser nulo y debe tener de 2 a 150 caracteres
	 */
	public void setNombre(String nombre) {
		if (nombre == null) {
			setErrorNombre("El nombre no puede ser nulo");
		} else if (nombre.length() < 2 || nombre.length() > 150) {
			setErrorNombre("El nombre debe tener de 2 a 150 caracteres");
		}

		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	/**
	 * 
	 * @param precio dos decimales y positivo
	 */
	public void setPrecio(String precio) {
		if (precio == null) {
			setErrorPrecio("Se debe introducir un precio");
		} else if (!precio.matches("\\d+\\.\\d{2}")) {
			setErrorPrecio("El precio debe ser un número positivo con 2 decimales");
		} else {
			try {
				setPrecio(new BigDecimal(precio));
			} catch (Exception e) {
				setErrorPrecio("El número introducido no puede almacenarse. Probablemente sea demasiado grande)");
			}
		}
	}

	/**
	 * 
	 * @param precio mayor que cero
	 */
	public void setPrecio(BigDecimal precio) {
		if (precio == null) {
			setErrorPrecio("Se debe introducir un precio");
		} else if (precio.compareTo(BigDecimal.ZERO) <= 0) { // precio <= ZERO
			setErrorPrecio("El precio debe ser mayor que cero");
		}
		this.precio = precio;
	}

	public Integer getDescuento() {
		return descuento;
	}

	/**
	 * 
	 * @param descuento número positivo
	 */
	public void setDescuento(String descuento) { // setDescuento("123")
		if (descuento == null) {
			setErrorDescuento("Se debe introducir un descuento");
		} else if (!descuento.matches("\\d+")) {
			setErrorDescuento("El descuento debe ser un número positivo");
		} else {
			try {
				setDescuento(Integer.parseInt(descuento));
			} catch (Exception e) {
				setErrorDescuento("El número introducido no puede almacenarse. Probablemente sea demasiado grande)");
			}
		}
	}

	/**
	 * 
	 * @param descuento entero entre 0 y 100
	 */
	public void setDescuento(Integer descuento) { // setDescuento(5)
		if (descuento == null) {
			setErrorDescuento("Se debe introducir un descuento");
		} else if (descuento == null || descuento < 0 || descuento > 100) {
			setErrorDescuento("El número debe estar comprendido entre 0 y 100");
		}
		this.descuento = descuento;
	}

	public String getAutor() {
		return autor;
	}

	/**
	 * 
	 * @param autor si no está rellenado tomará el valor "Anónimo"
	 */
	public void setAutor(String autor) {
		if (autor == null || autor.trim().length() == 0) { // " pepe ".trim() -> "pepe", " ".trim() -> ""
			this.autor = "Anónimo";
		} else {
			this.autor = autor;
		}
	}

	public String getImagen() {
		return imagen;
	}

	/**
	 * 
	 * @param imagen si no se rellena se utilizará "pordefecto.jpg"
	 */
	public void setImagen(String imagen) {
		if(imagen == null || !imagen.matches("\\w+\\.jpg")) {
			this.imagen = "pordefecto.jpg";
			return;
		}
		this.imagen = imagen;
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

	/**
	 * Se establece también el estado correcto = false para todo el objeto
	 * @param errorId
	 */
	public void setErrorId(String errorId) {
		correcto = false;
		this.errorId = errorId;
	}

	public String getErrorNombre() {
		return errorNombre;
	}

	/**
	 * Se establece también el estado correcto = false para todo el objeto
	 * @param errorNombre
	 */
	public void setErrorNombre(String errorNombre) {
		correcto = false;
		this.errorNombre = errorNombre;
	}

	public String getErrorPrecio() {
		return errorPrecio;
	}

	/**
	 * Se establece también el estado correcto = false para todo el objeto
	 * @param errorPrecio
	 */
	public void setErrorPrecio(String errorPrecio) {
		correcto = false;
		this.errorPrecio = errorPrecio;
	}

	public String getErrorDescuento() {
		return errorDescuento;
	}

	/**
	 * Se establece también el estado correcto = false para todo el objeto
	 * @param errorDescuento
	 */
	public void setErrorDescuento(String errorDescuento) {
		correcto = false;
		this.errorDescuento = errorDescuento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((descuento == null) ? 0 : descuento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
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
		Libro other = (Libro) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (descuento == null) {
			if (other.descuento != null)
				return false;
		} else if (!descuento.equals(other.descuento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento + ", autor="
				+ autor + ", imagen=" + imagen + "]";
	}

}
