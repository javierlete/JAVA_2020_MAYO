<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Principal</title>
</head>
<body>
	<h1>Mockup de página principal</h1>
	<p>
		<a href="admin/index.jsp">Administración</a>
	</p>
	<ul>
		<c:forEach items="${usuarios}" var="usuario">
			<li>${usuario.email}</li>
		</c:forEach>
	</ul>
</body>
</html>