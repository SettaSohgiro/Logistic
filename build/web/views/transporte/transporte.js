$(document).ready(function(){
    
    $("li a ").on("click",function(){
            var lii = $(this).attr("id").substr(1,5);
            var clali = $(this).attr("class").substr(9,6);
     //       console.log("herf - class : ",lii , clali);
            if(clali != "active"){
                $.each($("#ul_nav_user li a"),function(key, value){
       //             console.log(value,key);
                    $("#amenu"+key).removeClass("active");
                    $("#menu"+key).removeClass("active");
                    
                } );
                
                $("#a"+lii).addClass("active");
                $("#"+lii).addClass("active");
                
                
            }
    });
    
$(function(){
    
    tabletransporte();
    tableseleccion();
});
     
     
var     tableR = "";
function tabletransporte(){
        $('#tabletransporte').dataTable().fnClearTable();
        $('#tabletransporte').dataTable().fnDestroy();
                    
                    
    tableR = $('#tabletransporte').dataTable({

                scrollY:        "500px",
                scrollX:        true,
                scrollCollapse: true,
                paging:         true,
                fixedColumns:   {
                    leftColumns: 2
                },
                "pageLength": 25,
                lengthMenu: [[ 25 , 50 ], [ 25 , 50]],
                 "columnDefs": [
                                  {"targets": [0],"visible": true,"searchable": true},
                          
                  ],               
                "language":  {
                    "sProcessing":     "Procesando...",
                    "sLengthMenu":     "Mostrar _MENU_ registros",
                    "sZeroRecords":    "No se encontraron resultados",
                    "sEmptyTable":     "Ningún dato disponible en esta tabla",
                    "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                    "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
                    "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
                    "sInfoPostFix":    "",
                    "sSearch":         "Buscar:",
                    "sUrl":            "",
                    "sInfoThousands":  ",",
                    "sLoadingRecords": "Cargando...",
                    "oPaginate": {
                      "sFirst":    "Primero",
                      "sLast":     "Último",
                      "sNext":     "Siguiente",
                      "sPrevious": "Anterior"
                    },
                    "oAria": {
                      "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
                      "sSortDescending": ": Activar para ordenar la columna de manera descendente"
                    }
            },
            "bProcessing": true,
            //"sAjaxSource": "../../controllers/pagosController.php",
            //"sAjaxDataProp": "demo",
    "ajax":{
                     url :"transporte", // json datasource
                     type: "post",  // method  , by default get
                     data: {"func" : "tabletransporte"},
                     
                     
                   
          },
          "order": [[ 0, "desc" ]],
          "bPaginate":true,
          "sPaginationType":"full_numbers",
          "iDisplayLength": 100,
          "aoColumns": [
              {mData:"Opciones"},
                {mData:"ID"},
                {mData:"patente"},
                {mData:"tipo_vehiculo"},
                {mData:"capacidad_m3"},
                {mData:"capacidad_tonelada"},
                {mData:"nombre_conductor"},
                {mData:"tipo_licencia"},
                {mData:"region"},
                {mData:"direccion"},
                {mData:"estado"}
        ],
        initComplete: function () {
                    // Apply the search
                    this.api().columns().every( function () {
                        var that = this;
         
                        $( 'input', this.header() ).on( 'keyup change clear', function () {
                            if ( that.search() !== this.value ) {
                                that
                                    .search( this.value )
                                    .draw();
                            }
                        } );
         });
        }



      });
}


   $(this).on("click","#btn_apdate_T", function(){
       var nam = $(this).attr("name");
       console.log("boton pdf name ", nam);
     $("#ModalActualizarTransporte").addClass("show").css("display", "block").removeAttr("aria-hidden").attr("aria-modal", "true");
       
       
         //       $("#ModalprintDiv").addClass("show").css("display", "block").removeAttr("aria-hidden").attr("aria-modal", "true");

   }); 
   
   
      $("#tabletransporte").on("click","tr button",function(){
        var clic = $(this).attr("name");
     //   console.log("click : ",clic);
        setTimeout(function(){
            dataTransporte(clic);
        },100); 
    });
    var datatransporte= []; 

    $('#tabletransporte tbody').on('click', 'tr', function () {
        var table = $('#tabletransporte').DataTable();
        datatransporte = table.row(this).data();

    });

    function dataTransporte(tipo ){
          //  formulariosValidaOrigen("divFormContrato_up");
        //    console.log("click : ",tipo);
            console.log("table datatransporte : ", datatransporte);
            $("#ModalActualizarTransporte").addClass("show").css("display","block").removeAttr("aria-hidden").attr("aria-modal","true");
            $("#id_idTransporte").val(datatransporte["ID"]);
            $("#id_patente_mod").val(datatransporte["patente"]);
            $("#inp_tipo_vehiculo").val(datatransporte["tipo_vehiculo"]);
            $("#inp_capacidad_m3").val(datatransporte["capacidad_m3"]);
            $("#inp_capacidad_tonelada").val(datatransporte["capacidad_tonelada"]);
            $("#inp_nombre_conductor").val(datatransporte["nombre_conductor"]);
            $("#inp_tipo_licencia").val(datatransporte["tipo_licencia"]); 
    }






// -----------------funcionamiento de botones de modal modificar-----------------------------------
$("#btn_mod_cerrarT").on("click",function(){
    
    $("#ModalActualizarTransporte").removeClass("show").css("display","none").removeAttr("aria-modal").attr("aria-hidden","true");
});







 
$("#btn_mod_modificarT").on("click",function(){
    
    var salida = formulariosEnvioValida("divFormTransporte_up");
    console.log("tag : ", salida);
    console.log("tag can : ", salida.length);

    if(salida !== false){
        console.log("entro al ajax");
                $.ajax({
                url: "transporte", 
                type : "post",                                    
                data : {"func" : "updateTransporte",
                   "id_patente_mod" : salida["id_patente_mod"],
                   'inp_tipo_vehiculo' : salida["inp_tipo_vehiculo"],
                   'inp_capacidad_m3' : salida["inp_capacidad_m3"],
                   'inp_capacidad_tonelada' : salida["inp_capacidad_tonelada"],
                   'inp_nombre_conductor' : salida["inp_nombre_conductor"],
                   'inp_tipo_licencia' : salida["inp_tipo_licencia"],
                   'inp_id' : salida["id_idTransporte"],
                   } ,
            //    contentType: false,
            //    processData: false,

               success: function (data, textStatus, jqXHR) {
                   console.log(data);
                   tableContratos();
                 //  $(location).attr('href','http://localhost:8090/LogisticFV/contrato.jsp#menu0');
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
var  tableS = "";
function tableseleccion(){
        $('#tableseleccion').dataTable().fnClearTable();
        $('#tableseleccion').dataTable().fnDestroy();
                    
                    
    tableS = $('#tableseleccion').dataTable({

                scrollY:        "500px",
                scrollX:        true,
                scrollCollapse: true,
                paging:         true,
                fixedColumns:   {
                    leftColumns: 2
                },
                "pageLength": 25,
                lengthMenu: [[ 25 , 50 ], [ 25 , 50]],
                 "columnDefs": [
                                  {"targets": [0],"visible": true,"searchable": true},
                          
                  ],               
                "language":  {
                    "sProcessing":     "Procesando...",
                    "sLengthMenu":     "Mostrar _MENU_ registros",
                    "sZeroRecords":    "No se encontraron resultados",
                    "sEmptyTable":     "Ningún dato disponible en esta tabla",
                    "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                    "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
                    "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
                    "sInfoPostFix":    "",
                    "sSearch":         "Buscar:",
                    "sUrl":            "",
                    "sInfoThousands":  ",",
                    "sLoadingRecords": "Cargando...",
                    "oPaginate": {
                      "sFirst":    "Primero",
                      "sLast":     "Último",
                      "sNext":     "Siguiente",
                      "sPrevious": "Anterior"
                    },
                    "oAria": {
                      "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
                      "sSortDescending": ": Activar para ordenar la columna de manera descendente"
                    }
            },
            "bProcessing": true,
            //"sAjaxSource": "../../controllers/pagosController.php",
            //"sAjaxDataProp": "demo",
    "ajax":{
                     url :"transporte", // json datasource
                     type: "post",  // method  , by default get
                     data: {"func" : "tableseleccion"},
                     
                     
                   
          },
          "order": [[ 1, "desc" ]],
          "bPaginate":true,
          "sPaginationType":"full_numbers",
          "iDisplayLength": 100,
          "aoColumns": [
                {mData:"Opciones"},
                {mData:"id"},
                {mData:"nombre_empresa"},
                {mData:"rut_empresa"},
                {mData:"direccion_empresa"},
                {mData:"region"},
                {mData:"total_kg"},
                {mData:"nbolf"},
                {mData:"tipo_com"},
                {mData:"rol"}

        ],
        initComplete: function () {
                    // Apply the search
                    this.api().columns().every( function () {
                        var that = this;
         
                        $( 'input', this.header() ).on( 'keyup change clear', function () {
                            if ( that.search() !== this.value ) {
                                that
                                    .search( this.value )
                                    .draw();
                            }
                        } );
         });
        }



      });
}





























































































   $(this).on("click","#btn_pdf_descargar", function(){
       var nam = $(this).attr("name");
       console.log("boton pdf name ", nam);
       llenadoFactura(nam);
       
       
         //       $("#ModalprintDiv").addClass("show").css("display", "block").removeAttr("aria-hidden").attr("aria-modal", "true");

   }); 
   
   function llenadoFactura(id){
       
       var dat = [];
       var detalle = "";
       var intro = "";
        $.ajax({
               type : "post",
               url:"crearcontrato",                           
               data : {"func" : "llenadoFactura",
                   "id" :id} ,


               beforeSend: function (xhr) {

               },
               success: function (data, textStatus, jqXHR) {
                  // console.log(data);
                  // dat = data.data;
                        //   console.log(dat);
                       var resp = JSON.parse(data);
                       console.log(resp.data[0]);
                       
                       $("#m_cliente").text(resp.data[0]["nombre"]);
                       $("#m_vendedor").text(resp.data[0]["usernom"]);
                       $("#m_fechafact").text(resp.data[0]["fechaventa"]);
                       $("#m_facturanum").text(resp.data[0]["numBF"]);
                       
                       $("#m_porcentaje").text(resp.data[0]["impuesto"]);
                       $("#m_neto").text( parseInt(resp.data[0]["totalim"]) -  (parseInt(resp.data[0]["totalim"]) - ( parseInt(resp.data[0]["totalim"]) * 100)/(100 + parseInt(resp.data[0]["impuesto"])  ))  );
                       $("#m_impuesto").text( parseInt(resp.data[0]["totalim"]) - ( parseInt(resp.data[0]["totalim"]) * 100)/(100 + parseInt(resp.data[0]["impuesto"])  )  );
                       $("#m_total").text(resp.data[0]["totalim"]);
               
                                       $.ajax({
                                        type : "post",
                                        url:"crearcontrato",                           
                                        data : {"func" : "detalleFactura",
                                            "id" : id,


                                        },
                                        beforeSend: function (xhr) {

                                        },
                                        success: function (data, textStatus, jqXHR) {
                                          //  console.log(data);
                                           var resp = JSON.parse(data);
                                            console.log(resp.data);
                                            intro = "<tr>";
                                            
                                            $("#val_detalle_factura tr").remove();
                                            $.each(resp.data , function(key , val){
                                                
                                                console.log(val["descripcion"]);
                                                
                                                detalle = detalle + "<tr><td style='border: 1px solid #666; color:#333; background-color:white; width:260px; text-align:center'>"+val["descripcion"]+"</td> \n\
                                                                            <td style='border: 1px solid #666; color:#333; background-color:white; width:80px; text-align:center'>"+val["cantidad"]+"</td>\n\
                                                                            <td style='border: 1px solid #666; color:#333; background-color:white; width:100px; text-align:center'>$ "+val["precio"]+"</td>\n\
                                                                            <td style='border: 1px solid #666; color:#333; background-color:white; width:100px; text-align:center'>$ "+val["total"]+"</td></tr>";
                                                
                                            });
                                            
                                        //    console.log("detalle : ",detalle);
                                            $("#val_detalle_factura").append(detalle);
                                        },
                                        error: function (jqXHR, textStatus, errorThrown) {

                                        },

                                        complete: function (jqXHR, textStatus) {
                                            //document.location.href = "views/inicio/inicio.php";
                                        }



                                      });
               
                        
               
               },
               error: function (jqXHR, textStatus, errorThrown) {

               },

               complete: function (jqXHR, textStatus) {
                   //document.location.href = "views/inicio/inicio.php";
                   
                   $("#ModalprintDiv").addClass("show").css("display", "block").removeAttr("aria-hidden").attr("aria-modal", "true");
                   
               }



             });
       
   }
   
       $("#btn_modpdf_no , #btn_mod_no , #btn_mod_si, .close").on("click", function () {

        $("#ModalprintDiv , #ModalBorrar").removeClass("show").css("display", "none").removeAttr("aria-modal").attr("aria-hidden", "true");
    });
   
   function detalleFactura(){}
   

   
     $("#pdfDownloader").click(function() {
    html2canvas($("#printDiv"), {
      useCORS: true,
      onrendered: function(canvas) {
        var imgData = canvas.toDataURL('image/png');
        var doc = new jsPDF('p', 'pt', 'a4');
        doc.addImage(imgData, 'PNG', 10, 10);
        doc.save('download.pdf');
      }
    });
  });
   
   
   
     
function demoFromHTML() {
    var pdf = new jsPDF('p', 'pt', 'letter');
    // source can be HTML-formatted string, or a reference
    // to an actual DOM element from which the text will be scraped.
    source = "<table><tr> <td style='width:100px'><img src='http://localhost:8090/LogisticFV/views/image/logo.png' style='width: 150px;'>     </td>\n\
			<td style='background-color:white; width:140px;'><div style='font-size:8.5px; text-align:center; line-height:15px;'>	<br>RUC: 20517896312<br>Dirección: Av. Petit Thouars 1931 - Lince</div></td>\n\
			<td style='background-color:white; width:160px;text-align:center;'><div style='font-size:8.5px; text-align:center; line-height:18px;'><br>Teléfono: 940-120-981<br>Email: almacennbnetg@gmail.com</div></td>\n\
			<td style='background-color:white; width:150px; text-align:center; color:black;'><br>FACTURA <br> NRO: $valorVenta</td></tr></table>";
    // we support special element handlers. Register them with jQuery-style 
    // ID selector for either ID or node name. ("#iAmID", "div", "span" etc.)
    // There is no support for any other type of selectors 
    // (class, of compound) at this time.
    specialElementHandlers = {
        // element with id of "bypass" - jQuery style selector
        '#bypassme': function (element, renderer) {
            // true = "handled elsewhere, bypass text extraction"
            return true
        }
    };
    margins = {
        top: 80,
        bottom: 60,
        left: 10,
        width: 700
    };
    // all coords and widths are in jsPDF instance's declared units
    // 'inches' in this case
    pdf.fromHTML(
    source, // HTML string or DOM elem ref.
    margins.left, // x coord
    margins.top, { // y coord
        'width': margins.width, // max width of content on PDF
        'elementHandlers': specialElementHandlers
    },

    function (dispose) {
        // dispose: object with X, Y of the last line add to the PDF 
        //          this allow the insertion of new lines after html
        pdf.save('Test.pdf');
    }, margins);
}     
   
   
   
   
   
    $(this).on("click","#btn_anularContrato", function(){
       var nam = $(this).attr("name");
       console.log("boton pdf name ", nam);
       
       $("#mdlbmsnsn").text("");
       $("#mdlbmsnsn").html("Desea anular este contrato");
   $("#ModalBorrar").addClass("show").css("display", "block").removeAttr("aria-hidden").attr("aria-modal", "true").attr("name", nam);
        $("#mdlbmsnsn").attr("name", nam);
   });
   
   $("#btn_mod_si").on("click",function(){
       var dia = $("#mdlbmsnsn").text();
       var id = $("#mdlbmsnsn").attr("name");
       console.log("dia : ", dia , id);
       if(dia === "Desea anular este contrato"){
           $.ajax({
                                        type : "post",
                                        url:"crearcontrato",                           
                                        data : {"func" : "anularContrato",
                                            "id" : id,


                                        },
                                        beforeSend: function (xhr) {

                                        },
                                        success: function (data, textStatus, jqXHR) {
                                            console.log(data);
                                        //   var resp = JSON.parse(data);
                                        ///    console.log(resp.data);
                                        
                                        if(data.trim() === "contrato anulado"){
                                            $("#alertverde").addClass("show");
                                             $("#alertparrafo").text(data);  
                                             setTimeout(function(){
                                                 $("#alertverde").removeClass("show");
                                             },6000);
                                                tablecontrato();
                                         }else{

                                             $("#alertrojo").addClass("show");
                                             $("#alertparraforojo").text(data);  
                                             setTimeout(function(){
                                                 $("#alertrojo").removeClass("show");
                                             },6000);
                                         }
                                
                                        
                                        },
                                        error: function (jqXHR, textStatus, errorThrown) {

                                        },

                                        complete: function (jqXHR, textStatus) {
                                            //document.location.href = "views/inicio/inicio.php";
                                        }



                                      });
           
       }
   });
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
     
     
     
     $("#btn_envio_contrato").on("click",function(){
            
        var salida = formulariosEnvioValida("divFormContrato");
         
         console.log("salida de la validacion del formulario",salida);
         if(salida !== false){
                $.ajax({
               type : "post",
               url:"crearcontrato",                           
               data : {"func" : "crearContrato",
                   "id_nombre" : salida["id_nombre"],
                   'id_fingreso' : salida["id_fingreso"],
                   'id_rut' : salida["id_rut"],
                   'id_direccion' : salida["id_direccion"],
                   'id_telefono' : salida["id_telefono"],
                   'id_pais' : salida["id_pais"],
                   'id_ciudad' : salida["id_ciudad"],
                   'id_comuna' : salida["id_comuna"],} ,


               beforeSend: function (xhr) {

               },
               success: function (data, textStatus, jqXHR) {
                   console.log(data);
                   $(location).attr('href','http://localhost:8090/LogisticFV/contrato.jsp#menu0');
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
     }else{
         
         
     }
         
     });
 
    
    // ----------------------------captura de botones de actualizar y borrar------------------------------
    $("#example").on("click","tr button",function(){
        var clic = $(this).attr("name");
     //   console.log("click : ",clic);
        setTimeout(function(){
            dataContratos(clic);
        },100); 
    });
    var datacontrato = []; 

    $('#example tbody').on('click', 'tr', function () {
        var table = $('#example').DataTable();
        datacontrato = table.row(this).data();
        
        var clic = $("document button").attr("name");
     //   console.log("cliock : ",clic);
     //   console.log("table : ", datacontrato);
    });

    function dataContratos(tipo ){
        console.log("tipo",tipo);
        if(tipo == "actualizar"){
             formulariosValidaOrigen("divFormContrato_up");
        //    console.log("click : ",tipo);
        //    console.log("table : ", datacontrato);
            $("#exampleModal").addClass("show").css("display","block").removeAttr("aria-hidden").attr("aria-modal","true");
            $("#id_nombre_up").val(datacontrato["Nombre"]);
            $("#id_fingreso_up").val(datacontrato["Fecha_Ingreso"]);
            $("#id_rut_up").val(datacontrato["RUT"]);
            $("#id_direccion_up").val(datacontrato["Direccion"]);
            $("#id_telefono_up").val(datacontrato["Telefono"]);
            $("#id_pais_up").val(datacontrato["Pais"]);   
            $("#id_ciudad_up").val(datacontrato["Ciudad"]);
            $("#id_comuna_up").val(datacontrato["Comuna"]);
        }else if(tipo == "eliminar"){
            $("#modalmsnsn").addClass("show").css("display","block").removeAttr("aria-hidden").attr("aria-modal","true");
            $("#mdlbmsnsn").text("");
            $("#mdlbmsnsn").html("Seguro que desea eliminar el registro");
            
            $("#btn_mod_si").on("click",function(){
                console.log("iso click en si : ", datacontrato["RUT"]);
           
                $.ajax({
               type : "post",
               url:"crearcontrato",                           
               data : {"func" : "deleteContrato",
                   "id_rut_d" : datacontrato["RUT"]} ,


               beforeSend: function (xhr) {

               },
               success: function (data, textStatus, jqXHR) {
                   console.log(data);
                   tableContratos();
                //   $(location).attr('href','http://localhost:8090/LogisticFV/contrato.jsp#menu0');
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
$("#btn_mod_cerrar").on("click",function(){
    
    $("#exampleModal").removeClass("show").css("display","none").removeAttr("aria-modal").attr("aria-hidden","true");
});
 
$("#btn_mod_modificar").on("click",function(){
    
    var salida = formulariosEnvioValida("divFormContrato_up");
    console.log("tag : ", salida);
    console.log("tag can : ", salida.length);
    var data = new FormData();
        data.append("func","updateContrato");

    if(salida !== false){
        console.log("entro al ajax");
                $.ajax({
                url: "crearcontrato", 
                type : "post",                                    
                data : {"func" : "updateContrato",
                   "id_nombre" : salida["id_nombre_up"],
                   'id_fingreso' : salida["id_fingreso_up"],
                   'id_rut' : salida["id_rut_up"],
                   'id_direccion' : salida["id_direccion_up"],
                   'id_telefono' : salida["id_telefono_up"],
                   'id_pais' : salida["id_pais_up"],
                   'id_ciudad' : salida["id_ciudad_up"],
                   'id_comuna' : salida["id_comuna_up"],} ,
            //    contentType: false,
            //    processData: false,

               success: function (data, textStatus, jqXHR) {
                   console.log(data);
                   tableContratos();
                 //  $(location).attr('href','http://localhost:8090/LogisticFV/contrato.jsp#menu0');
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


$("#btn_mod_no").on("click",function(){
    
    $("#modalmsnsn").removeClass("show").css("display","none").removeAttr("aria-modal").attr("aria-hidden","true");
    
});
 
 
 
 
// -----------------fin funcionamiento de botones de modal eliminar----------------------------------- 
 
 
 
 

     function formulariosEnvioValida(idform){
        var  x =0;
        var dataarray = [];
        var tag = true;
         $("#"+idform+" input").each(function(){
             var id = $(this).attr("id");
             console.log("id de los imput de los formularios",id);
             var datos = $("#"+id).val();
             console.log("datos :",datos);
             if(datos != ""){
                 dataarray[id] = datos;
                 $("#"+id).css("border","1px solid #ced4da");
             }else{
                 tag = false;
                 $("#"+id).css("border","1px solid red");
             }
             
             x++;
         });
         console.log("dataarray ",dataarray);
         if(tag == true){
             return dataarray;
         }else{
             return tag;
         }
         
         
     }
     
     function formulariosValidaOrigen(idform){
        var  x =0;
        var dataarray = [];
        var tag = true;
         $("#"+idform+" input").each(function(){
             var id = $(this).attr("id");
        //     console.log("id de los imput de los formularios",id);
            $("#"+id).css("border","1px solid #ced4da");
          
         });

     }
    
    
});


