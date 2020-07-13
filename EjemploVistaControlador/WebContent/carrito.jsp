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
	<h1>Carrito</h1>

	<%--
	<c:if test="${carrito.size() == 0}">
		<h2>No hay productos todavía</h2>
	</c:if>
	--%>

	<c:choose>
		<c:when test="${carrito.size() == 0}">
			<h2>No hay productos todavía</h2>
		</c:when>
		<c:otherwise>
			<h2>Listado de productos del carrito</h2>
			<ul>
				<c:forEach items="${carrito}" var="producto">
					<li><a href="borrarproductocarrito?producto=${producto}">${producto}</a>
					</li>
				</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>

	<p>
		<a href="index">Volver a listado de productos</a> <a
			href="cerrarsesion">Cerrar sesión</a>
	</p>
</body>
</html>