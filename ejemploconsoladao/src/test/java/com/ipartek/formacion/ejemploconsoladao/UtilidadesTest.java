package com.ipartek.formacion.ejemploconsoladao;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilidadesTest {

	@Test
    public void sumar() {
    	int resultado = Utilidades.sumar(5, 3);
    	assertEquals(8, resultado);
    }

}
