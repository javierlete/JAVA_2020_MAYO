package com.ipartek.formacion.uf2175.ejemplojdbc;

import java.sql.*;

public class EjemploJDBC {

	private static Connection con;
	
	private static final String USUARIO = "debian-sys-maint";
	private static final String PASSWORD = "o8lAkaNtX91xMUcV";
	private static final String URL = "jdbc:mysql://localhost:3306/supermercado?serverTimezone=UTC";
	
	private static final String SQL_OBTENER_TODOS = "SELECT id, nombre FROM producto ORDER BY id";
	private static final String SQL_OBTENER_POR_ID = "SELECT id, nombre FROM producto WHERE id = 25";
	
	private static final String SQL_INSERTAR = "INSERT INTO producto (nombre, id_usuario) VALUES ('NUEVO4', 1)";
	private static final String SQL_MODIFICAR = "UPDATE producto SET nombre = 'MODIFICADO' WHERE id = 25";
	private static final String SQL_BORRAR = "DELETE FROM producto WHERE id = 25";
	
	public static void main(String[] args) throws SQLException {
		con = DriverManager.getConnection(URL, USUARIO, PASSWORD);

		System.out.println("Conectado");
		
		insertar();
		
		modificar();
		
		obtenerPorId();
		
		borrar();
		
		obtenerTodos();
		
		con.close();
	}

	private static void obtenerPorId() throws SQLException {
		Statement s = con.createStatement();

		ResultSet rs = s.executeQuery(SQL_OBTENER_POR_ID);
		
		if (rs.next()) {
			System.out.println(rs.getString("id") + ": " + rs.getString("nombre"));
		} else {
			System.err.println("No se ha encontrado un registro con el id 24");
		}
		
		rs.close();
		s.close();
	}

	private static void borrar() throws SQLException {
		actualizar(SQL_BORRAR);
	}

	private static void modificar() throws SQLException {
		actualizar(SQL_MODIFICAR);
	}

	private static void insertar() throws SQLException {
		actualizar(SQL_INSERTAR);
	}
	
	private static void actualizar(String sql) throws SQLException {
		Statement s = con.createStatement();

		int numeroFilasModificadas = s.executeUpdate(sql);
		
		System.out.println("La operación ha afectado a " + numeroFilasModificadas + " registros");
		
		s.close();
	}
	
	private static void obtenerTodos() throws SQLException {
		Statement s = con.createStatement();

		ResultSet rs = s.executeQuery(SQL_OBTENER_TODOS);
		
		while (rs.next()) {
			System.out.println(rs.getString("id") + ": " + rs.getString("nombre"));
		}
		
		rs.close();
		s.close();
	}
}
