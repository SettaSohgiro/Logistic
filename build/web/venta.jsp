<%-- 
    Document   : venta
    Created on : 01-10-2021, 11:56:57
    Author     : Lee
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LogisticFV</title>
        <jsp:include page="/views/menu/cabemenu.jsp"/>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
        <link href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css" rel="stylesheet">
        
          <script type="text/javascript" src="${pageContext.request.contextPath}/views/venta/venta.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/views/public/AdminLTE.css" >  
       
        <link rel="stylesheet" href="${pageContext.request.contextPath}/views/public/AdminLTE.min.css" >  
       
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">  
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/views/public/font-awesome.min.css">

        
        
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </head>
    
    <style>
        
        
        #tablepedidoDetalle tbody input{
            font-size: 13px;
            padding: 5px;
        }
    </style>
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
        
          <ul class="navbar-nav animate side-nav" style="background: #0f4d03;">
                <jsp:include page="aside.jsp"/>
        </ul>

      </div>
    </nav>
    <div class="container-fluid">
        <div class="row">
        <div class="col">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Ventas</h5>
                <jsp:include page="/alert.jsp"/>
              <jsp:include page="views/venta/ventaSeccion.jsp" />
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

    </body>
</html>
