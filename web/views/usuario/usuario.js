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
        selectRegion();
        selectProv();
        selectComuna();
        tableUsuarios();
        selectRol();
         $("#div_panel_transporte div").remove();
        
    });
    function tableUsuarios() {
        $('#example').dataTable().fnClearTable();
        $('#example').dataTable().fnDestroy();
        var tableR = $('#example').dataTable({

            scrollY: "500px",
            scrollX: true,
            scrollCollapse: true,
            paging: true,
            fixedColumns: {
                //  leftColumns: 2
            },
            "pageLength": 25,
            lengthMenu: [[25, 50], [25, 50]],
            "columnDefs": [
                //        {"targets": [0],"visible": true,"searchable": true},

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
                url: "crearusuario", // json datasource
                type: "post", // method  , by default get
                data: {"func": "tablaUsuario"},
            },
            "order": [[0, "desc"]],
            "bPaginate": true,
            "sPaginationType": "full_numbers",
            "iDisplayLength": 100,
            "aoColumns": [
                { mData: "ID"} , 
                { mData: "NOMBRE"} , 
                { mData: "PATERNO"} , 
                { mData: "MATERNO"} , 
                { mData: "DIRECCION"} , 
                { mData: "TELEFONO"} , 
                { mData: "TELEFONO2"} , 
                { mData: "MAIL"} , 
                { mData: "USUARIO"} , 
                { mData: "PASS"} , 
                { mData: "COMUNA"} , 
                { mData: "REGION"} , 
                { mData: "PROVINCIA"} , 
                { mData: "RUT"} , 
                { mData: "ESTADO"} , 
                { mData: "ROL"} , 
                { mData: "NOMBRE_EMPRESA"} , 
                { mData: "RUT_EMPRESA"} , 
                { mData: "PAIS_EMPRESA"} , 
                { mData: "DIRECCION_EMPRESA"} , 
                { mData: "TELEFONO_EMPRESA"} , 
                { mData: "CORREO_EMPRESA"} , 
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

    var tagem = 1;
    var tareg = 0;
    $("#sl_rol_user").on("change", function () {
        var valu = $("#sl_rol_user").val();
        console.log("valu" + valu);
        var apen = "<div class='panel panel-primary filterable ' style='border: 1px solid grey;border-radius: 5px;'> \n\
                   <div class='panel-heading' style='background-color: #c5dbef;color: #322F2D;font-size: 13px;height: 30px;    padding: 6px 0 0 15px;'> \n\
                   <p>Usuario Empresa</p>    </div> <div class='container' > <div class='form-row'> <div class='form-group col-md-6'> \n\
                <label for='id_nombre_Empre'>Nombre Empresa</label> \n\
                <input type='text' class='form-control' id='id_nombre_Empre' name='id_nombre_Empre' placeholder='Nombre'> \n\
              </div><div class='form-group col-md-6'> <label for='id_rut_empre'>RUT Empresa</label> \n\
                <input type='text' class='form-control' id='id_rut_empre' name='id_rut_empre' placeholder='rut'> \n\
              </div>  </div>  <div class='form-row'> <div class='form-group col-md-6'>   <label for='id_pais_empre'>Pais</label> \n\
               <select id='id_pais_empre' class='custom-select'>    <option selected>seleccionar</option>   </select> \n\
              </div>     <div class='form-group col-md-6'> <label for='​id_corempre'>Correo Empresa</label> \n\
                <input type='text' class='form-control' id='​id_corempre' name='​id_corempre' placeholder='correo'>    </div></div> \n\
               <div class='form-row'> <div class='form-group col-md-6'> <label for='id_direccion_empre'>Direccion Empresa</label> \n\
                <input type='text' class='form-control' id='id_direccion_empre' name='id_direccion_empre' placeholder='direccion'> \n\
              </div><div class='form-group col-md-6'><label for='id_telefono_empre'>Telefono</label> \n\
                <input type='text' class='form-control' id='id_telefono_empre' name='id_telefono_empre' placeholder='telefono'> \n\
              </div> </div>    <div class='form-row'> </div>  </div>  </div>   ";
        
        
        var apenlu = " <div class='form-row'><div class='form-group col-md-6'>  <label for='id_region'>Region</label>\n\
                    <select id='id_region' class='custom-select'> <option selected>seleccionar</option>  </select>  </div>\n\
                    <div class='form-group col-md-6'> <label for='id_provincia'>Provincia</label> <select id='id_provincia' class='custom-select'>\n\
                    <option selected>seleccionar</option>  </select></div>  </div>  <div class='form-row'><div class='form-group col-md-6'>\n\
                    <label for='id_comuna'>Comuna</label><select id='id_comuna' class='custom-select'><option selected>seleccionar</option>\n\
                    </select> </div> </div> ";
        
        
        var apentran = "<div class='panel panel-primary filterable ' style='border: 1px solid grey;border-radius: 5px;'> \n\
                   <div class='panel-heading' style='background-color: #c5dbef;color: #322F2D;font-size: 13px;height: 30px;    padding: 6px 0 0 15px;'>\n\
                   <p>Transporte</p>    </div> <div class='container' > <div class='form-row'> <div class='form-group col-md-6'>\n\
                <label for='id_patente'>Patente</label> \n\
                <input type='text' class='form-control' id='id_patente' name='id_patente' placeholder='Patente'> \n\
              </div><div class='form-group col-md-6'> <label for='id_vehiculo'>Clase vehiculo</label> \n\
                <input type='text' class='form-control' id='id_vehiculo' name='id_vehiculo' placeholder=''> \n\
              </div>  </div>  <div class='form-row'> <div class='form-group col-md-6'>   <label for='id_cap_m3'>Capacidad M3</label>\n\
               <input type='text' class='form-control' id='id_cap_m3' name='id_cap_m3' placeholder=''> \n\
              </div>     <div class='form-group col-md-6'> <label for='​id_capa_tn'>Capacidad Tn</label>\n\
                <input type='text' class='form-control' id='​id_capa_tn' name='​id_capa_tn' placeholder=''>    </div></div>\n\
               <div class='form-row'> <div class='form-group col-md-6'> <label for='id_nombre_condu'>Nombre conductor</label>\n\
                <input type='text' class='form-control' id='id_nombre_condu' name='id_nombre_condu' placeholder=''> \n\
              </div><div class='form-group col-md-6'><label for='id_tipo_licencia'>Tipo licencia</label>\n\
                <input type='text' class='form-control' id='id_tipo_licencia' name='id_tipo_licencia' placeholder=''>\n\
              </div> </div>    <div class='form-row'> </div>  </div>  </div>";

        if ((valu == "1" || valu == "6") && tagem == 0) {

            $("#div_panel_empresa div").remove();
            tagem = 1;
        } else if ((valu == "2" || valu == "3" || valu == "4" || valu == "5") && tagem == 1) {
            $("#div_panel_empresa").append(apen);
            tagem = 0;
            selectPais();

        }
        
        if ((valu == "3" )  && tareg == 0) {

            $("#div_lugar div").remove();
             tareg = 1;
        } else if ((valu == "1" || valu == "2" || valu == "4" ||  valu == "5"  || valu == "6")  && tareg == 1) {
            $("#div_lugar").append(apenlu);
            tareg = 0;
            selectRegion();
            selectProv();
            selectComuna();

        }
        
        if (valu == "5" ) {
            $("#div_panel_transporte").append(apentran);
           
        }else{
            $("#div_panel_transporte div").remove();
        }
        
        

      
        
        
    });




    $("#btn_envio_usuario").on("click", function () {

        var salida = formulariosEnvioValida("divFormUsuario");
        console.log("salida de la validacion del formulario", salida);
        if (salida !== false) {
            $.ajax({
                type: "post",
                url: "crearusuario",
                data: {"func": "crearUsuario",
                    
                    "id_amaterno": salida["id_amaterno"],
                    "id_apaterno": salida["id_apaterno"],
                    "id_comuna": salida["id_comuna"],
                    "id_correo": salida["id_correo"],
                    "​id_corem": salida["​id_corempre"],
                    "id_direccion": salida["id_direccion"],
                    "id_direccion_empre": salida["id_direccion_empre"],
                    "id_nombre": salida["id_nombre"],
                    "id_nombre_Empre": salida["id_nombre_Empre"],
                    "id_pais_empre": salida["id_pais_empre"],
                    "id_pass": salida["id_pass"],
                    "id_provincia": salida["id_provincia"],
                    "id_region": salida["id_region"],
                    "id_rut": salida["id_rut"],
                    "id_rut_empre": salida["id_rut_empre"],
                    "id_telefono": salida["id_telefono"],
                    "id_telefono2": salida["id_telefono2"],
                    "id_teleemp": salida["id_telefono_empre"],
                    "id_usuario": salida["id_usuario"],
                    "sl_rol_user": salida["sl_rol_user"],
                    "id_patente": salida["id_patente"],
                    "id_vehiculo": salida["id_vehiculo"],
                    "id_cap_m3": salida["id_cap_m3"],
                    "​id_capa_tn": salida["​id_capa_tn"],
                    "id_nombre_condu": salida["id_nombre_condu"],
                    "id_tipo_licencia": salida["id_tipo_licencia"],
                
                },

                beforeSend: function (xhr) {

                },
                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                    borrarFormulario("divFormUsuario");
                    tableUsuarios();
                     $("#div_panel_transporte div").remove();
                  //  $("#modalmsn").addClass("show").css("display", "block").removeAttr("aria-hidden").attr("aria-modal", "true");
                  //  $("#mdlbmsn").text("");
                  //  $("#mdlbmsn").html(data);
                    //   var resp = JSON.parse(data);
                    //   console.log(resp);
                    // document.location.href = "views/inicio/inicio.php";
                        $("#alertverde").addClass("show");
                        $("#alertparrafo").text(data);  
                        setTimeout(function(){
                            $("#alertverde").removeClass("show");
                        },3000);
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
          console.log("click : ",clic);
        setTimeout(function () {
            dataUsuarios(clic);
        }, 100);
    });
    var datausuario = [];

    $('#example tbody').on('click', 'tr', function () {
        var table = $('#example').DataTable();
        datausuario = table.row(this).data();
        var clic = $("document button").attr("name");
           console.log("cliock : ",clic);
           console.log("table : ", datausuario);
    });

    function dataUsuarios(tipo) {
        var rolup = "";
                var apen = "<div class='panel panel-primary filterable ' style='border: 1px solid grey;border-radius: 5px;'> \n\
                   <div class='panel-heading' style='background-color: #c5dbef;color: #322F2D;font-size: 13px;height: 30px;    padding: 6px 0 0 15px;'> \n\
                   <p>Usuario Empresa</p>    </div> <div class='container' > <div class='form-row'> <div class='form-group col-md-6'> \n\
                <label for='id_nombre_Empre_up'>Nombre Empresa</label> \n\
                <input type='text' class='form-control' id='id_nombre_Empre_up' name='id_nombre_Empre_up' placeholder='Nombre'> \n\
              </div><div class='form-group col-md-6'> <label for='id_rut_empre'>RUT Empresa</label> \n\
                <input type='text' class='form-control' id='id_rut_empre_up' name='id_rut_empre_up' placeholder='rut'> \n\
              </div>  </div>  <div class='form-row'> <div class='form-group col-md-6'>   <label for='id_pais_empre'>Pais</label> \n\
               <select id='id_pais_empre_up' class='custom-select'>    <option selected>seleccionar</option>   </select> \n\
              </div>     <div class='form-group col-md-6'> <label for='​id_corempre'>Correo Empresa</label> \n\
                <input type='text' class='form-control' id='​id_corempre_up' name='​id_corempre_up' placeholder='correo'>    </div></div> \n\
               <div class='form-row'> <div class='form-group col-md-6'> <label for='id_direccion_empre'>Direccion Empresa</label> \n\
                <input type='text' class='form-control' id='id_direccion_empre_up' name='id_direccion_empre_up' placeholder='direccion'> \n\
              </div><div class='form-group col-md-6'><label for='id_telefono_empre'>Telefono</label> \n\
                <input type='text' class='form-control' id='id_telefono_empre_up' name='id_telefono_empre_up' placeholder='telefono'> \n\
              </div> </div>    <div class='form-row'> </div>  </div>  </div>   ";
        
        
        var apenlu = " <div class='form-row'><div class='form-group col-md-6'>  <label for='id_region_up'>Region</label>\n\
                    <select id='id_region_up' class='custom-select'> <option selected>seleccionar</option>  </select>  </div>\n\
                    <div class='form-group col-md-6'> <label for='id_provincia'>Provincia</label> <select id='id_provincia_up' class='custom-select'>\n\
                    <option selected>seleccionar</option>  </select></div>  </div>  <div class='form-row'><div class='form-group col-md-6'>\n\
                    <label for='id_comuna'>Comuna</label><select id='id_comuna_up' class='custom-select'><option selected>seleccionar</option>\n\
                    </select> </div> </div> ";
        $("#div_lugar_up div").remove();
        $("#div_panel_empresa_up div").remove();      
      //  console.log("tipo", tipo);
        if (tipo == "actualizar") {
            formulariosValidaOrigen("divFormUsuario_up");
           
                 //   console.log("click : ",tipo);
                    console.log("table : ", datausuario );
                $("#id_idup").val(datausuario["ID"]);
                $("#id_nombre_up").val(datausuario["NOMBRE"]);
                $("#id_apaterno_up").val(datausuario["PATERNO"]);
                $("#id_amaterno_up").val(datausuario["MATERNO"]);
                $("#id_rut_up").val(datausuario["RUT"]);
                $("#id_direccion_up").val(datausuario["DIRECCION"]);
                $("#id_telefono_up").val(datausuario["TELEFONO"]);
                $("#id_telefono2_up").val(datausuario["TELEFONO2"]);
                $("#id_correo_up").val(datausuario["MAIL"]);
                rolup = datausuario["ROL"];
                   if(rolup == "2" || rolup == "3" || rolup == "4" || rolup == "5"){
                       
                       $("#div_panel_empresa_up").append(apen);
                       selectPais();
                       $("#id_nombre_Empre_up").val(datausuario["NOMBRE_EMPRESA"]);
                       $("#id_rut_empre_up").val(datausuario["RUT_EMPRESA"]);
                       
                       $("#​id_corempre_up").val(datausuario["CORREO_EMPRESA"]);
                       $("#id_direccion_empre_up").val(datausuario["DIRECCION_EMPRESA"]);
                       $("#id_telefono_empre_up").val(datausuario["TELEFONO_EMPRESA"]);
                       setTimeout(function(){$("#id_pais_empre_up").val(datausuario["PAIS_EMPRESA"]);},600);
                       
                       if(rolup == "2" ||  rolup == "4" || rolup == "5"){
                           console.log("2");
                        $("#div_lugar_up").append(apenlu);
                            selectRegion("id_region_up" , datausuario["REGION"]);
                            selectProv("id_provincia_up" , datausuario["PROVINCIA"]);
                            selectComuna("id_comuna_up" , datausuario["COMUNA"]);
                        setTimeout(function(){
                           // $("#id_region_up").val(datausuario["REGION"]);
                           // $("#id_provincia_up").val(datausuario["PROVINCIA"]);
                           // $("#id_comuna_up").val(datausuario["COMUNA"]);
                        },600);
                    }
                   }
                   if(rolup == "1" || rolup == "6"){
                       console.log("1");
                        $("#div_lugar_up").append(apenlu);

                        setTimeout(function(){
                        //    $("#id_region_up").val(datausuario["REGION"]);
                         //   $("#id_provincia_up").val(datausuario["PROVINCIA"]);
                         //   $("#id_comuna_up").val(datausuario["COMUNA"]);
                            selectRegion("id_region_up" , datausuario["REGION"]);
                            selectProv("id_provincia_up" , datausuario["PROVINCIA"]);
                            selectComuna("id_comuna_up" , datausuario["COMUNA"]);
                        },100);
                   }
//          $("#exampleModal").addClass("show").css("display", "block").removeAttr("aria-hidden").attr("aria-modal", "true");
          
        } else if (tipo == "eliminar") {
   //         $("#modalmsnsn").addClass("show").css("display", "block").removeAttr("aria-hidden").attr("aria-modal", "true");
            $("#mdlbmsnsn").text("");
            $("#mdlbmsnsn").html("Seguro que desea eliminar el registro");
            $("#btn_mod_si").on("click", function () {
            //    console.log("iso click en si : ", datausuario["RUT"]);
                $.ajax({
                    type: "post",
                    url: "crearusuario",
                    data: {"func": "deleteUsuario",
                        "id_rut_d": datausuario["RUT"]},

                    beforeSend: function (xhr) {

                    },
                    success: function (data, textStatus, jqXHR) {
                        console.log(data);
                        tableUsuarios();
                        
                        $("#alertverde").addClass("show");
                        $("#alertparrafo").text("");  
                        $("#alertparrafo").text(data);  
                        setTimeout(function(){
                            $("#alertverde").removeClass("show");
                        },3000);
 /*                   $("#btn_mod_cerrar").trigger("click");
                    $("#modalmsn").addClass("show").css("display", "block").removeAttr("aria-hidden").attr("aria-modal", "true");
                    $("#mdlbmsn").text("");*/
                  //  $("#mdlbmsn").html(data);
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
 /*   $("#btn_mod_cerrar").on("click", function () {

        $("#exampleModal").removeClass("show").css("display", "none").removeAttr("aria-modal").attr("aria-hidden", "true");
    });
    
    $("#btn_volver").on("click", function () {

        $("#modalmsn").removeClass("show").css("display", "none").removeAttr("aria-modal").attr("aria-hidden", "true");
    });
    */
    
    $("#btn_mod_modificar").on("click", function () {

        var salida = formulariosEnvioValida("divFormUsuario_up");
        console.log("tag : ", salida);
        console.log("tag can : ", salida.length);
        var idamatup = salida["id_amaterno_up"];
        var idapatup = salida["id_apaterno_up"];
        var idcomuup = salida["id_comuna_up"];
        var idcorreup = salida["id_correo_up"];
        var iddirempup = salida["id_direccion_empre_up"];
        var iddirup = salida["id_direccion_up"];
        var idnomEmpup = salida["id_nombre_Empre_up"];
        var idnomup = salida["id_nombre_up"];
        var idpaisempup = salida["id_pais_empre_up"];
        var idprovup = salida["id_provincia_up"];
        var idregup = salida["id_region_up"];
        var idrueup = salida["id_rut_empre_up"];
        var idrutup = salida["id_rut_up"];
        var idtel2up = salida["id_telefono2_up"];
        var idtelemup = salida["id_telefono_empre_up"];
        var idtelup = salida["id_telefono_up"];
        var idcoremup = salida["​id_corempre_up"];
        var ididup = salida["id_idup"];
      //  var data = new FormData();
   //     data.append("func", "updateUsuario");
    setTimeout(function(){
        if (salida !== false) {
            console.log("entro al ajax", salida["id_region_up"]+salida["​id_rut_up"]+salida["id_rut_empre_up"]);
            $.ajax({
                url: "crearusuario",
                type: "post",
                data: {"func": "updateUsuario",
                        "id_amat_up" : idamatup,
                        "id_apat_up" : idapatup,
                        "id_comu_up" : idcomuup,
                        "id_corre_up" : idcorreup,
                        "id_diremp_up" : iddirempup ,
                        "id_dir_up" : iddirup,
                        "id_nomEmp_up" : idnomEmpup,
                        "id_nom_up" : idnomup,
                        "id_paisemp_up" : idpaisempup,
                        "id_prov_up" : idprovup,
                        "​id_regup" : idregup,
                        "​id_rueup" : idrueup,
                        "​id_rutup" : idrutup,
                        "id_tel2_up" : idtel2up,
                        "​id_telemup" : idtelemup,
                        "id_tel_up" : idtelup,
                        "id_coremup" : idcoremup,
                        "id_idup" : ididup,},
//    contentType: false,
//    processData: false,

                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                    borrarFormulario("divFormUsuario");
                    tableUsuarios();
                    $("#btn_mod_cerrar").trigger("click");
 //                   $("#modalmsn").addClass("show").css("display", "block").removeAttr("aria-hidden").attr("aria-modal", "true");
//                    $("#mdlbmsn").text("");
//                   $("#mdlbmsn").html(data);

                    $("#alertverde").addClass("show");
                    $("#alertparrafo").text(data);  
                    //$('.alert').alert();
                    setTimeout(function(){
                        $("#alertverde").removeClass("show");
                    },3000);
                    

                },
                error: function (jqXHR, textStatus, errorThrown) {

                },

                complete: function (jqXHR, textStatus) {
                    //document.location.href = "views/inicio/inicio.php";

                }



            });
        }
        },100);

    });


// -----------------fin funcionamiento de botones de modal modificar----------------------------------- 

// -----------------funcionamiento de botones de modal eliminar----------------------------------- 


    $("#btn_mod_no").on("click", function () {

        $("#modalmsnsn").removeClass("show").css("display", "none").removeAttr("aria-modal").attr("aria-hidden", "true");
    });




// -----------------fin funcionamiento de botones de modal eliminar----------------------------------- 



$("#id_nombre , #id_apaterno,#id_rut ").on("change" , function(){
    
    var usu = $("#id_usuario").val();
    var pas = $("#id_pass").val();
    var nom = $("#id_nombre").val();
    var pat = $("#id_apaterno").val();
    var rut = $("#id_rut").val();

    if(nom != "" && pat != "" && rut != ""){
        
        $("#id_usuario").val(nom.substr(0,3)+pat.substr(0,3));
        $("#id_pass").val(nom.substr(0,2)+pat.substr(0,3)+rut.substr(0,3));
        
    }
});








    function formulariosEnvioValida(idform) {
        var x = 0;
        var dataarray = [];
        var tag = true;
        $("#" + idform + " input").each(function () {
            var id = $(this).attr("id");
             //  console.log("id de los imput de los formularios",id);
            var datos = $("#" + id).val();
              //  console.log("datos :",datos);
            if (datos != "") {
                dataarray[id] = datos;
                $("#" + id).css("border", "1px solid #ced4da");
            } else {
                tag = false;
                $("#" + id).css("border", "1px solid red");
            }

            x++;
        });
// console.log("dataarray ",dataarray);

        $("#" + idform + " select").each(function () {
            var id = $(this).attr("id");
             //  console.log("id de los imput de los formularios",id);
            var datos = $("#" + id).val();
            //    console.log("datos :",datos);
            if (datos != "0") {
                dataarray[id] = datos;
                $("#" + id).css("border", "1px solid #ced4da");
            } else {
                tag = false;
                $("#" + id).css("border", "1px solid red");
            }
        });
        
      //  console.log("dataarray : ",dataarray);
        if (tag == true) {
           return dataarray;
        } else {
            return tag;
        }


    }

    function borrarFormulario(idform) {
        var x = 0;
        var dataarray = [];
        var tag = true;
        $("#" + idform + " input").each(function () {
            var id = $(this).attr("id");
             //  console.log("id de los imput de los formularios",id);
            $("#" + id).val("");
                  
        });
        $("#" + idform + " select").each(function () {
            var id = $(this).attr("id");
             //  console.log("id de los imput de los formularios",id);
            $("#" + id).val(0);
            
        });

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

    function selectRol() {
        $.ajax({
            type: "post",
            url: "crearusuario",
            data: {"func": "selectRol"},
            beforeSend: function (xhr) {

            },
            success: function (data, textStatus, jqXHR) {
                var resp = JSON.parse(data);
                console.log(resp);
                //    console.log(data);
                $("#sl_rol_user option").remove();
                $("#sl_rol_user").append("<option value='0'>--seleccione--</option>");
                $.each(resp, function (key, value) {
                    console.log(value[0]);
                    $("#sl_rol_user").append("<option value='" + value["ID"] + "'>" + value["ROL"] + "</option>");
                });
            },
            error: function (jqXHR, textStatus, errorThrown) {

            },
            complete: function (jqXHR, textStatus) {

            }

        });
    }


//------------------------- validar ----------------------------------------

//------------------------------ combo region -------------------------------

    function selectRegion(id , dato) {
        $.ajax({
            type: "post",
            url: "crearusuario",
            data: {"func": "selectRegion"},
            beforeSend: function (xhr) {

            },
            success: function (data, textStatus, jqXHR) {
                var resp = JSON.parse(data);
                console.log(resp);
                //    console.log(data);
                $("#id_region_up option").remove();
                $("#id_region_up").append("<option value='0'>--seleccione--</option>");
                
                $("#id_region option").remove();
                $("#id_region").append("<option value='0'>--seleccione--</option>");
                $.each(resp, function (key, value) {
                    console.log(value[0]);
                    $("#id_region_up").append("<option value='" + value["ID_REGION"] + "'>" + value["REGION"] + "</option>");
                    $("#id_region").append("<option value='" + value["ID_REGION"] + "'>" + value["REGION"] + "</option>");
                });
            },
            error: function (jqXHR, textStatus, errorThrown) {

            },
            complete: function (jqXHR, textStatus) {
                if(id != ""){
                    $("#"+id).val(dato);
                }
                    
            }

        });
    }
    
 //------------------------------ fin combo repgion -------------------------------   
 

//------------------------------ combo provincia -------------------------------

    function selectProv(id , dato) {
        $.ajax({
            type: "post",
            url: "crearusuario",
            data: {"func": "selectProv"},
            beforeSend: function (xhr) {

            },
            success: function (data, textStatus, jqXHR) {
                var resp = JSON.parse(data);
                console.log(resp);
                //    console.log(data);
                $("#id_provincia_up option").remove();
                $("#id_provincia_up").append("<option value='0'>--seleccione--</option>");
                
                $("#id_provincia option").remove();
                $("#id_provincia").append("<option value='0'>--seleccione--</option>");
                $.each(resp, function (key, value) {
                //    console.log(value[0]);
                    $("#id_provincia_up").append("<option value='" + value["ID_PROVINCIA"] + "'>" + value["PROVINCIA"] + "</option>");
                    $("#id_provincia").append("<option value='" + value["ID_PROVINCIA"] + "'>" + value["PROVINCIA"] + "</option>");
                });
            },
            error: function (jqXHR, textStatus, errorThrown) {

            },
            complete: function (jqXHR, textStatus) {
                if(id != ""){
                    $("#"+id).val(dato);
                }
            }

        });
    }
    
 //------------------------------ fin combo provincia -------------------------------   
 
 
//------------------------------ combo comuna -------------------------------


    function selectComuna(id , dato) {
        $.ajax({
            type: "post",
            url: "crearusuario",
            data: {"func": "selectComuna"},
            beforeSend: function (xhr) {

            },
            success: function (data, textStatus, jqXHR) {
                var resp = JSON.parse(data);
                console.log(resp);
                //    console.log(data);
                $("#id_comuna_up option").remove();
                $("#id_comuna_up").append("<option value='0'>--seleccione--</option>");
                
                $("#id_comuna option").remove();
                $("#id_comuna").append("<option value='0'>--seleccione--</option>");
                $.each(resp, function (key, value) {
                 //   console.log(value[0]);
                    $("#id_comuna_up").append("<option value='" + value["ID_COMUNA"] + "'>" + value["COMUNA"] + "</option>");
                    
                    $("#id_comuna").append("<option value='" + value["ID_COMUNA"] + "'>" + value["COMUNA"] + "</option>");
                });
            },
            error: function (jqXHR, textStatus, errorThrown) {

            },
            complete: function (jqXHR, textStatus) {
                if(id != ""){
                    $("#"+id).val(dato);
                }
            }

        });
    }
    
 //------------------------------ fin combo comuna -------------------------------   






});


 
 //------------------------------ combo pais -------------------------------

    function selectPais() {
        $.ajax({
            type: "post",
            url: "crearusuario",
            data: {"func": "selectPais"},
            beforeSend: function (xhr) {

            },
            success: function (data, textStatus, jqXHR) {
                var resp = JSON.parse(data);
                console.log(resp);
                //    console.log(data);
                $("#id_pais_empre option").remove();
                $("#id_pais_empre").append("<option value='0'>--seleccione--</option>");
                $("#id_pais_empre_up option").remove();
                $("#id_pais_empre_up").append("<option value='0'>--seleccione--</option>");
                $.each(resp, function (key, value) {
                    console.log(value[0]);
                    $("#id_pais_empre").append("<option value='" + value["ID_PAIS"] + "'>" + value["PAIS"] + "</option>");
                    $("#id_pais_empre_up").append("<option value='" + value["ID_PAIS"] + "'>" + value["PAIS"] + "</option>");
                });
            },
            error: function (jqXHR, textStatus, errorThrown) {

            },
            complete: function (jqXHR, textStatus) {

            }

        });
    }
    
 //------------------------------ fin combo pais -------------------------------   

// Valida el rut con su cadena completa "XXXXXXXX-X"

    function rutCompleto(rutCompleto) {
        if (!/^[0-9]+[-|‐]{1}[0-9kK]{1}$/.test(rutCompleto))
            return false;
        var tmp = rutCompleto.split('-');
        var digv = tmp[1];
        var rut = tmp[0];
        if (digv == 'K')
            digv = 'k';
        //return (Fn.dv(rut) == digv );
    }


    function rutCompleto(T) {
        var M = 0, S = 1;
        for (; T; T = Math.floor(T / 10))
            S = (S + T % 10 * (9 - M++ % 6)) % 11;
        return S ? S - 1 : 'k';
    }
