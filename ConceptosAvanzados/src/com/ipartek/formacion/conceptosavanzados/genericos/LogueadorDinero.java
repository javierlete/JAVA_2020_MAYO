package com.ipartek.formacion.conceptosavanzados.genericos;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogueadorDinero implements Logueable<BigDecimal> {

	@Override
	public String formatear(BigDecimal importe) {
		String fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss: ").format(new Date());
		String euros = importe.setScale(2, BigDecimal.ROUND_HALF_EVEN) + "€";
		return  fecha + euros;
	}

}
