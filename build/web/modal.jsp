<%-- 
    Document   : modal
    Created on : 16-10-2021, 18:34:32
    Author     : Lee
--%>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>






<!-- Modal Actualizacion usuario-->
<div class="modal fade bd-example-modal-lg" id="ModalActualizar" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Actualizacion de Usuario</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <div id="divFormUsuario_up">

                    <div id="div_panel_empresa_up">        



                    </div>    


                    <div class="panel panel-primary filterable " style="border: 1px solid grey;border-radius: 5px;">
                        <div class="panel-heading" style="background-color: #c5dbef;color: #322F2D;font-size: 13px;height: 30px;    padding: 6px 0 0 15px;">
                            <p>Usuario</p>
                        </div>

                        <div id="form_usuario"  class="container" >
                            <input type="hidden" class="form-control" id="id_idup" name="id_idup">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="id_nombre_up">Nombre</label>
                                    <input type="text" class="form-control" id="id_nombre_up" name="id_nombre_up" placeholder="Nombre">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="id_apaterno_up">Apellido Paterno</label>
                                    <input type="text" class="form-control" id="id_apaterno_up" name="id_apaterno_up" placeholder="apellido paterno">
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="id_amaterno_up">Apellido Materno</label>
                                    <input type="text" class="form-control" id="id_amaterno_up" name="id_amaterno_up" placeholder="apellido materno">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="id_rut_up">RUT</label>
                                    <input type="text" class="form-control" id="id_rut_up" name="id_rut_up" placeholder="rut">
                                </div>
                            </div>

                            <div class="form-row">

                                <div class="form-group col-md-6">
                                    <label for="id_telefono_up">Telefono</label>
                                    <input type="text" class="form-control" id="id_telefono_up" name="id_telefono_up" placeholder="id_telefono2">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="id_telefono2_up">Telefono2</label>
                                    <input type="text" class="form-control" id="id_telefono2_up" name="id_telefono2_up" placeholder="direccion">
                                </div>

                            </div> 

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="id_correo_up">Correo</label>
                                    <input type="text" class="form-control" id="id_correo_up" name="id_correo_up" placeholder="Correo">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="id_direccion_up">Direccion</label>
                                    <input type="text" class="form-control" id="id_direccion_up" name="id_direccion_up" placeholder="direccion">
                                </div>

                            </div>


                            <div id="div_lugar_up">


                            </div>


                            <!--    <div class="form-row" style="display:none;">
                                      <div class="form-group col-md-3">
                                        <label for="id_usuario">Usuario</label>
                                        <input type="text" class="form-control" id="id_usuario" name="id_usuario" placeholder="usuario" readonly="">
                                      </div>
                                      <div class="form-group col-md-3">
                                        <label for="id_pass">Password</label>
                                            <input type="text" class="form-control" id="id_pass" name="id_pass" placeholder="password" readonly="">
                                      </div>
                        
                                    </div>   -->
                        </div>     
                    </div>    


                </div>





            </div>
            <div class="modal-footer">
                <button id="btn_mod_modificar" type="button" class="btn btn-success">Actualizar</button>
                <button id="btn_mod_cerrar" type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                <!--  <button type="button" class="btn btn-primary">Save changes</button>-->
            </div>
        </div>
    </div>
</div>





<!-- Modal de advertencia si o no  -->

<div class="modal fade" id="ModalBorrar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header" >
        <h5 class="modal-title" id="exampleModalLabel">Adventencia</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <label id="mdlbmsnsn"></label>
      </div>
      <div class="modal-footer" style="background: #92bd92;">
            <button id="btn_mod_si" type="button" class="btn btn-success" data-dismiss="modal">Si</button>
            <button id="btn_mod_no" type="button" class="btn btn-danger" data-dismiss="modal">No</button>
      </div>
    </div>
  </div>
</div>



<!-- Modal de mensaje -->

