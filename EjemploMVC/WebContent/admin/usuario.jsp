<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mantenimiento de usuario</title>
</head>
<body>

	<form action="index.jsp">
		<div>
			<label for="id">ID</label>
			<input name="id" id="id" readonly />
		</div>
		<div>
			<label for="email">Email</label>
			<input type="email" name="email" id="email" />
		</div>
		<div>
			<label for="password">Contraseña</label>
			<input type="password" name="password" id="password" />
		</div>
		<div>
			<button>Aceptar</button>
		</div>
	</form>
</body>
</html>