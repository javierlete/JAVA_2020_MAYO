package com.ipartek.formacion.ejemploswingdao.accesodatos;

public class AccesoDatosException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AccesoDatosException() {		
	}

	public AccesoDatosException(String arg0) {
		super(arg0);
	}

	public AccesoDatosException(Throwable arg0) {
		super(arg0);
	}

	public AccesoDatosException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccesoDatosException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
