$(document).ready(function () {

    $("li a ").on("click", function () {
        var lii = $(this).attr("id").substr(1, 5);
        var clali = $(this).attr("class").substr(9, 6);
        //       console.log("herf - class : ",lii , clali);
        if (clali != "active") {
            $.each($("#ul_nav_user li a"), function (key, value) {
                //             console.log(value,key);
                $("#amenu" + key).removeClass("active");
                $("#menu" + key).removeClass("active");

            });

            $("#a" + lii).addClass("active");
            $("#" + lii).addClass("active");
        }
    });

    $(function () {
        for (i = new Date().getFullYear(); i > 2010; i--)
        {
            $('#yearpicker').append($('<option />').val(i).html(i));
        }
        var anio = '2021';
        getDatosReporte(anio);

    });

//    $("#yearpicker").combobox({
//        select: function (event, ui) {
//            alert("the select event has fired!");
//        }
//    }
//    );

    $('#yearpicker').on('change', function () {
        getDatosReporte(this.value);
    });

    // TOMA LOS ID DE LOS ELEMENTOS DE LA PESTAÑA "menu1"
    function getDatosReporte(anio) {

        $.ajax({
            type: "post",
            url: "reportesservlet",
            data: {"id_anio": anio,
            },
            beforeSend: function (xhr) {

            },
            success: function (data, textStatus, jqXHR) {
                var datos = JSON.parse(data);
                proyectarDatos(anio, datos);
//                $(location).attr('href', 'http://localhost:8090/LogisticFV/clienteExtreno.jsp');
//                    $(location).attr('href', 'http://localhost:8090/LogisticFV/productor.jsp#menu0');
                //   var resp = JSON.parse(data);
                //   console.log(resp);
                // document.location.href = "views/inicio/inicio.php";


            },
            error: function (jqXHR, textStatus, errorThrown) {

            },

            complete: function (jqXHR, textStatus) {
                //document.location.href = "views/inicio/inicio.php";
            }

        });

    }

    var myChart;
    var myChart2;
    var myChart3;

    function proyectarDatos(anio, datos) {
        console.log(datos.data.length);
        var data = [];
        for (var i = 0; i < datos.data.length; i++) {
            data[i] = datos.data[i].perididaFruta;
        }
        console.log(data);

        const ctx = $('#frutasChart');
        if (myChart) {
            myChart.destroy();
        }
        myChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
                datasets: [{
                        label: 'Perdida de Fruta Por Mes Durante el Año: ' + anio,
                        data: data,
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.2)',
                            'rgba(54, 162, 235, 0.2)',
                            'rgba(255, 206, 86, 0.2)',
                            'rgba(75, 192, 192, 0.2)',
                            'rgba(153, 102, 255, 0.2)',
                            'rgba(255, 159, 64, 0.2)'
                        ],
                        borderColor: [
                            'rgba(255, 99, 132, 1)',
                            'rgba(54, 162, 235, 1)',
                            'rgba(255, 206, 86, 1)',
                            'rgba(75, 192, 192, 1)',
                            'rgba(153, 102, 255, 1)',
                            'rgba(255, 159, 64, 1)'
                        ],
                        borderWidth: 2,
                        lineTension: 0.25,
                    }]
            },
            options: {
                plugins: {
                    title: {
                        display: true,
                        text: 'Perdida de Fruta al Mes Durante el Año: ' + anio,
                        font: {
                            size: 32
                        }
                    }
                },
                scales: {
                    y: {
                        beginAtZero: true,
                        title: {
                            display: true,
                            text: 'Frutas',
                            font: {
                                size: 24
                            }
                        }
                    },
                    x: {
                        title: {
                            display: true,
                            text: 'Meses',
                            font: {
                                size: 24
                            }
                        }
                    }
                }
            }
        });

        var data2 = [];
        for (var i = 0; i < datos.data.length; i++) {
            data2[i] = datos.data[i].liquido;
        }
        console.log(data);

        const ctx2 = $('#ventasLiqChart');
        if (myChart2) {
            myChart2.destroy();
        }
        myChart2 = new Chart(ctx2, {
            type: 'line',
            data: {
                labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
                datasets: [{
                        label: 'Ganancia de Productores por Ventas de Producto Durante el Año: ' + anio,
                        data: data2,
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.2)',
                            'rgba(54, 162, 235, 0.2)',
                            'rgba(255, 206, 86, 0.2)',
                            'rgba(75, 192, 192, 0.2)',
                            'rgba(153, 102, 255, 0.2)',
                            'rgba(255, 159, 64, 0.2)'
                        ],
                        borderColor: [
                            'rgba(255, 99, 132, 1)',
                            'rgba(54, 162, 235, 1)',
                            'rgba(255, 206, 86, 1)',
                            'rgba(75, 192, 192, 1)',
                            'rgba(153, 102, 255, 1)',
                            'rgba(255, 159, 64, 1)'
                        ],
                        borderWidth: 2,
                        lineTension: 0.25,
                    }]
            },
            options: {
                plugins: {
                    title: {
                        display: true,
                        text: 'Ganancia de Productores por Ventas de Producto Durante el Año: ' + anio,
                        font: {
                            size: 32
                        }
                    }
                },
                scales: {
                    y: {
                        beginAtZero: true,
                        title: {
                            display: true,
                            text: 'Pesos',
                            font: {
                                size: 24
                            }
                        }
                    },
                    x: {
                        title: {
                            display: true,
                            text: 'Meses',
                            font: {
                                size: 24
                            }
                        }
                    }
                }
            }
        });

        var data3 = [];
        for (var i = 0; i < datos.data.length; i++) {
            data3[i] = datos.data[i].comision;
        }
        console.log(data);

        const ctx3 = $('#comisionChart');
        if (myChart3) {
            myChart3.destroy();
        }
        myChart3 = new Chart(ctx3, {
            type: 'line',
            data: {
                labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
                datasets: [{
                        label: 'Ganancia por Concepto de Comisiones Durante el Año: ' + anio,
                        data: data3,
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.2)',
                            'rgba(54, 162, 235, 0.2)',
                            'rgba(255, 206, 86, 0.2)',
                            'rgba(75, 192, 192, 0.2)',
                            'rgba(153, 102, 255, 0.2)',
                            'rgba(255, 159, 64, 0.2)'
                        ],
                        borderColor: [
                            'rgba(255, 99, 132, 1)',
                            'rgba(54, 162, 235, 1)',
                            'rgba(255, 206, 86, 1)',
                            'rgba(75, 192, 192, 1)',
                            'rgba(153, 102, 255, 1)',
                            'rgba(255, 159, 64, 1)'
                        ],
                        borderWidth: 2,
                        lineTension: 0.25,
                    }]
            },
            options: {
                plugins: {
                    title: {
                        display: true,
                        text: 'Ganancia por Concepto de Comisiones Durante el Año: ' + anio,
                        font: {
                            size: 32
                        }
                    }
                },
                scales: {
                    y: {
                        beginAtZero: true,
                        title: {
                            display: true,
                            text: 'Pesos',
                            font: {
                                size: 24
                            }
                        }
                    },
                    x: {
                        title: {
                            display: true,
                            text: 'Meses',
                            font: {
                                size: 24
                            }
                        }
                    }
                }
            }
        });


    }




