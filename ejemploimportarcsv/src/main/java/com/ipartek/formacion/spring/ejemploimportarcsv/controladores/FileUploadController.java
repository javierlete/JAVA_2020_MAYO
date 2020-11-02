package com.ipartek.formacion.spring.ejemploimportarcsv.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ipartek.formacion.spring.ejemploimportarcsv.modelos.Alumno;

@Controller
@RequestMapping("/")
public class FileUploadController {
	@Autowired
	private JdbcTemplate jdbc;

	@GetMapping()
	public String index() {
		return "index";
	}

	@PostMapping()
	@ResponseBody
	public String handleFileUpload(@RequestParam("ficherocsv") MultipartFile file) throws IOException {
		try (Scanner s = new Scanner(file.getInputStream())) {
			StringBuffer sb = new StringBuffer();

			Alumno alumno;

			List<Alumno> alumnos = new ArrayList<>();

			String linea;

			s.nextLine();

			while (s.hasNext()) {
				linea = s.nextLine();

				sb.append(linea).append("<br />");

				String[] datos = linea.split(";");

				alumno = new Alumno();

				alumno.setCodigo(Long.parseLong(datos[0]));
				alumno.setNombre(datos[1].replaceAll("\"", ""));
				alumno.setApellidos(datos[2].replaceAll("\"", ""));
				alumno.setEmail(datos[3].replaceAll("\"", ""));

				alumnos.add(alumno);
			}

			for (Alumno a : alumnos) {
				jdbc.update("INSERT INTO alumno (codigo, nombre, apellidos, email, telefono, dni) VALUES (?,?,?,?,?,?)",
						null, a.getNombre(), a.getApellidos(), a.getEmail(), 0L, a.getCodigo().toString());
			}

			// jdbc.batchUpdate("INSERT INTO alumno (codigo, nombre, apellidos, email,
			// telefono, dni) VALUES (?,?,?,?,?,?)", alumnos);

//		redirectAttributes.addFlashAttribute("message",
//				"You successfully uploaded " + file.getOriginalFilename() + "!");

			return sb.toString();
		}
	}
}