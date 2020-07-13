<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<fmt:setLocale value="es_ES"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tienda virtual</title>
</head>
<body>
	<h1>Tienda virtual</h1>

	<jsp:useBean id="ahora" class="java.util.Date" />
	<p>Fecha actual <fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${ahora}"/> <fmt:formatDate dateStyle="medium" value="${ahora}"/> <fmt:formatDate value="${ahora}" pattern="yyyy-MMM.-dd HH:mm:ss" /></p>
	
	<c:choose>
		<c:when test="${favorito != null}">
			<h2>Tu favorito es ${favorito}</h2>
		</c:when>
		<c:otherwise>
			<h2>Selecciona tu favorito</h2>
		</c:otherwise>
	</c:choose>

	<form action="favorito">
		<select name="producto">
			<option>Sin favorito</option>
			<c:forEach items="${productos}" var="producto">
				<!-- ${producto} ${favorito} ${producto == favorito} ${producto == favorito ? "selected" : ""} -->
				<option ${producto == favorito ? "selected" : ""}
					value="${producto}">${producto}</option>
			</c:forEach>
		</select>

		<button>Fijar favorito</button>
	</form>

	<h2>Listado de productos disponibles</h2>

	<ul>
		<c:forEach items="${productos}" var="producto">
			<li><a href="carrito?producto=${producto}">${producto}</a>

				<form action="carrito">
					<input type="hidden" name="producto" value="${producto}" />
					<button>${producto}</button>
				</form></li>
		</c:forEach>
	</ul>
	
	<p>Total de productos: ${fn:length(productos)} <fmt:formatNumber pattern="#0,000.00#" value="${productos.size()}" /> <fmt:formatNumber type="currency" value="123412341234.5" /></p>

	<p>
		<a href="carrito">Ver carrito</a>
	</p>
</body>
</html>