package com.ipartek.formacion.ejemplomvc.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.ejemplomvc.modelos.Usuario;

class UsuarioMySqlDao implements Dao<Usuario> {
	private String url;
	private String usuario;
	private String password;

	private static final String SQL_OBTENER_TODOS = "SELECT id, email, password FROM usuarios ORDER BY id";
	private static final String SQL_OBTENER_POR_ID = "SELECT id, email, password FROM usuarios WHERE id = ?";

	private static final String SQL_INSERTAR = "INSERT INTO usuarios (email, password, roles_id) VALUES (?, ?, 2)";
	private static final String SQL_MODIFICAR = "UPDATE usuarios SET email = ?, password = ? WHERE id = ?";
	private static final String SQL_BORRAR = "DELETE FROM usuarios WHERE id = ?";

	public UsuarioMySqlDao(String url, String usuario, String password) {
		super();
		this.url = url;
		this.usuario = usuario;
		this.password = password;
	}

	@Override
	public Iterable<Usuario> obtenerTodos() {
		List<Usuario> usuarios = new ArrayList<Usuario>();

		try (Statement s = getConexion().createStatement()) {
			try (ResultSet rs = s.executeQuery(SQL_OBTENER_TODOS)) {
				while (rs.next()) {
					usuarios.add(new Usuario(Long.parseLong(rs.getString("id")), rs.getString("email"),
							rs.getString("password")));
				}

				return usuarios;
			} catch(Exception e) {
				throw new AccesoDatosException("No se ha podido crear el conjunto de resultados", e);
			}
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido crear la sentencia de acceso a usuarios", e);
		}
	}

	


	@Override
	public Usuario obtenerPorId(Long id) {
		Usuario usuario = null;

		try (PreparedStatement ps = getConexion().prepareStatement(SQL_OBTENER_POR_ID)) {
			ps.setLong(1, id);
			
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					usuario = new Usuario(Long.parseLong(rs.getString("id")), rs.getString("email"),
							rs.getString("password"));
				}

				return usuario;
			} catch(Exception e) {
				throw new AccesoDatosException("No se ha podido crear el conjunto de resultados", e);
			}
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido crear la sentencia de acceso a usuarios", e);
		}
	}

	@Override
	public Usuario insertar(Usuario usuario) {
		try (PreparedStatement ps = getConexion().prepareStatement(SQL_INSERTAR)) {
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getPassword());
			
			int numeroFilasModificadas = ps.executeUpdate();
		
			if(numeroFilasModificadas != 1) {
				throw new AccesoDatosException("Número de filas insertadas: " + numeroFilasModificadas);
			}
			
			return usuario; // TODO: que devuelva el id nuevo
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido crear la sentencia de inserción de usuarios", e);
		}
	}

	@Override
	public void modificar(Usuario usuario) {
		try (PreparedStatement ps = getConexion().prepareStatement(SQL_MODIFICAR)) {
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getPassword());
			
			ps.setLong(3, usuario.getId());
			
			int numeroFilasModificadas = ps.executeUpdate();
		
			if(numeroFilasModificadas != 1) {
				throw new AccesoDatosException("Número de filas modificadas: " + numeroFilasModificadas);
			}
			
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido crear la sentencia de modificación de usuarios", e);
		}
	}

	@Override
	public void borrar(Usuario usuario) {
		borrar(usuario.getId());
	}

	@Override
	public void borrar(Long id) {
		try (PreparedStatement ps = getConexion().prepareStatement(SQL_BORRAR)) {
			
			ps.setLong(1, id);
			
			int numeroFilasModificadas = ps.executeUpdate();
		
			if(numeroFilasModificadas != 1) {
				throw new AccesoDatosException("Número de filas borradas: " + numeroFilasModificadas);
			}
			
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido crear la sentencia de borrado de usuarios", e);
		}
	}

	private Connection getConexion() {
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			new com.mysql.cj.jdbc.Driver();
			return DriverManager.getConnection(url, usuario, password);
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido conectar al origen de datos", e);
		}
	}

	// Versión de obtenerTodos para Java < 7
	public Iterable<Usuario> obtenerTodosAntiguo() {
		List<Usuario> usuarios = new ArrayList<Usuario>();

		Statement s = null;
		ResultSet rs = null;

		try {
			s = getConexion().createStatement();

			rs = s.executeQuery(SQL_OBTENER_TODOS);

			while (rs.next()) {
				usuarios.add(new Usuario(Long.parseLong(rs.getString("id")), rs.getString("email"),
						rs.getString("password")));
			}

			return usuarios;

		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido obtener el listado de usuarios", e);
		} finally {
			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
					rs = null;
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("No se ha podido cerrar el conjunto de resultados", e);
			}
			try {
				if (s != null && !s.isClosed()) {
					s.close();
					s = null;
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("No se ha podido cerrar la sentencia", e);
			}
		}
	}
}
