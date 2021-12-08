$(document).ready(function () {
    $('#modificar_form').hide();

    $("li a ").on("click", function () {
        var lii = $(this).attr("id").substr(1, 5);
        var clali = $(this).attr("class").substr(9, 6);
        console.log("herf - class : ", lii, clali);
        if (clali != "active") {
            $.each($("#ul_nav_user li a"), function (key, value) {
                console.log(value, key);
                $("#amenu" + key).removeClass("active");
                $("#menu" + key).removeClass("active");

            });

            $("#a" + lii).addClass("active");
            $("#" + lii).addClass("active");


        }
    });

    $('#example').DataTable();

    $("tr #btn_modificar").on("click", function () {
        var modificarForm = $('#modificar_form');
        modificarForm.show();

        var fila = $(this).parent().parent();
        var idProducto = fila.find('#id_mod_producto').text();
        var idNombreP = fila.find('#id_mod_nombre').text();
        var idCalidadP = fila.find('#id_mod_calidad').text();
        var idTipoP = fila.find('#id_mod_tipo').text();
        var idPrecioP = fila.find('#id_mod_precio').text();
        var idCantidadP = fila.find('#id_mod_cantidad').text();
        var idFechaProduccion = fila.find('#id_mod_fecha_prod').text();
        alert(idNombreP)
        console.log(idNombreP)

        modificarForm.find('#id_producto').val(idProducto);
        modificarForm.find('#id_nombre').val(idNombreP);
        modificarForm.find('#id_calidad').val(idCalidadP);
        modificarForm.find('#id_tipo').val(idTipoP);
        modificarForm.find('#id_precio').val(idPrecioP);
        modificarForm.find('#id_cantidad').val(idCantidadP);
        modificarForm.find('#id_fecha_prod').val(idFechaProduccion);



        /*    
         $.ajax({
         type : "post",
         url:"   ../crearusuario",                           
         data : {"id_nombre" : nombre},
         beforeSend: function (xhr) {
         
         },
         success: function (data, textStatus, jqXHR) {
         console.log(data);
         var resp = JSON.parse(data);
         console.log(resp);
         // document.location.href = "views/inicio/inicio.php";
         },
         error: function (jqXHR, textStatus, errorThrown) {
         
         },
         
         complete: function (jqXHR, textStatus) {
         //document.location.href = "views/inicio/inicio.php";
         }
         
         
         
         });*/


    });

    $('#id_btn_modificar').on('click', function () {
        var modificarForm = $('#modificar_form');

        var opcion = confirm("¿Desea Modificar el Producto?");
        if (opcion) {
            var fila = $(this).parent().parent();
            var idproducto = fila.find('#id_producto').text();
            var data = modificarForm.serialize();
            $.post("updateproducto", data, function (res, est, jqXHR) {
                alert(res);
            });
        }
    });

    $('tr #id_borrar_btn').click(function (e) {
        e.preventDefault();
        var opcion = confirm("¿Desea Eliminar el Producto?");

        if (opcion) {
            var fila = $(this).parent().parent();
            var idproducto = fila.find('#id_mod_producto').text();
            var data = {idProducto: idproducto};
            $.post("deleteproducto", data, function (res, est, jqXHR) {
                alert(res);
                fila.remove();
            });
        }

    });


//    $('tr #btn-eliminar').click(function(e){
//        e.preventDefault();
//        var opcion = confirm("¿Desea Eliminar el Producto?");
//        
//        if(opcion){
//            var fila = $(this).parent().parent();
//            var idproducto = fila.find('#id_producto').text();
//            var data = {idProducto:idproducto};
//            $.post("deleteProducto", data, function(res, est, jqXHR){
//                alert(res);
//                fila.remove();
//            });
//        }
//        
//    });
});
