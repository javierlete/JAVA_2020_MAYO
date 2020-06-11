package com.ipartek.formacion.ejemplopoo.tipos;

public class TiposException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TiposException() {
	}

	public TiposException(String message) {
		super(message);
	}

	public TiposException(Throwable cause) {
		super(cause);
	}

	public TiposException(String message, Throwable cause) {
		super(message, cause);
	}

	public TiposException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
