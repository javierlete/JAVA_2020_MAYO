<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Diccionario</title>
</head>
<body>
	<ul>
	<c:forEach items="${diccionario}" var="par">
		<li>${par.key}: ${par.value}</li>
	</c:forEach>
	</ul>
</body>
</html>