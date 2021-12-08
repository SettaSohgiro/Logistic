<%-- 
    Document   : clienteExtreno
    Created on : 29-10-2021, 21:38:28
    Author     : me
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal Cliente Externo</title>
        <jsp:include page="/views/menu/cabemenu.jsp"/>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/views/clienteExterno2/clienteExterno2.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
        <link href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css" rel="stylesheet">
    </head>
    <body>

        <div id="wrapper" class="animate">
            <nav class="navbar header-top fixed-top navbar-expand-lg navbar-dark bg-dark" style="background-color: #063e02 !important;">
                <span class="navbar-toggler-icon leftmenutrigger"></span>
                <a class="navbar-brand" href="#">LogisticFV</a>
                <button id="button_togle" class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarText">

                    <ul class="navbar-nav animate side-nav" style="background: red;">
                        <jsp:include page="aside.jsp"/>
                    </ul>

                </div>
            </nav>
            <div class="container-fluid">

                <div class="row">
                    <div class="col">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Solicitudes</h5>
                                <jsp:include page="views/clienteExterno2/clienteExterno_nab_tab2.jsp" />
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="row">

            </div>
        </div>
    </div>
    <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
    <jsp:include page="views/clienteExterno2/clienteExterno_modal2.jsp"/>
</body>
</html>

