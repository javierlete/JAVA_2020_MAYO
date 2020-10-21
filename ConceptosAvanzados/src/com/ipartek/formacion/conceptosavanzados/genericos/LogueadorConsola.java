package com.ipartek.formacion.conceptosavanzados.genericos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogueadorConsola implements Logueable<Object> {
	public String formatear(Object o) {
		return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss: ").format(new Date())) + o;
	}
}
