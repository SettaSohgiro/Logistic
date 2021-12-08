<%-- 
    Document   : modal
    Created on : 16-10-2021, 18:34:32
    Author     : Lee
--%>

<%@page import="Controlador.ControladorCalidad"%>
<%@page import="Controlador.ControladorFrutas"%>
<!-- Modal de actualizacion  -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" role="dialog" style="background: #2f2d2db3;">
    <div class="modal-dialog" style="max-width: 1000px;">
        <div class="modal-content">
            <div class="modal-header" style="background: #269b1c;">
                <h5 class="modal-title" id="exampleModalLabel">Actualizacion de Producto</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" >
                <div id="divFormProducto_up">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="id_idproducto_up">ID</label>
                            <input type="text" class="form-control" id="id_idproducto_up" name="id_idproducto_up" placeholder="ID" disabled style="color: red">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="id_nombre_up">Nombre</label>
                            <!--<input type="text" class="form-control" id="id_nombre_up" name="id_nombre_up" placeholder="Nombre">-->
                            <select class="form-control" id="id_nombre_up" name="id_nombre_up" placeholder="nombre">

                            </select>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="id_calidad_up">Calidad</label>
                            <!--<input type="number" class="form-control" id="id_calidad_up" name="id_calidad_up" placeholder="Calidad">-->
                            <select class="form-control" id="id_calidad_up" name="id_calidad_up" placeholder="calidad">

                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="id_cantidad_up">Cantidad en Kilos</label>
                            <input type="number" min="1" onClick="this.select();" class="form-control" id="id_cantidad_up" name="id_cantidad_up" placeholder="Tipo">
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="id_precio_up">Precio</label>
                            <input type="number" min="1" onClick="this.select();" class="form-control" id="id_precio_up" name="id_precio_up" placeholder="direccion">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="id_fecha_up">Fecha Producción</label>
                            <input type="date" class="form-control" id="id_fecha_up" name="id_fecha_up" placeholder="telefono">
                        </div>
                    </div>          

                    <!--                    <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="id_correo_up">Correo</label>
                                                <input type="text" class="form-control" id="id_correo_up" name="id_correo_up" placeholder="Correo">
                                            </div>
                    
                                        </div> -->


                    <!--                    <div class="form-row">
                                            <div class="form-group col-md-3">
                                                <label for="id_usuario_up">Usuario</label>
                                                <input type="text" class="form-control" id="id_usuario_up" name="id_usuario_up" placeholder="usuario">
                                            </div>
                                            <div class="form-group col-md-3">
                                                <label for="id_pass_up">Password</label>
                                                <input type="text" class="form-control" id="id_pass_up" name="id_pass_up" placeholder="password">
                                            </div>
                                            <div class="form-group col-md-3">
                                                <label for="id_passrepite_up">Repite Password</label>
                                                <input type="text" class="form-control" id="id_passrepite_up" placeholder="repite password">
                                            </div>
                                        </div>-->
                </div>
            </div>
            <div class="modal-footer" style="background: #92bd92;">
                <button id="btn_mod_modificar" type="button" class="btn btn-success" >Modificar</button>
                <button id="btn_mod_cerrar" type="button" class="btn btn-danger">Cerrar</button>
            </div>
        </div>
    </div>
</div>




<!-- Modal de advertencia si o no  -->
<div class="modal fade" id="modalmsnsn" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" role="dialog" style="background: #2f2d2db3;">
    <div class="modal-dialog" style="max-width: 1000px;">
        <div class="modal-content">
            <div class="modal-header" style="background: #269b1c;">
                <h5 class="modal-title" id="mdcabemsnsn">Adventencia</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" style="text-align: center;font-size: 22px;height: 200px;">
                <label id="mdlbmsnsn"></label>
            </div>
            <div class="modal-footer" style="background: #92bd92;">
                <button id="btn_mod_si" type="button" class="btn btn-success" >SI</button>
                <button id="btn_mod_no" type="button" class="btn btn-danger">NO</button>
            </div>
        </div>
    </div>
</div>
