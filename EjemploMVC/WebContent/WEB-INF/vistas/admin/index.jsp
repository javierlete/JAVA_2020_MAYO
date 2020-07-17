<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>
	<h2>Listado de usuarios</h2>

	<table class="table table-striped table-bordered table-hover table-sm">
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
					<td><a class="btn btn-primary" href="admin/usuario?id=${usuario.id}">Editar</a> <a class="btn btn-danger" href="admin/borrar?id=${usuario.id}">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<a class="btn btn-primary" href="admin/usuario">Nuevo usuario</a>
	</p>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>