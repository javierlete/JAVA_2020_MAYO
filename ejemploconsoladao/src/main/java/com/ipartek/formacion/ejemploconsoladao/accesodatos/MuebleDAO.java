package com.ipartek.formacion.ejemploconsoladao.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.ejemploconsoladao.modelos.Mueble;

public class MuebleDAO {
	// https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-reference-jdbc-url-format.html
	// https://es.stackoverflow.com/a/48946
	private static final String URL = "jdbc:mysql://localhost:3306/ejemploconsoladao?serverTimezone=UTC";
	private static final String usuario = "debian-sys-maint";
	private static final String password = "o8lAkaNtX91xMUcV";
	
	private static final String SQL_SELECT = "SELECT * FROM muebles";

	public static ArrayList<Mueble> obtenerTodos() {
		try(Connection con = DriverManager.getConnection(URL, usuario, password)) {
			try(Statement st = con.createStatement()) {
				try(ResultSet rs = st.executeQuery(SQL_SELECT)) {
					ArrayList<Mueble> muebles = new ArrayList<>();
					
					Mueble mueble;
					
					while(rs.next()) {
						mueble = new Mueble(rs.getLong("id"), rs.getString("nombre"), rs.getDouble("largo"), rs.getDouble("ancho"), rs.getDouble("alto"));
						
						muebles.add(mueble);
					}
					
					return muebles;
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido recibir los datos de la base de datos", e);
		}
	}
}
