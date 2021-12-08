/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    
    
    $(".btn_menu_nav").on("click",function(){
        var id = $(this).attr("id");
        console.log("id _:", id);
        if(id == "btn_Inicio"){
            $("#id_inicio").css("display","block");
            $("#id_galeria").css("display","none");
            $("#div_contacta").css("display","none");
           
        }else if(id == "btn_Galería"){
            $("#id_inicio").css("display","none");
            $("#id_galeria").css("display","block");
            $("#div_contacta").css("display","none");
           
        }else if(id == "btn_Contáctenos"){
            $("#id_inicio").css("display","none");
            $("#id_galeria").css("display","none");
            $("#div_contacta").css("display","block");
           
        }
        
    });
    
   /* $("#btn_Login").on("click",function(){
        var style = $("#loginModal").attr("style");
        console.log(style);
        if(style == "display: none;"){
            $("#loginModal").attr("style","display: block;");
        }else{
            $("#loginModal").attr("style","display: none;");
        }
    });
    */
});

