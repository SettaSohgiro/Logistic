/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControllerContrato;
import include.variable1;
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
@WebServlet(name = "Contrato", urlPatterns = {"/crearcontrato"})
public class Contrato extends HttpServlet {

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
            case "tablecontrato":
                
                ControllerContrato cc = new ControllerContrato();
                System.out.println("estoy en tablecontrato");

                JSONObject myObject = new JSONObject();

                myObject.put("data", cc.tablecontrato());

                response.getWriter().println(myObject);

                break;
                
                
                
                case "llenadoFactura":
                
                ControllerContrato cf = new ControllerContrato();
                System.out.println("estoy en llenadoFactura");
                String id = request.getParameter("id");
                JSONObject myfactura = new JSONObject();

                myfactura.put("data", cf.llenadoFactura(id));

                response.getWriter().println(myfactura);

                break; 
                
                
                  case "detalleFactura":
                
                ControllerContrato cfd = new ControllerContrato();
                System.out.println("estoy en detalleFactura");
                String idd = request.getParameter("id");
                JSONObject myfacturade = new JSONObject();

                myfacturade.put("data", cfd.detalleFactura(idd));

                response.getWriter().println(myfacturade);

                break;        
                        

                         
               case "anularContrato":
                
                ControllerContrato cac = new ControllerContrato();
                System.out.println("estoy en detalleFactura");
                String id3 = request.getParameter("id");
                   //  JSONObject objectbolfact = new JSONObject();

                //    objectRol.put("data", cus.comboRol());
                variable1 v1 = new variable1(id3);
             //   System.out.println("usuario : "+v);
                if (cac.anularContrato(v1)) {
                    //  response.sendRedirect("usuario.jsp");
                     System.out.println("true : contrato anulado");
                    response.getWriter().println("contrato anulado");
                   
                } else {
                    //  response.sendRedirect("usuario.jsp#menu1");
                     System.out.println("false ");
                    response.getWriter().println("No se pudo anular el contrato");

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
