<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1>Inmobiliaria Casas</h1>

<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover table-sm">
		<thead class="thead-dark">
			<tr>
				<th>Id</th>
				<th>Provincia</th>
				<th>Código Postal</th>
				<th>Dirección</th>
				<th>Número</th>
				<th>Piso</th>
				<th>Puerta</th>
				<th>Opciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${casas}" var="casa">
				<%-- for(Casa casa: request.getAttribute("casas")) --%>
				<tr>
					<td>${casa.id}</td>
					<%-- casa.getId() --%>
					<td>${casa.provincia}</td>
					<td>${casa.codigoPostal}</td>
					<td>${casa.direccion}</td>
					<td>${casa.numero}</td>
					<td>${casa.piso}</td>
					<td>${casa.puerta}</td>
					<td><a class="btn btn-primary" href="casa?id=${casa.id}">Modificar</a>
						<a data-toggle="modal" data-target="#confirmarBorrado"
						class="btn btn-danger" data-id="${casa.id}">Borrar</a></td>
					<%-- <a onclick="return confirm('¿Estás seguro de que quieres borrar el registro id = ${casa.id}?')" class="btn btn-danger" href="borrar?id=${casa.id}">Borrar</a> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<a class="btn btn-primary" href="casa">Añadir</a>

<!-- Modal -->
<div class="modal fade" id="confirmarBorrado" data-backdrop="static"
	data-keyboard="false" tabindex="-1"
	aria-labelledby="confirmarBorradoLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="staticBackdropLabel">Borrado de
					registro</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">Cancelar</button>
				<a href="" class="btn btn-danger">Borrar</a>
			</div>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>

<script>
	$(function() {
		// Cuando el modal cuyo id es confirmarBorrado se muestre, se ejecutará esta función
		$('#confirmarBorrado').on('show.bs.modal', function(event) {
			var a = $(event.relatedTarget); // Enlace que ha lanzado el modal
			var id = a.data('id'); // Extraemos el id de data-id

			var modal = $(this); // Apuntamos al propio modal
			modal.find('.modal-footer a')[0].href = 'borrar?id=' + id; // Rellenamos el enlace con su id

			// Rellenamos el texto del mensaje con su id
			modal.find('.modal-body')[0].innerHTML = '¿Estás seguro de que quieres borrar el registro id=' + id + '?';
		});
	});
</script>
