<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1>Casa</h1>

<%-- <pre>${casa}</pre> --%>

<!-- ${casa} -->

<form action="casa" method="post" class="needs-validation" novalidate>
	<input type="hidden" name="id" value="${casa.id}" />

	<div class="form-group row">
		<label for="provincia" class="col-sm-2 col-form-label">Provincia</label>
		<div class="col-sm-10">
			<input class="form-control" name="provincia" id="provincia"
				value="${casa.provincia}" />
		</div>
	</div>

	<div class="form-group row">
		<label for="codigopostal" class="col-sm-2 col-form-label">Código
			Postal</label>
		<div class="col-sm-10">
			<input pattern="\d{5}" maxlength="5" class="form-control"
				name="codigopostal" id="codigopostal" value="${casa.codigoPostal}" />
			<div class="invalid-feedback">El código postal tiene que ser cinco dígitos</div>
		</div>
	</div>
	<div class="form-group row">
		<label for="direccion" class="col-sm-2 col-form-label">Dirección</label>
		<div class="col-sm-10">
			<input class="form-control" name="direccion" id="direccion"
				value="${casa.direccion}" />
		</div>
	</div>
	<div class="form-group row">
		<label for="numero" class="col-sm-2 col-form-label">Número</label>
		<div class="col-sm-10">
			<input class="form-control" name="numero" id="numero"
				value="${casa.numero}" />
		</div>
	</div>
	<div class="form-group row">
		<label for="piso" class="col-sm-2 col-form-label">Piso</label>
		<div class="col-sm-10">
			<input class="form-control" name="piso" id="piso"
				value="${casa.piso}" />
		</div>
	</div>
	<div class="form-group row">
		<label for="puerta" class="col-sm-2 col-form-label">Puerta</label>
		<div class="col-sm-10">
			<input class="form-control" name="puerta" id="puerta"
				value="${casa.puerta}" />
		</div>
	</div>
	<div class="form-group row">
		<div class="offset-sm-2 col-sm-10">
			<button class="btn btn-primary">Aceptar</button>
			<a class="btn btn-danger" href="listado">Cancelar</a>
		</div>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>

<script>
	// Example starter JavaScript for disabling form submissions if there are invalid fields
	(function() {
		'use strict';
		window.addEventListener('load', function() {
			// Fetch all the forms we want to apply custom Bootstrap validation styles to
			var forms = document.getElementsByClassName('needs-validation');
			// Loop over them and prevent submission
			var validation = Array.prototype.filter.call(forms, function(form) {
				form.addEventListener('submit', function(event) {
					if (form.checkValidity() === false) {
						event.preventDefault();
						event.stopPropagation();
					}
					form.classList.add('was-validated');
				}, false);
			});
		}, false);
	})();
</script>
