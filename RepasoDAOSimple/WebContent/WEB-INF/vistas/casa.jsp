<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

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

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>