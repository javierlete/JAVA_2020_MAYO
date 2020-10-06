package com.ipartek.formacion.mf0226.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.mf0226.modelos.Curso;
import com.ipartek.formacion.mf0226.modelos.Profesor;

public class CursoDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/ejemploconsoladao?serverTimezone=UTC";
	private static final String usuario = "debian-sys-maint";
	private static final String password = "o8lAkaNtX91xMUcV";
	private static final String SQL_LISTADO = "SELECT c.nombre, c.identificador, p.nombre pnombre, p.apellidos papellidos FROM curso JOIN profesor ON p.codigo = c.profesor_codigo";
	private static final String SQL_CURSO = "SELECT \n"
			+ "	c.codigo, c.nombre, c.identificador, c.fInicio, c.fFin, c.nHoras, c.temario, c.activo, c.precio, \n"
			+ "    p.nombre pnombre, p.apellidos papellidos\n"
			+ "FROM curso c \n"
			+ "JOIN profesor p ON p.codigo = c.profesor_codigo";
	private static final String SQL_RESENA = "SELECT texto FROM resenas WHERE codigo_curso = ?";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver");
		}
	}

	public static ArrayList<Curso> listado() {

		try (Connection con = DriverManager.getConnection(URL, usuario, password)) {
			try (Statement st = con.createStatement()) {
				try (ResultSet rs = st.executeQuery(SQL_LISTADO)) {
					ArrayList<Curso> cursos = new ArrayList<>();

					Curso curso;
					
					while (rs.next()) {
						curso = new Curso(
								rs.getString("nombre"),
								rs.getString("identificador"));
						
						curso.setProfesor(new Profesor(rs.getString("pnombre"), rs.getString("papellidos")));
						
						cursos.add(curso);
					}

					return cursos;
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido recibir los datos de la base de datos", e);
		}
	}
	
	public static Curso detalle(Long id) {
		try (Connection con = DriverManager.getConnection(URL, usuario, password)) {
			try (Statement st = con.createStatement()) {
				try (ResultSet rs = st.executeQuery(SQL_CURSO)) {
					Curso curso = null;
					
					if(rs.next()) {
						curso = new Curso(
								rs.getLong("codigo"),
								rs.getString("nombre"),
								rs.getString("identificador"),
								rs.getDate("fInicio"),
								rs.getDate("fFin"),
								rs.getInt("nHoras"),
								rs.getString("temario")
								);
						
						curso.setProfesor(new Profesor(rs.getString("pnombre"), rs.getString("papellidos")));
					}

					try (PreparedStatement ps = con.prepareStatement(SQL_RESENA)) {
						ps.setLong(1, id);
						
						try (ResultSet rs2 = ps.executeQuery()) {
							ArrayList<String> resenas = new ArrayList<>();

							String resena;
							
							while (rs.next()) {
								resena = rs.getString("texto");
								
								resenas.add(resena);
							}
							
							curso.setResenas(resenas);
						}
					}
					
					return curso;
				}
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido recibir los datos de la base de datos", e);
		}
	}
}




















