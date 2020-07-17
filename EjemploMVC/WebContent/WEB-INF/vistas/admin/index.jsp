<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>
	<h2>Listado de usuarios</h2>

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
<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>