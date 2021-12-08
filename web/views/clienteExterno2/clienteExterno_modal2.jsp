<%-- 
    Document   : modal
    Created on : 16-10-2021, 18:34:32
    Author     : Lee
--%>

<%@page import="Controlador.ControladorCalidad"%>
<%@page import="Controlador.ControladorFrutas"%>
<!-- Modal de actualizacion  -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" role="dialog" style="background: #2f2d2db3; overflow-y: scroll;">
    <div class="modal-dialog" style="max-width: 1000px;">
        <div class="modal-content">
            <div class="modal-header" style="background: #269b1c;">
                <h5 class="modal-title" id="exampleModalLabel">Actualizacion de Solicitud</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" >
                <div id="divFormSolicitud_up">
                    <label>ID</label>
                    <input type="text" id="id_idSolicitud_up" name="id_idSolicitud_up" placeholder="ID" disabled style="color: red">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="id_fechaSoli_up">Fecha Solicitud</label>
                            <input type="date" class="form-control" id="id_fechaSoli_up" name="id_fechaSoli_up" placeholder="Fecha Solicitud">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="id_presupuesto_up">Presupuesto</label>
                            <input type="number" min="1" class="form-control" id="id_presupuesto_up" name="id_presupuesto_up" placeholder="Presupuesto" min="1">
                        </div>
                    </div>    
                </div>

<!--                <div id="divFormFruta_up">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="id_idFruta_up">Fruta</label>
                            <select class="form-control" id="id_idFruta_up" name="id_idFruta_up" placeholder="Fruta">
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="id_idCalidad_up">Calidad</label>
                            <select class="form-control" id="id_idCalidad_up" name="id_idCalidad_up" placeholder="Calidad">
                            </select>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="id_cantidad_up">Cantidad en Kilos</label>
                            <input type="number" min="1" class="form-control" id="id_cantidad_up" name="id_cantidad_up" placeholder="Cantidad">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="id_embalaje_up">Embalaje</label>
                            <input type="text" class="form-control" id="id_embalaje_up" name="id_embalaje_up" placeholder="Embalaje">
                        </div>
                    </div>      
                </div>

                <button id="btn_agregar_up"  type="button" class="btn btn-primary">Agregar Fruta</button>-->

                <div>
                    <table id="solicitudes_up" class="display" style="width:100%">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Id Fruta</th>
                                <th>Fruta</th>
                                <th>Id Calidad</th>
                                <th>Calidad</th>
                                <th>Cantidad en Kilos</th>
                                <th>Embalaje</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--NO BORRAR EL "tbody"-->
                        </tbody>
                    </table>
                    <br>
                </div>
            </div>
            <div class="modal-footer" style="background: #92bd92;">
                <button id="btn_mod_solicitud" type="button" class="btn btn-success" >Modificar</button>
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
