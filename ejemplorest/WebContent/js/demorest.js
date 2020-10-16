'use strict';

window.onload = function() {
	//alert('Página cargada');
	
	fetch('http://localhost:8081/ejemplorest/api/muebles/')
		.then(respuesta => respuesta.json())
		.then(muebles => console.log(muebles));
		
	pedirListado();
};

// JS2017
async function pedirListado() {
	const respuesta = await fetch('http://localhost:8081/ejemplorest/api/muebles/');
	
	console.log('respuesta', respuesta);
	
	const muebles = await respuesta.json();
	
	console.log('muebles', muebles);
	
	console.log(muebles[0]);
	
	mueblesATabla(muebles);
}

function mueblesATabla(muebles) {
	const tbody = document.getElementsByTagName('tbody')[0];
	
	//console.log(tbody);
	
	let tr;
		
	for(let mueble of muebles) {
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














