/*jslint browser: true, plusplus: true*/
/*global alert, console, prompt, document, window*/
/*eslint no-console:off*/

/* eslint-disable no-unused-vars */
function demo1() {
    'use strict';

    var nombre, sNumero, numero, esTexto;

    alert('Hola DOM (Document Object Model)');

    nombre = prompt('Dime tu nombre');

    console.log('Hola ' + nombre);

    sNumero = prompt('Dime un número');

    console.log(typeof sNumero);

    numero = parseInt(sNumero, 10);

    esTexto = isNaN(numero);

    if (esTexto) {
        console.error('La próxima vez introduce un número, listo');
    } else if (numero === 5) {
        console.log('¡Te ha tocado el premio!');
    }
}

function arrays() {
    'use strict';

    var clave, i, arr = []; //new Array(2); //[1, 2];

    arr[0] = 10;
    arr[1] = 20;
    arr[2] = 30;
    arr[5] = 50;

    //arr['nombre'] = 'Javier';
    arr.nombre = 'Javier';

    arr[8] = 'Pepe';

    arr.push(123);

    console.log(arr);

    console.log(arr[4]);

    console.log(arr[20]);

    console.log(arr.length);

    //console.log(arr['nombre']);

    console.log(arr.nombre);

    for (i = 0; i < arr.length; i++) {
        console.log(i, arr[i]);
    }

    for (clave in arr) {
        if (arr.hasOwnProperty(clave)) {
            console.log(clave, arr[clave]);
        }
    }
}

/* eslint-enable no-unused-vars */

/*
var botonSaludarClick = function () {
    'use strict';
    alert('Botón pulsado');
};

function alCargarDocumento() {
    'use strict';
    var botonSaludar = document.getElementsByTagName('button')[0];

    botonSaludar.onclick = botonSaludarClick;
}

window.onload = alCargarDocumento;
*/

window.onload = function () {
    'use strict';

    var botonSaludar, cuantos, i, li, lis, p; //, error;

    lis = document.getElementsByTagName('li');

    //for(var li of lis) {

    for (i = 0; i < lis.length; i++) {
        li = lis[i];
        console.log(li.innerHTML);
    }

    cuantos = lis.length;

    document.getElementsByTagName('p')[0].innerHTML += ' (' + cuantos + ')';

    botonSaludar = document.getElementsByTagName('button')[0];

    botonSaludar.onclick = function (e) {
        var label, input;

        e.preventDefault(); //Deshabilita la propagación del evento

        label = document.getElementsByTagName('label')[0];
        input = document.getElementsByTagName('input')[0];

        //error = document.getElementsByClassName('error')[0];
        
        if (input.value.trim().length) { //Si está rellenado
            if (input.error) { //Si hay error
                input.error.remove(); //Quitamos el error de pantalla
                delete input.error; //Quitamos la referencia al error en el input
                
                input.className = ''; //Vaciamos la clase de error, lo que quita el color rojo del cuadro
            }
        } else { //El texto está vacío
            if (!input.error) { //No hay error previo
                p = document.createElement('p'); //Creamos un elemento de tipo párrafo (p)

                p.innerHTML = 'Al menos introduce un nombre, majete'; //Rellenamos el contenido del párrafo
                p.className = 'error'; //Le ponemos un aspecto de error con la clase error

                document.forms[0].appendChild(p); //Agregamos el elemento después del último del formulario
                
                input.error = p; //Asociamos el párrafo de error al input por un atributo nuevo inventado por nosotros llamado error
                input.className = 'error'; //Ponemos la clase error al input para que se vea con un cuadro rojo
            }
        }

        label.innerHTML = 'Hola ' + input.value;
        //return false; //Deshabilita la propagación del evento
    };
};

//arrays();
//demo1();
