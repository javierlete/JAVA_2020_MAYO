<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carrito</title>
</head>
<body>

	<table border="1">
		<thead>
			<tr>
				<th>Número</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Cantidad</th>
				<th>Total</th>
			</tr>
		</thead>

		<tbody>

			<c:forEach items="${carrito}" var="producto">
				<tr>
					<th>${producto.numero}</th>
					<td>${producto.nombre}</td>
					<td>${producto.precio}</td>
					<td>${producto.cantidad}</td>
					<td>${producto.total}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th></th>
				<td></td>
				<td></td>
				<td></td>
				<td>${total}</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>