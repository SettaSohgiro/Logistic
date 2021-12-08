$(document).ready(function(){
    
    $(".img-res").on("click",function(){
        var img = $(this).attr("src");
      //  console.log(img);
        imagemodal(img);
        
    });
    
    function imagemodal(img){
         $("#dialogcargamsn").css("display", "block");
         $("#imag").attr("src","");
         $("#imag").attr("src",img);
    }
    
    $("#btnmodalokmsn").on("click",function(){
        $("#dialogcargamsn").css("display", "none");
        
        
    });
});