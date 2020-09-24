package com.ipartek.formacion.ejemploconsoladao.accesodatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.ejemploconsoladao.modelos.Mueble;

public class MuebleDAOTest {

	private static Mueble m1 = new Mueble(1L, "Mueble1", 1.0, 2.0, 3.0);
	private static Mueble m2 = new Mueble(2L, "Mueble2", 2.0, 3.0, 4.0);
	
	/*
	 INSERT INTO `ejemploconsoladao`.`muebles` (`nombre`, `largo`, `ancho`, `alto`) VALUES ('Mueble1', '1.0', '2.0', '3.0');
INSERT INTO `ejemploconsoladao`.`muebles` (`nombre`, `largo`, `ancho`, `alto`) VALUES ('Mueble2', '2.0', '3.0', '4.0');

	 */
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void obtenerTodos() {
		ArrayList<Mueble> muebles = MuebleDAO.obtenerTodos();
		
		assertNotNull(muebles);
		
		assertEquals(2, muebles.size());
		
		assertEquals(m1, muebles.get(0));
		assertEquals(m2, muebles.get(1));
	}

}
