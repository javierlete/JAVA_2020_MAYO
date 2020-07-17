<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

	<form action="admin/usuario" method="post">
		<div class="form-group row">
			<label for="id" class="col-sm-3 col-form-label">ID</label>
			<div class="col-sm-9">
				<input class="form-control" name="id" id="id" value="${usuario.id}" readonly />
			</div>
		</div>
		<div class="form-group row">
			<label for="email" class="col-sm-3 col-form-label">Email</label>
			<div class="col-sm-9">
				<input class="form-control" type="email" name="email" id="email" value="${usuario.email}"/>
			</div>
		</div>
		<div class="form-group row">
			<label for="password" class="col-sm-3 col-form-label">Contraseña</label>
			<div class="col-sm-9">
				<input class="form-control" type="password" name="password" id="password" value="${usuario.password}" /> <!-- No se debe dejar normalmente una contraseña en un interfaz gráfico -->
			</div>
		</div>
		<div>
			<button class="btn btn-primary">Aceptar</button>
			<a class="btn btn-warning" href="admin/index">Cancelar</a>
		</div>
	</form>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>