<div class="modal fade" id="modalmsn" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header" style="background: #269b1c;">
        <h5 class="modal-title" id="exampleModalLabel">Atencion</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
            <label id="mdlbmsn"></label>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Volver</button>
       
      </div>
    </div>
  </div>
</div>




<div class="modal fade" id="modalmsn" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" role="dialog" style="background: #2f2d2db3;">
    <div class="modal-dialog" style="max-width: 1000px;">
        <div class="modal-content">
            <div class="modal-header" style="background: #269b1c;">
                <h5 class="modal-title" id="mdcabemsnsn">Atencion</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" style="text-align: center;font-size: 22px;height: 200px;">
                <label id="mdlbmsn"></label>
            </div>
            <div class="modal-footer" style="background: #92bd92;">
                <button id="btn_volver" type="button" class="btn btn-success" >Volver</button>

            </div>
        </div>
    </div>
</div>



<!-- Modal de prueba de factura -->

<div class="modal fade" id="ModalprintDiv" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" style="display:none;">
    <div class="modal-dialog" role="document" style="max-width: 800px;">
    <div class="modal-content">
      <div class="modal-header" >
        <h5 class="modal-title" id="exampleModalLabel">Factura</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <!--   <span aria-hidden="true">&times;</span>  -->
        </button>
      </div>
      <div class="modal-body">
          
          
       <div id="printDiv">
<table style="width: 700px;"><tr> <td style='width:100px'><img src='https://i.ibb.co/SP5nS3x/logo.jpg' alt="This is a cool picture" width="200px" >     </td>
			<td style='background-color:white; width:140px;'><div style='font-size:11px; text-align:center; line-height:15px;'>	<br>RUT: 99.999.999-9<br>Dirección: Av. Martin Wagner 111</div></td>
			<td style='background-color:white; width:160px;text-align:center;'><div style='font-size:11px; text-align:center; line-height:18px;'><br>Teléfono: +56 9 22 222 222<br>Email: administracion@logistic.cl</div></td>
                        <td style='background-color:white; width:150px; text-align:center; color:black;'><br>FACTURA <br> NRO: <span id="m_facturanum"></span></td></tr></table>
                        
   	<table style="font-size:10px; padding:5px 10px;width: 700px; margin-top: 50px;">	
		<tr>		
			<td style="border: 1px solid #666; background-color:white; width:390px">
				Cliente: <span id="m_cliente"></span>
			</td>
			<td style="border: 1px solid #666; background-color:white; width:150px; text-align:left">			
				Fecha: <span id="m_fechafact"></span>
			</td>
		</tr>
		<tr>		
			<td style="border: 1px solid #666; background-color:white; width:540px">Vendedor: <span id="m_vendedor"></span></td>
		</tr>
		<tr>
                    <td style="border-bottom: 1px solid #666; background-color:white; width:540px"></td>
		</tr>
	</table>                     
                        
      <table style="font-size:10px; padding:5px 10px;width: 700px; margin-top: 50px;">
            <head>
		<tr>
		
		<td style="border: 1px solid #666; background-color:#0c045e;color:#fff; width:260px; text-align:center">Producto</td>
		<td style="border: 1px solid #666; background-color:#0c045e;color:#fff; width:80px; text-align:center">Cantidad</td>
		<td style="border: 1px solid #666; background-color:#0c045e;color:#fff; width:100px; text-align:center">Valor Unit.</td>
		<td style="border: 1px solid #666; background-color:#0c045e;color:#fff; width:100px; text-align:center">Valor Total</td>

		</tr>
        </head>
        
        <tbody id="val_detalle_factura">
 
        </tbody>
	</table>  
           
           
       <table style="font-size:10px; padding:5px 10px;width: 700px;">
		<tr>
			<td style="color:#333; background-color:white; width:340px; text-align:center"></td>

			<td style="border-bottom: 1px solid #666; background-color:white; width:100px; text-align:center"></td>

			<td style="border-bottom: 1px solid #666; color:#333; background-color:white; width:100px; text-align:center"></td>

		</tr>		
		<tr>		
			<td style="border-right: 1px solid #666; color:#333; background-color:white; width:340px; text-align:center"></td>

			<td style="border: 1px solid #666;  background-color:white; width:100px; text-align:center">
				Neto:
			</td>

			<td style="border: 1px solid #666; color:#333; background-color:white; width:100px; text-align:center">
				$ <span id="m_neto"></span>
			</td>

		</tr>
		<tr>
			<td style="border-right: 1px solid #666; color:#333; background-color:white; width:340px; text-align:center"></td>

			<td style="border: 1px solid #666; background-color:white; width:100px; text-align:center">
				Impuesto % <span id="m_porcentaje"></span> 
			</td>
		
			<td style="border: 1px solid #666; color:#333; background-color:white; width:100px; text-align:center">
				$ <span id="m_impuesto"></span>
			</td>

		</tr>

		<tr>		
			<td style="border-right: 1px solid #666; color:#333; background-color:white; width:340px; text-align:center"></td>

			<td style="border: 1px solid #666; background-color:white; width:100px; text-align:center">
				Total:
			</td>
			
			<td style="border: 1px solid #666; color:#333; background-color:white; width:100px; text-align:center">
				$ <span id="m_total"></span>
			</td>

		</tr>


	</table>    
                        
                        
