/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControllerTransporte;
import include.variable6;
import include.variable7;
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
@WebServlet(name = "Transporte", urlPatterns = {"/transporte"})
public class Transporte extends HttpServlet {

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
            case "tabletransporte":
                
                ControllerTransporte cvtu = new ControllerTransporte();
                System.out.println("estoy en tabletransporte");

                JSONObject mytableu = new JSONObject();

                mytableu.put("data", cvtu.tabletransporte());

                response.getWriter().println(mytableu);

            break;
               
                     
            case "updateTransporte":

                ControllerTransporte cvt= new ControllerTransporte();
                System.out.println("estoy en updateTransporte : ");
                String patente = request.getParameter("id_patente_mod");
                String vehiculo = request.getParameter("inp_tipo_vehiculo");
                String m3 = request.getParameter("inp_capacidad_m3");
                String tonelada = request.getParameter("inp_capacidad_tonelada");
                String conductor = request.getParameter("inp_nombre_conductor");
                String licencia = request.getParameter("inp_tipo_licencia");
                String inp_id = request.getParameter("inp_id");
             
   
              //  JSONObject objectbolfact = new JSONObject();

                //    objectRol.put("data", cus.comboRol());
                variable7 v7 = new variable7(patente,vehiculo,m3,tonelada,conductor, licencia , inp_id);
             //   System.out.println("usuario : "+v);
                if (cvt.updateTransporte(v7)) {
                    //  response.sendRedirect("usuario.jsp");
                     System.out.println("true : venta ingresada");
                    response.getWriter().println("Venta ingresada");
                   
                } else {
                    //  response.sendRedirect("usuario.jsp#menu1");
                     System.out.println("false ");
                    response.getWriter().println("No se pudo ingresar la venta");

                }
                break; 
  
            case "tableseleccion":
                
                ControllerTransporte cvts = new ControllerTransporte();
                System.out.println("estoy en tabletransporte_seleccion");

                JSONObject mytables = new JSONObject();

                mytables.put("data", cvts.tableseleccion());

                response.getWriter().println(mytables);

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
