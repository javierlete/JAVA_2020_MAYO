package com.ipartek.formacion.mf0227.modelo;

public class Login {
	private Long id;
	private String usuario;
	private String password;
	
	private boolean correcto = true;
	
	private String errorUsuario, errorPassword;
	
	public Login(Long id, String usuario, String password) {
		setId(id);
		setUsuario(usuario);
		setPassword(password);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		if(usuario == null || usuario.trim().length() == 0) {
			setErrorUsuario("El usuario no puede estar vacío");
		}
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if(password == null || password.trim().length() == 0) {
			setErrorPassword("La contraseña no puede estar vacía");
		}
		this.password = password;
	}
	
	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	public String getErrorUsuario() {
		return errorUsuario;
	}

	public void setErrorUsuario(String errorUsuario) {
		correcto = false;
		this.errorUsuario = errorUsuario;
	}

	public String getErrorPassword() {
		return errorPassword;
	}

	public void setErrorPassword(String errorPassword) {
		correcto = false;
		this.errorPassword = errorPassword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Login other = (Login) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Login [id=" + id + ", usuario=" + usuario + ", password=" + password + "]";
	}
}