//CODIGO QUE COLOCA LOS REGISTROS EN LA TABLA
    var tableR = "";
    function tableUsuarios() {
        $('#example').dataTable().fnClearTable();
        $('#example').dataTable().fnDestroy();


        tableR = $('#example').dataTable({

            scrollY: "500px",
            scrollX: true,
            scrollCollapse: true,
            paging: true,
            fixedColumns: {
                leftColumns: 2
            },
            "pageLength": 25,
            lengthMenu: [[25, 50], [25, 50]],
            "columnDefs": [
                {"targets": [0], "visible": true, "searchable": true},
            ],
            "language": {
                "sProcessing": "Procesando...",
                "sLengthMenu": "Mostrar _MENU_ registros",
                "sZeroRecords": "No se encontraron resultados",
                "sEmptyTable": "Ningún dato disponible en esta tabla",
                "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
                "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
                "sInfoPostFix": "",
                "sSearch": "Buscar:",
                "sUrl": "",
                "sInfoThousands": ",",
                "sLoadingRecords": "Cargando...",
                "oPaginate": {
                    "sFirst": "Primero",
                    "sLast": "Último",
                    "sNext": "Siguiente",
                    "sPrevious": "Anterior"
                },
                "oAria": {
                    "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                    "sSortDescending": ": Activar para ordenar la columna de manera descendente"
                }
            },
            "bProcessing": true,
            //"sAjaxSource": "../../controllers/pagosController.php",
            //"sAjaxDataProp": "demo",
            "ajax": {
                url: "solicitudservlet", // json datasource
                type: "post", // method  , by default get
                data: {"func": "tablaSolicitudes",
                    "type": 0},

            },
            "order": [[0, "desc"]],
            "bPaginate": true,
            "sPaginationType": "full_numbers",
            "iDisplayLength": 100,
            "aoColumns": [
                {mData: "ID"},
                {mData: "FechaSolicitud"},
                {mData: "Fruta"},
                {mData: "Calidad"},
                {mData: "Cantidad"},
                {mData: "Presupuesto"},
                {mData: "Embalaje"},
                {mData: "Actualizar"},
                {mData: "Borrar"},
            ],
            initComplete: function () {
                // Apply the search
                this.api().columns().every(function () {
                    var that = this;

                    $('input', this.header()).on('keyup change clear', function () {
                        if (that.search() !== this.value) {
                            that
                                    .search(this.value)
                                    .draw();
                        }
                    });
                });
            }



        });
    }

