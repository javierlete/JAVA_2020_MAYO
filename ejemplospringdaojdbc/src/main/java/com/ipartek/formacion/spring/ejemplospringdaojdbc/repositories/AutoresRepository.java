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
	    return jdbc.query(
	        "SELECT id, nombre, apellidos FROM autores", new Object[] {},
	        (rs, rowNum) -> new Autor(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellidos"))
	    );
	}
	
	public Autor getById(Long id) {
		return jdbc.queryForObject(
		        "SELECT id, nombre, apellidos FROM autores WHERE id = ?", new Object[] { id },
		        (rs, rowNum) -> new Autor(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellidos"))
		    );
	}
	
	public void insert(Autor autor) {
		jdbc.update("INSERT INTO autores (nombre, apellidos) VALUES (?, ?)", 
				new Object[] { autor.getNombre(), autor.getApellidos() });
	}
	
	public void update(Autor autor) {
		jdbc.update("UPDATE autores SET nombre = ?, apellidos = ? WHERE id = ?", 
				new Object[] { autor.getNombre(), autor.getApellidos(), autor.getId() });
	}
	
	public void delete(Long id) {
		jdbc.update("DELETE FROM autores WHERE id = ?", new Object[] { id });
	}
}
