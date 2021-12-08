/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControladorFrutas;
import Controlador.ControladorSolicitudes;
import include.Calidad;
import include.Fruta;
import include.Solicitud;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author me
 */
public class SolicitudesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String func = request.getParameter("func");
        System.out.println("func _: " + func);

        switch (func) {
            case "crearSolicitud":

                String fechaSolC = request.getParameter("id_fechaSolitud");
                int idFrutaC = Integer.parseInt(request.getParameter("id_fruta"));
                int idCalidadC = Integer.parseInt(request.getParameter("id_calidad"));
                float cantidadC = Float.parseFloat(request.getParameter("id_cantidad"));
                float presupuestoC = Float.parseFloat(request.getParameter("id_presupuesto"));
                String embajaleC = request.getParameter("id_embalaje");

                SimpleDateFormat sdfC = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaC;
                try {
                    fechaC = sdfC.parse(fechaSolC);

                    Solicitud fC = new Solicitud(0, fechaC, cantidadC, presupuestoC, embajaleC, idFrutaC, idCalidadC, 0, 0);
                    ControladorSolicitudes csC = new ControladorSolicitudes();
                    //    response.getWriter().println(cu.crearUsuario(u)); 
                    if (csC.crearSolicitud(fC)) {
                        //  response.sendRedirect("usuario.jsp");
                        response.getWriter().println("usuario creado");

                    } else {
                        //  response.sendRedirect("usuario.jsp#menu1");
                        response.getWriter().println("No se se pudo crear un nuevo usuario");
                    }
                } catch (Exception e) {

                }

                break;

            case "tablaSolicitudes":
                ControladorSolicitudes csT = new ControladorSolicitudes();
                System.out.println("estoy en tablaSolicitudes");

                JSONObject myObject = new JSONObject();

                int type = Integer.parseInt(request.getParameter("type"));

                if (type == 0) {
                    //LE PASA EL OBJETO JSON CON TODOS LOS REGISTROS AL DATA DE AJAX
                    myObject.put("data", csT.getviewSolicitudes());
                    System.out.println(csT.getviewSolicitudes().length());
                } else if (type == 1) {
                    //LE PASA EL OBJETO JSON CON TODOS LOS REGISTROS AL DATA DE AJAX
                    myObject.put("data", csT.getviewSolicitudesAdmin());
                    System.out.println(csT.getviewSolicitudesAdmin().length());

                }

                //LINEA QUE IMPRIME LOS REGISTROS A LA TABLA
                response.getWriter().println(myObject);

                break;

            case "updateSolicitud":
                System.out.println("estoy en updateSolicitud");

                int idSolicitudU = Integer.parseInt(request.getParameter("id_idSolicitud"));
                String fechaSolU = request.getParameter("id_fechaSoli");
                int idFrutaU = Integer.parseInt(request.getParameter("id_idFruta"));
                int idCalidadU = Integer.parseInt(request.getParameter("id_idCalidad"));
                float cantidadU = Float.parseFloat(request.getParameter("id_cantidad"));
                float presupuestoU = Float.parseFloat(request.getParameter("id_presupuesto"));
                String embalajeU = request.getParameter("id_embalaje");

                SimpleDateFormat sdfu = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaDateU;
                try {
                    fechaDateU = sdfu.parse(fechaSolU);

                    Solicitud sU = new Solicitud(idSolicitudU, fechaDateU, cantidadU, presupuestoU, embalajeU, idFrutaU, idCalidadU, 0, 0);
                    ControladorSolicitudes csu = new ControladorSolicitudes();
                    //    response.getWriter().println(cu.crearUsuario(u)); 
                    if (csu.updateSolicitud(sU)) {
                        //  response.sendRedirect("usuario.jsp");
                        response.getWriter().println("solicitud Modificado");

                    } else {
                        //  response.sendRedirect("usuario.jsp#menu1");
                        response.getWriter().println("No se pudo modificar la solicitud");

                    }

                } catch (ParseException ex) {
                    Logger.getLogger(ProductosServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

            case "deleteSolicitud":
                //     ControladorUsuarios cu2 =new ControladorUsuarios();
                System.out.println("estoy en deleteSolicitud");

                int idSolicitudD = Integer.parseInt(request.getParameter("id_idsolicitud_d"));

                //    response.getWriter().println(myObject);
                //    Usuario ud = new Usuario(rutd);
                ControladorSolicitudes csD = new ControladorSolicitudes();
                //    response.getWriter().println(cu.crearUsuario(u)); 
                if (csD.deleteSolicitud(idSolicitudD)) {
                    //  response.sendRedirect("usuario.jsp");
                    response.getWriter().println("solicitud eliminada");

                } else {
                    //  response.sendRedirect("usuario.jsp#menu1");
                    response.getWriter().println("No se pudo eliminar la solicitud");
                }

                break;

            case "llenarFormMod":
                System.out.println("estoy en llenarFormMod");
                int idSolLF = Integer.parseInt(request.getParameter("id_idsolicitud"));
                ControladorSolicitudes csLF = new ControladorSolicitudes();
                String prodJsonString = csLF.getviewSolicitud(idSolLF);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(prodJsonString);
                break;

            case "llenarComboBoxes":
                System.out.println("estoy en llenarComboBoxes");
                ControladorFrutas cf = new ControladorFrutas();
                String frutasJsonString = cf.getviewFrutas();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(frutasJsonString);
                break;

            default:
                throw new AssertionError();
        }

//        solicitudservlet
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
