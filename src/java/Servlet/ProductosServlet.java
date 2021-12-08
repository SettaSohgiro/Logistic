/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControladorFrutas;
import Controlador.ControladorProductos;
import include.Calidad;
import include.Fruta;
import include.Producto;
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
import org.json.*;

/**
 *
 * @author me
 */
public class ProductosServlet extends HttpServlet {

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
            case "crearProducto":

                int idProductorC = Integer.parseInt(request.getParameter("id_productor"));
                float cantidadC = Float.parseFloat(request.getParameter("id_cantidad"));
                float precioC = Float.parseFloat(request.getParameter("id_precio"));
                String fechaProdC = request.getParameter("id_fechaproduccion");
                int idFrutaC = Integer.parseInt(request.getParameter("id_nombre_value"));
                String nombreFrutaC = request.getParameter("id_nombre_text");
                int idCalidadC = Integer.parseInt(request.getParameter("id_calidad_value"));
                String nombreCalidadC = request.getParameter("id_calidad_text");

                System.out.println("nombre : " + nombreFrutaC);

                SimpleDateFormat sdfC = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaC;
                try {
                    fechaC = sdfC.parse(fechaProdC);

                    Fruta fc = new Fruta(idFrutaC, nombreFrutaC);
                    Calidad cc = new Calidad(idCalidadC, nombreCalidadC);

                    Producto p = new Producto(0, cantidadC, precioC, fechaC, fc, cc, idProductorC);
                    ControladorProductos cProd = new ControladorProductos();
                    //    response.getWriter().println(cu.crearUsuario(u)); 
                    if (cProd.crearProducto(p)) {
                        //  response.sendRedirect("usuario.jsp");
                        response.getWriter().println("usuario creado");

                    } else {
                        //  response.sendRedirect("usuario.jsp#menu1");
                        response.getWriter().println("No se se pudo crear un nuevo usuario");
                    }
                } catch (Exception e) {

                }

                break;

            case "tablaProductos":
                ControladorProductos cu2 = new ControladorProductos();
                System.out.println("estoy en tablaProductos");
                int idProductorU = Integer.parseInt(request.getParameter("id_productor"));

                JSONObject myObject = new JSONObject();

                //LE PASA EL OBJETO JSON CON TODOS LOS REGISTROS AL DATA DE AJAX
                myObject.put("data", cu2.getviewProductos(idProductorU));

                //LINEA QUE IMPRIME LOS REGISTROS A LA TABLA
                response.getWriter().println(myObject);

                break;

            case "updateProducto":
                //     ControladorUsuarios cu2 =new ControladorUsuarios();
                System.out.println("estoy en updateUsuario");

                int idProductoU = Integer.parseInt(request.getParameter("id_idproducto"));
                float cantidadU = Float.parseFloat(request.getParameter("id_cantidad"));
                float precioU = Float.parseFloat(request.getParameter("id_precio"));
                String fechaStringU = request.getParameter("id_fecha");
                int idFrutaU = Integer.parseInt(request.getParameter("id_nombre_value"));
                String nombreFrutaU = request.getParameter("id_nombre_text");
                int idCalidadU = Integer.parseInt(request.getParameter("id_calidad_value"));
                String nombreCalidadU = request.getParameter("id_calidad_text");

                SimpleDateFormat sdfu = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaDateU;
                try {
                    fechaDateU = sdfu.parse(fechaStringU);

                    Fruta fu = new Fruta(idFrutaU, nombreFrutaU);
                    Calidad cu = new Calidad(idCalidadU, nombreCalidadU);

                    Producto up = new Producto(idProductoU, cantidadU, precioU, fechaDateU, fu, cu, -1);
                    ControladorProductos cpu = new ControladorProductos();
                    //    response.getWriter().println(cu.crearUsuario(u)); 
                    if (cpu.updateProducto(up)) {
                        //  response.sendRedirect("usuario.jsp");
                        response.getWriter().println("usuario Modificado");

                    } else {
                        //  response.sendRedirect("usuario.jsp#menu1");
                        response.getWriter().println("No se pudo madificar el usuario");

                    }

                } catch (ParseException ex) {
                    Logger.getLogger(ProductosServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

            case "deleteProducto":
                //     ControladorUsuarios cu2 =new ControladorUsuarios();
                System.out.println("estoy en updateUsuario");

                int idProducto = Integer.parseInt(request.getParameter("id_idproducto_d"));

                //    response.getWriter().println(myObject);
                //    Usuario ud = new Usuario(rutd);
                ControladorProductos cd = new ControladorProductos();
                //    response.getWriter().println(cu.crearUsuario(u)); 
                if (cd.deleteProducto(idProducto)) {
                    //  response.sendRedirect("usuario.jsp");
                    response.getWriter().println("usuario eliminado");

                } else {
                    //  response.sendRedirect("usuario.jsp#menu1");
                    response.getWriter().println("No se pudo eliminar el usuario");

                }

                break;

            case "llenarFormMod":
                System.out.println("estoy en llenarFormMod");
                int idProdLl = Integer.parseInt(request.getParameter("id_idproducto"));
                ControladorProductos cll = new ControladorProductos();
                String prodJsonString = cll.getviewProducto(idProdLl);
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
