/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControladorContratosVenta;
import include.ContratoVenta;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author me
 */
public class ContratosVentaServlet extends HttpServlet {

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
            case "crearContratoVenta":

                String fechaInicio = request.getParameter("fechaInicio");
                int idSolicitud = Integer.parseInt(request.getParameter("id_solicitud"));
                int idCliente = Integer.parseInt(request.getParameter("id_cliente"));

                SimpleDateFormat sdfC = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaC;
                try {
                    fechaC = sdfC.parse(fechaInicio);

                    ContratoVenta cv = new ContratoVenta(-1, fechaC, fechaC, "Contrato" + Integer.toString(idSolicitud) + Integer.toString(idCliente), 0, idCliente, idSolicitud, -1, -1);
                    ControladorContratosVenta ccvC = new ControladorContratosVenta();
                    //    response.getWriter().println(cu.crearUsuario(u)); 
                    if (ccvC.crearContratoVenta(cv)) {
                        //  response.sendRedirect("usuario.jsp");
                        response.getWriter().println("contrato venta creado");

                    } else {
                        //  response.sendRedirect("usuario.jsp#menu1");
                        response.getWriter().println("No se se pudo crear un nuevo contrato venta");
                    }
                } catch (Exception e) {

                }
                break;

            case "tablaContratosVenta":
                ControladorContratosVenta ccT = new ControladorContratosVenta();
                System.out.println("estoy en tablaContratosVenta");

                JSONObject myObject = new JSONObject();

                int type = Integer.parseInt(request.getParameter("type"));

                if (type == 0) {
                    //LE PASA EL OBJETO JSON CON TODOS LOS REGISTROS AL DATA DE AJAX
                    myObject.put("data", ccT.getviewContratosVenta());
                    System.out.println(ccT.getviewContratosVenta().length());
                } else if (type == 1) {
                    //LE PASA EL OBJETO JSON CON TODOS LOS REGISTROS AL DATA DE AJAX
                    myObject.put("data", ccT.getviewContratosVenta());
                    System.out.println(ccT.getviewContratosVenta().length());

                }

                //LINEA QUE IMPRIME LOS REGISTROS A LA TABLA
                response.getWriter().println(myObject);

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

// URL Patern: contratosventaservlet
