<%-- Comentario de JSP --%>
<%@ page import="java.util.*,java.text.*" %><%--Directiva de p�gina para importar paquetes --%>
<%! // Incrustaci�n de c�digo dentro de la clase generada, pero fuera de los m�todos
private String hoy() {
	Date d = new Date();
	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	return formato.format(d);
}
%>
<!DOCTYPE html> <%-- out.write("texto escrito"); --%>
<html lang="es">
<head>
<title>Demo de JSP</title>
</head>
<body>
	<% for(int i = 1; i <= 6; i++) { %> <%-- Incrustaci�n de sentencias Java --%>
		<h<%=i%>>JSP <%= hoy() %></h<%=i%>> <%-- Incrustaci�n de expresiones Java (out.print(expresi�n);) --%>
	<% } %>
</body>
</html>

