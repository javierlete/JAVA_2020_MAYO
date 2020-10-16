'use strict';

window.onload = function() {
	//alert('Página cargada');

	const btnInsertar = document.getElementById('btn-insertar');

	btnInsertar.onclick = btnInsertarOnClick;

//	console.log('Antes del fetch');
//
//	fetch('http://localhost:8081/ejemplorest/api/muebles/')
//		.then(respuesta => {
//			console.log('RESPUESTA');
//			return respuesta.json()
//		})
//		.then(muebles => console.log('MUEBLES', muebles));
//
//	console.log('Después del fetch');

	pedirListado();
};

const URL = 'http://localhost:8081/ejemplorest/api/muebles/';

function btnInsertarOnClick(e) {
	e.preventDefault();

	const mueble = {};

	mueble.nombre = document.getElementById('nombre').value;
	mueble.largo = document.getElementById('largo').value;
	mueble.ancho = document.getElementById('ancho').value;
	mueble.alto = document.getElementById('alto').value;

	console.log(mueble);

	insertar(mueble);
}

// JS2017
async function pedirListado() {
	const respuesta = await fetch(URL);

	console.log('respuesta', respuesta);

	const muebles = await respuesta.json();

	console.log('muebles', muebles);

	console.log(muebles[0]);

	mueblesATabla(muebles);
}

// Ejemplo implementando el metodo POST:
// https://developer.mozilla.org/es/docs/Web/API/Fetch_API/Utilizando_Fetch

async function insertar(mueble) {
	// Opciones por defecto estan marcadas con un *
	const response = await fetch(URL, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(mueble)
	});

	console.log(response);
	
	pedirListado();
}


function mueblesATabla(muebles) {
	const tbody = document.getElementsByTagName('tbody')[0];

	tbody.innerHTML = '';

	//console.log(tbody);

	let tr;

	for (let mueble of muebles) {
		console.log(mueble);

		tr = document.createElement('tr');

		tr.innerHTML = `
			<th>${mueble.id}</th>
			<td>${mueble.nombre}</td>
			<td>${mueble.largo}</td>
			<td>${mueble.ancho}</td>
			<td>${mueble.alto}</td>
		`;

		console.log(tr);

		tbody.append(tr);
	}
}