// TOMA LOS ID DE LOS ELEMENTOS DE LA PESTAÑA "menu1"
    $("#btn_envio_solicitud").on("click", function () {

        var salida = formulariosEnvioValida("divFormSolicitud");

        console.log("salida de la validacion del formulario", salida);
        if (salida !== false) {
            $.ajax({
                type: "post",
                url: "solicitudservlet",
                data: {"func": "crearSolicitud",
                    'id_fechaSolitud': salida["id_fechaSolitud"],
                    'id_fruta': salida["id_fruta_value"],
                    'id_calidad': salida["id_calidad_value"],
                    'id_cantidad': salida["id_cantidad"],
                    'id_presupuesto': salida["id_presupuesto"],
                    'id_embalaje': salida["id_embalaje"],
                },
                beforeSend: function (xhr) {

                },
                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                    $(location).attr('href', 'http://localhost:8090/LogisticFV/clienteExtreno.jsp');
//                    $(location).attr('href', 'http://localhost:8090/LogisticFV/productor.jsp#menu0');
                    //   var resp = JSON.parse(data);
                    //   console.log(resp);
                    // document.location.href = "views/inicio/inicio.php";
                },
                error: function (jqXHR, textStatus, errorThrown) {

                },

                complete: function (jqXHR, textStatus) {
                    //document.location.href = "views/inicio/inicio.php";
                }



            });
        } else {


        }

    });


    // ----------------------------captura de botones de actualizar y borrar------------------------------
    $("#example").on("click", "tr button", function () {
        var clic = $(this).attr("name");
        //   console.log("click : ",clic);
        setTimeout(function () {
            dataUsuarios(clic);
        }, 100);
    });
    var datausuario = [];

    $('#example tbody').on('click', 'tr', function () {
        var table = $('#example').DataTable();
        datausuario = table.row(this).data();

        var clic = $("document button").attr("name");
        //   console.log("cliock : ",clic);
        //   console.log("table : ", datausuario);
    });

    function dataUsuarios(tipo) {
        console.log("tipo", tipo);
        //PREPARA LOS DATOS DEL REGISTRO SELECCIONADO PARA MOSTRARLOS EN EL PANEL MODAL
        if (tipo == "actualizar") {
            formulariosValidaOrigen("divFormProducto_up");
            //    console.log("click : ",tipo);
            //    console.log("table : ", datausuario);
            $("#exampleModal").addClass("show").css("display", "block").removeAttr("aria-hidden").attr("aria-modal", "true");

            //OBTENER REGISTRO SELECCIONADO EN AJAX
            $.ajax({
                type: "post",
                url: "solicitudservlet",
                data: {"func": "llenarFormMod",
                    "id_idsolicitud": datausuario["ID"],
                },
                beforeSend: function (xhr) {

                },
                success: function (data, textStatus, jqXHR) {
//                    var resp = JSON.parse(data);
                    console.log(data);
                    $("#id_idSolicitud_up").val(data.idSolicitud);
                    $("#id_fechaSoli_up").val(data.fechaSoli);
                    $("#id_idFruta_up").val(data.idFruta);
                    $("#id_idCalidad_up").val(data.idCalidad);
                    $("#id_cantidad_up").val(data.cantidad);
                    $("#id_presupuesto_up").val(data.presupuesto);
                    $("#id_embalaje_up").val(data.embalaje);
                },
                error: function (jqXHR, textStatus, errorThrown) {

                },
                complete: function (jqXHR, textStatus) {

                }

            });

            //MUESTRA MODAL DE ELIMINAR REGISTRO
        } else if (tipo == "eliminar") {
            $("#modalmsnsn").addClass("show").css("display", "block").removeAttr("aria-hidden").attr("aria-modal", "true");
            $("#mdlbmsnsn").text("");
            $("#mdlbmsnsn").html("Seguro que desea eliminar el registro");

            $("#btn_mod_si").on("click", function () {
                console.log("hizo click en si : ", datausuario["ID"]);

                $.ajax({
                    type: "post",
                    url: "solicitudservlet",
                    data: {"func": "deleteSolicitud",
                        "id_idsolicitud_d": datausuario["ID"]},

                    beforeSend: function (xhr) {

                    },
                    success: function (data, textStatus, jqXHR) {
                        console.log(data);
                        $("#modalmsnsn").removeClass("show").css("display", "none").removeAttr("aria-modal").attr("aria-hidden", "true");
                        tableUsuarios();
                        $(location).attr('href', 'http://localhost:8090/LogisticFV/clienteExtreno.jsp');
                        //   var resp = JSON.parse(data);
                        //   console.log(resp);
                        // document.location.href = "views/inicio/inicio.php";
                    },
                    error: function (jqXHR, textStatus, errorThrown) {

                    },

                    complete: function (jqXHR, textStatus) {
                        //document.location.href = "views/inicio/inicio.php";
                    }



                });


            });// click en boton si
        }

    }


