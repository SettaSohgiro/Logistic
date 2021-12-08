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

        tableSeguros();
        limitarInputsNumerosSeguro();
//        llenarComboBox();
//        limitarFechaProduccionInsert();
//        limitarInputsNumeros();

    });



//CODIGO QUE COLOCA LOS REGISTROS EN LA TABLA
    var tableR = "";
    function tableSeguros() {
        $('#seguros_table').dataTable().fnClearTable();
        $('#seguros_table').dataTable().fnDestroy();


        tableR = $('#seguros_table').dataTable({

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
                url: "segurosservlet", // json datasource
                type: "post", // method  , by default get
                data: {"func": "tablaSeguros"},

            },
            "order": [[0, "desc"]],
            "bPaginate": true,
            "sPaginationType": "full_numbers",
            "iDisplayLength": 100,
            "aoColumns": [
                {mData: "ID"},
                {mData: "Nombre"},
                {mData: "Costo"},
                {mData: "Estado"},
                {mData: "IdEmbarque"},
                {mData: "Eliminar"},
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
    $("#btn_envio_seguro").on("click", function () {

        var salida = formulariosEnvioValida("divFormSeguro");

        console.log("salida de la validacion del formulario", salida);
        if (salida !== false) {
            $.ajax({
                type: "post",
                url: "segurosservlet",
                data: {"func": "crearSeguro",
                    'id_nombre': salida["id_nombre"],
                    'id_costo': salida["id_costo"],
                    'id_estado': salida["id_estado"],
                    'id_embarque': salida["id_embarque"],
                },
                beforeSend: function (xhr) {

                },
                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                    $(location).attr('href', 'http://localhost:8090/LogisticFV/administrador.jsp');
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
    $("#seguros_table").on("click", "tr button", function () {
        var clic = $(this).attr("name");
        //   console.log("click : ",clic);
        setTimeout(function () {
            dataSeguro(clic);
        }, 100);
    });
    var dataseguro = [];

    $('#seguros_table tbody').on('click', 'tr', function () {
        var table = $('#seguros_table').DataTable();
        dataseguro = table.row(this).data();

        var clic = $("document button").attr("name");
        //   console.log("cliock : ",clic);
        //   console.log("table : ", datasolicitud);
    });

    function dataSeguro(tipo) {
        console.log("tipo", tipo);
        //PREPARA LOS DATOS DEL REGISTRO SELECCIONADO PARA MOSTRARLOS EN EL PANEL MODAL
        if (tipo == "") {
            formulariosValidaOrigen("divFormProducto_up");
            //    console.log("click : ",tipo);
            //    console.log("table : ", datasolicitud);
            $("#exampleModal").addClass("show").css("display", "block").removeAttr("aria-hidden").attr("aria-modal", "true");

            //OBTENER REGISTRO SELECCIONADO EN AJAX
            $.ajax({
                type: "post",
                url: "solicitudservlet",
                data: {"func": "crearContratoVenta",
                    "id_idseguro_d": dataseguro["ID"],
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
        } else if (tipo == "eliminarSeguro") {
            $("#modalmsnsn").addClass("show").css("display", "block").removeAttr("aria-hidden").attr("aria-modal", "true");
            $("#mdlbmsnsn").text("");
            $("#mdlbmsnsn").html("¿Esta seguro que desea eliminar este seguro?");

            $("#btn_mod_si").on("click", function () {
                console.log("hizo click en si : ", dataseguro["ID"]);

                $.ajax({
                    type: "post",
                    url: "segurosservlet",
                    data: {"func": "deleteSeguro",
                        "id_idseguro_d": dataseguro["ID"],
                        },

                    beforeSend: function (xhr) {

                    },
                    success: function (data, textStatus, jqXHR) {
                        console.log(data);
                        $("#modalmsnsn").removeClass("show").css("display", "none").removeAttr("aria-modal").attr("aria-hidden", "true");
                        tableSeguros();
                        $(location).attr('href', 'http://localhost:8090/LogisticFV/administrador.jsp');
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
                    tableSolicitudes();
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

    function limitarInputsNumerosSeguro() {
        document.getElementById("id_costo").onkeyup = function () {
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