package com.ipartek.formacion.ejemploconsoladao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void sumar() {
    	int resultado = Utilidades.sumar(5, 3);
    	assertEquals(8, resultado);
    }
	
	/**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
