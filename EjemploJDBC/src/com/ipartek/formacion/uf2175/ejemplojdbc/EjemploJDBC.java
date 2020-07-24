package com.ipartek.formacion.uf2175.ejemplojdbc;

import java.sql.*;

public class EjemploJDBC {

	private static Connection con;
	
	private static final String usuario = "debian-sys-maint";
	private static final String password = "o8lAkaNtX91xMUcV";
	private static final String url = "jdbc:mysql://localhost:3306/supermercado?serverTimezone=UTC";
	
	private static final String sqlObtenerTodos = "SELECT id, nombre FROM producto ORDER BY id";
	private static final String sqlObtenerPorId = "SELECT id, nombre FROM producto WHERE id = 25";
	
	private static final String sqlInsertar = "INSERT INTO producto (nombre, id_usuario) VALUES ('NUEVO3', 1)";
	private static final String sqlModificar = "UPDATE producto SET nombre = 'MODIFICADO' WHERE id = 25";
	private static final String sqlBorrar = "DELETE FROM producto WHERE id = 25";
	
	public static void main(String[] args) throws SQLException {
		con = DriverManager.getConnection(url, usuario, password);

		System.out.println("Conectado");
		
		insertar();
		
		modificar();
		
		obtenerPorId();
		
		borrar();
		
		obtenerTodos();
	}

	private static void obtenerPorId() throws SQLException {
		Statement s = con.createStatement();

		ResultSet rs = s.executeQuery(sqlObtenerPorId);
		
		if (rs.next()) {
			System.out.println(rs.getString("id") + ": " + rs.getString("nombre"));
		} else {
			System.err.println("No se ha encontrado un registro con el id 24");
		}
	}

	private static void borrar() throws SQLException {
		actualizar(sqlBorrar);
	}

	private static void modificar() throws SQLException {
		actualizar(sqlModificar);
	}

	private static void insertar() throws SQLException {
		actualizar(sqlInsertar);
	}
	
	private static void actualizar(String sql) throws SQLException {
		Statement s = con.createStatement();

		int numeroFilasModificadas = s.executeUpdate(sql);
		
		System.out.println("La operación ha afectado a " + numeroFilasModificadas + " registros");
	}
	
	private static void obtenerTodos() throws SQLException {
		Statement s = con.createStatement();

		ResultSet rs = s.executeQuery(sqlObtenerTodos);
		
		while (rs.next()) {
			System.out.println(rs.getString("id") + ": " + rs.getString("nombre"));
		}
	}
}
