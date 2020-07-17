<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<h2>Listado de usuarios</h2>

<ul>
	<c:forEach items="${usuarios}" var="usuario">
		<li>${usuario.email}</li>
	</c:forEach>
</ul>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>