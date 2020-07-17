<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<th>Contraseña</th>
				<!-- En una aplicación real NI DE COÑA muestro contraseñas, de hecho no puedo verlas porque están codificadas -->
				<th>Opciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<th>${usuario.id}</th>
					<td>${usuario.email}</td>
					<td>${usuario.password}</td>
					<td><a href="usuario?id=${usuario.id}">Editar</a> <a href="borrar?id=${usuario.id}">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<a href="usuario">Nuevo usuario</a>
	</p>

	<p>
		<a href="../index">Volver a página Principal</a>
	</p>
</body>
</html>