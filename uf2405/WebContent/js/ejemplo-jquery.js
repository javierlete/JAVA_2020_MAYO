/*jslint browser: true, plusplus: true*/
/*global $, console*/
/*eslint no-console:off*/

/* eslint-disable no-unused-vars */

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

    for (i = 0; i < arr.length; i++) {
        console.log(i, arr[i]);
    }

    for (clave in arr) {
        if (arr.hasOwnProperty(clave)) {
            console.log(clave, arr[clave]);
        }
    }

    $(arr).each(function (i) {
        console.log(i, this);
    });
}

$(function () {
    'use strict';

    $('form:last').slideUp(1000); //.hide();
    
    var cuantos;

    cuantos = $('li').each(function () {
        console.log(this.innerHTML);
    }).length;

    $('p')[0].innerHTML += ' (' + cuantos + ')';

    //$('p').html($('p').html() + ' (' + cuantos + ')');

    $('button:first').click(function (e) {
        var $input;

        e.preventDefault();

        $input = $('input:first');

        if ($input.val().trim()) {
            if ($input[0].error) {
                $input[0].error.remove();
                delete $input[0].error;

                $input.removeClass('error');
            }
        } else {
            if (!$input[0].error) {

                $input.addClass('error')[0].error = $('<p>')
                    .html('Al menos introduce un nombre, majete')
                    .addClass('error')
                    .appendTo('form:first')[0];
            }
        }

        $('label').html('Hola ' + $input.val());
    });
});

//arrays();
//demo1();
