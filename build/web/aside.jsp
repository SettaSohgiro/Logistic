 
            <li class="nav-item dropdown">
                <a class="nav-link" href="dirigir?direc=inicio" name="inicio"  title="Inicio"><i class="fas fa-home"></i>  Inicio <i class="fas fa-home shortmenu animate"></i> </a>
          </li>
          <li class="nav-item dropdown">
              <a class="nav-link" href="dirigir?direc=usuario" name="usuario" title="Usuario"><i class="fas fa-user"></i>Usuario<i class="fas fa-user shortmenu animate"></i> </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" type="submit" href="dirigir?direc=venta" name="venta"  title="ventas"><i class="fas fa-cart-plus"></i> Ventas <i class="fas fa-cart-plus shortmenu animate"></i></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="dirigir?direc=contrato" name="contrato"  title="contratos"><i class="far fa-address-book"></i>Contratos <i class="far fa-address-book shortmenu animate"></i></a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="dirigir?direc=transporte" name="transporte"  title="transporte"><i class="fas fa-bus"></i>Transporte <i class="fas fa-bus shortmenu animate"></i></a>
          
           </li>
           
            <li class="nav-item">
              <a class="nav-link" href="dirigir?direc=administrador" name="administrador"  title="administrador"><i class='fas fa-bookmark'></i>Transporte <i class="fas fa-bookmark shortmenu animate"></i></a>
          
           </li>
           
           <li class="nav-item">
            <a class="nav-link" href="dirigir?direc=consultor" name="consultor"  title="consultor"><i class="far fa-file-alt"></i> Consultor <i class="far fa-file-alt shortmenu animate"></i></a>
          </li>
           
           <li class="nav-item">
            <a class="nav-link" href="dirigir?direc=productor" name="productor"  title="productor"><i class="fas fa-leaf"></i> Productor <i class="fas fa-leaf shortmenu animate"></i></a>
          </li>           
           
</ul>
        <ul class="navbar-nav ml-md-auto d-md-flex">
            <%
    HttpSession objsesion = request.getSession(false);
    String usuario = (String)objsesion.getAttribute("usuario");
    String paterno = (String)objsesion.getAttribute("paterno");
    String id = (String)objsesion.getAttribute("id");
    String rol = (String)objsesion.getAttribute("rol");
    
//    if(usuario == null){
//    request.getRequestDispatcher("index.jsp");
//     };
%>
          <li class="nav-item">
              <div style="color: #839f81;font-size: 22px;"><label id="id_usuario_sesion"><% out.println(usuario); %></label>
              <label id="id_paterno_sesion"><% out.println(paterno); %></label></div>
              <input id="id_id_sesion" type="hidden" value="<% out.println(id); %>">
              <input id="id_rol_sesion" type="hidden" value="<% out.println(rol); %>">
          </li> 
          <li class="nav-item">
            <a class="nav-link" href="#"><i class="fas fa-user"></i> Informacion</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="dirigir?direc=salir"><i class="fas fa-key"></i> Salir</a>
          </li>