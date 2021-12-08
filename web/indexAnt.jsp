<%-- 
    Document   : index
    Created on : 28-09-2021, 20:51:16
    Author     : Lee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/cabecera.jsp"/>
        <title>LogisticFV</title>
    </head>
    <body>
        
                


    <!-- header -->
    <div class="container-fluid header" style="">
        <header>		
                <div class="constainer-portada">
                    <div class="capa-gradien">
                        <div class="constainer-details">
                            <div class="details">
                                <h1>LOGISTICFV</h1>
                                <p>
                             
                                </p>
                    
                </div>
                </div>
                </div>
                </div>
	</header>
    </div>
    <!-- end header -->

    <!-- menu navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      
        <div class="collapse navbar-collapse" id="navbarColor01">
          <ul class="navbar-nav mr-auto col-sm-3 col-md-3">
            <li class="nav-item active">
              <a class="nav-link" href="#">Inicio<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#mision">Mision</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Vision</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Contacto</a>
            </li>
		<!-- 	<li class="nav-item">
				<div class="dropdown show">
				  <a class="btn nav-link dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Dropdown link
				  </a>

				  <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
					<a class="dropdown-item" href="#">Lorem</a>
					<a class="dropdown-item" href="#">Lorem ipsum</a>
					<a class="dropdown-item" href="#">Lorem ipsum</a>
				  </div>
				</div>
			</li>
  -->
          </ul>
          <form class="form-inline my-2 my-lg-0">
            <button id="btn_Login" class="btn btn-primary my-2 my-sm-0" type="button" data-toggle="modal" data-target="#loginModal">Login</button>
          </form>
        </div>
    </nav>
    <!-- end navbar -->

    <!-- login modal-->
    <div class="modal" id="loginModal" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title">Login</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                  </button>
                </div>
                <div class="modal-body">
        <form class="form-signin" action="iniciar" method="post">
          
                        <div class="form-label-group">
                            <label for="inputEmail">Usuario</label>
                          <input type="text" id="inputEmail" class="form-control" name="usuario" placeholder="Usuario" required="" autofocus="">
                        </div>

                        <div class="form-label-group">
                            <label for="inputPassword">Password</label>
                            <input type="password" id="inputPassword" name="pass"  class="form-control" placeholder="Password" required="">
                        </div>

                        <div class="checkbox mb-3">
                          <label>
                            <input type="checkbox" value="remember-me"> Remember me
                          </label>
                        </div>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
                        <p class="mt-5 mb-3 text-muted text-center">© 2021 Empresa Dinamic SPA</p>
              </form>
                 

              </div>
            </div>
          </div>
        </div>
    <!-- end login modal-->

    <!-- content -->

    <div class="col-12 col-sm-12 col-md-12 col-lg-12" style="margin: 20px 0 80px 0;">
       
                <div id="demo" class="carousel slide" data-ride="carousel">
                    <ul class="carousel-indicators">
                      <li data-target="#demo" data-slide-to="0" class="active"></li>
                      <li data-target="#demo" data-slide-to="1"></li>
                      <li data-target="#demo" data-slide-to="2"></li>
                    </ul>
                    <div class="carousel-inner">
                      <div class="carousel-item active">
                        <img src="/LogisticFV/views/image/frutas.jpg" alt="Los Angeles" width="70%" height="650">
                        <div class="carousel-caption">
                          <h3>Norte</h3>
                          <p>We had such a great time in LA!</p>
                        </div>   
                      </div>
                        
                     <div class="carousel-item">
                        <img src="/LogisticFV/views/image/Mesa.jpg" alt="Los Angeles" width="70%" height="650">
                        <div class="carousel-caption">
                          <h3>Centro</h3>
                          <p>We had such a great time in LA!</p>
                        </div>   
                      </div>
                        
                      <div class="carousel-item">
                        <img src="/LogisticFV/views/image/megafrutas.jpg" alt="Los Angeles" width="70%" height="650">
                        <div class="carousel-caption">
                          <h3>Sur</h3>
                          <p>We had such a great time in LA!</p>
                        </div>   
                      </div>
                        


                    </div>
                    <a class="carousel-control-prev" href="#demo" data-slide="prev">
                      <span class="carousel-control-prev-icon"></span>
                    </a>
                    <a class="carousel-control-next" href="#demo" data-slide="next">
                      <span class="carousel-control-next-icon"></span>
                    </a>
                  </div>
        
    </div>
    
    
    <div id="mision" class="col-12 col-sm-12 col-md-12 col-lg-12" style="margin: 20px 0 100px 0;height: 700px;">
        
        <div style="background: url(https://bootstrapious.com/i/snippets/sn-static-header/background.jpg)" class=" bg-cover text-white">
    <div class="container py-5 text-center">
        <h1 class="display-4 font-weight-bold" style="margin-bottom: 10%;">Mision</h1>
        <p class="font-italic mb-0" style="font-size: 25px;">Ser una empresa de comercialización mayorista reconocida por su seriedad, solvencia y ética de trabajo  que atienda   las  necesidades y
            exigencias de productos fruticolas y otros en el mercado nacional como tambien internacional,  ofreciendo  productos diferenciados por su calidad, accesibles al consumidor y prácticos en su uso.
Conformar un equipo de trabajo capacitado, motivado, productivo y comprometido  con la empresa, clientes,  proveedores y la comunidad.</p>
  
    </div>
</div>
        
        
    </div>

	<footer>© 2021 Empresa Dinamic SPA</footer>
	<!-- this template is made by silvan paul -->

	<script type="text/javascript">
		</script>


    </body>
</html>
