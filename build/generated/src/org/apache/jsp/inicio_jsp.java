package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class inicio_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>LogisticFV</title>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/views/menu/cabemenu.jsp", out, false);
      out.write("\n");
      out.write("        \n");
      out.write("          <!-- base:css \n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/views/vendors/mdi/css/materialdesignicons.min.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/views/vendors/feather/feather.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/views/vendors/base/vendor.bundle.base.css\">-->\n");
      out.write("  <!-- endinject -->\n");
      out.write("  <!-- plugin css for this page \n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/views/vendors/flag-icon-css/css/flag-icon.min.css\"/>\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/views/vendors/font-awesome/css/font-awesome.min.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/views/vendors/jquery-bar-rating/fontawesome-stars-o.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/views/vendors/jquery-bar-rating/fontawesome-stars.css\">-->\n");
      out.write("  <!-- End plugin css for this page -->\n");
      out.write("    <script src=\"https://unpkg.com/axios/dist/axios.min.js\"></script>\n");
      out.write("    \n");
      out.write("   <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js\"></script> \n");
      out.write("    \n");
      out.write("  <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/views/inicio/inicio.js\"></script>\n");
      out.write("    \n");
      out.write("   <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/views/public/AdminLTE.css\">\n");
      out.write("   <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/views/public/AdminLTE.min.css\">\n");
      out.write("    \n");
      out.write("  \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        \n");
      out.write("  <style>\n");
      out.write("      \n");
      out.write(".panel-pricing {\n");
      out.write("  -moz-transition: all .3s ease;\n");
      out.write("  -o-transition: all .3s ease;\n");
      out.write("  -webkit-transition: all .3s ease;\n");
      out.write("}\n");
      out.write(".panel-pricing:hover {\n");
      out.write("  box-shadow: 0px 0px 30px rgba(0, 0, 0, 0.2);\n");
      out.write("}\n");
      out.write(".panel-pricing .panel-heading {\n");
      out.write("  padding: 20px 10px;\n");
      out.write("}\n");
      out.write(".panel-pricing .panel-heading .fa {\n");
      out.write("  margin-top: 10px;\n");
      out.write("  font-size: 58px;\n");
      out.write("}\n");
      out.write(".panel-pricing .list-group-item {\n");
      out.write("  color: #777777;\n");
      out.write("  border-bottom: 1px solid rgba(250, 250, 250, 0.5);\n");
      out.write("}\n");
      out.write(".panel-pricing .list-group-item:last-child {\n");
      out.write("  border-bottom-right-radius: 0px;\n");
      out.write("  border-bottom-left-radius: 0px;\n");
      out.write("}\n");
      out.write(".panel-pricing .list-group-item:first-child {\n");
      out.write("  border-top-right-radius: 0px;\n");
      out.write("  border-top-left-radius: 0px;\n");
      out.write("}\n");
      out.write(".panel-pricing .panel-body {\n");
      out.write("  background-color: #f0f0f0;\n");
      out.write("  font-size: 40px;\n");
      out.write("  color: #777777;\n");
      out.write("  padding: 20px;\n");
      out.write("  margin: 0px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("  </style>       \n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("  <div id=\"wrapper\" class=\"animate\">\n");
      out.write("    <nav class=\"navbar header-top fixed-top navbar-expand-lg navbar-dark bg-dark\" style=\"background-color: #063e02 !important;\">\n");
      out.write("      <span class=\"navbar-toggler-icon leftmenutrigger\"></span>\n");
      out.write("      <a class=\"navbar-brand\" href=\"#\">LogisticFV</a>\n");
      out.write("      <button id=\"button_togle\" class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarText\" aria-controls=\"navbarText\"\n");
      out.write("        aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("        <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("      </button>\n");
      out.write("      <div class=\"collapse navbar-collapse\" id=\"navbarText\">\n");
      out.write("        \n");
      out.write("          <ul class=\"navbar-nav animate side-nav\" style=\"background: #0f4d03;\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "aside.jsp", out, false);
      out.write("\n");
      out.write("        </ul>\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("    </nav>\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("        \n");
      out.write("       \n");
      out.write("                <div class=\"col-lg-3 col-xs-6\" style=\"border: 2px solid white;margin: 0;padding: 0;border-radius: 8px;box-shadow: 0 .15rem 1.75rem 0 rgba(83, 83, 87, 0.57) !important;\">\n");
      out.write("\n");
      out.write("                    <div class=\"small-box bg-aqua\" style=\"margin: 0;\">\n");
      out.write("\n");
      out.write("                      <div class=\"inner\" style=\"font-size: 73px;\">\n");
      out.write("\n");
      out.write("                        <p style=\"font-size: 42px;margin: 0;\"><strong>$<strong id=\"ston_dollar\">0</strong></strong></p>\n");
      out.write("\n");
      out.write("                        <p>Dollar</p>\n");
      out.write("\n");
      out.write("                      </div>\n");
      out.write("\n");
      out.write("                      <div class=\"icon\">\n");
      out.write("\n");
      out.write("                        <i class=\"fas fa-dollar-sign\"></i>\n");
      out.write("\n");
      out.write("                      </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                  </div>\n");
      out.write("\n");
      out.write("<div class=\"row mt-3\">\n");
      out.write("            <div class=\"col-xl-3 flex-column d-flex grid-margin stretch-card\">\n");
      out.write("              <div class=\"row flex-grow\">\n");
      out.write("                <div class=\"col-sm-12 grid-margin stretch-card\">\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                      <div class=\"card-body\"><div class=\"chartjs-size-monitor\"><div class=\"chartjs-size-monitor-expand\"><div class=\"\"></div></div><div class=\"chartjs-size-monitor-shrink\"><div class=\"\"></div></div></div>\n");
      out.write("                          <h4 class=\"card-title\">Ventas</h4>\n");
      out.write("                          <p>0% incrementacion</p>\n");
      out.write("                          <h4 class=\"text-dark font-weight-bold mb-2\">0</h4>\n");
      out.write("                          <canvas id=\"customers\" height=\"64\" style=\"display: block; width: 322px; height: 64px;\" width=\"322\" class=\"chartjs-render-monitor\"></canvas>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-12 stretch-card\">\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                      <div class=\"card-body\"><div class=\"chartjs-size-monitor\"><div class=\"chartjs-size-monitor-expand\"><div class=\"\"></div></div><div class=\"chartjs-size-monitor-shrink\"><div class=\"\"></div></div></div>\n");
      out.write("                          <h4 class=\"card-title\">Pedidos</h4>\n");
      out.write("                          <p>0% incrementos</p>\n");
      out.write("                          <h4 class=\"text-dark font-weight-bold mb-2\">0</h4>\n");
      out.write("                          <canvas id=\"orders\" height=\"64\" style=\"display: block; width: 322px; height: 200px;\" width=\"322\" class=\"chartjs-render-monitor\"></canvas>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("               </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-xl-9 d-flex grid-margin stretch-card\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                  <div class=\"card-body\">\n");
      out.write("                      <h4 class=\"card-title\">Usuarios registrados en el sistema</h4>\n");
      out.write("                      <div class=\"row\">\n");
      out.write("                        <div class=\"col-lg-5\">\n");
      out.write("                          <p></p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-lg-7\">\n");
      out.write("                          <div class=\"chart-legends d-lg-block d-none\" id=\"chart-legends\"><div class=\"row\">\n");
      out.write("                                  <div class=\"col-lg-4\"><div class=\"row\">\n");
      out.write("                                          <div class=\"col-sm-12\"><h5 class=\"font-weight-bold text-dark mb-1\">83.123</h5></div></div>\n");
      out.write("                                          <div class=\"row align-items-center\"><div class=\"col-2\"><span class=\"legend-label\" style=\"background-color:#3794fc\"></span></div>\n");
      out.write("                                              <div class=\"col-9 pl-0\"><p class=\"text-muted m-0 ml-1\">Sesiones</p></div></div></div>\n");
      out.write("                                              <div class=\"col-lg-4\"><div class=\"row\">\n");
      out.write("                                                      <div class=\"col-sm-12\"><h5 class=\"font-weight-bold text-dark mb-1\">3333</h5></div></div>\n");
      out.write("                                                      <div class=\"row align-items-center\"><div class=\"col-2\"><span class=\"legend-label\" style=\"background-color:#a037fc\"></span></div>\n");
      out.write("                                                          <div class=\"col-9 pl-0\"><p class=\"text-muted m-0 ml-1\">Usuarios</p></div></div></div><div class=\"col-lg-4\">\n");
      out.write("                                                              <div class=\"row\">\n");
      out.write("                                                                  <div class=\"col-sm-12\"><h5 class=\"font-weight-bold text-dark mb-1\">16.869</h5></div></div>\n");
      out.write("                                                                  <div class=\"row align-items-center\"><div class=\"col-2\"><span class=\"legend-label\" style=\"background-color:#dee5ef\"></span></div>\n");
      out.write("                                                                      <div class=\"col-9 pl-0\"><p class=\"text-muted m-0 ml-1\">Paginas Visitadas</p></div></div></div></div></div>\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"row\">\n");
      out.write("                          <div class=\"col-sm-12\"><div class=\"chartjs-size-monitor\"><div class=\"chartjs-size-monitor-expand\"><div class=\"\"></div></div><div class=\"chartjs-size-monitor-shrink\"><div class=\"\"></div></div></div>\n");
      out.write("                              <canvas id=\"web-audience-metrics-satacked\" class=\"mt-3 chartjs-render-monitor\" height=\"328\" style=\"display: block; width: 1121px; height: 328px;\" width=\"1121\"></canvas>\n");
      out.write("                          </div>\n");
      out.write("                      </div>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"row\">\n");
      out.write("    <!--    <div class=\"col\">\n");
      out.write("          <div class=\"card\">\n");
      out.write("            <div class=\"card-body\">\n");
      out.write("              <h5 class=\"card-title\">Card title</h5>\n");
      out.write("              <table class=\"table\">\n");
      out.write("                <thead>\n");
      out.write("                  <tr>\n");
      out.write("                    <th scope=\"col\">#</th>\n");
      out.write("                    <th scope=\"col\">First</th>\n");
      out.write("                    <th scope=\"col\">Last</th>\n");
      out.write("                    <th scope=\"col\">Handle</th>\n");
      out.write("                  </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                  <tr>\n");
      out.write("                    <th scope=\"row\">1</th>\n");
      out.write("                    <td>Mark</td>\n");
      out.write("                    <td>Otto</td>\n");
      out.write("                    <td>@mdo</td>\n");
      out.write("                  </tr>\n");
      out.write("                  <tr>\n");
      out.write("                    <th scope=\"row\">2</th>\n");
      out.write("                    <td>Jacob</td>\n");
      out.write("                    <td>Thornton</td>\n");
      out.write("                    <td>@fat</td>\n");
      out.write("                  </tr>\n");
      out.write("                  <tr>\n");
      out.write("                    <th scope=\"row\">3</th>\n");
      out.write("                    <td>Larry</td>\n");
      out.write("                    <td>the Bird</td>\n");
      out.write("                    <td>@twitter</td>\n");
      out.write("                  </tr>\n");
      out.write("                </tbody>\n");
      out.write("              </table>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col\">\n");
      out.write("          <div class=\"card\">\n");
      out.write("            <div class=\"card-body\">\n");
      out.write("              <h5 class=\"card-title\">Card title</h5>\n");
      out.write("              <table class=\"table\">\n");
      out.write("                <thead>\n");
      out.write("                  <tr>\n");
      out.write("                    <th scope=\"col\">#</th>\n");
      out.write("                    <th scope=\"col\">First</th>\n");
      out.write("                    <th scope=\"col\">Last</th>\n");
      out.write("                    <th scope=\"col\">Handle</th>\n");
      out.write("                  </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                  <tr>\n");
      out.write("                    <th scope=\"row\">1</th>\n");
      out.write("                    <td>Mark</td>\n");
      out.write("                    <td>Otto</td>\n");
      out.write("                    <td>@mdo</td>\n");
      out.write("                  </tr>\n");
      out.write("                  <tr>\n");
      out.write("                    <th scope=\"row\">2</th>\n");
      out.write("                    <td>Jacob</td>\n");
      out.write("                    <td>Thornton</td>\n");
      out.write("                    <td>@fat</td>\n");
      out.write("                  </tr>\n");
      out.write("                  <tr>\n");
      out.write("                    <th scope=\"row\">3</th>\n");
      out.write("                    <td>Larry</td>\n");
      out.write("                    <td>the Bird</td>\n");
      out.write("                    <td>@twitter</td>\n");
      out.write("                  </tr>\n");
      out.write("                </tbody>\n");
      out.write("              </table>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div> -->\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <script defer src=\"https://use.fontawesome.com/releases/v5.0.6/js/all.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}