/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloUsuarios;
import include.Usuario;
import include.Combo2;
import include.ComboCom;
import include.ComboP;
import include.ComboPais;
import include.ComboRegion;
import include.variable28;
import org.json.*;

/**
 *
 * @author Lee
 */
public class ControladorUsuarios {

    public boolean crearUsuario(variable28 u) {
        ModeloUsuarios modelou = new ModeloUsuarios();
        return modelou.crear_usuario(u);
    }

    public boolean updateUsuario(Usuario u) {
        ModeloUsuarios modeloup = new ModeloUsuarios();
        return modeloup.update_usuario(u);
    }

    public boolean deleteUsuario(String rut) {
        System.out.println("deleteusuario controlador ususario : " + rut);
        ModeloUsuarios modeloup = new ModeloUsuarios();
        return modeloup.delete_usuario(rut);
    }

    public JSONArray getviewUsuarios() {

        JSONObject myObject = new JSONObject();

        JSONArray myArray = new JSONArray();
        ModeloUsuarios modelou = new ModeloUsuarios();
        int x = 0;
        for (Usuario u : modelou.getAllUsuarios()) {
            JSONObject subdata = new JSONObject();
            subdata.put("ID", u.getID());
            subdata.put("NOMBRE", u.getNOMBRE());
            subdata.put("PATERNO", u.getPATERNO());
            subdata.put("MATERNO", u.getMATERNO());
            subdata.put("DIRECCION", u.getDIRECCION());
            subdata.put("TELEFONO", u.getTELEFONO());
            subdata.put("TELEFONO2", u.getTELEFONO2());
            subdata.put("MAIL", u.getMAIL());
            subdata.put("USUARIO", u.getUSUARIO());
            subdata.put("PASS", u.getPASS());
            subdata.put("COMUNA", u.getCOMUNA());
            subdata.put("REGION", u.getREGION());
            subdata.put("PROVINCIA", u.getPROVINCIA());
            subdata.put("RUT", u.getRUT());
            subdata.put("ESTADO", u.getESTADO());
            subdata.put("ROL", u.getROL());
            subdata.put("NOMBRE_EMPRESA", u.getNOMBRE_EMPRESA());
            subdata.put("RUT_EMPRESA", u.getRUT_EMPRESA());
            subdata.put("PAIS_EMPRESA", u.getPAIS_EMPRESA());
            subdata.put("DIRECCION_EMPRESA", u.getDIRECCION_EMPRESA());
            subdata.put("TELEFONO_EMPRESA", u.getTELEFONO_EMPRESA());
            subdata.put("CORREO_EMPRESA", u.getCORREO_EMPRESA());
           subdata.put("Actualizar", "<button id=\""+ u.getRUT() + "\"  name=\"actualizar\"  type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#ModalActualizar\">Actualizar</button>");
           subdata.put("Borrar", "<button id=\""+ u.getRUT() + "\" name=\"eliminar\"   type=\"button\" class=\"btn btn-danger\" data-toggle=\"modal\" data-target=\"#ModalBorrar\">Borrar</button>");
           
          // subdata.put("Borrar", "<button id=\"" + u.getRUT() + "\" name=\"eliminar\" type=\"button\" class=\"btn btn-danger\">Borrar</button>\n");
            //   System.out.println(subdata);
            myArray.put(subdata);

        }
        //   System.out.println("myarra : "+ myArray);
        //return htmlcode;
        return myArray;
    }

    public JSONArray comboRol() {

        JSONArray myArray = new JSONArray();
        ModeloUsuarios modelou = new ModeloUsuarios();
        int x = 0;
        for (Combo2 ub : modelou.getComboRol()) {
            JSONObject subdata = new JSONObject();

            subdata.put("ID", ub.getID());
            subdata.put("ROL", ub.getDato1());
            //   System.out.println(subdata);
            myArray.put(subdata);

        }
        //   System.out.println("myarra : "+ myArray);
        //return htmlcode;
        return myArray;
    }
    
    public JSONArray comboPais() {

        JSONArray myArray = new JSONArray();
        ModeloUsuarios modelou = new ModeloUsuarios();
        int x = 0;
        for (ComboPais ub : modelou.getComboPais()) {
            JSONObject subdata = new JSONObject();

            subdata.put("ID_PAIS", ub.getID_PAIS());
            subdata.put("PAIS", ub.getPAIS());
            //   System.out.println(subdata);
            myArray.put(subdata);

        }
        //   System.out.println("myarra : "+ myArray);
        //return htmlcode;
        return myArray;
    }    

    public JSONArray comboRegion() {

        JSONArray myArray = new JSONArray();
        ModeloUsuarios modelou = new ModeloUsuarios();
        int x = 0;
        for (ComboRegion ur : modelou.getComboRegion()) {
            JSONObject subdata = new JSONObject();

            subdata.put("ID_REGION", ur.getID_REGION());
            subdata.put("REGION", ur.getREGION());
           //    System.out.println(subdata);
            myArray.put(subdata);

        }
        //   System.out.println("myarra : "+ myArray);
        //return htmlcode;
        return myArray;
    } 
    
        public JSONArray comboProv() {

        JSONArray myArray = new JSONArray();
        ModeloUsuarios modelou = new ModeloUsuarios();
        int x = 0;
        for (ComboP upr : modelou.getComboProv()) {
            JSONObject subdata = new JSONObject();

            subdata.put("ID_PROVINCIA", upr.getId_prov());
            subdata.put("PROVINCIA", upr.getProvincia());
            //   System.out.println(subdata);
            myArray.put(subdata);

        }
        //   System.out.println("myarra : "+ myArray);
        //return htmlcode;
        return myArray;
    } 
        
        
        public JSONArray comboCom() {

        JSONArray myArray = new JSONArray();
        ModeloUsuarios modelou = new ModeloUsuarios();
        int x = 0;
        for (ComboCom urc : modelou.getComboCom()) {
            JSONObject subdata = new JSONObject();

            subdata.put("ID_COMUNA", urc.getId_comuna());
            subdata.put("COMUNA", urc.getComuna());
           //    System.out.println(subdata);
            myArray.put(subdata);

        }
        //   System.out.println("myarra : "+ myArray);
        //return htmlcode;
        return myArray;
    }     

    
}
