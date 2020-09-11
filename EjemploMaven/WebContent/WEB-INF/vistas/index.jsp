<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LETElecom</title>
</head>
<body>
	<h1>LETElecom</h1>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>nombre</th>
				<th>Precio Mensual</th>
				<th>Meses Promocion</th>
				<th>Precio Mensual Promocion</th>
				<th>Ancho de Banda en Mb</th>
				<th>Datos en GB</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${servicios}" var="servicio">
				<tr>
					<td>${servicio.id}</td>
					<td>${servicio.nombre}</td>
					<td>${servicio.precioMensual}</td>
					<td>${servicio.mesesPromocion}</td>
					<td>${servicio.precioMensualPromocion}</td>
					<td><c:if test="${servicio['class'].simpleName eq 'Fibra'}">
						${servicio.anchoDeBandaEnMb}
					</c:if></td>

					<td><c:if test="${servicio['class'].simpleName eq 'Movil'}">
						${servicio.datosEnGb}
					</c:if></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>