// -----------------funcionamiento de botones de modal modificar-----------------------------------
    $("#btn_mod_cerrar").on("click", function () {

        $("#exampleModal").removeClass("show").css("display", "none").removeAttr("aria-modal").attr("aria-hidden", "true");
    });

    $("#btn_mod_solicitud").on("click", function () {

        var salida = formulariosEnvioValida("divFormSolicitud_up");
        console.log("tag : ", salida);
        console.log("tag can : ", salida.length);
        var data = new FormData();
        data.append("func", "updateProducto");

        if (salida !== false) {
            console.log("entro al ajax");
            $.ajax({
                url: "solicitudservlet",
                type: "post",
                data: {"func": "updateSolicitud",
                    "id_idSolicitud": salida["id_idSolicitud_up"],
                    'id_fechaSoli': salida["id_fechaSoli_up"],
                    'id_idFruta': salida["id_idFruta_up_value"],
                    'id_idCalidad': salida["id_idCalidad_up_value"],
                    'id_cantidad': salida["id_cantidad_up"],
                    'id_presupuesto': salida["id_presupuesto_up"],
                    'id_embalaje': salida["id_embalaje_up"],
                    //    contentType: false,
                    //    processData: false,
                },

                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                    tableUsuarios();
                    $("#exampleModal").removeClass("show").css("display", "none").removeAttr("aria-modal").attr("aria-hidden", "true");
                    $(location).attr('href', 'http://localhost:8090/LogisticFV/clienteExtreno.jsp');
                    //   var resp = JSON.parse(data);
                    //   console.log(resp);
                    // document.location.href = "views/inicio/inicio.php";
                },
                error: function (jqXHR, textStatus, errorThrown) {

                },

                complete: function (jqXHR, textStatus) {
                    //document.location.href = "views/inicio/inicio.php";
                }



            });
        }


    });


// -----------------fin funcionamiento de botones de modal modificar----------------------------------- 

// -----------------funcionamiento de botones de modal eliminar----------------------------------- 


    $("#btn_mod_no").on("click", function () {

        $("#modalmsnsn").removeClass("show").css("display", "none").removeAttr("aria-modal").attr("aria-hidden", "true");

    });




