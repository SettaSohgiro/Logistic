<%-- 
    Document   : menu
    Created on : 29-09-2021, 18:06:28
    Author     : Lee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LogisticFV</title>
        <jsp:include page="/views/menu/cabemenu.jsp"/>
        
          <!-- base:css 
  <link rel="stylesheet" href="${pageContext.request.contextPath}/views/vendors/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/views/vendors/feather/feather.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/views/vendors/base/vendor.bundle.base.css">-->
  <!-- endinject -->
  <!-- plugin css for this page 
  <link rel="stylesheet" href="${pageContext.request.contextPath}/views/vendors/flag-icon-css/css/flag-icon.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/views/vendors/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/views/vendors/jquery-bar-rating/fontawesome-stars-o.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/views/vendors/jquery-bar-rating/fontawesome-stars.css">-->
  <!-- End plugin css for this page -->
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    
   <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script> 
    
  <script type="text/javascript" src="${pageContext.request.contextPath}/views/inicio/inicio.js"></script>
    
   <link rel="stylesheet" href="${pageContext.request.contextPath}/views/public/AdminLTE.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/views/public/AdminLTE.min.css">
    
  



        
  <style>
      
.panel-pricing {
  -moz-transition: all .3s ease;
  -o-transition: all .3s ease;
  -webkit-transition: all .3s ease;
}
.panel-pricing:hover {
  box-shadow: 0px 0px 30px rgba(0, 0, 0, 0.2);
}
.panel-pricing .panel-heading {
  padding: 20px 10px;
}
.panel-pricing .panel-heading .fa {
  margin-top: 10px;
  font-size: 58px;
}
.panel-pricing .list-group-item {
  color: #777777;
  border-bottom: 1px solid rgba(250, 250, 250, 0.5);
}
.panel-pricing .list-group-item:last-child {
  border-bottom-right-radius: 0px;
  border-bottom-left-radius: 0px;
}
.panel-pricing .list-group-item:first-child {
  border-top-right-radius: 0px;
  border-top-left-radius: 0px;
}
.panel-pricing .panel-body {
  background-color: #f0f0f0;
  font-size: 40px;
  color: #777777;
  padding: 20px;
  margin: 0px;
}

  </style>       
        
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
        
          <ul class="navbar-nav animate side-nav" style="background: #0f4d03;">
                <jsp:include page="aside.jsp"/>
        </ul>

      </div>
    </nav>
    <div class="container-fluid">
        
       
                <div class="col-lg-3 col-xs-6" style="border: 2px solid white;margin: 0;padding: 0;border-radius: 8px;box-shadow: 0 .15rem 1.75rem 0 rgba(83, 83, 87, 0.57) !important;">

                    <div class="small-box bg-aqua" style="margin: 0;">

                      <div class="inner" style="font-size: 73px;">

                        <p style="font-size: 42px;margin: 0;"><strong>$<strong id="ston_dollar">0</strong></strong></p>

                        <p>Dollar</p>

                      </div>

                      <div class="icon">

                        <i class="fas fa-dollar-sign"></i>

                      </div>


                    </div>

                  </div>

<div class="row mt-3">
            <div class="col-xl-3 flex-column d-flex grid-margin stretch-card">
              <div class="row flex-grow">
                <div class="col-sm-12 grid-margin stretch-card">
                    <div class="card">
                      <div class="card-body"><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div>
                          <h4 class="card-title">Ventas</h4>
                          <p>0% incrementacion</p>
                          <h4 class="text-dark font-weight-bold mb-2">0</h4>
                          <canvas id="customers" height="64" style="display: block; width: 322px; height: 64px;" width="322" class="chartjs-render-monitor"></canvas>
                      </div>
                    </div>
                </div>
                <div class="col-sm-12 stretch-card">
                    <div class="card">
                      <div class="card-body"><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div>
                          <h4 class="card-title">Pedidos</h4>
                          <p>0% incrementos</p>
                          <h4 class="text-dark font-weight-bold mb-2">0</h4>
                          <canvas id="orders" height="64" style="display: block; width: 322px; height: 200px;" width="322" class="chartjs-render-monitor"></canvas>
                      </div>
                    </div>
               </div>
              </div>
            </div>
            <div class="col-xl-9 d-flex grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                      <h4 class="card-title">Usuarios registrados en el sistema</h4>
                      <div class="row">
                        <div class="col-lg-5">
                          <p></p>
                        </div>
                        <div class="col-lg-7">
                          <div class="chart-legends d-lg-block d-none" id="chart-legends"><div class="row">
                                  <div class="col-lg-4"><div class="row">
                                          <div class="col-sm-12"><h5 class="font-weight-bold text-dark mb-1">83.123</h5></div></div>
                                          <div class="row align-items-center"><div class="col-2"><span class="legend-label" style="background-color:#3794fc"></span></div>
                                              <div class="col-9 pl-0"><p class="text-muted m-0 ml-1">Sesiones</p></div></div></div>
                                              <div class="col-lg-4"><div class="row">
                                                      <div class="col-sm-12"><h5 class="font-weight-bold text-dark mb-1">3333</h5></div></div>
                                                      <div class="row align-items-center"><div class="col-2"><span class="legend-label" style="background-color:#a037fc"></span></div>
                                                          <div class="col-9 pl-0"><p class="text-muted m-0 ml-1">Usuarios</p></div></div></div><div class="col-lg-4">
                                                              <div class="row">
                                                                  <div class="col-sm-12"><h5 class="font-weight-bold text-dark mb-1">16.869</h5></div></div>
                                                                  <div class="row align-items-center"><div class="col-2"><span class="legend-label" style="background-color:#dee5ef"></span></div>
                                                                      <div class="col-9 pl-0"><p class="text-muted m-0 ml-1">Paginas Visitadas</p></div></div></div></div></div>
                        </div>
                      </div>
                      <div class="row">
                          <div class="col-sm-12"><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div>
                              <canvas id="web-audience-metrics-satacked" class="mt-3 chartjs-render-monitor" height="328" style="display: block; width: 1121px; height: 328px;" width="1121"></canvas>
                          </div>
                      </div>
                        
                    </div>
                  </div>
            </div>
          </div>
      </div>
      <div class="row">
    <!--    <div class="col">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <table class="table">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">First</th>
                    <th scope="col">Last</th>
                    <th scope="col">Handle</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                  </tr>
                  <tr>
                    <th scope="row">2</th>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                  </tr>
                  <tr>
                    <th scope="row">3</th>
                    <td>Larry</td>
                    <td>the Bird</td>
                    <td>@twitter</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <table class="table">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">First</th>
                    <th scope="col">Last</th>
                    <th scope="col">Handle</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                  </tr>
                  <tr>
                    <th scope="row">2</th>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                  </tr>
                  <tr>
                    <th scope="row">3</th>
                    <td>Larry</td>
                    <td>the Bird</td>
                    <td>@twitter</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div> -->
      </div>
    </div>
  </div>
  <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
    </body>
</html>
