<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="admin/usuario" method="post" class="needs-validation"
	novalidate>
	<div class="form-group row">
		<label for="id" class="col-sm-3 col-form-label">ID</label>
		<div class="col-sm-9">
			<input class="form-control" name="id" id="id" value="${usuario.id}"
				readonly />
		</div>
	</div>
	<div class="form-group row">
		<label for="email" class="col-sm-3 col-form-label">Email</label>
		<div class="col-sm-9">
			<input class="form-control ${alertanivel == 'danger' && alertamensaje.indexOf('email') >= 0 ? 'is-invalid' : '' }" type="email" name="email" id="email"
				value="${usuario.email}" required />
			<div class="invalid-feedback">Es obligatorio introducir un email y debe tener al menos una arroba</div>
		</div>
	</div>
	<div class="form-group row">
		<label for="password" class="col-sm-3 col-form-label">Contraseña</label>
		<div class="col-sm-9">
			<input class="form-control" type="password" name="password"
				id="password" value="${usuario.password}" required />
						<div class="invalid-feedback">Es obligatorio introducir una contraseña</div>
			<!-- No se debe dejar normalmente una contraseña en un interfaz gráfico -->
		</div>
	</div>
	<div>
		<button class="btn btn-primary">Aceptar</button>
		<a class="btn btn-warning" href="admin/index">Cancelar</a>
	</div>
</form>

<script>
	//Example starter JavaScript for disabling form submissions if there are invalid fields
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
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
