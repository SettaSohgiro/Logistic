/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lee
 */
public class Redireccionamiento extends HttpServlet {

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
         
        String dire=request.getParameter("direc");
        System.out.println("direccion : "+ dire);
        
        
       // 
        switch(dire){
            case "inicio":
                response.sendRedirect("inicio.jsp");

                break; 
            case "usuario":
                response.sendRedirect("usuario.jsp");
              //  List<Persona>datos=dao.listar();
              //  request.setAttribute("datos",datos);
              // request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "venta":
                response.sendRedirect("venta.jsp");

                break; 
                
                        
            case "contrato":
                response.sendRedirect("contrato.jsp");

                break;                         
                        
            case "reporte":
                response.sendRedirect("reporte.jsp");

                break;   
            case "consultor":
                response.sendRedirect("consultor.jsp");

                break;   
             case "transporte":
                response.sendRedirect("transporte.jsp");

                break;  
                
            case "administrador":
                response.sendRedirect("administrador.jsp");

                break;   
                
            case "productor":
                response.sendRedirect("productor.jsp");

                break;                 
                
            case "salir":
                HttpSession objsesion = request.getSession();
                objsesion.invalidate();
                
                response.sendRedirect("index.jsp");

                break;    
            default:
                throw  new AssertionError();
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
