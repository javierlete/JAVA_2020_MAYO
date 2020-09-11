package com.ipartek.formacion.ejemplomaven.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.ejemplomaven.modelo.Fibra;
import com.ipartek.formacion.ejemplomaven.modelo.Movil;
import com.ipartek.formacion.ejemplomaven.modelo.Servicio;

public class ServicioDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/ejemplomaven?serverTimezone=UTC";
	private static final String usuario = "debian-sys-maint";
	private static final String password = "o8lAkaNtX91xMUcV";
	private static final String SQL_SELECT = "SELECT * FROM servicios";

	public static ArrayList<Servicio> obtenerTodos() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try (Connection con = DriverManager.getConnection(URL, usuario, password)) {
				try(Statement st = con.createStatement()){
					try(ResultSet rs = st.executeQuery(SQL_SELECT)) {
						ArrayList<Servicio> servicios = new ArrayList<>();
						String tipo;
						
						while(rs.next()) {
							tipo = rs.getString("tipo");
							
							Servicio servicio;
							
							switch(tipo) {
							case "Fibra": 
								servicio = new Fibra(rs.getLong("id"), rs.getString("nombre"), (Integer)rs.getObject("meses_promocion"), rs.getBigDecimal("precio_mensual_promocion"), rs.getBigDecimal("precio_mensual"), rs.getInt("ancho_de_banda_en_mb"));
								break;
							case "Movil": 
								servicio = new Movil(rs.getLong("id"), rs.getString("nombre"), (Integer)rs.getObject("meses_promocion"), rs.getBigDecimal("precio_mensual_promocion"), rs.getBigDecimal("precio_mensual"), rs.getInt("datos_en_gb"));
								break;
							case "Servicio":
								servicio = new Servicio(rs.getLong("id"), rs.getString("nombre"), (Integer)rs.getObject("meses_promocion"), rs.getBigDecimal("precio_mensual_promocion"), rs.getBigDecimal("precio_mensual"));
								break;
							default: throw new DaoException("Tipo no reconocido: " + tipo);
							}
							
							servicios.add(servicio);
						}
						
						return servicios;
					} catch (SQLException e) {
						throw new DaoException("No se han podido recibir los registros", e);
					}
				} catch (SQLException e) {
					throw new DaoException("No se ha podido crear la sentencia", e);
				}
			} catch (SQLException e) {
				throw new DaoException("No se ha podido conectar a la base de datos", e);
			}
		} catch (ClassNotFoundException e) {
			throw new DaoException("No se ha encontrado el driver de MySQL", e);
		}

	}
}
