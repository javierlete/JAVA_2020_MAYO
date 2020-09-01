package com.ipartek.formacion.repasodaosimple.dao;

public class DaoException extends RuntimeException {
	private static final long serialVersionUID = 3137978892775165371L;

	// Quitar TODO y añadir Add generated serial version ID en la línea amarilla de warning de DaoException
	public DaoException() {
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
