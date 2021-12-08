/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.ModelVenta;
import include.ComboVenta;
import include.Venta;
import include.variable12;
import include.variable16;
import include.variable6;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Lee
 */
public class ControllerVenta {
    
    
        public JSONArray tableStock() {

        JSONObject myObject = new JSONObject();

        JSONArray myArray = new JSONArray();
        ModelVenta modelv = new ModelVenta();
        int x = 0;
        for (Venta u : modelv.tablestock()) {
            JSONObject subdata = new JSONObject();
            subdata.put("SELECCIONAR" , "<span class=\"input-group-addon\"><button  id=\"btnPlay_" + u.getID_PRODUCTO() + "\" value=\"" + u.getID_PRODUCTO() + "\" type=\"button\" class=\"btn btn-xs stock_fruta btn-success\"><i class=\"fa fa-play\"></i></button></span> ");
            subdata.put("ID",u.getID_PRODUCTO());
            subdata.put("ID_FRUTA",u.getID_FRUTA());
            subdata.put("NOMBRE",u.getNOMBRE());
            subdata.put("STOCK",u.getSTOCK());
            subdata.put("ID_CALIDAD",u.getID_CALIDAD());
            subdata.put("CALIDAD",u.getCALIDAD());
            subdata.put("PRECIO",u.getPRECIO());
            subdata.put("FECHA_CO",u.getFECHA_CO());
            subdata.put("VENTA_KILOS",u.getVENTA_KILOS());
            subdata.put("ESTADO",u.getESTADO());
         //   subdata.put("Borrar", "<button id=\""+ u.getRUT() + "\" name=\"eliminar\"   type=\"button\" class=\"btn btn-danger\" data-toggle=\"modal\" data-target=\"#ModalBorrar\">Borrar</button>");
           
          // subdata.put("Borrar", "<button id=\"" + u.getRUT() + "\" name=\"eliminar\" type=\"button\" class=\"btn btn-danger\">Borrar</button>\n");
            //   System.out.println(subdata);
            myArray.put(subdata);

        }
        //   System.out.println("myarra : "+ myArray);
        //return htmlcode;
        return myArray;
    }
        
        public JSONArray comboClientes() {

        JSONArray myArray = new JSONArray();
        ModelVenta modelou = new ModelVenta();
        int x = 0;
        for (ComboVenta ub : modelou.comboClientes()) {
            JSONObject subdata = new JSONObject();

            subdata.put("ID", ub.getID());
            subdata.put("Nombre", ub.getNombre());
            //   System.out.println(subdata);
            myArray.put(subdata);

        }
        //   System.out.println("myarra : "+ myArray);
        //return htmlcode;
        return myArray;
    }   
        
    public JSONArray comboComprobante() {

        JSONArray myArray = new JSONArray();
        ModelVenta modelou = new ModelVenta();
        int x = 0;
        for (ComboVenta ub : modelou.comboComprobante()) {
            JSONObject subdata = new JSONObject();

            subdata.put("ID", ub.getID());
            subdata.put("Comprobante", ub.getNombre());
            //   System.out.println(subdata);
            myArray.put(subdata);

        }
        //   System.out.println("myarra : "+ myArray);
        //return htmlcode;
        return myArray;
    } 
    
    public JSONArray Com_boleta_fact(String val) {

        JSONArray myArray = new JSONArray();
        ModelVenta modelou = new ModelVenta();
        int x = 0;
        for (ComboVenta ub : modelou.Com_boleta_fact(val)) {
            JSONObject subdata = new JSONObject();

            subdata.put("ID", ub.getID());
            subdata.put("Comprobante", ub.getNombre());
            //   System.out.println(subdata);
            myArray.put(subdata);

        }
        //   System.out.println("myarra : "+ myArray);
        //return htmlcode;
        return myArray;
    } 
     public boolean insertVenta(variable12 v) {
        ModelVenta modelou = new ModelVenta();
        return modelou.insertVenta(v);
    }
     
     
       public boolean insertVentaDetalle(variable6 v6) {
        ModelVenta modelou = new ModelVenta();
        return modelou.insertVentaDetalle(v6);
    }
       
       
    public JSONArray tablaUsuario() {

        JSONObject myObject = new JSONObject();

        JSONArray myArray = new JSONArray();
        ModelVenta modelv = new ModelVenta();
        int x = 0;
        for (variable16 u : modelv.tablaUsuario()) {
            JSONObject subdata = new JSONObject();
            
                    subdata.put("usernom",u.getVar1());
                    subdata.put("iduser",u.getVar2());
                    subdata.put("nbolf",u.getVar3());
                    subdata.put("tipo_com",u.getVar4());
                    subdata.put("comprobante",u.getVar5());
                    subdata.put("impuesto",u.getVar6());
                    subdata.put("totalim",u.getVar7());
                    subdata.put("pago",u.getVar8());
                    subdata.put("vuelto",u.getVar9());
                    subdata.put("cod_trans",u.getVar10());
                    subdata.put("cliente",u.getVar11());
                    subdata.put("formapago",u.getVar12());
                    subdata.put("estado",u.getVar13());
                    subdata.put("estadopago",u.getVar14());
                    subdata.put("id_venta",u.getVar15());
                    subdata.put("fechaventa",u.getVar16());
         //   subdata.put("Borrar", "<button id=\""+ u.getRUT() + "\" name=\"eliminar\"   type=\"button\" class=\"btn btn-danger\" data-toggle=\"modal\" data-target=\"#ModalBorrar\">Borrar</button>");
           
          // subdata.put("Borrar", "<button id=\"" + u.getRUT() + "\" name=\"eliminar\" type=\"button\" class=\"btn btn-danger\">Borrar</button>\n");
            //   System.out.println(subdata);
            myArray.put(subdata);

        }
        //   System.out.println("myarra : "+ myArray);
        //return htmlcode;
        return myArray;
    }           
               
               
}
