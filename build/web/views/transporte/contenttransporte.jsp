<%-- 
    Document   : nab_tab
    Created on : 01-10-2021, 12:29:49
    Author     : Jona
--%>


<div class="">
  <ul id="ul_nav_user" class="nav nav-tabs" role="tablist">
    <li class="nav-item">
      <a id="amenu0" class="nav-link active" data-toggle="tab" href="#menu0">Vehiculos Registrados</a>
    </li>
    <li class="nav-item">
      <a id="amenu1" class="nav-link" data-toggle="tab" href="#menu1">Seleccion de Transporte</a>
    </li>

  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div id="menu0" class=" tab-pane active"><br>
        
        



            <table id="tabletransporte" class="display" style="width:100%">
                    <thead>
                        <tr>
<th>Opciones</th> 
<th>ID</th>
<th>patente</th>
<th>tipo_vehiculo</th>
<th>capacidad_m3</th>
<th>capacidad_tonelada</th>
<th>nombre_conductor</th>
<th>tipo_licencia</th>
<th>region</th>
<th>direccion</th>
<th>estado</th>


                            
                        </tr>
                    </thead>
                    <tbody>

                    </tbody>
            </table>
                    

    </div>
    <div id="menu1" class="container tab-pane "><br>
     <!--    <form action="crearusuario" method="post" > -->
           
        


            <table id="tableseleccion" class="display" style="width:100%">
                    <thead>
                        <tr>
<th>Opciones</th> 
<th>id</th>
<th>nombre_empresa</th>
<th>rut_empresa</th>
<th>direccion_empresa</th>
<th>region</th>
<th>total_kg</th>
<th>nbolf</th>
<th>tipo_com</th>
<th>rol</th>

                            
                        </tr>
                    </thead>
                    <tbody>

                    </tbody>
            </table>

                    

         
     

    </div>

  </div>
</div>