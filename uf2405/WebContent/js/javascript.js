/*jslint browser: true, plusplus: true*/
/*global alert, console, prompt*/
/*eslint no-console:off*/

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

//demo1();
arrays();
