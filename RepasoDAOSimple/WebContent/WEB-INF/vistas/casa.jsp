<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Casa</title>

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
	<h1>Casa</h1>

	<form action="casa" method="post">
		<div class="form-group row">
			<label for="provincia" class="col-sm-2 col-form-label">Provincia</label>
			<div class="col-sm-10">
				<input class="form-control" name="provincia" id="provincia" />
			</div>
		</div>

		<div class="form-group row">
			<label for="codigopostal" class="col-sm-2 col-form-label">Código
				Postal</label>
			<div class="col-sm-10">
				<input class="form-control" name="codigopostal" id="codigopostal" />
			</div>
		</div>
		<div class="form-group row">
			<label for="direccion" class="col-sm-2 col-form-label">Dirección</label>
			<div class="col-sm-10">
				<input class="form-control" name="direccion" id="direccion" />
			</div>
		</div>
		<div class="form-group row">
			<label for="numero" class="col-sm-2 col-form-label">Número</label>
			<div class="col-sm-10">
				<input class="form-control" name="numero" id="numero" />
			</div>
		</div>
		<div class="form-group row">
			<label for="piso" class="col-sm-2 col-form-label">Piso</label>
			<div class="col-sm-10">
				<input class="form-control" name="piso" id="piso" />
			</div>
		</div>
		<div class="form-group row">
			<label for="puerta" class="col-sm-2 col-form-label">Puerta</label>
			<div class="col-sm-10">
				<input class="form-control" name="puerta" id="puerta" />
			</div>
		</div>
		<div class="form-group row">
			<div class="offset-sm-2 col-sm-10">
				<button class="btn btn-primary">Aceptar</button>
			</div>
		</div>
	</form>

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