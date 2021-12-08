/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
  $('.leftmenutrigger').on('click', function (e) {
    $('.side-nav').toggleClass("open");
    $('#wrapper').toggleClass("open");
    e.preventDefault();
  });
  
  $("#button_togle").on("click",function(){
      var clas = $("#navbarText").attr("class");
      console.log("class : ", clas);
      if(clas == "collapse navbar-collapse"){
          $("#navbarText").removeClass("collapse navbar-collapse");
          $("#navbarText").addClass("collapse navbar-collapse show");
      }else{
          $("#navbarText").removeClass("collapse navbar-collapse show");
          $("#navbarText").addClass("collapse navbar-collapse");
          
      }
  });
  
  
});