// -----------------fin funcionamiento de botones de modal eliminar----------------------------------- 




    //FUNCION QUE VALIDA LOS DATOS INGRESADOS EN EL FORMULARIO DE MODIFICACION O CREACION
    function formulariosEnvioValida(idform) {
        var x = 0;
        var dataarray = [];
        var tag = true;

        //OBTIENE CADA ELEMENTO INPUT EN FORMULARIO
        $("#" + idform + " input").each(function () {
            var id = $(this).attr("id");
            //   console.log("id de los imput de los formularios",id);
            var datos = $("#" + id).val();
            //    console.log("datos :",datos);
            if (datos != "") {
                dataarray[id] = datos;
                $("#" + id).css("border", "1px solid #ced4da");
            } else {
                tag = false;
                $("#" + id).css("border", "1px solid red");
            }

            x++;
        });

        //OBTIENE CADA ELEMENTO COMBO BOX EN FORMULARIO
        $("#" + idform + " select").each(function () {
            var id = $(this).attr("id");
            var idvalue = id + "_value";
            var value_cb = this.value;

            if (value_cb != "") {
                dataarray[idvalue] = value_cb;

                $("#" + id).css("border", "1px solid #ced4da");
            } else {
                tag = false;
                $("#" + id).css("border", "1px solid red");
            }

            x++;
        });

        // console.log("dataarray ",dataarray);
        if (tag == true) {
            return dataarray;
        } else {
            return tag;
        }


    }

    function formulariosValidaOrigen(idform) {
        var x = 0;
        var dataarray = [];
        var tag = true;
        $("#" + idform + " input").each(function () {
            var id = $(this).attr("id");
            //     console.log("id de los imput de los formularios",id);
            $("#" + id).css("border", "1px solid #ced4da");

        });

    }

    function llenarComboBox() {
        $.ajax({
            url: "solicitudservlet",
            type: "post",
            data: {"func": "llenarComboBoxes",
            },

            success: function (data, textStatus, jqXHR) {
                console.log(data);
                var frutas = data.frutas;
                var calidades = data.calidades;

                $('#id_fruta').append($('<option>', {
                    value: "",
                    text: "Seleccionar"
                }));

                for (let i = 0; i < Object.keys(data.frutas).length; i++) {

                    $('#id_fruta').append($('<option>', {
                        value: i,
                        text: data.frutas[i]
                    }));

                    $('#id_idFruta_up').append($('<option>', {
                        value: i,
                        text: data.frutas[i]
                    }));

                }

                $('#id_calidad').append($('<option>', {
                    value: "",
                    text: "Seleccionar"
                }));

//                $('#id_calidad_up').append($('<option>', {
//                    value: "",
//                    text: "Seleccionar"
//                }));

                for (let i = 0; i < Object.keys(data.calidades).length; i++) {

                    $('#id_calidad').append($('<option>', {
                        value: i,
                        text: data.calidades[i]
                    }));

                    $('#id_idCalidad_up').append($('<option>', {
                        value: i,
                        text: data.calidades[i]
                    }));
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {

            },

            complete: function (jqXHR, textStatus) {
                //document.location.href = "views/inicio/inicio.php";
            }

        });
    }

//    function limitarFechaProduccionInsert() {
//        var maxDate = new Date();
//        var minDate = new Date();
//        minDate.setMonth(maxDate.getMonth() - 3);
//
//        var dd = maxDate.getDate();
//        var mm = maxDate.getMonth() + 1; //January is 0 so need to add 1 to make it 1!
//        var yyyy = maxDate.getFullYear();
//        if (dd < 10) {
//            dd = '0' + dd
//        }
//        if (mm < 10) {
//            mm = '0' + mm
//        }
//
//        maxDate = yyyy + '-' + mm + '-' + dd;
//
//        var dd = minDate.getDate();
//        var mm = minDate.getMonth() + 1; //January is 0 so need to add 1 to make it 1!
//        var yyyy = minDate.getFullYear();
//        if (dd < 10) {
//            dd = '0' + dd
//        }
//        if (mm < 10) {
//            mm = '0' + mm
//        }
//
//        minDate = yyyy + '-' + mm + '-' + dd;
//
//        document.getElementById("id_fechaproduccion").setAttribute("max", maxDate);
//        document.getElementById("id_fechaproduccion").setAttribute("min", minDate);
//        document.getElementById("id_fecha_up").setAttribute("max", maxDate);
//        document.getElementById("id_fecha_up").setAttribute("min", minDate);
//
//    }

    function limitarInputsNumeros() {
        document.getElementById("id_cantidad").onkeyup = function () {
            if (this.value < 0) {
                this.value = this.value * -1;
            }
            ;
            if (this.value == 0) {
                this.value = 1;
            }
        };

        document.getElementById("id_presupuesto").onkeyup = function () {
            if (this.value < 0) {
                this.value = this.value * -1;
            }
            ;
            if (this.value == 0) {
                this.value = 1;
            }
        };

        document.getElementById("id_cantidad_up").onkeyup = function () {
            if (this.value < 0) {
                this.value = this.value * -1
            }
            ;
            if (this.value == 0) {
                this.value = 1;
            }
        };

        document.getElementById("id_presupuesto_up").onkeyup = function () {
            if (this.value < 0) {
                this.value = this.value * -1;
            }
            ;
            if (this.value == 0) {
                this.value = 1;
            }
        };
    }

});