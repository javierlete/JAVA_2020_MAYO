<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Producto</title>
</head>
<body>

<form action="insertarproducto" method="post" enctype="multipart/form-data">
	<div>
		<label for="nombre">Nombre</label>
		<input name="nombre" id="nombre" />
	</div>
	<div>
		<label for="precio">Precio</label>
		<input type="number" step=".01" name="precio" id="precio" />
	</div>
	<div>
		<label for="foto">Foto</label>
		<input type="file" name="foto" id="foto" />
	</div>
	<div>
		<button>Aceptar</button>
	</div>
</form>
</body>
</html>