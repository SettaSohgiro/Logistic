<%-- 
    Document   : nab_tab
    Created on : 01-10-2021, 12:29:49
    Author     : Lee
--%>

<div class="container">
    <ul id="ul_nav_user" class="nav nav-tabs" role="tablist">
        <li class="nav-item">
            <a id="amenu0" class="nav-link active" data-toggle="tab" href="#menu0">Solicitudes Registradas</a>
        </li>
        <li class="nav-item">
            <a id="amenu1" class="nav-link" data-toggle="tab" href="#menu1">Procesos de Venta</a>
        </li>
        <li class="nav-item">
            <a id="amenu2" class="nav-link" data-toggle="tab" href="#menu2">Seguros</a>
        </li>
        <li class="nav-item">
            <a id="amenu3" class="nav-link" data-toggle="tab" href="#menu3">Ingresar Seguro</a>
        </li>

    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div id="menu0" class=" tab-pane active"><br>

            <table id="example" class="display" style="width:100%">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Fecha Solicitud</th>
                        <th>Fruta</th>
                        <th>Calidad</th>
                        <th>Cantidad</th>
                        <th>Presupuesto</th>
                        <th>Embalaje</th>
                        <th>Publicar Contrato</th>
                        <!--<th>Borrar</th>-->
                    </tr>
                </thead>
                <tbody>
                    <!--NO BORRAR EL "tbody"-->
                </tbody>
            </table>
            <br>

        </div>

        <div id="menu1" class="container tab-pane "><br>
            <table id="contratos_table" class="display" style="width:100%">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Fecha Inicio</th>
                        <th>Fecha Termino</th>
                        <th>Nombre Contrato</th>
                        <th>Estado</th>
                        <th>Cliente</th>
                        <th>Solicitud</th>
                        <th>Transporte</th>
                        <th>Resumen Venta</th>
                        <th>Actualizar Contrato</th>
                    </tr>
                </thead>
                <tbody>
                    <!--NO BORRAR EL "tbody"-->
                </tbody>
            </table>
            <br>
        </div>

        <div id="menu2" class="container tab-pane "><br>
            <table id="seguros_table" class="display" style="width:100%">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Costo</th>
                        <th>Estado</th>
                        <th>IdEmbarque</th>
                        <th>Eliminar Seguro</th>
                    </tr>
                </thead>
                <tbody>
                    <!--NO BORRAR EL "tbody"-->
                </tbody>
            </table>
            <br>
        </div>

        <div id="menu3" class="container tab-pane "><br>
            <div id="divFormSeguro">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="id_nombre">Nombre</label>
                        <input type="text" class="form-control" id="id_nombre" name="id_nombre" placeholder="nombre">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="id_costo">Costo</label>
                        <input type="number" class="form-control" id="id_costo" name="id_costo" placeholder="costo" min="1">
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="id_estado">Estado</label>
                        <input type="text" class="form-control" id="id_estado" name="id_estado" placeholder="estado">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="id_embarque">ID Embarque</label>
                        <input type="number" class="form-control" id="id_embarque" name="id_embarque" placeholder="0">
                    </div>
                </div>
      
            </div>

            <button id="btn_envio_seguro"  type="button" class="btn btn-primary">Registrar</button>
            <label id="id_error_seguro" name="id_error_seguro" for="id_error_seguro">

            </label>
        </div>

    </div>
</div>
contratos_table