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
            <a id="amenu1" class="nav-link" data-toggle="tab" href="#menu1">Ingresar Solicitudes</a>
        </li>
        <li class="nav-item">
            <a id="amenu2" class="nav-link" data-toggle="tab" href="#menu2">Pedidos en Curso</a>
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
                        <th>Presupuesto</th>
                        <th>Venta</th>
                        <th>Usuario</th>
                        <th>Actualizar</th>
                        <th>Cancelar</th>
                    </tr>
                </thead>
                <tbody>
                    <!--NO BORRAR EL "tbody"-->
                </tbody>
            </table>
            <br>

        </div>

        <div id="menu1" class="container tab-pane "><br>

            <div id="divFormSolicitud">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="id_fechaSolitud">Fecha Solicitud</label>
                        <input type="date" class="form-control" id="id_fechaSolitud" name="id_fechaSolitud" placeholder="Fecha Solicitud">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="id_presupuesto">Presupuesto</label>
                        <input type="number" class="form-control" id="id_presupuesto" name="id_presupuesto" placeholder="0" min="1">
                    </div>
                </div>      
            </div>

            <hr style="height:2px;border-width:0;color:gray;background-color:gray">

            <div id="divFormFruta">

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="id_fruta">Fruta</label>
                        <select class="form-control" id="id_fruta" name="id_fruta" placeholder="Fruta">
                        </select>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="id_calidad">Calidad</label>
                        <select class="form-control" id="id_calidad" name="id_calidad" placeholder="Calidad">

                        </select>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="id_cantidad">Cantidad en Kilos</label>
                        <input type="number" class="form-control" id="id_cantidad" name="id_cantidad" placeholder="0" min="1">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="id_embalaje">Embalaje</label>
                        <input type="text" class="form-control" id="id_embalaje" name="id_embalaje" placeholder="Embalaje">
                    </div>
                </div>
            </div>

            <button id="btn_agregar"  type="button" class="btn btn-primary">Agregar Fruta</button>

            <hr style="height:2px;border-width:0;color:gray;background-color:gray">

            <div>
                <table id="solicitudes" class="display" style="width:100%">
                    <thead>
                        <tr>
                            <th>Id Fruta</th>
                            <th>Fruta</th>
                            <th>Id Calidad</th>
                            <th>Calidad</th>
                            <th>Cantidad en Kilos</th>
                            <th>Embalaje</th>
                            <th>Borrar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!--NO BORRAR EL "tbody"-->
                    </tbody>
                </table>
                <br>

            </div>

            <button id="btn_envio_solicitud"  type="button" class="btn btn-primary">Registrar</button>
            <label id="id_error_usuario" name="id_error_usuario" for="id_error_usuario">

            </label>
            <!--</form>--> 
        </div>

        <div id="menu2" class="container tab-pane "><br>

            <div id="divFormSolicitud">

            </div>

        </div>

    </div>
</div>
