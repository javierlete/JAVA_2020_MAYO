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

<base href="${pageContext.servletContext.contextPath}/" />
<%--/mf0227 --%>

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

<link rel="stylesheet" href="css/estilos.css" />

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
			<div class="ficha card-">
				<img
					src="data:image/jpeg;base64,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"
					class="card-img-top-" alt="...">
				<div class="ficha-texto card-body-">
					<div class="ficha-datos">
						<p class="titulo card-text-">Los futbolísimos. El misterio del
							jugador número 13 (T...</p>

						<p class="autor card-text-">Roberto Santiago</p>
						<p class="precios card-text-">
							<span class="precio">11<span class="decimales">,35€</span></span>
							<span class="precio-sin-descuento">11<span
								class="decimales">,95€</span></span> <span class="descuento">-5%</span>
						</p>
					</div>
					
					<div class="corazon card-text-">
						<%-- TODO Cambiar SVG por estilo que lo incluya--%>
						<svg width="1em" height="1em" viewBox="0 0 16 16"
							class="bi bi-heart" fill="currentColor"
							xmlns="http://www.w3.org/2000/svg">
 								<path fill-rule="evenodd"
								d="M8 2.748l-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z" />
						</svg>
					<div>
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