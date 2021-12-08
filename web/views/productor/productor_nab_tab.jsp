<%-- 
    Document   : nab_tab
    Created on : 01-10-2021, 12:29:49
    Author     : Lee
--%>

<%@page import="Controlador.ControladorFrutas"%>
<%@page import="Controlador.ControladorCalidad"%>

<div class="container">
    <ul id="ul_nav_user" class="nav nav-tabs" role="tablist">
        <li class="nav-item">
            <a id="amenu0" class="nav-link active" data-toggle="tab" href="#menu0">Productos Registrados</a>
        </li>
        <li class="nav-item">
            <a id="amenu1" class="nav-link" data-toggle="tab" href="#menu1">Ingresar Producto</a>
        </li>

        <li class="nav-item">
            <a id="amenu1" class="nav-link" data-toggle="tab" href="#menu1">Contratos de Venta</a>
        </li>

    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div id="menu0" class=" tab-pane active"><br>

            <table id="example" class="display" style="width:100%">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Calidad</th>
                        <th>Cantidad</th>
                        <th>Precio</th>
                        <th>FechaProducción</th>
                        <th>Actualizar</th>
                        <th>Borrar</th>

                    </tr>
                </thead>
                <tbody>
                    <!--NO BORRAR EL "tbody"-->
                </tbody>
            </table>
            <br>

        </div>
        <div id="menu1" class="container tab-pane "><br>
            <!--<form action="crearproducto" method="post" >-->
            <div id="divFormProducto">
                <div class="form-row">
                    <!--                    <div class="form-group col-md-6">
                                            <label for="id_idproducto">ID</label>
                                            <input type="number" class="form-control" id="id_idproducto" name="id_idproducto" placeholder="Nombre" disabled>
                                        </div>-->
                    <div class="form-group col-md-6">
                        <label for="id_nombre">Nombre</label>
                        <!--<input type="text" class="form-control" id="id_nombre" name="id_nombre" placeholder="Nombre">-->
                        <select class="form-control" id="id_nombre" name="id_nombre" placeholder="nombre">

                        </select>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="id_calidad">Calidad</label>
                        <!--<input type="number" class="form-control" id="id_calidad" name="id_calidad" placeholder="calidad">-->
                        <select class="form-control" id="id_calidad" name="id_calidad" placeholder="calidad">

                        </select>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="id_cantidad">Cantidad en Kilos</label>
                        <input type="number" class="form-control" id="id_cantidad" name="id_cantidad" placeholder="tipo">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="id_precio">Precios</label>
                        <input type="number" class="form-control" id="id_precio" name="id_precio" placeholder="0">
                    </div>
                </div>

                <div class="form-row">
                    <!--                    <div class="form-group col-md-6">
                                            <label for="id_cantidad">Cantidad</label>
                                            <input type="number" class="form-control" id="id_cantidad" name="id_cantidad" placeholder="cantidad">
                                        </div>-->
                    <div class="form-group col-md-6">
                        <label for="id_fechaproduccion">Fecha Producción</label>
                        <input type="date" class="form-control" id="id_fechaproduccion" name="id_fechaproduccion" placeholder="fecha">
                    </div>
                </div>          
            </div>

            <button id="btn_envio_producto"  type="button" class="btn btn-primary">Registrar</button>
            <label id="id_error_usuario" name="id_error_usuario" for="id_error_usuario">

            </label>
            <!--</form>--> 
        </div>

        <div id="menu2" class=" tab-pane active"><br>

            <br>
        </div>

    </div>
</div>


<!--            <input id="btnfechaperioH" name="btnfechaperioH"  type="text" placeholder="Periodo" class="form-control" value="" maxlength="7"
                                                            readonly="" style="font-size: 13px;padding: 2px;height: 28px;" onkeypress="if ((event.keyCode < 46  event.keyCode > 57)  (event.keyCode == 47))
                    event.returnValue = false;"/>-->