package com.ipartek.formacion.spring.ejemplospringmvcdaojdbc.repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.ejemplospringmvcdaojdbc.modelos.Usuario;

@Repository
public class UsuarioRepository {
	@Autowired
	JdbcTemplate jdbc;

	public Usuario getByEmail(String email) {
		return getByEmailConMapeadorAutomatico(email);
	}
	
	public Usuario getByEmailConMapeadorAutomatico(String email) {
		try {
			return jdbc.queryForObject("SELECT id, email, password FROM usuarios WHERE email = ?",
					BeanPropertyRowMapper.newInstance(Usuario.class),
					email);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public Usuario getByEmailLambda(String email) {
		try {
			return jdbc.queryForObject("SELECT id, email, password FROM usuarios WHERE email = ?",
					(rs, rowNum) -> new Usuario(rs.getLong("id"), rs.getString("email"), rs.getString("password")),
					email);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public Usuario getByEmailConClaseEnElMetodo(String email) {
		try {
			return jdbc.queryForObject("SELECT id, email, password FROM usuarios WHERE email = ?",
					new RowMapper<Usuario>() {
						@Override
						public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {						
							return new Usuario(rs.getLong("id"), rs.getString("email"), rs.getString("password"));
						}	
					},
					email);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public Usuario getByEmailConClaseInterna(String email) {
		try {
			MapeadorUsuarios mapeador = new MapeadorUsuarios();
			
			return jdbc.queryForObject("SELECT id, email, password FROM usuarios WHERE email = ?",
					mapeador,
					email);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public static class MapeadorUsuarios implements RowMapper<Usuario> {
		@Override
		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			return new Usuario(rs.getLong("id"), rs.getString("email"), rs.getString("password"));
		}
	}
}
