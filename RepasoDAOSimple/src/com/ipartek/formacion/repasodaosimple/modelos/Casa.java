package com.ipartek.formacion.repasodaosimple.modelos;

public class Casa {
	// Variables de Instancia
	private Long id;
	private String provincia, codigoPostal, direccion, numero, piso, puerta;
	
	// Constructor completo: Menú/Source/Generate Constructor using Fields...
	public Casa(Long id, String provincia, String codigoPostal, String direccion, String numero, String piso,
			String puerta) {
		super();
		this.id = id;
		this.provincia = provincia;
		this.codigoPostal = codigoPostal;
		this.direccion = direccion;
		this.numero = numero;
		this.piso = piso;
		this.puerta = puerta;
	}

	// Setters y Getters: Menú/Source/Generate Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	// Hashcode e equals: Menú/Source/Generate hashCode() and equals()...
	@Override
	public int hashCode() {
		final int prime = 31;
		
		
		int result = 1;
		result = prime * result + ((codigoPostal == null) ? 0 : codigoPostal.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((piso == null) ? 0 : piso.hashCode());
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
		result = prime * result + ((puerta == null) ? 0 : puerta.hashCode());
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
		Casa other = (Casa) obj;
		if (codigoPostal == null) {
			if (other.codigoPostal != null)
				return false;
		} else if (!codigoPostal.equals(other.codigoPostal))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (piso == null) {
			if (other.piso != null)
				return false;
		} else if (!piso.equals(other.piso))
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		if (puerta == null) {
			if (other.puerta != null)
				return false;
		} else if (!puerta.equals(other.puerta))
			return false;
		return true;
	}

	// toString: Menú/Source/Generate toString()...
	
	@Override
	public String toString() {
		return "Casa [id=" + id + ", provincia=" + provincia + ", codigoPostal=" + codigoPostal + ", direccion="
				+ direccion + ", numero=" + numero + ", piso=" + piso + ", puerta=" + puerta + "]";
	}
}
