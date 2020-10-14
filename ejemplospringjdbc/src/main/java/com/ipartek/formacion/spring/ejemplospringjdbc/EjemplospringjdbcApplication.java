package com.ipartek.formacion.spring.ejemplospringjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.spring.ejemplospringjdbc.entidades.Cliente;

@SpringBootApplication
public class EjemplospringjdbcApplication implements CommandLineRunner { // CommandLineRunner indica que se va a
																			// ejecutar la aplicación en consola

	private static final Logger log = LoggerFactory.getLogger(EjemplospringjdbcApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EjemplospringjdbcApplication.class, args);
	}

	@Autowired // Spring crea automáticamente un singleton del objeto JdbcTemplate
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception { // Punto de entrada de la aplicación de consola
		log.info("Creating tables");

		jdbcTemplate.execute("DROP TABLE clientes IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE clientes(id SERIAL, nombre VARCHAR(255), apellidos VARCHAR(255))");

		// Split up the array of whole names into an array of first/last names
		// Requiere Java 8
//	    List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
//	        .map(nombre -> nombre.split(" "))
//	        .collect(Collectors.toList());

		// Array.asList ===> Convierte un conjunto de Strings en un List<String>
		// .stream() ===> Convierte en un flujo los datos anteriores
		// .map() ===> A cada elemento del flujo lo transforma según la función recibida
		// nombre -> nombre.split(" ") ===> Por cada elemento del flujo que llamaremos
		// nombre, devuelve un array de dos elementos de tipo String con el nombre y el
		// apellido como datos
		// .collect() ===> Recopila la información del flujo después de pasar por los
		// filtros
		// Collectors.toList() ===> Y devuelve el resultado en formato List<Object[]>

		List<Object[]> nombres = new ArrayList<>();

		nombres.add(new String[] { "John", "Woo" });
		nombres.add(new String[] { "Jeff", "Dean" });
		nombres.add(new String[] { "Josh", "Bloch" });
		nombres.add(new String[] { "Josh", "Long" });

		// Use a Java 8 stream to print out each tuple of the list
		// nombres.forEach(name -> log.info(String.format("Inserting customer record for
		// %s %s", name[0], name[1])));

		for (Object[] nombreCompleto : nombres) {
			log.info(String.format("Inserting customer record for %s %s", nombreCompleto[0], nombreCompleto[1]));
		}

		// Uses JdbcTemplate's batchUpdate operation to bulk load data
		jdbcTemplate.batchUpdate("INSERT INTO clientes (nombre, apellidos) VALUES (?,?)", nombres);

		log.info("Querying for customer records where first_name = 'Josh':");

		// Java 8
//	    jdbcTemplate.query(
//	        "SELECT id, nombre, apellidos FROM clientes WHERE nombre = ?", new Object[] { "Josh" },
//	        (rs, rowNum) -> new Cliente(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellidos"))
//	    ).forEach(cliente -> log.info(cliente.toString()));

		List<Cliente> clientes = jdbcTemplate.query("SELECT id, nombre, apellidos FROM clientes WHERE nombre = ?",
				new Object[] { "Josh" }, new RowMapper<Cliente>() {
					@Override
					public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new Cliente(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellidos"));
					}
				});

		for (Cliente cliente : clientes) {
			log.info(cliente.toString());
		}
	}
}
