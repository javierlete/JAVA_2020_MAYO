<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio sesión usuario</title>
</head>
<body>
	<h1>Inicio sesión usuario</h1>
	
	<form action="login">
		<input type="email" name="email" placeholder="Email" value="${param.email}" />
		<input type="password" name="password" placeholder="Password" />
		<button>Inicio sesión</button>
	</form>
	<p>${error}</p> <%-- Busca en ámbito: page, request, session, application --%>
</body>
</html>
