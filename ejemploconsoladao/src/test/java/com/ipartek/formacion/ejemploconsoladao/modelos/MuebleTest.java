package com.ipartek.formacion.ejemploconsoladao.modelos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MuebleTest {
	private static final long ID = 5L;
	private static final double ALTO = 7.9;
	private static final String NOMBRE = "Original";
	private static final double ANCHO = 6.5;
	private static final double LARGO = 5.0;
	private static final double DELTA = 0.0000001;
	
	private Mueble mueble;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		mueble = new Mueble(ID, NOMBRE, LARGO, ANCHO, ALTO);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testHashCode() {
		Mueble m1 = new Mueble(1L, "Prueba", 1.0, 2.0, 3.0);
		Mueble m2 = new Mueble(1L, "Prueba", 1.0, 2.0, 3.0);
		
		assertEquals(m1.hashCode(), m2.hashCode());
	}

	@Test
	public void testMueble() {
		Mueble m = new Mueble(1L, "Prueba", 1.0, 2.0, 3.0);
		
		long id = m.getId();
		String nombre = m.getNombre();
		double largo = m.getLargo();
		double ancho = m.getAncho();
		double alto = m.getAlto();
		
		assertEquals(1L, id);
		assertEquals("Prueba", nombre);
		assertEquals(1.0, largo, DELTA);
		assertEquals(2.0, ancho, DELTA);
		assertEquals(3.0, alto, DELTA);
	}

	@Test
	public void testGetId() {
		assertEquals(ID, (long)mueble.getId());
	}

	@Test
	public void testSetId() {
		mueble.setId(1L);
		assertEquals(1L, (long)mueble.getId());
	}

	@Test
	public void testGetNombre() {
		assertEquals(NOMBRE, mueble.getNombre());
	}

	@Test
	public void testSetNombre() {
		mueble.setNombre("Otro nombre");
		assertEquals("Otro nombre", mueble.getNombre());
	}

	@Test
	public void testGetLargo() {
		assertEquals(LARGO, mueble.getLargo(), DELTA);
	}

	@Test
	public void testSetLargo() {
		mueble.setLargo(1.0);
		assertEquals(1.0, mueble.getLargo(), DELTA);
	}

	@Test
	public void testGetAncho() {
		assertEquals(ANCHO, mueble.getAncho(), DELTA);
	}

	@Test
	public void testSetAncho() {
		mueble.setAncho(1.0);
		assertEquals(1.0, mueble.getAncho(), DELTA);
	}

	@Test
	public void testGetAlto() {
		assertEquals(ALTO, mueble.getAlto(), DELTA);
	}

	@Test
	public void testSetAlto() {
		mueble.setAlto(1.0);
		assertEquals(1.0, mueble.getAlto(), DELTA);
	}

	@Test
	public void testEqualsObject() {
		assertTrue(mueble.equals(new Mueble(ID, NOMBRE, LARGO, ANCHO, ALTO)));
	}

	@Test
	public void testToString() {
		assertEquals("Mueble [id=" + ID + ", nombre=" + NOMBRE + ", largo=" + LARGO + ", ancho=" + ANCHO + ", alto=" + ALTO
				+ "]", mueble.toString());
	}

}
