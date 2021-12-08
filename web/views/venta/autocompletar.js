/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var clik = "";
$('#inp_jefepro_formu').on('keyup', function() {
        var key = $(this).val();    
        var func = "autoCompletar";
        clik = 0;
  $.ajax({
            type: "POST",
            url: "../../controllers/pagosController.php",
            data: {"func":func,"key":key},
            success: function(data) {
                //Escribimos las sugerencias que nos manda la consulta
                $('#suggestions').fadeIn(1000).html(data);
                //Al hacer click en alguna de las sugerencias
                $('.suggest-element').on('click', function(){
                        //Obtenemos la id unica de la sugerencia pulsada
                        var id = $(this).attr('id');
                        //Editamos el valor del input con data de la sugerencia pulsada
                        $('#inp_jefepro_formu').val($('#'+id).attr('data'));
                        $('#id_jefeproRut_formu_cestas').val($('#'+id).attr('id'));
                        formuCabe($('#'+id).attr('id'), 1);
                        //Hacemos desaparecer el resto de sugerencias
                        $('#suggestions').fadeOut(1000);
                        clik = 1;
                      //  alert('Has seleccionado el '+id+' '+$('#'+id).attr('data'));
                        return false;
                });
            }
        });
});

/*

<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8" style="padding: 0  5px 0 0;">
                                    <div class="col-xs-11 col-sm-11 col-md-11 col-lg-11" style="padding: 0;margin: 0;">
                                        <input name="inp_jefepro_formu" id="inp_jefepro_formu" type="text" class="form-control input-sm inputcestas" style="height: 25px;font-size: 11px;border-radius: 0 5px 5px 0;" placeholder="Busqueda de Gerencias">
                                        <input id="id_jefeproRut_formu_cestas" type="hidden" value="0">
                                    </div>
                                    <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1" style="padding: 0;margin: 0;">
                                        <span class="glyphicon glyphicon-question-sign" style="margin: 5px 0 0 10px;color: #8585e4;" title="Se debe registrar el solicitante, dado que algunos casos es diferente al Jefe de Proyecto definido en Master de PPTO."></span>
                                    </div>
                                </div>
                                
                                */