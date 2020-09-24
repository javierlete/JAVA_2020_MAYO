package com.ipartek.formacion.ejemploconsoladao.accesodatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.ejemploconsoladao.modelos.Mueble;

public class MuebleDAOTest {

	private static final String URL = "jdbc:mysql://localhost:3306/ejemploconsoladao?serverTimezone=UTC";
	private static final String usuario = "debian-sys-maint";
	private static final String password = "o8lAkaNtX91xMUcV";

	private static Mueble m1 = new Mueble(1L, "Mueble1", 1.0, 2.0, 3.0);
	private static Mueble m2 = new Mueble(2L, "Mueble2", 2.0, 3.0, 4.0);

	private static final String TRUNCATE_MUEBLES = "TRUNCATE muebles";
	private static final String INSERT_M1 = "INSERT INTO `ejemploconsoladao`.`muebles` (`nombre`, `largo`, `ancho`, `alto`) VALUES ('Mueble1', '1.0', '2.0', '3.0')";
	private static final String INSERT_M2 = "INSERT INTO `ejemploconsoladao`.`muebles` (`nombre`, `largo`, `ancho`, `alto`) VALUES ('Mueble2', '2.0', '3.0', '4.0')";

	private static Connection con;

	/*
	 * @BeforeClass
	 * 
	 * @Before
	 * 
	 * @Test
	 * 
	 * @After
	 * 
	 * @Before
	 * 
	 * @Test
	 * 
	 * @After
	 * 
	 * @AfterClass
	 */

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		con = DriverManager.getConnection(URL, usuario, password);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		try (Statement st = con.createStatement()) {
			st.executeUpdate(TRUNCATE_MUEBLES);
			st.executeUpdate(INSERT_M1);
			st.executeUpdate(INSERT_M2);
		}
		con.close();
	}

	@Before
	public void setUp() throws Exception {
		try (Statement st = con.createStatement()) {
			st.executeUpdate(TRUNCATE_MUEBLES);
			st.executeUpdate(INSERT_M1);
			st.executeUpdate(INSERT_M2);
		}
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

	@Test
	public void obtenerPorId() {
		Mueble mueble = MuebleDAO.obtenerPorId(1L);

		assertEquals(m1, mueble);

		mueble = MuebleDAO.obtenerPorId(5L);

		assertNull(mueble);
	}

	@Test
	public void insertar() {
		Mueble mueble = new Mueble(null, "Prueba", 1.2, 3.4, 5.6);

		MuebleDAO.insertar(mueble);

		mueble.setId(3L);

		assertEquals(mueble, MuebleDAO.obtenerPorId(3L));
	}
	
	@Test
	public void modificar() {
		Mueble mueble = MuebleDAO.obtenerPorId(1L);
		
		mueble.setNombre("Modificado");
		mueble.setAlto(21.32);
		mueble.setAncho(56.78);
		mueble.setLargo(78.90);
		
		MuebleDAO.modificar(mueble);
		
		Mueble modificado = MuebleDAO.obtenerPorId(1L);
		
		assertEquals(mueble, modificado);
	}
	
	@Test
	public void borrar() {
		assertNotNull(MuebleDAO.obtenerPorId(1L));
		
		MuebleDAO.borrar(1L);
		
		assertNull(MuebleDAO.obtenerPorId(1L));
		
	}
}
