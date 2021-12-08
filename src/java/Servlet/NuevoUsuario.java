/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.Consultas;
import Controlador.ControladorUsuarios;
import Modelo.ModeloUsuarios;
import include.Usuario;
import include.Usuario;
import include.variable28;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.*;

/**
 *
 * @author Lee
 */
public class NuevoUsuario extends HttpServlet {

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
            case "crearUsuario":
                
                String	ID = request.getParameter("id_idup"); 
                String	CORREO_EMPRESA = request.getParameter("​id_corem");
                String	NOMBRE = request.getParameter("id_nombre");
                String	PATERNO	= request.getParameter("id_apaterno");
                String	MATERNO	= request.getParameter("id_amaterno");
                String	DIRECCION	= request.getParameter("id_direccion");
                String	TELEFONO	= request.getParameter("id_telefono");
                String	TELEFONO2	= request.getParameter("id_telefono2");
                String	MAIL	= request.getParameter("id_correo");
                String	USUARIO	= request.getParameter("id_usuario");
                String	PASS	= request.getParameter("id_pass");
                String	COMUNA	= request.getParameter("id_comuna");
                String	REGION	= request.getParameter("id_region");
                String	PROVINCIA = request.getParameter("id_provincia");
                String	RUT	= request.getParameter("id_rut");
                String	ESTADO	= "1";
                String	ROL	= request.getParameter("sl_rol_user");
                String	NOMBRE_EMPRESA	= request.getParameter("id_nombre_Empre");
                String	RUT_EMPRESA = request.getParameter("id_rut_empre");
                String	PAIS_EMPRESA = request.getParameter("id_pais_empre");
                String	DIRECCION_EMPRESA = request.getParameter("id_direccion_empre");
                String	TELEFONO_EMPRESA = request.getParameter("id_teleemp");
                String	id_patente = request.getParameter("id_patente");
                String	id_vehiculo = request.getParameter("id_vehiculo");
                String	id_cap_m3 = request.getParameter("id_cap_m3");
                String	tonelada = request.getParameter("​id_capa_tn");
                String	id_nombre_condu = request.getParameter("id_nombre_condu");
                String	id_tipo_licencia = request.getParameter("id_tipo_licencia");
                

                
                System.out.println("ID : " +ID);
                // Consultas co = new Consultas();
                variable28 u = new variable28(NOMBRE,PATERNO,MATERNO,DIRECCION,TELEFONO,TELEFONO2,MAIL,USUARIO,PASS,COMUNA,REGION,PROVINCIA,RUT,ESTADO,ROL,NOMBRE_EMPRESA,RUT_EMPRESA,PAIS_EMPRESA,DIRECCION_EMPRESA,TELEFONO_EMPRESA,CORREO_EMPRESA  , id_patente ,  id_vehiculo , id_cap_m3 , tonelada , id_nombre_condu , id_tipo_licencia , ID  );
                ControladorUsuarios cu = new ControladorUsuarios();
                System.out.println("crear : "+u);
                if (cu.crearUsuario(u)) {
                    //  response.sendRedirect("usuario.jsp");
                    response.getWriter().println("usuario creado");

                } else {
                    //  response.sendRedirect("usuario.jsp#menu1");
                    response.getWriter().println("No se se pudo crear un nuevo usuario");

                }

                break;

            case "tablaUsuario":
                ControladorUsuarios cu2 = new ControladorUsuarios();
                System.out.println("estoy en tablausuarios");

                JSONObject myObject = new JSONObject();

                myObject.put("data", cu2.getviewUsuarios());

                response.getWriter().println(myObject);

                break;

            case "updateUsuario":
                //     ControladorUsuarios cu2 =new ControladorUsuarios();
                System.out.println("estoy en updateUsuario");            

                

                String	IDU = request.getParameter("id_idup");
                String	NOMBREU = request.getParameter("id_nom_up");
                String	MATERNOU = request.getParameter("id_amat_up");
                String	PATERNOU = request.getParameter("id_apat_up");
                
                String	DIRECCIONU	= request.getParameter("id_dir_up");
                String	TELEFONOU	= request.getParameter("id_tel_up");
                String	TELEFONO2U	= request.getParameter("id_tel2_up");
                String	MAILU	= request.getParameter("id_corre_up");
                String	USUARIOU	= "";
                String	PASSU	= "";
                String	COMUNAU	= request.getParameter("id_comu_up");
             
