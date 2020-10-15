package com.ipartek.formacion.spring.ejemplospringdaojdbc.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.ejemplospringdaojdbc.entities.Autor;

@Repository
public class AutoresRepository {

	@Autowired
	JdbcTemplate jdbc;
	
	public List<Autor> getAll() {
		// Java 8
	    return jdbc.query(
	        "SELECT id, nombre, apellidos FROM autores", new Object[] {},
	        (rs, rowNum) -> new Autor(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellidos"))
	    );

//		return jdbc.query("SELECT id, nombre, apellidos FROM autores",
//				new Object[] {}, new RowMapper<Autor>() {
//					@Override
//					public Autor mapRow(ResultSet rs, int rowNum) throws SQLException {
//						return new Autor(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellidos");
//					}
//				});
	}
}
