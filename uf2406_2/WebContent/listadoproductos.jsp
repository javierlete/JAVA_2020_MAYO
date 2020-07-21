<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado productos</title>
</head>
<body>
	<form action="carrito">
		<table border="1">
			<thead>
				<tr>
					<th>Número</th>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Cantidad</th>
				</tr>
			</thead>

			<tbody>

				<c:forEach items="${productos}" var="par">
					<c:set var="producto" value="${par.value}" />
					<tr>
						<th>${producto.numero}</th>
						<td>${producto.nombre}</td>
						<td>${producto.precio}</td>
						<td><input type="number" min="0" name="${producto.numero}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<button>Aceptar pedido</button>
	</form>
</body>
</html>
