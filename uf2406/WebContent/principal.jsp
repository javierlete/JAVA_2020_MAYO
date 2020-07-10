<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- https://repo1.maven.org/maven2/jstl/jstl/1.2/jstl-1.2.jar --%>
<%-- Colocar en WEB-INF/lib --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenido</title>
</head>
<body>
	<h1>Bienvenido 
		<c:if test="${email != null}">
			usuario ${email}
		</c:if>
	a la tienda</h1>
	
	<h2>
		<c:choose>
			<c:when test="${email != null}">Usuario registrado ${email}</c:when>
			<c:otherwise>Usuario anónimo</c:otherwise>
		</c:choose>
	</h2>
	
	<ul>
		<c:forEach items="${productos}" var="producto">
			<li>${producto}</li>
		</c:forEach>
	</ul>
</body>
</html>
