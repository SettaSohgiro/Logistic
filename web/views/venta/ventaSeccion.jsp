<%-- 
    Document   : nab_tab
    Created on : 01-10-2021, 12:29:49
    Author     : Lee
--%>

<div class="">
    <ul id="ul_nav_user" class="nav nav-tabs" role="tablist">
        <li class="nav-item">
            <a id="amenu0" class="nav-link active" data-toggle="tab" href="#menu0">Administrar Ventas</a>
        </li>
        <li class="nav-item">
            <a id="amenu1" class="nav-link" data-toggle="tab" href="#menu1">Crear Ventas</a>
        </li>

    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div id="menu0" class=" tab-pane active"><br>





            <table id="tableVentas" class="display" style="width:100%">
                <thead>
                    <tr>
                        <th>usernom</th>
                        <th>iduser</th>
                        <th>nbolf</th>
                        <th>tipo_com</th>
                        <th>comprobante</th>
                        <th>impuesto</th>
                        <th>totalim</th>
                        <th>pago</th>
                        <th>vuelto</th>
                        <th>cod_trans</th>
                        <th>cliente</th>
                        <th>formapago</th>
                        <th>estado</th>
                        <th>estadopago</th>
                        <th>id_venta</th>
                        <th>fechaventa</th>

                    </tr>
                </thead>
                <tbody>

                </tbody>
            </table>

        </div>
        <div id="menu1" class="tab-pane "><br>

            <div class="row">  
                <div class="col-lg-5 col-xs-12">

                    <div class="box box-success">

                        <div class="box-header with-border"></div>

                        <form role="form" method="post" class="formularioVenta">

                            <div id="formularioVenta" class="box-body">

                                <div class="box">

                                    <!--=====================================
                                    ENTRADA DEL VENDEDOR
                                    ======================================-->

                                    <div class="form-row">
                                        <div class="form-group col-md-8">
                                            <label for="id_nombre_usuario">Usuario</label>
                                            <input type="text" class="form-control" id="id_nombre_usuario" name="id_nombre_usuario" placeholder="" readonly="">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="id_usuario">Id</label>
                                            <input type="text" class="form-control" id="id_usuario" name="id_usuario" placeholder="" readonly="">
                                        </div>
                                    </div>
                                    <!--=====================================
                                    ENTRADA DEL CLIENTE
                                    ======================================--> 

                                    <div class="form-row">
                                        <div class="form-group col-md-12 col-lg-12">
                                            <label for="sl_cliente_ven">Seleccion Cliente</label>
                                            <select id="sl_cliente_ven" class="custom-select">
                                                <option selected>--seleccione--</option>

                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="id_comprob_venta">Tipo Comprobante</label>
                                            <select id="id_comprob_venta" class="custom-select">
                                                <option value="0">--seleccione--</option>

                                            </select>
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="id_numfac_ven">Numero Factura</label>
                                            <input type="text" class="form-control" id="id_numfac_ven" name="id_numfac_ven" placeholder=""  readonly="">
                                        </div>

                                        <div class="form-group col-md-3">
                                            <label for="id_fecha_venta">Fecha</label>
                                            <input type="text" class="form-control" id="id_fecha_venta" name="id_fecha_venta" placeholder="" readonly="">
                                        </div>
                                    </div>      


                                    <!--=====================================
                                    ENTRADA PARA AGREGAR PRODUCTO
                                    ======================================--> 

                                    <div class="form-group col-lg-12 row nuevoProducto">

                                        <table id="tablepedidoDetalle"   class="table" style="padding: 0;font-size: 14px;">

                                            <thead>

                                                <tr>
                                                    <th>ID</th>
                                                    <th>Descripcion</th>  
                                                    <th>Cantidad</th>
                                                    <th>Stock</th>
                                                    <th>Total</th>  
                                                    <th>Borrar</th> 
                                                </tr>

                                            </thead>

                                            <tbody id="body_venta"> 

                                            </tbody>
                                        </table>      


                                    </div>


                                    <!--=====================================
                                    BOTÓN PARA AGREGAR PRODUCTO
                                    ======================================-->


                                    <hr>

                                    <div class="row col-xs-12 col-lg-12">

                                        <!--=====================================
                                        ENTRADA IMPUESTOS Y TOTAL
                                        ======================================-->

                                        <div class="col-xs-12 pull-right">

                                            <table class="table">

                                                <thead>

                                                    <tr>
                                                        <th>Impuesto</th>
                                                        <th>Total</th>      
                                                    </tr>

                                                </thead>

                                                <tbody>

                                                    <tr>

                                                        <td style="width: 50%">

                                                            <div class="input-group">

                                                                <input type="text" class="form-control input-lg" id="nuevoImpuestoVenta" name="nuevoImpuestoVenta" placeholder="0" value="0" required="">

                                                 
                                                            </div>

                                                        </td>

                                                        <td style="width: 50%">

                                                            <div class="input-group">

                                                                <span class="input-group-addon"><i class="ion ion-social-usd"></i></span>

                                                                <input type="text" class="form-control input-lg" id="nuevoTotalVenta" name="nuevoTotalVenta"  placeholder="0"  value="0" readonly="" required="">

                                                                                    

                                                            </div>

                                                        </td>

                                                    </tr>

                                                </tbody>

                                            </table>

                                        </div>

                                    </div>

                                    <hr>

                                    <!--=====================================
                                    ENTRADA MÉTODO DE PAGO
                                    ======================================-->

                                    <div class=" row  col-xs-12 col-lg-12">
                                        <div class="form-row" style="width: 100%;">
                                            <div class="form-group col-md-12 col-lg-4">
                                                <label for="id_nombre">Forma Pago</label>
                                                <select class="custom-select" id="nuevoMetodoPago" name="nuevoMetodoPago" required="">
                                                    <option value="0" selected="selected">Seleccione método</option>
                                                    <option value="EF">Efectivo</option>
                                                    <option value="TC">Tarjeta Crédito</option>
                                                    <option value="TD">Tarjeta Débito</option>    
                                                    <option value="DD">Deposito Bancario</option> 
                                                </select>
                                            </div>





                                            <div  id="div_pago_efectivo" class="form-group col-md-12 col-lg-8" style="display: none;">
                                                    <div class="form-group col-md-4 col-lg-4 pagoEfect" style="display: inline-block;">
                                                        <label for="id_nombre">Pago</label>
                                                        <input type="text" value=""  class="form-control" id="nuevoPago" placeholder="" required="">
                                                    </div>
                                                    <div class="form-group col-md-4 col-lg-4 pagoEfect" style="display: inline-block;">
                                                        <label for="id_apaterno">Vuelto</label>
                                                        <input type="text" value=""  class="form-control" id="nuevoVuelto"  readonly="" placeholder="" required="">
                                                    </div>
                                            </div>

                            

                                            <!-- metodo de pago con tarjeta solo se paga y se anota el codigo transaccion-->              

                                      
                                            <div  id="div_pago_otros" class="form-group col-md-12 col-lg-8" style="display: none;">
                                                <div id="tarjcredito" class="col-xs-6 col-lg-8" style="padding-left:0px;">
                                                    <label for="">Código transacción</label>
                                                    <div class="input-group">
                                                        <input type="text" value="" class="form-control" id="nuevoCodigoTransaccion" placeholder="" required="">

                                                    </div>
                                                </div>
                                            </div>


                                        </div>



                                    </div>

                                    <br>

                                </div>

                            </div>

                            <div class="box-footer">

                                <button id="btnGuardarVenta" type="" class="btn btn-primary pull-right">Guardar venta</button>

                            </div>

                        </form>


                    </div>

                </div>

                <!-- -------------------------tabla de stock -------------------------------------  -->

                <div class="col-lg-7">

<div>
                    <table id="tableStock" class="display" style="width:100%">    
                        <thead>
                            <tr>
                                    <th>SELECCIONAR</th>
                                    <th>ID</th>
                                    <th>ID_FRUTA</th>
                                    <th>NOMBRE</th>
                                    <th>STOCK</th>
                                    <th>ID_CALIDAD</th>
                                    <th>CALIDAD</th>
                                    <th>PRECIO</th>
                                    <th>FECHA_CO</th>
                                    <th>VENTA_KILOS</th>
                                    <th>ESTADO</th>

                            </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>        

</div>
                </div>

                <!--  ------------------------- fin tabla de stock ------------------------------------- -->
            </div>







        </div>

    </div>
</div>