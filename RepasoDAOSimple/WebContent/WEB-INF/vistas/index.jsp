<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1>Inmobiliaria Casas</h1>

<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover table-sm">
		<thead class="thead-dark">
			<tr>
				<th>Id</th>
				<th>Provincia</th>
				<th>Código Postal</th>
				<th>Dirección</th>
				<th>Número</th>
				<th>Piso</th>
				<th>Puerta</th>
				<th>Opciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${casas}" var="casa">
				<%-- for(Casa casa: request.getAttribute("casas")) --%>
				<tr>
					<td>${casa.id}</td>
					<%-- casa.getId() --%>
					<td>${casa.provincia}</td>
					<td>${casa.codigoPostal}</td>
					<td>${casa.direccion}</td>
					<td>${casa.numero}</td>
					<td>${casa.piso}</td>
					<td>${casa.puerta}</td>
					<td><a class="btn btn-primary" href="casa?id=${casa.id}">Modificar</a>
						<a class="btn btn-danger" href="borrar?id=${casa.id}">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<a class="btn btn-primary" href="casa">Añadir</a>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>