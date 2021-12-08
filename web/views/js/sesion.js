/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    
    $(function(){
       // setTimeout(function(){
            var sesuser =  $("#id_usuario_sesion").text().trim();
            console.log("user:",sesuser);
            if(sesuser === "null" || sesuser === ""){
                console.log("no entro");
                //salida();
                var url = "http://localhost:8090/LogisticFV/index.jsp";    
                $(location).attr('href',url);
            }
      //  },500);
    });
    
         function salida() {
        $.ajax({
            type: "post",
            url: "./dirigir",
            data: {"func": "salir"},
            beforeSend: function (xhr) {

            },
            success: function (data, textStatus, jqXHR) {
                var resp = JSON.parse(data);

            },
            error: function (jqXHR, textStatus, errorThrown) {

            },
            complete: function (jqXHR, textStatus) {

            }

        });
    }
    
    
    
});

