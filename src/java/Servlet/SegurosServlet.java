/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControladorSeguros;
import include.Seguro;
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
public class SegurosServlet extends HttpServlet {

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

        switch (func) {
            case "crearSeguro":

                String nombreSeguroC = request.getParameter("id_nombre");
                float costoC = Float.parseFloat(request.getParameter("id_costo"));
                String estadoC = request.getParameter("id_estado");
                int idEmbarqueC = Integer.parseInt(request.getParameter("id_embarque"));

                Seguro s = new Seguro(-1, nombreSeguroC, costoC, estadoC, idEmbarqueC);
                ControladorSeguros cSegC = new ControladorSeguros();
                if (cSegC.crearSeguro(s)) {
                    response.getWriter().println("seguro creado");
                } else {
                    //  response.sendRedirect("usuario.jsp#menu1");
                    response.getWriter().println("No se se pudo crear un nuevo seguro");
                }

                break;

            case "tablaSeguros":
                ControladorSeguros csT = new ControladorSeguros();
                System.out.println("estoy en tablaSeguros");

                JSONObject myObject = new JSONObject();

                //LE PASA EL OBJETO JSON CON TODOS LOS REGISTROS AL DATA DE AJAX
                myObject.put("data", csT.getviewSeguros());

                //LINEA QUE IMPRIME LOS REGISTROS A LA TABLA
                response.getWriter().println(myObject);

                break;

//            case "updateProducto":
//                //     ControladorUsuarios cu2 =new ControladorUsuarios();
//                System.out.println("estoy en updateUsuario");
//
//                int idProductoU = Integer.parseInt(request.getParameter("id_idproducto"));
//                float cantidadU = Float.parseFloat(request.getParameter("id_cantidad"));
//                float precioU = Float.parseFloat(request.getParameter("id_precio"));
//                String fechaStringU = request.getParameter("id_fecha");
//                int idFrutaU = Integer.parseInt(request.getParameter("id_nombre_value"));
//                String nombreFrutaU = request.getParameter("id_nombre_text");
//                int idCalidadU = Integer.parseInt(request.getParameter("id_calidad_value"));
//                String nombreCalidadU = request.getParameter("id_calidad_text");
//
//                SimpleDateFormat sdfu = new SimpleDateFormat("yyyy-MM-dd");
//                Date fechaDateU;
//                try {
//                    fechaDateU = sdfu.parse(fechaStringU);
//
//                    Fruta fu = new Fruta(idFrutaU, nombreFrutaU);
//                    Calidad cu = new Calidad(idCalidadU, nombreCalidadU);
//
//                    Producto up = new Producto(idProductoU, cantidadU, precioU, fechaDateU, fu, cu, -1);
//                    ControladorProductos cpu = new ControladorProductos();
//                    //    response.getWriter().println(cu.crearUsuario(u)); 
//                    if (cpu.updateProducto(up)) {
//                        //  response.sendRedirect("usuario.jsp");
//                        response.getWriter().println("usuario Modificado");
//
//                    } else {
//                        //  response.sendRedirect("usuario.jsp#menu1");
//                        response.getWriter().println("No se pudo madificar el usuario");
//
//                    }
//
//                } catch (ParseException ex) {
//                    Logger.getLogger(ProductosServlet.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//                break;

            case "deleteSeguro":
                //     ControladorUsuarios cu2 =new ControladorUsuarios();
                System.out.println("estoy en deleteSeguro");

                int idSeguro = Integer.parseInt(request.getParameter("id_idseguro_d"));

                ControladorSeguros csD = new ControladorSeguros();
                
                if (csD.deleteSeguro(idSeguro)) {
                    //  response.sendRedirect("usuario.jsp");
                    response.getWriter().println("seguro eliminado");

                } else {
                    //  response.sendRedirect("usuario.jsp#menu1");
                    response.getWriter().println("No se pudo eliminar el seguro");
                }

                break;

            default:
                throw new AssertionError();
        }
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

// URL Pattern: segurosservlet