                String	REGIONU	= request.getParameter("​id_regup");
                String	PROVINCIAU = request.getParameter("id_prov_up");
                String	RUTU	= request.getParameter("​id_rutup");
                String	ESTADOU	= "1";
                String	ROLU	= "";
                String	NOMBRE_EMPRESAU	= request.getParameter("id_nomEmp_up");
                
                String	RUT_EMPRESAU = request.getParameter("​id_rueup");
                String	PAIS_EMPRESAU = request.getParameter("id_paisemp_up");
                String	DIRECCION_EMPRESAU = request.getParameter("id_diremp_up");
                String	TELEFONO_EMPRESAU = request.getParameter("​id_telemup");
                String	CORREO_EMPRESAU = request.getParameter("id_coremup");
                
                    System.out.println("IDU : " +IDU);
                //    response.getWriter().println(myObject);
                Usuario up = new Usuario(IDU,NOMBREU,PATERNOU,MATERNOU,DIRECCIONU,TELEFONOU,TELEFONO2U,MAILU,USUARIOU,PASSU,COMUNAU,REGIONU,PROVINCIAU,RUTU,ESTADOU,ROLU,NOMBRE_EMPRESAU,RUT_EMPRESAU,PAIS_EMPRESAU,DIRECCION_EMPRESAU,TELEFONO_EMPRESAU,CORREO_EMPRESAU);
                ControladorUsuarios cuu = new ControladorUsuarios();
                //    response.getWriter().println(cu.crearUsuario(u)); 
                if (cuu.updateUsuario(up)) {
                    //  response.sendRedirect("usuario.jsp");
                    response.getWriter().println("usuario Modificado");

                } else {
                    //  response.sendRedirect("usuario.jsp#menu1");
                    response.getWriter().println("No se pudo modificar el usuario");

                }

                break;

            case "deleteUsuario":
                //     ControladorUsuarios cu2 =new ControladorUsuarios();
                System.out.println("estoy en updateUsuario");

                String rutd = request.getParameter("id_rut_d");

                //    response.getWriter().println(myObject);
                //    Usuario ud = new Usuario(rutd);
                ControladorUsuarios cd = new ControladorUsuarios();
                //    response.getWriter().println(cu.crearUsuario(u)); 
                if (cd.deleteUsuario(rutd)) {
                    //  response.sendRedirect("usuario.jsp");
                    response.getWriter().println("usuario eliminado");

                } else {
                    //  response.sendRedirect("usuario.jsp#menu1");
                    response.getWriter().println("No se pudo eliminar el usuario");

                }

                break;

            case "selectRol":
                ControladorUsuarios cus = new ControladorUsuarios();
                System.out.println("estoy en selectRol");

                JSONObject objectRol = new JSONObject();

                //    objectRol.put("data", cus.comboRol());
                response.getWriter().println(cus.comboRol());
                break;

            case "selectPais":
                ControladorUsuarios cup = new ControladorUsuarios();
                System.out.println("estoy en selectRol");

                JSONObject objectPais = new JSONObject();

                //    objectRol.put("data", cus.comboRol());
                response.getWriter().println(cup.comboPais());
                break;

                
            case "selectRegion":
                ControladorUsuarios cur = new ControladorUsuarios();
                System.out.println("estoy en selectregion");

                JSONObject objectReg = new JSONObject();

                //    objectRol.put("data", cus.comboRol());
                response.getWriter().println(cur.comboRegion());
                break;

            case "selectProv":
                ControladorUsuarios cupr = new ControladorUsuarios();
                System.out.println("estoy en selectregion");

                JSONObject objectPro = new JSONObject();

                //    objectRol.put("data", cus.comboRol());
                response.getWriter().println(cupr.comboProv());
                break;
                
            case "selectComuna":
                ControladorUsuarios cucom = new ControladorUsuarios();
                System.out.println("estoy en selectregion");

                JSONObject objectCom = new JSONObject();

                //    objectRol.put("data", cus.comboRol());
                response.getWriter().println(cucom.comboCom());
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
