<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado productos</title>
</head>
<body>
	<ul>
		<c:forEach items="${productos}" var="par">
			<c:set var="producto" value="${par.value}" />
			<li>${producto.numero}, ${producto.nombre}, ${producto.precio}</li>
		</c:forEach>
	</ul>
	
	<p>${productos[222].nombre}</p>
</body>
</html>