</div>   
          
  <button type="button" id="pdfDownloader">Download PDF</button>  
      </div>
      <div class="modal-footer" style="background: #92bd92;">
         
            <button id="btn_modpdf_no" type="button" class="btn btn-danger" data-dismiss="modal">Volver</button>
      </div>
    </div>
  </div>
</div>







<!-- Modal Actualizacion Transporte-->
<div class="modal fade bd-example-modal-lg" id="ModalActualizarTransporte" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Actualizacion de Transporte</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <div id="divFormTransporte_up">

  


                    <div class="panel panel-primary filterable " style="border: 1px solid grey;border-radius: 5px;">
                        <div class="panel-heading" style="background-color: #c5dbef;color: #322F2D;font-size: 13px;height: 30px;    padding: 6px 0 0 15px;">
                            <p>Transporte</p>
                        </div>

                        <div id="form_usuario"  class="container" >
                              <input type="hidden" id="id_idTransporte" name="id_idTransporte" >
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="id_patente_mod">patente</label>
                                    <input type="text" class="form-control" id="id_patente_mod" name="id_patente_mod" placeholder="">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inp_tipo_vehiculo">tipo_vehiculo</label>
                                    <input type="text" class="form-control" id="inp_tipo_vehiculo" name="inp_tipo_vehiculo" placeholder="">
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="inp_capacidad_m3">capacidad_m3</label>
                                    <input type="text" class="form-control" id="inp_capacidad_m3" name="inp_capacidad_m3" placeholder="">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inp_capacidad_tonelada">capacidad_tonelada</label>
                                    <input type="text" class="form-control" id="inp_capacidad_tonelada" name="inp_capacidad_tonelada" placeholder="">
                                </div>
                            </div>

                            <div class="form-row">

                                <div class="form-group col-md-6">
                                    <label for="inp_nombre_conductor">nombre_conductor</label>
                                    <input type="text" class="form-control" id="inp_nombre_conductor" name="inp_nombre_conductor" placeholder="">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inp_tipo_licencia">tipo_licencia</label>
                                    <input type="text" class="form-control" id="inp_tipo_licencia" name="inp_tipo_licencia" placeholder="">
                                </div>

                            </div> 


                        </div>     
                    </div>    


                </div>





            </div>
            <div class="modal-footer">
                <button id="btn_mod_modificarT" type="button" class="btn btn-success">Actualizar</button>
                <button id="btn_mod_cerrarT" type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                <!--  <button type="button" class="btn btn-primary">Save changes</button>-->
            </div>
        </div>
    </div>
</div>



