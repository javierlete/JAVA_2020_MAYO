package com.ipartek.formacion.ejemploswingdao.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.ejemploswingdao.modelos.Mueble;

public class MuebleDAO {
	// https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-reference-jdbc-url-format.html
	// https://es.stackoverflow.com/a/48946
	private static final String URL = "jdbc:mysql://localhost:3306/ejemploconsoladao?serverTimezone=UTC";
	private static final String USUARIO = "debian-sys-maint";
	private static final String PASSWORD = "o8lAkaNtX91xMUcV";
	
	private static final String SQL_SELECT = "SELECT * FROM muebles";
	private static final String SQL_SELECT_ID = "SELECT * FROM muebles WHERE id = ?";
	private static final String SQL_INSERT = "INSERT INTO muebles (nombre, largo, ancho, alto) VALUES (?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE muebles SET nombre = ?, largo = ?, ancho = ?, alto = ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM muebles WHERE id = ?";

	public static ArrayList<Mueble> obtenerTodos() {
		try(Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD)) {
			try(Statement st = con.createStatement()) {
				try(ResultSet rs = st.executeQuery(SQL_SELECT)) {
					ArrayList<Mueble> muebles = new ArrayList<>();
					
					Mueble mueble;
					
					while(rs.next()) {
						mueble = new Mueble(rs.getLong("id"), rs.getString("nombre"), (Double)rs.getObject("largo"), (Double)rs.getObject("ancho"), (Double)rs.getObject("alto"));
						
						muebles.add(mueble);
					}
					
					return muebles;
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido recibir los datos de la base de datos", e);
		}
	}

	public static Mueble obtenerPorId(Long id) {
		try(Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD)) {
			try(PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID)) {
				pst.setLong(1, id);
				
				try(ResultSet rs = pst.executeQuery()) {
					Mueble mueble = null;
					
					if(rs.next()) {
						mueble = new Mueble(rs.getLong("id"), rs.getString("nombre"), (Double)rs.getObject("largo"), (Double)rs.getObject("ancho"), (Double)rs.getObject("alto"));
					}
					
					return mueble;
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido recibir los datos de la base de datos", e);
		}
	}

	public static void insertar(Mueble mueble) {
		try(Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD)) {
			try(PreparedStatement pst = con.prepareStatement(SQL_INSERT)) {
				pst.setString(1, mueble.getNombre());
				pst.setObject(2, mueble.getLargo());
				pst.setObject(3, mueble.getAncho());
				pst.setObject(4, mueble.getAlto());
				
				pst.executeUpdate();
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido insertar los datos de la base de datos", e);
		}
	}

	public static void modificar(Mueble mueble) {
		try(Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD)) {
			try(PreparedStatement pst = con.prepareStatement(SQL_UPDATE)) {
				pst.setString(1, mueble.getNombre());
				pst.setObject(2, mueble.getLargo());
				pst.setObject(3, mueble.getAncho());
				pst.setObject(4, mueble.getAlto());
				pst.setLong(5, mueble.getId());
				
				pst.executeUpdate();
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido modificar los datos de la base de datos", e);
		}
	}

	public static void borrar(long id) {
		try(Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD)) {
			try(PreparedStatement pst = con.prepareStatement(SQL_DELETE)) {
				pst.setLong(1, id);
				
				pst.executeUpdate();
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido borrar los datos de la base de datos", e);
		}
	}
}
