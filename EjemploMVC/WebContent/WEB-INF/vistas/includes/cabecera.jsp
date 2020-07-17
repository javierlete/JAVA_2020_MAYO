<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<base href="${pageContext.request.contextPath}/" />
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>EjemploMVC</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css" />
<!-- FontAwesome -->
<link rel="stylesheet" href="css/all.min.css" />
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
		<a class="navbar-brand" href="#">EjemploMVC</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="${pageContext.request.contextPath}/index">Principal <span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/index">Administración</a>
				</li>
			</ul>
		</div>
	</nav>
	<c:if test="${alertamensaje != null}">
		<div class="alert alert-${alertanivel} alert-dismissible fade show"
			role="alert">
			${alertamensaje}
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>
	<main class="container-fluid">