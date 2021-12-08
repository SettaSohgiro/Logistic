<%-- 
    Document   : nab_tab
    Created on : 01-10-2021, 12:29:49
    Author     : Lee
--%>

<div class="container">
    <ul id="ul_nav_user" class="nav nav-tabs" role="tablist">
        <li class="nav-item">
            <a id="amenu0" class="nav-link active" data-toggle="tab" href="#menu0">Reportes</a>
        </li>

    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div id="menu0" class=" tab-pane active"><br>
            <div>
                <label for="yearpicker">Seleccione Año</label>
                <select name="yearpicker" id="yearpicker"></select>
            </div>

            <div style="width: 90%">
                <canvas id='frutasChart' width="400" height="200"></canvas>                
            </div>
            <br>
            <div style="width: 90%">
                <canvas id='ventasLiqChart' width="400" height="200"></canvas>                
            </div>
            <br>
            <div style="width: 90%">
                <canvas id='comisionChart' width="400" height="200"></canvas>                
            </div>

        </div>

    </div>
</div>
