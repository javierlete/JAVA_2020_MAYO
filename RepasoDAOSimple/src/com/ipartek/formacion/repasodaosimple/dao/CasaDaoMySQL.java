package com.ipartek.formacion.repasodaosimple.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.repasodaosimple.modelos.Casa;

//DAO: Data Access Object (Objeto de acceso a datos)
public class CasaDaoMySQL {
	private static final String SQL_INSERT = "INSERT INTO casas (provincia, codigopostal, direccion, numero, piso, puerta) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String SQL_SELECT = "SELECT * FROM casas";
	// serverTimezone=UTC es necesario a partir de la versión 8 del driver de MySQL
	private static final String URL = "jdbc:mysql://localhost:3306/inmobiliaria?serverTimezone=UTC";
	private static final String USUARIO = "debian-sys-maint";
	private static final String PASSWORD = "o8lAkaNtX91xMUcV";

	/**
	 * Obtención de todas las casas disponibles
	 * 
	 * @return casas disponibles
	 * @throws SQLException
	 */
	public static ArrayList<Casa> obtenerTodas() {
		ArrayList<Casa> casas = new ArrayList<>();

		try {
			// Aparte, en las aplicaciones web sigue siendo necesario registrar el driver de
			// forma explícita
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Para poder conectar se necesita el driver de JDBC para MySQL
			// Se coloca en WEB-INF/lib/

			// Establecemos la conexión con la base de datos según su URL, USUARIO y
			// PASSWORD
			try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD)) {
				// Creamos una sentencia para mandar órdenes SQL
				try (Statement s = con.createStatement()) {
					// Ejecutamos la órden SQL_SELECT que nos devuelve un conjunto de filas
					// (ResultSet)
					try (ResultSet rs = s.executeQuery(SQL_SELECT)) {
						Casa casa;

						// Se posiciona en el registro siguiente y mientras haya un registro siguiente
						while (rs.next()) {
							// Tomamos los campos del registro en el que nos encontramos en esta repetición,
							// y rellenamos con ellos un objeto nuevo de tipo Casa
							casa = new Casa(rs.getLong("id"), rs.getString("provincia"), rs.getString("codigopostal"),
									rs.getString("direccion"), rs.getString("numero"), rs.getString("piso"),
									rs.getString("puerta"));
							
							// Añadimos el objeto a la colección de casas
							casas.add(casa);
						}
					}
				}
				
				// Devolvemos todas las casas en un ArrayList
				return casas;
			} catch (SQLException e) {
				throw new DaoException("Ha habido un error al obtener todas las casas", e);
				// Para generar la clase, le damos desde la línea roja que nos aparece cuando
				// todavía no existe
				// seleccionamos Create Class DaoException

				// En la pantalla de creación de clase, cambiamos Exception -> RuntimeException
				// Marcamos Constructors from Superclass
			}
		} catch (ClassNotFoundException e) {
			throw new DaoException("No se ha encontrado el driver", e);
		}
	}

	public static void insertar(Casa casa) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD)) {
				try (PreparedStatement ps = con.prepareStatement(SQL_INSERT)) {
					ps.setString(1, casa.getProvincia());
					ps.setString(2, casa.getCodigoPostal());
					ps.setString(3, casa.getDireccion());
					ps.setString(4, casa.getNumero());
					ps.setString(5, casa.getPiso());
					ps.setString(6, casa.getPuerta());
					
					ps.executeUpdate();
				}
				
			} catch (SQLException e) {
				throw new DaoException("Ha habido un error al insertar una casa", e);
			}
		} catch (ClassNotFoundException e) {
			throw new DaoException("No se ha encontrado el driver", e);
		}
		
	}
}
