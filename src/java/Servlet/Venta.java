/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControllerVenta;
import include.variable12;
import include.variable6;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author Lee
 */
@WebServlet(name = "Venta", urlPatterns = {"/VentaIngreso"})
public class Venta extends HttpServlet {

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
        String val = request.getParameter("val");
        System.out.println("func _: " + func);
        
        switch (func) {
            case "tableStock":
                
                ControllerVenta cv = new ControllerVenta();
                System.out.println("estoy en tableStock");

                JSONObject myObject = new JSONObject();

                myObject.put("data", cv.tableStock());

                response.getWriter().println(myObject);

                break;
                
            case "selectClientes":
                ControllerVenta cvc = new ControllerVenta();
                System.out.println("estoy en selectClientes");

                JSONObject objectRol = new JSONObject();

                //    objectRol.put("data", cus.comboRol());
                response.getWriter().println(cvc.comboClientes());
                break;
            case "selectComprobante":
                ControllerVenta cvcc = new ControllerVenta();
                System.out.println("estoy en comboComprobante");

               // JSONObject objectcomprobante = new JSONObject();

                //    objectRol.put("data", cus.comboRol());
                response.getWriter().println(cvcc.comboComprobante());
                break;

            case "Com_boleta_fact":
                ControllerVenta cvbf = new ControllerVenta();
                System.out.println("estoy en comboComprobante : "+val);

              //  JSONObject objectbolfact = new JSONObject();

                //    objectRol.put("data", cus.comboRol());

                response.getWriter().println(cvbf.Com_boleta_fact(val));
                break;
                
                        
            case "insertVenta":
                ControllerVenta cviv = new ControllerVenta();
                System.out.println("estoy en insertVenta : ");
                String user = request.getParameter("user");
                String iduser = request.getParameter("iduser");
                String nbolf = request.getParameter("nbolf");
                String fechaventa = request.getParameter("fechaventa");
                String impuesto = request.getParameter("impuesto");
                String totalim = request.getParameter("totalim");
                String pago = request.getParameter("pago");
                String vuelto = request.getParameter("vuelto");
                String cod_trans = request.getParameter("cod_trans");
                String cliente = request.getParameter("cliente");
                String tipo_com = request.getParameter("tipo_com");
                String formapago = request.getParameter("formapago");

              //  JSONObject objectbolfact = new JSONObject();

                //    objectRol.put("data", cus.comboRol());
                variable12 v = new variable12(user,iduser,nbolf,fechaventa,impuesto,totalim,pago,vuelto,cod_trans,cliente,tipo_com,formapago);
             //   System.out.println("usuario : "+v);
                if (cviv.insertVenta(v)) {
                    //  response.sendRedirect("usuario.jsp");
                     System.out.println("true : venta ingresada");
                    response.getWriter().println("Venta ingresada");
                   
                } else {
                    //  response.sendRedirect("usuario.jsp#menu1");
                     System.out.println("false ");
                    response.getWriter().println("No se pudo ingresar la venta");

                }
                break;
                
                    
            case "insertVentadetalle":
                ControllerVenta cvid = new ControllerVenta();
                System.out.println("estoy en insertVentadetalle : ");
                String id = request.getParameter("id");
                String descrip = request.getParameter("descrip");
                String cantidad = request.getParameter("cantidad");
                String stock = request.getParameter("stock");
                String total = request.getParameter("total");
                String clide = request.getParameter("cliente");
             
                System.out.println("cliente "+ clide);
              //  JSONObject objectbolfact = new JSONObject();

                //    objectRol.put("data", cus.comboRol());
                variable6 v6 = new variable6(id,descrip,cantidad,stock,total, clide);
             //   System.out.println("usuario : "+v);
                if (cvid.insertVentaDetalle(v6)) {
                    //  response.sendRedirect("usuario.jsp");
                     System.out.println("true : venta ingresada");
                    response.getWriter().println("Venta ingresada");
                   
                } else {
                    //  response.sendRedirect("usuario.jsp#menu1");
                     System.out.println("false ");
                    response.getWriter().println("No se pudo ingresar la venta");

                }
                break; 
                
                
            case "tablaUsuario":
                
                ControllerVenta cvtu = new ControllerVenta();
                System.out.println("estoy en tablaUsuario");

                JSONObject mytableu = new JSONObject();

                mytableu.put("data", cvtu.tablaUsuario());

                response.getWriter().println(mytableu);

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
