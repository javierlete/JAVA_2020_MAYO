<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado productos</title>
</head>
<body>
	<h1>Tienda virtual</h1>
	<section>
		<h2>Productos</h2>

		<c:forEach items="${productos}" var="producto">
			<article>
				<h3>${producto.nombre}</h3>
				<img src="productosimgs/${producto.foto != null ? producto.foto : '_sinfoto.jpg'}" />
				<p>${producto.precio}</p>
			</article>
		</c:forEach>
	</section>
	
	<footer>
		Créditos: 
		<a href="https://www.freepik.es/fotos/negocios">Foto de Negocios creado por freepik - www.freepik.es</a>
	</footer>
</body>
</html>