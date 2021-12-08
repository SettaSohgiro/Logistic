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
    
    var formato = "";
    
    $("#amenu1").on("click",function(){
        // borrarFormulario("formularioVenta");
    });
    
    
    $(function () {
     
         $("#div_pago_otros").css("display" , "none");
         $("#div_pago_efectivo").css("display" , "none");
        var fecha = new Date() ;

        formato = fecha.getDate()+"/"+ (fecha.getMonth() + 1 )+"/"+fecha.getFullYear();
        $("#id_fecha_venta").val(formato);
        console.log("fecha : ",formato);
        $("#id_nombre_usuario").val($("#id_usuario_sesion").text()+" "+$("#id_paterno_sesion").text());
        $("#id_usuario").val($("#id_id_sesion").val());
        selectClientes();
        selectComprobante();
        
      
       // tableVentas();
        tableStock();
        tableVentas(); 
      //  selectRol();
      
    });
    function tableVentas() {
        $('#tableVentas').dataTable().fnClearTable();
        $('#tableVentas').dataTable().fnDestroy();
        var tableV = $('#tableVentas').dataTable({

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
                url: "VentaIngreso", // json datasource
                type: "post", // method  , by default get
                data: {"func": "tablaUsuario"},
            },
            "order": [[0, "desc"]],
            "bPaginate": true,
            "sPaginationType": "full_numbers",
            "iDisplayLength": 100,
            "aoColumns": [
                { mData: "usernom"} ,
                { mData: "iduser"} ,
                { mData: "nbolf"} ,
                { mData: "tipo_com"} ,
                { mData: "comprobante"} ,
                { mData: "impuesto"} ,
                { mData: "totalim"} ,
                { mData: "pago"} ,
                { mData: "vuelto"} ,
                { mData: "cod_trans"} ,
                { mData: "cliente"} ,
                { mData: "formapago"} ,
                { mData: "estado"} ,
                { mData: "estadopago"} ,
                { mData: "id_venta"} ,
                { mData: "fechaventa"} 
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
    
    
        function tableStock() {
        $('#tableStock').dataTable().fnClearTable();
        $('#tableStock').dataTable().fnDestroy();
        var tableS = $('#tableStock').dataTable({

            scrollY: "500px",
            scrollX: true,
            scrollCollapse: true,
            paging: true,
            fixedColumns: {
                //  leftColumns: 2
            },
            "pageLength": 10,
            lengthMenu: [[10, 25, 50], [10, 25, 50]],
            "columnDefs": [
                    {"targets": [2,5,10],"visible": false,"searchable": true},

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
                url: "VentaIngreso", // json datasource
                type: "post", // method  , by default get
                data: {"func": "tableStock"},
            },
            "order": [[9, "desc"]],
            "bPaginate": true,
            "sPaginationType": "full_numbers",
            "iDisplayLength": 100,
            "aoColumns": [
                {mData:"SELECCIONAR"},
                {mData:"ID"},
                {mData:"ID_FRUTA"},
                {mData:"NOMBRE"},
                {mData:"STOCK"},
                {mData:"ID_CALIDAD"},
                {mData:"CALIDAD"},
                {mData:"PRECIO"},
                {mData:"FECHA_CO"},
                {mData:"VENTA_KILOS"},
                {mData:"ESTADO"}
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
    
    function selectClientes() {
        $.ajax({
            type: "post",
            url: "VentaIngreso",
            data: {"func": "selectClientes"},
            beforeSend: function (xhr) {

            },
            success: function (data, textStatus, jqXHR) {
                var resp = JSON.parse(data);
                console.log("selectClientes : ",resp);
                //    console.log(data);
                $("#sl_cliente_ven option").remove();
                $("#sl_cliente_ven").append("<option value='0'>--seleccione--</option>");
                $.each(resp, function (key, value) {
                 //   console.log(value[0]);
                    $("#sl_cliente_ven").append("<option value='" + value["ID"] + "'>" + value["Nombre"] + "</option>");
                });
            },
            error: function (jqXHR, textStatus, errorThrown) {

            },
            complete: function (jqXHR, textStatus) {

            }

        });
    }
    
    
     function selectComprobante() {
        $.ajax({
            type: "post",
            url: "VentaIngreso",
            data: {"func": "selectComprobante"},
            beforeSend: function (xhr) {

            },
            success: function (data, textStatus, jqXHR) {
                var resp = JSON.parse(data);
                console.log("Comprobante : ",resp);
                //    console.log(data);
                $("#id_comprob_venta option").remove();
                $("#id_comprob_venta").append("<option value='0'>--seleccione--</option>");
                $.each(resp, function (key, value) {
                 //   console.log(value[0]);
                    $("#id_comprob_venta").append("<option value='" + value["ID"] + "'>" + value["Comprobante"] + "</option>");
                });
            },
            error: function (jqXHR, textStatus, errorThrown) {

            },
            complete: function (jqXHR, textStatus) {

            }

        });
    }   
    
    
$("#id_comprob_venta").on("change", function(){
    var val = $(this).val();
    console.log("val _ ", val);
    
    Com_boleta_fact(val);
});    
    
    
    function Com_boleta_fact(val){
        $.ajax({
            type: "post",
            url: "VentaIngreso",
            data: {"func": "Com_boleta_fact","val":val},
            beforeSend: function (xhr) {

            },
            success: function (data, textStatus, jqXHR) {
                var resp = JSON.parse(data);
    //            console.log("Com_boleta_fact : ",resp);
                //    console.log(data);
                $("#id_numfac_ven").val(resp[0]["ID"]);
            },
            error: function (jqXHR, textStatus, errorThrown) {

            },
            complete: function (jqXHR, textStatus) {

            }

        });
    }
    
    
$(this).on('click','.stock_fruta', function() {
    var at =  $(this).attr("id"); 
    var  val = $("#"+at).val();
 //   console.log("at :"+at+" val : "+val);
  //  llenadotablastock(val);
}); 


$('#tableStock tbody').on('click', 'tr', function () {
        var table = $('#tableStock').DataTable();
        var datatable = table.row(this).data();
//        console.log("tableStock");
//        console.log(datatable);
    AgregarFilaVenta(datatable);
});
 
 var posiCa =  0;
function AgregarFilaVenta(data){
     
    var tds=$("#tablepedidoDetalle thead tr:first th").length;
//numerosDecimales
//    console.log("tds : "+tds);
    var clas = $("#btnPlay_"+data["ID"]).attr("class").split(' ');
//    console.log("buton : "+clas);

    
    // Obtenemos el total de columnas (tr) del id "tabla"
    var trs=$("#tablepedidoDetalle tr").length;
//    console.log("data : ", data);
//    console.log("trs : "+trs);
    
    if(clas[3] == "btn-success"){
        var nuevaFila="<tr id='tr_"+data["ID"]+"' >";
        for(var i=0;i<tds;i++){
            // añadimos las columnas
            if(i == 0){
               nuevaFila+="<td style='width: 12%'>"+"<input type='text' class='clasValidar form-control input-lg clas_ID ' id='cerrar_"+data["ID"]+"' value='"+data["ID"]+"' id='nuevoDescripcion_"+posiCa+"' name='nuevoDescripcion_"+posiCa+"' total='0' placeholder='' readonly='' required=''>"+"</td>";
            }else 
            if(i == 1){
               nuevaFila+="<td style='width: 40%'>"+"<input type='text' class='clasValidar form-control input-lg clas_descrip' value='"+data["NOMBRE"]+"' id='nuevoDescripcion_"+posiCa+"' name='nuevoDescripcion_"+posiCa+"' total='0' placeholder='' readonly='' required=''>"+"</td>";
            }else 
            if(i == 2){
               nuevaFila+= "<td style='width: 10%'>"+"<input id='nuevocantidad_"+data["ID"]+"' name='"+data["ID"]+"' value='0' type='text' class='clasValidar form-control input-lg clasCantidad '  placeholder='' required='' maxlength='6' >"+"</td>";
            }else 
            if(i == 3){
               nuevaFila+= "<td style='width: 10%'>"+"<input type='text' class='clasValidar form-control input-lg clas_stock ' value='"+data["STOCK"]+"' id='nuevoStock_"+data["ID"]+"' name='"+data["STOCK"]+"' placeholder='' readonly='' required=''>"+"</td>";
            }else 
            if(i == 4){
               nuevaFila+= "<td style='width: 25%'>"+"<input type='text' class='clasValidar form-control input-lg clas_descrip ' value='0' id='nuevoTotal_"+data["ID"]+"' name='"+data["STOCK"]+"' placeholder='' readonly='' required=''>"+"</td>";
            }else 
            if(i == 5){
               nuevaFila+= "<td style='width: 4%'>"+"<span class='input-group-addon'><button type='button' class='btn-danger btn  btn-xs quitarProducto' id='"+data["ID"]+"' value='_"+posiCa+"' >X</button></span> "+"</td>";
            }

       }
    
        nuevaFila+="</tr>";
        posiCa++;
        $("#body_venta").append(nuevaFila);
        
        $("#btnPlay_"+data["ID"]).removeClass("btn-success");
        $("#btnPlay_"+data["ID"]).addClass("btn-secondary");
    }    
        
    }
    
$(this).on('click','.quitarProducto', function() {
    var at =  $(this).attr("id"); 
  //  var  val = $("#"+at).val();
 //   console.log("at :"+at);
    
    $("#tr_"+at).remove();
        $("#btnPlay_"+at).removeClass("btn-secondary");
        $("#btnPlay_"+at).addClass("btn-success");
  //  llenadotablastock(val);
    //    totalDetalleVenta();
        calculoImpustoVenta();
}); 
 
    
$(this).on('keyup','.clasCantidad',function() {
    var valor =  $(this).val(); 
    var id =  $(this).attr("name"); 
  //  var  val = $("#"+at).val();
//    console.log("at :"+valor+ " id : "+ id);
    var stock = $("#nuevoStock_"+id).attr("name");
 //   console.log("stock : "+stock);
    if((stock - valor) >= 0){
        $("#nuevoStock_"+id).val(stock - valor);
        var precio = $("#nuevoTotal_"+id).attr("name");
        $("#nuevoTotal_"+id).val(precio * valor);
        $("#nuevocantidad_"+id).css("border","1px solid #ced4da");
        totalDetalleVenta();
        calculoImpustoVenta();
    }else{
        $("#nuevocantidad_"+id).css("border","1px solid red");
        $("#nuevocantidad_"+id).val(0);
        $("#nuevoStock_"+id).val(stock );
    }
    
    

});     
    
    
    
 function totalDetalleVenta(){
    var info = ""; 
    var info2 = []; 
    var total = 0;
    var totales = 0;
   $('.clas_ID').each(function(e) {
     info += this.value + " ";

  
   });
//     console.log("info each : "+info);
     info2 = info.split(" ");
//     console.log("info2  : "+info2);
   
    $.each(info2 , function(key , value) {
//        console.log("value each : "+value);
        if(value != ""){
            total =   parseInt($("#nuevoTotal_"+value).val());
//            console.log("total each : "+total);
            totales = totales + total ; 
        }

     }); 
//   console.log("totales fin : "+totales);
   
   $("#nuevoTotalVenta").val(totales);
   
   return totales;
   /*  $.each($("#body_venta tr input"),function(key , value){
         console.log("value : "+value);
     });*/
 } 
 
$("#nuevoImpuestoVenta").on("change",function(){
    calculoImpustoVenta();
}); 
    
    
function calculoImpustoVenta(){
    
    var totales = totalDetalleVenta();
  //  var totales = $("#nuevoTotalVenta").val();
    var impu = $("#nuevoImpuestoVenta").val();
    var totaldef = 0;
    
    if(impu > 0){
        totaldef =  Math.round(totales * ((impu / 100) + 1)) ;
        $("#nuevoTotalVenta").val(totaldef);
    }
    var nuevop = $("#nuevoPago").val();
    if(nuevop != "0"){
        $("#nuevoVuelto").val( nuevop - totaldef);
    }
        
    
}    


$("#btnGuardarVenta").on("click",function(){
    
    
    
    
    var btngua = formulariosEnvioValida("formularioVenta");
    console.log("btngua : "+btngua);
        if(btngua != false){
          insertVenta(btngua[0] ,btngua[1],btngua[2],btngua[3],btngua[4] ,btngua[5] ,btngua[6] ,btngua[7] ,btngua[8] ,btngua[9] ,btngua[10] ,btngua[11] ,btngua[12] ,btngua[13] ,btngua[14] ,btngua[15] ,btngua[16] );
      }
  
  

            

            
});
    
    
 $("#nuevoMetodoPago").on("change",function(){
     var sel = $("#nuevoMetodoPago").val();
     console.log("sel : ",sel);
     
     $("#nuevoCodigoTransaccion").val("");
     $("#nuevoPago").val("");
     $("#nuevoVuelto").val("");
     
     if(sel == "EF"){
    
         $("#div_pago_efectivo").css("display" , "block");
         $("#div_pago_otros").css("display" , "none");
         $("#nuevoPago").val("0");
         $("#nuevoVuelto").val("0");
     }else if(sel == "TC" || sel == "TD" || sel == "DD"){
         $("#div_pago_otros").css("display" , "block");
         $("#div_pago_efectivo").css("display" , "none");
         $("#nuevoCodigoTransaccion").val("0");
     }else{
          $("#div_pago_otros").css("display" , "none");
         $("#div_pago_efectivo").css("display" , "none");
     }
     
     
 });   
    
    
 $("#nuevoPago").on("change", function(){
     calculoImpustoVenta();
 });   
    
//  function insertVenta(user,iduser,nbolf,fechaventa,idpro_de,descrip_de,cant_de,stock_de,total_de,impuesto,totalim,pago,vuelto,cod_trans,cliente,tipo_com,formapago,){
   function insertVenta(user,iduser,nbolf,fechaventa,impuesto,totalim,pago,vuelto,cod_trans,cliente,tipo_com,formapago){
     
    console.log("insert venta : "+user);
      $.ajax({
            type: "post",
            url: "VentaIngreso",
            data: {"func": "insertVenta",
                    "user":user,
                    "iduser":iduser,
                    "nbolf":nbolf,
                    "fechaventa":fechaventa,
                    "impuesto":impuesto,
                    "totalim":totalim,
                    "pago":pago,
                    "vuelto":vuelto,
                    "cod_trans":cod_trans,
                    "cliente":cliente,
                    "tipo_com":tipo_com,
                    "formapago":formapago},
            beforeSend: function (xhr) {

            },
            success: function (data, textStatus, jqXHR) {
                console.log("Ventas  : ",data);
              //  var resp = JSON.parse(data);
            //    console.log("Ventas  : ",resp);
                //    console.log(data);
                            var larg = $("#body_venta tr").length;
            
            var detalle = [];
            detalle = leerDetalle("body_venta");
            console.log("cliente ",cliente);
            var larin = insertVentadetalle(detalle , cliente);
            console.log("detalle : " ,detalle);
            console.log("largo body : ",larg, larin);
       
                    if(data.trim() === "Venta ingresada"){
                       $("#alertverde").addClass("show");
                        $("#alertparrafo").text(data);  
                        setTimeout(function(){
                            $("#alertverde").removeClass("show");
                        },6000);
                        borrarformulario();
                        tableStock();
                        tableVentas();
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

            }

        });
  }  
  
   function insertVentadetalle(detalle , cliente){
     var x = 0;
    console.log("insert insertVentadetalle : ");
    
    $.each(detalle ,function(key,value){
        x++;
        console.log("value : ", value[1]);
              $.ajax({
            type: "post",
            url: "VentaIngreso",
            data: {"func": "insertVentadetalle",
                    "id":value[0],
                    "descrip" : value[1],
                    "cantidad" : value[2],
                    "stock" : value[3],
                    "total" : value[4],
                    "cliente" : cliente
            },
   
            beforeSend: function (xhr) {

            },
            success: function (data, textStatus, jqXHR) {
                console.log("Ventasdetalle  : ",data);
           
               
            },
            error: function (jqXHR, textStatus, errorThrown) {

            },
            complete: function (jqXHR, textStatus) {

            }

        });
    });
    
    return x;

  }  
    
 function borrarformulario(){
     $("#sl_cliente_ven").val(0);
     $("#id_comprob_venta").val(0);
     $("#id_numfac_ven").val(0);
     $("#nuevoImpuestoVenta").val(0);
     $("#nuevoTotalVenta").val(0);
     $("#nuevoMetodoPago").val(0);
     $("#body_venta tr").remove();
 }  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    function formulariosEnvioValida(idform) {
        var x = 0;
        var dataarray = [];
        
        var tag = true;
        $("#" + idform + " input").each(function () {
            var id = $(this).attr("id");
            var clas = $(this).attr("class").substr(0,11).trim();
            var sel = $("#nuevoMetodoPago").val();
            //   console.log("id de los imput de los formularios",id , sel, clas);
  
            var datos = $("#" + id).val().trim();
      //         console.log("datos :",datos);
      
      
            if(clas != "clasValidar"){
            
                if ((datos !== "0" && datos !== "0" )   || !datos ){   //
                  //  dataarray[id] = datos;
                    dataarray.push(datos);
                    $("#" + id).css("border", "1px solid #ced4da");
                } else {
                    tag = false;
                    $("#" + id).css("border", "1px solid red");
          //          console.log("entro en 1");
                }
            }
            x++;
        });
// console.log("dataarray ",dataarray);

        $("#" + idform + " select").each(function () {
            var id = $(this).attr("id");
        //       console.log("id de los select de los formularios",id);
            var datos = $("#" + id).val();
       //         console.log("datos :",datos);
            if (datos !== "0") {
               // dataarray[id] = datos;
                dataarray.push(datos);
                $("#" + id).css("border", "1px solid #ced4da");
            } else {
                tag = false;
                $("#" + id).css("border", "1px solid red");
        //        console.log("entro en ");
            }
        });
        

        
        
        
        
        
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
    
    function leerDetalle(idform){
        
            var detaarray = [[]];
            var finalarr = [[]];
            var x = 0;
            var y = 0;
            var iid = "";
            var datos2 = "";
            
            var id = "";
            var datos = "";
            
            $("#" + idform + " tr ").each(function () {
                id = $(this).attr("id");

                $("#" + id + " input ").each(function () {
                    iid = $(this).attr("id");
                    datos2 = $("#" + iid).val();
             //       console.log("datos :",datos2);
                    detaarray[x] = datos2;
                    x++;
                });
                 finalarr[y] = detaarray;   
                 y++;
                 x = 0;
                 detaarray = [[]];
                
                
        });
        // console.log("detaarray : ", detaarray);
     //   console.log("finalarr : ", finalarr);
       
       return finalarr;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
});


