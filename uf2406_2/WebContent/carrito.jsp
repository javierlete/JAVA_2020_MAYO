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

	<ul>
		<c:forEach items="${carrito}" var="producto">
			<li>${producto.numero} ${producto.nombre} ${producto.precio} ${producto.cantidad} ${producto.total}</li>
		</c:forEach>
	</ul>

</body>
</html>