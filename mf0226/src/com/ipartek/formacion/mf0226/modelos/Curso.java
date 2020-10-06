package com.ipartek.formacion.mf0226.modelos;

import java.util.ArrayList;
import java.util.Date;

public class Curso {
	private Long codigo;
	private String nombre, identificador;
	private Date fInicio, fFin;
	private Integer nHoras;
	private String temario;
	
	private Profesor profesor;
	private ArrayList<String> resenas;
	
	public Curso(String nombre, String identificador) {
		this(null, nombre, identificador, null, null, null, null);
	}
	
	public Curso(Long codigo, String nombre, String identificador, Date fInicio, Date fFin, Integer nHoras,
			String temario) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.identificador = identificador;
		this.fInicio = fInicio;
		this.fFin = fFin;
		this.nHoras = nHoras;
		this.temario = temario;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Date getfInicio() {
		return fInicio;
	}

	public void setfInicio(Date fInicio) {
		this.fInicio = fInicio;
	}

	public Date getfFin() {
		return fFin;
	}

	public void setfFin(Date fFin) {
		this.fFin = fFin;
	}

	public Integer getnHoras() {
		return nHoras;
	}

	public void setnHoras(Integer nHoras) {
		this.nHoras = nHoras;
	}

	public String getTemario() {
		return temario;
	}

	public void setTemario(String temario) {
		this.temario = temario;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public ArrayList<String> getResenas() {
		return resenas;
	}

	public void setResenas(ArrayList<String> resenas) {
		this.resenas = resenas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((fFin == null) ? 0 : fFin.hashCode());
		result = prime * result + ((fInicio == null) ? 0 : fInicio.hashCode());
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		result = prime * result + ((nHoras == null) ? 0 : nHoras.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
		result = prime * result + ((resenas == null) ? 0 : resenas.hashCode());
		result = prime * result + ((temario == null) ? 0 : temario.hashCode());
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
		Curso other = (Curso) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (fFin == null) {
			if (other.fFin != null)
				return false;
		} else if (!fFin.equals(other.fFin))
			return false;
		if (fInicio == null) {
			if (other.fInicio != null)
				return false;
		} else if (!fInicio.equals(other.fInicio))
			return false;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		if (nHoras == null) {
			if (other.nHoras != null)
				return false;
		} else if (!nHoras.equals(other.nHoras))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (profesor == null) {
			if (other.profesor != null)
				return false;
		} else if (!profesor.equals(other.profesor))
			return false;
		if (resenas == null) {
			if (other.resenas != null)
				return false;
		} else if (!resenas.equals(other.resenas))
			return false;
		if (temario == null) {
			if (other.temario != null)
				return false;
		} else if (!temario.equals(other.temario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", nombre=" + nombre + ", identificador=" + identificador + ", fInicio="
				+ fInicio + ", fFin=" + fFin + ", nHoras=" + nHoras + ", temario=" + temario + ", profesor=" + profesor
				+ ", resenas=" + resenas + "]";
	}
	
	
}
