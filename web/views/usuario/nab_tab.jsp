<%-- 
    Document   : nab_tab
    Created on : 01-10-2021, 12:29:49
    Author     : Lee
--%>

<div class="">
  <ul id="ul_nav_user" class="nav nav-tabs" role="tablist">
    <li class="nav-item">
      <a id="amenu0" class="nav-link active" data-toggle="tab" href="#menu0">Usuarios Registrados</a>
    </li>
    <li class="nav-item">
      <a id="amenu1" class="nav-link" data-toggle="tab" href="#menu1">Ingresos de Usuarios</a>
    </li>

  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div id="menu0" class=" tab-pane active"><br>
        
        



            <table id="example" class="display" style="width:100%">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NOMBRE</th>
                            <th>PATERNO</th>
                            <th>MATERNO</th>
                            <th>DIRECCION</th>
                            <th>TELEFONO</th>
                            <th>TELEFONO2</th>
                            <th>MAIL</th>
                            <th>USUARIO</th>
                            <th>PASS</th>
                            <th>COMUNA</th>
                            <th>REGION</th>
                            <th>PROVINCIA</th>
                            <th>RUT</th>
                            <th>ESTADO</th>
                            <th>ROL</th>
                            <th>NOMBRE_EMPRESA</th>
                            <th>RUT_EMPRESA</th>
                            <th>PAIS_EMPRESA</th>
                            <th>DIRECCION_EMPRESA</th>
                            <th>TELEFONO_EMPRESA</th>
                            <th>CORREO_EMPRESA</th> 
                            <th>Actualizar</th>
                            <th>Borrar</th>
                            
                        </tr>
                    </thead>
                    <tbody>

                    </tbody>
            </table>
  
    </div>
    <div id="menu1" class="tab-pane "><br>
     <!--    <form action="crearusuario" method="post" > -->
     <div id="divFormUsuario">
         
         
            <div class="form-row">
              <div class="form-group col-md-6">
                <label for="sl_rol_user">Rol</label>
                    <select id="sl_rol_user" class="custom-select">
                        <option selected>--seleccione--</option>
              
                    </select>
              </div>
   
            </div>
 
<div id="div_panel_empresa">        
         
    
      
</div>  
         
<div id="div_panel_transporte">        
  
    
      
</div>          
         
         
         
         
    <div class="panel panel-primary filterable " style="border: 1px solid grey;border-radius: 5px;">
                                        <div class="panel-heading" style="background-color: #c5dbef;color: #322F2D;font-size: 13px;height: 30px;    padding: 6px 0 0 15px;">
                                            <p>Usuario</p>
                                        </div>

        <div id="form_usuario"  class="container" >
               
            <div class="form-row">
              <div class="form-group col-md-6">
                <label for="id_nombre">Nombre</label>
                <input type="text" class="form-control" id="id_nombre" name="id_nombre" placeholder="Nombre">
              </div>
              <div class="form-group col-md-6">
                <label for="id_apaterno">Apellido Paterno</label>
                <input type="text" class="form-control" id="id_apaterno" name="id_apaterno" placeholder="apellido paterno">
              </div>
            </div>

           <div class="form-row">
              <div class="form-group col-md-6">
                <label for="id_amaterno">Apellido Materno</label>
                <input type="text" class="form-control" id="id_amaterno" name="id_amaterno" placeholder="apellido materno">
              </div>
              <div class="form-group col-md-6">
                <label for="id_rut">RUT</label>
                <input type="text" class="form-control" id="id_rut" name="id_rut" placeholder="rut">
              </div>
            </div>

           <div class="form-row">
              
              <div class="form-group col-md-6">
                <label for="id_telefono">Telefono</label>
                <input type="text" class="form-control" id="id_telefono" name="id_telefono" placeholder="id_telefono2">
              </div>
               <div class="form-group col-md-6">
                <label for="id_telefono2">Telefono2</label>
                <input type="text" class="form-control" id="id_telefono2" name="id_telefono2" placeholder="direccion">
              </div>

            </div> 

           <div class="form-row">
              <div class="form-group col-md-6">
                <label for="id_correo">Correo</label>
                <input type="text" class="form-control" id="id_correo" name="id_correo" placeholder="Correo">
              </div>
              <div class="form-group col-md-6">
                <label for="id_direccion">Direccion</label>
                <input type="text" class="form-control" id="id_direccion" name="id_direccion" placeholder="direccion">
              </div>

            </div>
            
            
            <div id="div_lugar">
            <div class="form-row">

              <div class="form-group col-md-6">
                <label for="id_region">Region</label>
                    <select id="id_region" class="custom-select">
                        <option selected>seleccionar</option>              
                    </select>
              </div>
              <div class="form-group col-md-6">
                <label for="id_provincia">Provincia</label>
                    <select id="id_provincia" class="custom-select">
                        <option selected>seleccionar</option>              
                    </select>
              </div>  
            </div> 

            <div class="form-row">

              <div class="form-group col-md-6">
                <label for="id_comuna">Comuna</label>
                    <select id="id_comuna" class="custom-select">
                        <option selected>seleccionar</option>              
                    </select>
              </div>
            </div> 
            
            </div>
            <div class="form-row">
              <div class="form-group col-md-3">
                <label for="id_usuario">Usuario</label>
                <input type="text" class="form-control" id="id_usuario" name="id_usuario" placeholder="usuario" readonly="">
              </div>
              <div class="form-group col-md-3">
                <label for="id_pass">Password</label>
<input type="text" class="form-control" id="id_pass" name="id_pass" placeholder="password" readonly="">
              </div>

            </div>
    </div>     
</div>
            <button id="btn_envio_usuario"  type="button" class="btn btn-primary">Registrar</button>
</div>
        <!--  </form> --> 
    </div>

  </div>
</div>