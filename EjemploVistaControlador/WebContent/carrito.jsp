<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carrito</title>
</head>
<body>
	<h1>Carrito</h1>
	
	<ul>
		<c:forEach items="${carrito}" var="producto">
			<li>
				<a href="#">${producto}</a>
			</li>
		</c:forEach>
		
	</ul>
	
	<p>
		<a href="index">Volver a listado de productos</a>
	</p>
</body>
</html>