<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tienda virtual</title>
</head>
<body>
	<h1>Tienda virtual</h1>
	
	<ul>
		<c:forEach items="${productos}" var="producto">
			<li>
				<a href="carrito.jsp">${producto}</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>