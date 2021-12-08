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

    //Inicializacion de pagina
    $(function () {

        tableSolicitudes(idCliente);
        llenarComboBox();
//        limitarFechaProduccionInsert();
        limitarInputsNumeros();

    });

////////////////////////////////////////////////////////////////////////////////
//PESTAÑA SOLICITUDES
////////////////////////////////////////////////////////////////////////////////

    var idCliente = 0;

//CODIGO QUE COLOCA LOS REGISTROS EN LA TABLA
    var tableR = "";
    function tableSolicitudes(idCliente) {
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
                url: "solicitudes2servlet", // json datasource
                type: "post", // method  , by default get
                data: {"func": "tablaSolicitudes",
                    "type": 0,
                    "idCliente": idCliente}
            },
            "order": [[0, "desc"]],
            "bPaginate": true,
            "sPaginationType": "full_numbers",
            "iDisplayLength": 100,
            "aoColumns": [
                {mData: "ID"},
                {mData: "FechaSolicitud"},
                {mData: "Presupuesto"},
                {mData: "Venta"},
                {mData: "Usuario"},
                {mData: "Actualizar"},
                {mData: "Cancelar"},
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


    //CODIGO QUE COLOCA LOS REGISTROS EN LA TABLA
    var tableDS = "";
    function tableDetallesSolicitud(idSolicitud) {
        $('#solicitudes_up').dataTable().fnClearTable();
        $('#solicitudes_up').dataTable().fnDestroy();


        tableDS = $('#solicitudes_up').dataTable({

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
                url: "solicitudes2servlet", // json datasource
                type: "post", // method  , by default get
                data: {"func": "tablaDetallesSolicitud",
                    "idSolicitud": idSolicitud}
            },
            "order": [[0, "desc"]],
            "bPaginate": true,
            "sPaginationType": "full_numbers",
            "iDisplayLength": 100,
            "aoColumns": [
                {mData: "ID"},
                {mData: "IdFruta"},
                {mData: "Fruta"},
                {mData: "IdCalidad"},
                {mData: "Calidad"},
                {mData: "Cantidad"},
                {mData: "Embalaje"},
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

    // ----------------------------captura de botones de actualizar y borrar------------------------------
    $("#example").on("click", "tr button", function () {
        var clic = $(this).attr("name");
        //   console.log("click : ",clic);
        setTimeout(function () {
            dataSolicitudes(clic);
        }, 100);
    });
    var dataSolicitud = [];

    $('#example tbody').on('click', 'tr', function () {
        var table = $('#example').DataTable();
        dataSolicitud = table.row(this).data();

        var clic = $("document button").attr("name");
        //   console.log("cliock : ",clic);
        //   console.log("table : ", datausuario);
    });

    function dataSolicitudes(tipo) {
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
                url: "solicitudes2servlet",
                data: {"func": "llenarFormMod",
                    "id_idsolicitud": dataSolicitud["ID"],
                },
                beforeSend: function (xhr) {

                },
                success: function (data, textStatus, jqXHR) {
//                    var resp = JSON.parse(data);
                    console.log(data);
                    $("#id_idSolicitud_up").val(data.idSolicitud);
                    $("#id_fechaSoli_up").val(data.fechaSoli);
                    $("#id_presupuesto_up").val(data.presupuesto);
                    tableDetallesSolicitud(dataSolicitud["ID"]);
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
                console.log("hizo click en si : ", dataSolicitud["ID"]);

                $.ajax({
                    type: "post",
                    url: "solicitudes2servlet",
                    data: {"func": "deleteSolicitud",
                        "id_idsolicitud_d": dataSolicitud["ID"]},

                    beforeSend: function (xhr) {

                    },
                    success: function (data, textStatus, jqXHR) {
                        console.log(data);
                        $("#modalmsnsn").removeClass("show").css("display", "none").removeAttr("aria-modal").attr("aria-hidden", "true");
                        tableSolicitudes(idCliente);
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

        var salida = formulariosEnvioValida("divFormSolicitud_up", "solicitudes_up");
        console.log("tag : ", salida);
        console.log("tag can : ", salida.length);
        var data = new FormData();
        data.append("func", "updateProducto");

        if (salida !== false) {
            console.log("entro al ajax");
            $.ajax({
                url: "solicitudes2servlet",
                type: "post",
                data: {"func": "updateSolicitud",
                    'id_idSolicitud': salida["id_idSolicitud_up"],
                    'id_fechaSolitud': salida["id_fechaSoli_up"],
                    'id_presupuesto': salida["id_presupuesto_up"],
                    'id_cliente': idCliente,
                },

                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                    tableSolicitudes(idCliente);
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
    // -----------------fin funcionamiento de botones de modal eliminar----------------------------------- 

    // -----------------funcionamiento de botones de modal eliminar----------------------------------- 

    $("#btn_mod_no").on("click", function () {

        $("#modalmsnsn").removeClass("show").css("display", "none").removeAttr("aria-modal").attr("aria-hidden", "true");

    });

    $("#btn_agregar_up").on("click", function () {
        var table = $("#solicitudes_up").DataTable();

        var datos = validarFruta("divFormFruta_up");

        console.log(datos);

        if (datos !== false) {
            if (table.rows().count() < 3) {
                table.row.add([
                    datos["id_idFruta_up_value"],
                    datos["id_idFruta_up"],
                    datos["id_idCalidad_up_value"],
                    datos["id_idCalidad_up"],
                    datos["id_cantidad_up"],
                    datos["id_embalaje_up"],
                    '<td><button id=\"borrarBtn\" name=\"eliminar\" type=\"button\" class=\"btn btn-danger\">Borrar</button>\n</td>'
                ]).draw(false);
            }
        }

        console.log("PRESIONO AGREGAR BTN " + table.rows().count());
    });

    //Borrar fila de solicitud de fruta
    $("#solicitudes_up").on("click", "tr button", function () {
        var table = $("#solicitudes_up").DataTable();
        var row = table.row($(this).parents('tr'));
        row.remove().draw();
    });


////////////////////////////////////////////////////////////////////////////////
//PESTAÑA NUEVA SOLICITUD
////////////////////////////////////////////////////////////////////////////////

// TOMA LOS ID DE LOS ELEMENTOS DE LA PESTAÑA "menu1"
    $("#btn_envio_solicitud").on("click", function () {

        var salida = formulariosEnvioValida("divFormSolicitud", "solicitudes");

        console.log("salida de la validacion del formulario", salida);
        if (salida !== false) {
            $.ajax({
                type: "post",
                url: "solicitudes2servlet",
                data: {"func": "crearSolicitud",
                    'id_fechaSolitud': salida["id_fechaSolitud"],
                    'id_presupuesto': salida["id_presupuesto"],
                    'detalles': salida["detalles"],
                    'id_cliente': idCliente,                    
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

    $("#btn_agregar").on("click", function () {
        var table = $("#solicitudes").DataTable();

        var datos = validarFruta("divFormFruta");

        if (datos !== false) {
            if (table.rows().count() < 3) {
                table.row.add([
                    datos["id_fruta_value"],
                    datos["id_fruta"],
                    datos["id_calidad_value"],
                    datos["id_calidad"],
                    datos["id_cantidad"],
                    datos["id_embalaje"],
                    '<td><button id=\"borrarBtn\" name=\"eliminar\" type=\"button\" class=\"btn btn-danger\">Borrar</button>\n</td>'
                ]).draw(false);
            }
        }

        console.log("PRESIONO AGREGAR BTN " + table.rows().count());
    });

    //Borrar fila de solicitud de fruta
    $("#solicitudes").on("click", "tr button", function () {
        var table = $("#solicitudes").DataTable();
        var row = table.row($(this).parents('tr'));
        row.remove().draw();
    });


////////////////////////////////////////////////////////////////////////////////
//FUNCIONES MULTIUSO
////////////////////////////////////////////////////////////////////////////////

    //FUNCION QUE VALIDA LOS DATOS INGRESADOS EN EL FORMULARIO DE MODIFICACION O CREACION
    function formulariosEnvioValida(idform, idTable) {
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

        var table = $("#" + idTable).DataTable();
        var detalles = new Array();

        if (table.rows().count() > 0) {
            $("#" + idTable + " tr").each(function (index, row) {

                if (index > 0) {
                    var detalle = {};
                    detalle.idFruta = $(row).find('td:eq(0)').html();
                    detalle.fruta = $(row).find('td:eq(1)').html();
                    detalle.idCalidad = $(row).find('td:eq(2)').html();
                    detalle.calidad = $(row).find('td:eq(3)').html();
                    detalle.cantidad = $(row).find('td:eq(4)').html();
                    detalle.embalaje = $(row).find('td:eq(5)').html();

                    detalles.push(detalle);
                }

            });

            dataarray['detalles'] = JSON.stringify(detalles);

            $("#" + idTable).css("border", "1px solid #ced4da");
        } else {
            tag = false;
            $("#" + idTable).css("border", "1px solid red");
        }

        // console.log("dataarray ",dataarray);
        if (tag == true) {
            return dataarray;
        } else {
            return tag;
        }
    }

    //FUNCION QUE VALIDA LOS DATOS INGRESADOS EN EL FORMULARIO DE MODIFICACION O CREACION
    function validarFruta(idform) {
        var x = 0;
        var dataarray = [];
        var tag = true;

        //CODIGO QUE CHEQUE SI FORMULARIO ESTA VISIBLE
        if ($("#" + idform + " input").is(":visible")) {
            console.log("FROMULARIO VISIBLE");
        }

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
            var text_cb = $("#" + id + " option:selected").text();

            if (value_cb != "") {
                dataarray[id] = text_cb;
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

    function limitarFechaProduccionInsert() {
        var maxDate = new Date();
        var minDate = new Date();
        minDate.setMonth(maxDate.getMonth() - 3);

        var dd = maxDate.getDate();
        var mm = maxDate.getMonth() + 1; //January is 0 so need to add 1 to make it 1!
        var yyyy = maxDate.getFullYear();
        if (dd < 10) {
            dd = '0' + dd
        }
        if (mm < 10) {
            mm = '0' + mm
        }

        maxDate = yyyy + '-' + mm + '-' + dd;

        var dd = minDate.getDate();
        var mm = minDate.getMonth() + 1; //January is 0 so need to add 1 to make it 1!
        var yyyy = minDate.getFullYear();
        if (dd < 10) {
            dd = '0' + dd
        }
        if (mm < 10) {
            mm = '0' + mm
        }

        minDate = yyyy + '-' + mm + '-' + dd;

        document.getElementById("id_fechaproduccion").setAttribute("max", maxDate);
        document.getElementById("id_fechaproduccion").setAttribute("min", minDate);
        document.getElementById("id_fecha_up").setAttribute("max", maxDate);
        document.getElementById("id_fecha_up").setAttribute("min", minDate);

    }

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

//        document.getElementById("id_cantidad_up").onkeyup = function () {
//            if (this.value < 0) {
//                this.value = this.value * -1
//            }
//            ;
//            if (this.value == 0) {
//                this.value = 1;
//            }
//        };

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