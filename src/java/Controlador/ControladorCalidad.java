/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloCalidad;
import include.Calidad;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author me
 */
public class ControladorCalidad {

    public String getviewCalidad() {
        String htmlcode = "";

        ModeloCalidad modeloc = new ModeloCalidad();

        htmlcode += "<option value=''>--Seleccione--</option>\n";

        for (Calidad c : modeloc.getAllCalidades()) {

            htmlcode += "<option value='" + c.getIdCalidad()+ "'>" + c.getNombre()+ "</option>";
        }

        return htmlcode;
//
//        JSONObject myObject = new JSONObject();
//
//        JSONArray myArray = new JSONArray();
//        ModeloCalidad modelof = new ModeloCalidad();
//        int x = 0;
//        for (Calidad c : modelof.getAllCalidades()) {
//            JSONObject subdata = new JSONObject();
//
//            subdata.put("ID", c.getIdCalidad());
//            subdata.put("NOMBRE_CALIDAD", c.getNombre());
//            //   System.out.println(subdata);
//            myArray.put(subdata);
//
//        }
//        //   System.out.println("myarra : "+ myArray);
//        //return htmlcode;
//        return myArray;
    }
}
