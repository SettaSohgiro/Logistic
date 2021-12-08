<%-- 
    Document   : productorreporte
    Created on : 15-10-2021, 23:07:45
    Author     : me
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LogisticFV</title>
        <jsp:include page="/views/menu/cabemenu.jsp"/>
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
                <jsp:include page="productoraside.jsp"/>
        </ul>

      </div>
    </nav>
    <div class="container-fluid">
        <div>Reportes</div>
        <div class="row">
        <div class="col">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Try Other</h5>
            </div>
          </div>
        </div>
        </div>
    <!--  <div class="row">
        <div class="col">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Try Other</h5>
              <h6 class="card-subtitle mb-2 text-muted">Bootstrap 4.0.0 Snippet by pradeep330</h6>
              <p class="card-text">You can also try different version of Bootstrap V4 side menu. Click below link to view all Bootstrap Menu versions.</p>
              <a href="https://bootsnipp.com/pradeep330" class="card-link">link</a>
              <a href="http://websitedesigntamilnadu.com" class="card-link">Another link</a>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Try Other</h5>
              <h6 class="card-subtitle mb-2 text-muted">Bootstrap 4.0.0 Snippet by pradeep330</h6>
              <p class="card-text">You can also try different version of Bootstrap V4 side menu. Click below link to view all Bootstrap Menu versions.</p>
              <a href="https://bootsnipp.com/pradeep330" class="card-link">link</a>
              <a href="http://websitedesigntamilnadu.com" class="card-link">Another link</a>
            </div>
          </div>
        </div>  -->
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
