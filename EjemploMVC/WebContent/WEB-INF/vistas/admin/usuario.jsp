<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

	<form action="usuario" method="post">
		<div>
			<label for="id">ID</label>
			<input name="id" id="id" value="${usuario.id}" readonly />
		</div>
		<div>
			<label for="email">Email</label>
			<input type="email" name="email" id="email" value="${usuario.email}"/>
		</div>
		<div>
			<label for="password">Contraseña</label>
			<input type="password" name="password" id="password" value="${usuario.password}" /> <!-- No se debe dejar normalmente una contraseña en un interfaz gráfico -->
		</div>
		<div>
			<button>Aceptar</button>
		</div>
	</form>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>
