<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de usuarios</title>
</head>
<body>
	<h1>Listado de usuarios</h1>
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Email</th>
				<th>Contraseña</th> <!-- En una aplicación real NI DE COÑA muestro contraseñas, de hecho no puedo verlas porque están codificadas -->
				<th>Opciones</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>1</th>
				<td>email1@email.net</td>
				<td>contra1</td>
				<td>
					<a href="usuario.jsp">Editar</a>
					<a href="#">Borrar</a>
				</td>
			</tr>
			<tr>
				<th>2</th>
				<td>email2@email.net</td>
				<td>contra2</td>
				<td>
					<a href="usuario.jsp">Editar</a>
					<a href="#">Borrar</a>
				</td>
			</tr>
		</tbody>
	</table>
	
	<p>
		<a href="usuario.jsp">Nuevo usuario</a>
	</p>
	
	<p>
		<a href="../index.jsp">Volver a página Principal</a>
	</p>
</body>
</html>