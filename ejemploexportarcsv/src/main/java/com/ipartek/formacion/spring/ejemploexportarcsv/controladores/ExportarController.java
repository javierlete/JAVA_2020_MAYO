package com.ipartek.formacion.spring.ejemploexportarcsv.controladores;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipartek.formacion.spring.ejemploexportarcsv.modelos.Alumno;

@Controller
@RequestMapping("/exportar")
public class ExportarController {
	@Autowired
	private JdbcTemplate jdbc;
	
	@GetMapping(value = "/alumnos", produces = "text/csv")
	@ResponseBody
	public String alumnos(HttpServletResponse response) {
		Date ahora = new Date();
		
		String fichero = new SimpleDateFormat("yyyyMMdd'T'HHmmss").format(ahora);
		
		response.setHeader("content-disposition","attachment;filename =" + fichero + ".csv"); 
		
		List<Alumno> alumnos = jdbc.query(
				"SELECT codigo, nombre, apellidos, email FROM alumno", 
				BeanPropertyRowMapper.newInstance(Alumno.class));
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("codigo;nombre;apellidos;email\n");
		
		for(Alumno alumno: alumnos) {
			sb.append(alumno.getCodigo());
			sb.append(";\"");
			sb.append(alumno.getNombre());
			sb.append("\";\"");
			sb.append(alumno.getApellidos());
			sb.append("\";\"");
			sb.append(alumno.getEmail());
			sb.append("\"\n");
		}
		
		return sb.toString();
	}

}
