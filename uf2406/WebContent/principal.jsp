<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenido</title>
</head>
<body>
	<h1>Bienvenido ${email} a la zona para usuarios registrados</h1>
	<%-- <h1><%= session.getAttribute("email") %></h1> --%>
	
	<ul>
		<% 
		@SuppressWarnings("unchecked")
		List<String> productos = (List<String>)application.getAttribute("productos");
		if(productos != null) {
			for(String producto: productos) { 
		%>
				<li><%=producto %></li>
		<%
			}
		} 
		%>
	</ul>
</body>
</html>
