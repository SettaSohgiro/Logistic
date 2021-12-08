/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.Consultas;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author Lee
 */
public class InicioSesion extends HttpServlet {

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
        
            String usuario = request.getParameter("usuario");
            String contraseña = request.getParameter("pass");
           
           Consultas co = new Consultas();
           
            JSONArray arr = new JSONArray(co.autenticacion2(usuario, contraseña));
            System.out.println("arr : "+ arr.length());

      

           if(arr.length() > 0){
               HttpSession objsesion = request.getSession(true);

                    for(int i = 0; i < arr.length(); i++){

                        //System.out.println("for : "+ arr.getJSONObject(i).getString("ID"));
                       // System.out.println("for : "+ arr.getJSONObject(i).getString("NOMBRE"));
                        objsesion.setAttribute("usuario", arr.getJSONObject(i).getString("NOMBRE"));
                        objsesion.setAttribute("paterno", arr.getJSONObject(i).getString("PATERNO"));
                        objsesion.setAttribute("id", arr.getJSONObject(i).getString("ID"));
                        objsesion.setAttribute("rol", arr.getJSONObject(i).getString("ROL"));
                        
               
                    }
             
               response.sendRedirect("inicio.jsp");
           }else{
               response.sendRedirect("index.jsp");
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
