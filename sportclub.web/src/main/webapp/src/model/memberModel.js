/* ========================================================================
 * Copyright 2014 monitor
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 monitor
 
 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
 
 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.
 
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.
 * ========================================================================
 
 
 Source generated by CrudMaker version 1.0.0.201408112050
 
 */
define(['model/_memberModel'], function() {
    App.Model.MemberModel = App.Model._MemberModel.extend({
        validate: function(attrs, options) {
            var validationMessage = "";
            if (!attrs.name) {
                validationMessage = "Debe llenar todos los campos! falta name";
            }
            if (!attrs.firstName) {
                validationMessage = "Debe llenar todos los campos! falta first name";
            }

            if (!attrs.lastName) {
                validationMessage = "Debe llenar todos los campos! falta first name";
            }
            if (!attrs.birthDate) {
                validationMessage = "Debe llenar todos los campos! falta birth date";
            }
            if (!attrs.docNumber) {
                validationMessage = "Debe llenar todos los campos! falta doc number";
            }

            if (!attrs.documenttypeId) {
                validationMessage = "Debe llenar todos los campos! falta document type id ";
            }

            if (!attrs.partnerId) {
                validationMessage = "Debe llenar todos los campos! falta partner Id ";

            }
            if (attrs.docNumber.length < 5) {
                validationMessage = "El numero de documento debe tener m�s de 5 caracteres! ";
            }


            var fecha = attrs.birthDate;
            var valores = fecha.split("/");
            var anio = valores[2];
            var mes = valores[1];
            var dia = valores[0];
            var fechaActual = new Date();
            var diaActual = fechaActual.getDate();
            var m = fechaActual.getMonth();
            var mesActual = m + 1;
            var a = fechaActual.getYear();
            var anioActual = a + 1900;
            var chisteAnualActual = anioActual * 365;
            var chisteAnualNacimiento = anio * 365;
            var chisteMensualActual = mesActual * 30;
            var chisteMensualNacimiento = mes * 30;
            var chisteDiarioActual = diaActual;
            //todo este juego de variables es por culpa del d�a.... no se deja sumar bien.
            var d = dia.toString();
            var chisteDiarioNacimiento = parseInt(d);
            var tiempoActualDias = chisteAnualActual + chisteMensualActual + chisteDiarioActual;
            var tiempoNacimientoDias = chisteAnualNacimiento + chisteMensualNacimiento + chisteDiarioNacimiento;
            var edadDias = tiempoActualDias - tiempoNacimientoDias;
            var cienAniosenDias = 100 * 365;

            if (edadDias > cienAniosenDias) {
                validationMessage = "No es saludable hacer ejercicio a esa edad!";

            }
            if(edadDias===0){
               validationMessage = "Un recien nacido no deber�a estar aqu�!";
            }
            if(edadDias<0){
               validationMessage = "No se permiten mienbros del futuro!";
              
            } 

            if (validationMessage.length > 0) {
                return validationMessage;
            }


        }

    });

    App.Model.MemberList = App.Model._MemberList.extend({
        model: App.Model.MemberModel
    });

    return  App.Model.MemberModel;

});