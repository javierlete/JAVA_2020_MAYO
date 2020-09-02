<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- Necesitamos WEB-INF/lib/jstl-1.2.jar para poder tener la biblioteca de etiquetas de c:forEach --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Inmobiliaria Casas</title>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

</head>
<body class="container">
	<h1>Inmobiliaria Casas</h1>

	<div class="table-responsive">
		<table class="table table-striped table-bordered table-hover table-sm">
			<thead class="thead-dark">
				<tr>
					<th>Id</th>
					<th>Provincia</th>
					<th>Código Postal</th>
					<th>Dirección</th>
					<th>Número</th>
					<th>Piso</th>
					<th>Puerta</th>
					<th>Opciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${casas}" var="casa">
					<%-- for(Casa casa: request.getAttribute("casas")) --%>
					<tr>
						<td>${casa.id}</td>
						<%-- casa.getId() --%>
						<td>${casa.provincia}</td>
						<td>${casa.codigoPostal}</td>
						<td>${casa.direccion}</td>
						<td>${casa.numero}</td>
						<td>${casa.piso}</td>
						<td>${casa.puerta}</td>
						<td><a class="btn btn-primary" href="modificar?id=${casa.id}">Modificar</a>
							<a class="btn btn-danger" href="borrar?id=${casa.id}">Borrar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<a class="btn btn-primary" href="casa">Añadir</a>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
</body>
</html>