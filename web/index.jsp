
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>LogisticFV</title>
        
                
        <link rel="stylesheet"  href="views/css/styles.css" />
        <link rel="stylesheet"  href="views/css/index.css" />
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <script src="views/js/gallery.js"></script>
        <script type="text/javascript" src="views/js/index.js"></script>
        <style>

            @media (max-width: 700px){
                #dialogcargamsn{
                    margin-left: 12%;
                    margin-top: 3%;
                }
            }
            /*            @media (max-width: 950px){
                            #dialogcargamsn{
                                    margin-left: 12%;
                                    margin-top: 3%;
                            }
                        }
                        @media (max-width: 1050px){
                            #dialogcargamsn{
                                    margin-left: 30%;
                                    margin-top: 3%;
                            }
                        }*/
            @media (min-width: 700px){
                #dialogcargamsn{
                    margin-left: 30%;
                    margin-top: 3%;
                }
            }

            /* The Modal (background) */
            .modal {
                display: none; /* Hidden by default */
                position: fixed; /* Stay in place */
                z-index: 10000; /* Sit on top */
                padding-top: 15px; /* Location of the box */
                left: 0;
                top: 0;
                width: 100%; /* Full width */
                height: 100%; /* Full height */
                overflow: auto; /* Enable scroll if needed */
                background-color: rgb(0,0,0); /* Fallback color */
                background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
            }

            /* Modal Content */
            .modal-content {
                position: relative;
                background-color: #fefefe;
                margin: auto;
                padding: 0;
                border: 1px solid #888;
                width: 80%;
                box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
                -webkit-animation-name: animatetop;
                -webkit-animation-duration: 0.4s;
                animation-name: animatetop;
                animation-duration: 0.4s
            }

            /* Add Animation */
            @-webkit-keyframes animatetop {
                from {top:-300px; opacity:0} 
                to {top:0; opacity:1}
            }

            @keyframes animatetop {
                from {top:-300px; opacity:0}
                to {top:0; opacity:1}
            }

            /* The Close Button */
            .close {
                color: white;
                float: right;
                font-size: 28px;
                font-weight: bold;
            }

            .close:hover,
            .close:focus {
                color: #000;
                text-decoration: none;
                cursor: pointer;
            }

            .modal-header {
                padding: 2px 16px;
                background-color: #0d7190;
                color: white;
            }

            .modal-body {padding: 2px 16px;}

            .modal-footer {
                padding: 3px 16px;
                background-color: #06485B;
                color: white;
            }
            .help-block {
                margin-top: 0;
            }  

            #modelconten{
                width: 800px;
                margin-top: 10px
            }
            #loginA{
                display: none;
            }
            .navbar-collapse {
                width: 100%;
            }
        </style>
        
    </head>
    <body>
        
        <header class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                
                                <div class="constainer-portada">
                    <div class="capa-gradien">
                        <div class="constainer-details">
                            <div class="details">
                                <img id="imglogo" src="http://localhost:8090/LogisticFV/views/image/logo.png" class="img-responsive" style=""   alt=""/>
                    
                             
                    
                </div>
                </div>
                </div>
                </div>

                <!-- LOGOTIPO -->


                
                <div id="" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                
                <div id="botoneraMovil" class="navbar-header navbar-inverse">

                    <button type="button" class="navbar-toggle pull-left" data-toggle="collapse" data-target="#botonera">

                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>

                    </button>

                </div>
                </div>
                
                <nav id="botonera" class="col-lg-12 col-md-9 col-sm-12 col-xs-12 collapse navbar-collapse " style="    margin: 10px 0 40px 0;">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <ul class="nav navbar-nav ">
                        <li class="nav-item"><button id="btn_Inicio" class="btn btn-primary my-2 my-sm-0 btn_menu_nav" type="button" >Inicio</button></li>
                        <li><button id="btn_Galería" class="btn btn-primary my-2 my-sm-0 btn_menu_nav" type="button" >Galería</button></li>
                                          
                        <li><button id="btn_Contáctenos" class="btn btn-primary my-2 my-sm-0 btn_menu_nav" type="button" >Contáctenos</button></li>
                        <li><button id="btn_Login" class="btn btn-primary my-2 my-sm-0 btn_menu_nav" type="button" data-toggle="modal" data-target="#loginModal">Login</button></li>
                     <!--   <li><a href="#login">Login</a></li>  -->

                    </ul>
                    </div>
                </nav>
                
                
            </header>

        <div id="id_inicio" style="display:inline-block;">
            
        
            <article>
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="top">

                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 text-center">

                    <img class="img-circle img_tam" src="http://localhost:8090/LogisticFV/views/image/VentaII.jpg" width="30%">
                    <h3>Venta Internacional</h3>
                    <p>Realizamos ventas internacionales para otras empresas</p>

                </div>

                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 text-center">

                    <img class="img-circle img_tam" src="http://localhost:8090/LogisticFV/views/image/VentaN.jpg" width="30%">
                    <h3>Venta Nacional</h3>
                    <p>disponemos tambien de ventas nacionales</p>

                </div>

                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 text-center">

                    <img class="img-circle img_tam" src="http://localhost:8090/LogisticFV/views/image/TransporteN.jpg" width="30%">
                    <h3>Disponemos de Transporte </h3>
                    <p>toda nuestra logistica de camiones disponible para niestros clientes.</p>

                </div>

                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 text-center">

                    <img class="img-circle img_tam" src="http://localhost:8090/LogisticFV/views/image/Embarque.jpg" width="30%">
                    <h3>Embarques</h3>
                    <p>Nos eseguramos de que tu producto llegue a buen puerto.</p>

                </div>

            </div>
        
        
        
        
        <!---->
        
                 <div id="" class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style=" margin-top: 200px"    >
                <div id="" class="col-xs-12 col-sm-2 col-md-2 col-lg-2"></div>
                <div id="myCarousel" class="carousel slide col-xs-12 col-sm-8 col-md-8 col-lg-8" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                        <li data-target="#myCarousel" data-slide-to="2"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner">

                        <div class="item active">
                            <img src="http://localhost:8090/LogisticFV/views/image/fondo.jpeg" alt="Los Angeles" style="width:100%;height: 300px;">
                            <div class="carousel-caption">
                                <h3></h3>
                                <p></p>
                            </div>
                        </div>

                        <div class="item">
                            <img src="http://localhost:8090/LogisticFV/views/image/frutas.jpg" alt="Chicago" style="width:100%;height: 300px;">
                            <div class="carousel-caption">
                                <h3></h3>
                                <p></p>
                            </div>
                        </div>

                        <div class="item">
                            <img src="http://localhost:8090/LogisticFV/views/image/Mesa.jpg" alt="New York" style="width:100%;height: 300px;">
                            <div class="carousel-caption">
                                <h3></h3>
                                <p></p>
                            </div>
                        </div>

                    </div>

                    <!-- Left and right controls -->
                    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#myCarousel" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
                <div id="" class="col-xs-2 col-sm-2 col-md-2 col-lg-2"></div>
            </div>
        </article>

        
        
        
        </div>
        
        
        
        <div id="id_galeria" style="display:none;">
        <article>
        <div id="div_galeria" class="container">
            
            <div class="row">
                <div class="col-md-4 col-lg-4 col-sm-6 img_space ">
                    <!-- Trigger the modal with a button -->
                    <img class="img-responsive img-res" src="http://localhost:8090/LogisticFV/views/image/frutas.jpg" data-toggle="modal" >
                    <!-- Modal -->

                </div>

                <div class="col-md-4 col-lg-4 col-sm-6 img_space">
                    <!-- Trigger the modal with a button -->
                    <img class="img-responsive img-res" src="http://localhost:8090/LogisticFV/views/image/frutas.jpg" data-toggle="modal" data-target="#myModal1">
                    <!-- Modal -->
                </div>
                <div class="col-md-4 col-lg-4 col-sm-6 img_space">
                    <!-- Trigger the modal with a button -->
                    <img class="img-responsive img-res" src="http://localhost:8090/LogisticFV/views/image/Mesa.jpg" data-toggle="modal" data-target="#myModal2">
                    <!-- Modal -->
                </div>
                <div class="col-md-4 col-lg-4 col-sm-6 img_space">
                    <!-- Trigger the modal with a button -->
                    <img class="img-responsive img-res" src="http://localhost:8090/LogisticFV/views/image/Mesa.jpg" data-toggle="modal" data-target="#myModal2">
                    <!-- Modal -->
                </div>
                

            </div>
        </div>
        </article>
        
            
            
            
        </div>
        
        
        <div id="div_contacta" style="display:none;">
             <hr>

            <h1 class="text-center text-info" style="height:100px;"><b>CONTÁCTENOS</b></h1>



            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-1" ></div>

            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-10" id="formulario">
                <!--    comienza codigo -->
                <div class="form-group">
                    <label for="nombre" class="lblform">Nombres:</label>
                    <label id="lblnom" style="margin:0 0 0 100px;color:red;"></label>
                    <input type="text" class="form-control" id="nombre" placeholder="Nombre" name="nombre">
                </div>
                <div class="form-group">
                    <label for="apellido" class="lblform">Apellidos:</label>
                    <label id="lbla" style="margin:0 0 0 100px;color:red;"></label>
                    <input type="text" class="form-control" id="apellido" placeholder="apellido" name="nombre">
                </div>
                <div class="form-group">
                    <label for="tele" class="lblform">Telefono:</label>
                    <label id="lblt" style="margin:0 0 0 100px;color:red;"></label>
                    <input type="text" class="form-control" id="tele" placeholder="Telefono" name="tele" maxlength="9" onKeypress="if (event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;">
                </div>
                <div class="form-group">
                    <label for="email" class="lblform">Email:</label>
                    <label id="lble" style="margin:0 0 0 100px;color:red;"></label>
                    <input type="email" class="form-control" id="email" placeholder="email" name="email" required pattern="[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}">
                </div>
                <div class="form-group">
                    <label for="comment" class="lblform">Comentarios</label>
                    <label id="lblc" style="margin:0 0 0 100px;color:red;"></label>
                    <textarea class="form-control" rows="5" id="comment" style="resize: none;"></textarea>
                </div>

                <button id="enviarC" type="" class="btn btn-default" style="margin: 0 0 100px 0">Enviar</button>
                <!--  fin  comienza codigo -->
            </div>
            
        </div>
        
        
                   <footer class="footer-area" >
		<div class="container">
			<div class="row">
				<div class="col-xl-3 col-lg-6 col-sm-6 mb-4 mb-xl-0 single-footer-widget">
					<h4 style = "line-height: 2.55em" class="text-info"><b>Sobre Nosotros</b></h4>
					<p class="text-info">En Logistic </p>
				</div>
				<div class="col-xl-3 col-lg-6 col-sm-6 mb-4 mb-xl-0 single-footer-widget">
					<h4 style = "line-height: 2.55em" class="text-info"><b>Contacto Info</b></h4>
					<ul>
						<li><p class="text-info">Dirección :Esq Blanca 501, Maipú, Región Metropolitana .</p></li>
						<li><p class="text-info">Teléfono : +569 44338899</p></li>
						<li><p class="text-info">Email : info@logistic.cl</p></li>
					</ul>
				</div>
				
			</div>
			<div class="copyright_text">
				<div class="">
					<div class="col-lg-12">
						<div class="copyright_part">
							<p class="footer-text m-0" class="text-info"><b>Copyright © 2019 All rights reserved </b><span class="px-2"></span> <i class="ti-heart"></i></a></p>
						</div>
					</div>

				</div>
			</div>
		</div>
	</footer>
        
        
        
    <!-- login modal-->
    <div class="modal" id="loginModal" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
            <div class="modal-dialog" role="document">
              <div class="modal-content" style="height: 350px;">
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

    </body>
</html>
