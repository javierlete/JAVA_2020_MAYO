<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parámetros múltiples</title>
</head>
<body>

	<form action="parametrosmultiples">
		<c:forEach begin="1" end="10" var="contador">
			<input name="par${contador}" />
		</c:forEach>

		<button>Enviar</button>
	</form>

</body>
</html>