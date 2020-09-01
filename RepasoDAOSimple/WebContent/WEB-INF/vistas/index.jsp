<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- Necesitamos WEB-INF/lib/jstl-1.2.jar para poder tener la biblioteca de etiquetas de c:forEach --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inmobiliaria Casas</title>
</head>
<body>
	<h1>Inmobiliaria Casas</h1>

	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Provincia</th>
				<th>Código Postal</th>
				<th>Dirección</th>
				<th>Número</th>
				<th>Piso</th>
				<th>Puerta</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${casas}" var="casa"> <%-- for(Casa casa: request.getAttribute("casas")) --%>
				<tr>
					<td>${casa.id}</td> <%-- casa.getId() --%>
					<td>${casa.provincia}</td>
					<td>${casa.codigoPostal}</td>
					<td>${casa.direccion}</td>
					<td>${casa.numero}</td>
					<td>${casa.piso}</td>
					<td>${casa.puerta}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>