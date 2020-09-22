<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="es">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<base href="${pageContext.servletContext.contextPath}/" /> <%--/mf0227 --%>

<!-- 
URL = http://localhost:8081/mf0227/admin/index.html
<a href="detalles.html">...

SIN BASE
DESTINO = http://localhost:8081/mf0227/admin/ + detalles.html

CON BASE
<base href="/mf0227/" />
DESTINO = http://localhost:8081/mf0227/ + detalles.html

 -->

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<title>Libros</title>
</head>
<body class="container">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Libros</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="index.jsp">Inicio</a>
				</li>
			</ul>
			<form class="form-inline my-2 my-lg-0" action="login" method="post">
				<label class="sr-only" for="usuario">Usuario</label> <input
					type="text" class="form-control mb-2 mr-sm-2" id="usuario"
					placeholder="Usuario" name="usuario"> <label
					class="sr-only" for="password">Contraseña</label> <input
					type="password" class="form-control mb-2 mr-sm-2" id="password"
					placeholder="Contraseña" name="password">

				<button type="submit" class="btn btn-primary mb-2">Login</button>
			</form>
		</div>
	</nav>
	<c:if test="${error != null}">
		<div class="alert alert-danger alert-dismissible fade show"
			role="alert">
			${error}
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>
	<div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 row-cols-xl-4">
		<div class="col mb-4">
			<div class="card">
				<img src="http://placeimg.com/320/240/people?1" class="card-img-top"
					alt="...">
				<div class="card-body">
					<h5 class="card-title">Cómo ser feliz</h5>
					<p class="card-text">Con este libro serás más feliz que una
						perdiz</p>
					<a class="btn btn-primary" href="detalles.html">Más información</a>
				</div>
			</div>
		</div>
		<div class="col mb-4">
			<div class="card">
				<img src="http://placeimg.com/320/240/people?2" class="card-img-top"
					alt="...">
				<div class="card-body">
					<h5 class="card-title">Cómo andar en bici</h5>
					<p class="card-text">Ese medio tan necesario y tan poco
						utilizado...</p>
				</div>
			</div>
		</div>
		<div class="col mb-4">
			<div class="card">
				<img src="http://placeimg.com/320/240/people?3" class="card-img-top"
					alt="...">
				<div class="card-body">
					<h5 class="card-title">Cómo limpiar cacas de perro</h5>
					<p class="card-text">Muy necesario ya que se ve que la gente no
						sabe.</p>
				</div>
			</div>
		</div>
		<div class="col mb-4">
			<div class="card">
				<img src="http://placeimg.com/320/240/people?4" class="card-img-top"
					alt="...">
				<div class="card-body">
					<h5 class="card-title">Cómo ser un asesino en serie</h5>
					<p class="card-text">Uso de motosierras, cuchillos, y todo tipo
						de armas.</p>
				</div>
			</div>
		</div>
		<div class="col mb-4">
			<div class="card">
				<img src="http://placeimg.com/320/240/people?5" class="card-img-top"
					alt="...">
				<div class="card-body">
					<h5 class="card-title">Cómo ser feliz</h5>
					<p class="card-text">Con este libro serás más feliz que una
						perdiz</p>
				</div>
			</div>
		</div>
		<div class="col mb-4">
			<div class="card">
				<img src="http://placeimg.com/320/240/people?6" class="card-img-top"
					alt="...">
				<div class="card-body">
					<h5 class="card-title">Cómo andar en bici</h5>
					<p class="card-text">Ese medio tan necesario y tan poco
						utilizado...</p>
				</div>
			</div>
		</div>
		<div class="col mb-4">
			<div class="card">
				<img src="http://placeimg.com/320/240/people?7" class="card-img-top"
					alt="...">
				<div class="card-body">
					<h5 class="card-title">Cómo limpiar cacas de perro</h5>
					<p class="card-text">Muy necesario ya que se ve que la gente no
						sabe.</p>
				</div>
			</div>
		</div>
		<div class="col mb-4">
			<div class="card">
				<img src="http://placeimg.com/320/240/people?8" class="card-img-top"
					alt="...">
				<div class="card-body">
					<h5 class="card-title">Cómo ser un asesino en serie</h5>
					<p class="card-text">Uso de motosierras, cuchillos, y todo tipo
						de armas.</p>
				</div>
			</div>
		</div>
		<div class="col mb-4">
			<div class="card">
				<img src="http://placeimg.com/320/240/people?9" class="card-img-top"
					alt="...">
				<div class="card-body">
					<h5 class="card-title">Cómo ser feliz</h5>
					<p class="card-text">Con este libro serás más feliz que una
						perdiz</p>
				</div>
			</div>
		</div>
		<div class="col mb-4">
			<div class="card">
				<img src="http://placeimg.com/320/240/people?10"
					class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Cómo andar en bici</h5>
					<p class="card-text">Ese medio tan necesario y tan poco
						utilizado...</p>
				</div>
			</div>
		</div>
		<div class="col mb-4">
			<div class="card">
				<img src="http://placeimg.com/320/240/people?11"
					class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Cómo limpiar cacas de perro</h5>
					<p class="card-text">Muy necesario ya que se ve que la gente no
						sabe.</p>
				</div>
			</div>
		</div>
		<div class="col mb-4">
			<div class="card">
				<img src="http://placeimg.com/320/240/people?12"
					class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Cómo ser un asesino en serie</h5>
					<p class="card-text">Uso de motosierras, cuchillos, y todo tipo
						de armas.</p>
				</div>
			</div>
		</div>
	</div>

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