<%-- Comentario de JSP --%>
<%@ page import="java.util.*,java.text.*" %><%--Directiva de página para importar paquetes --%>
<%! // Incrustación de código dentro de la clase generada, pero fuera de los métodos
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
	<% for(int i = 1; i <= 6; i++) { %> <%-- Incrustación de sentencias Java --%>
		<h<%=i%>>JSP <%= hoy() %></h<%=i%>> <%-- Incrustación de expresiones Java (out.print(expresión);) --%>
	<% } %>
</body>
</html>

