/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloReportes;
import include.Reporte;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author me
 */
public class ControladorReportes {

    public JSONArray getviewReportes(String anio) {

        JSONObject myObject = new JSONObject();

        JSONArray myArray = new JSONArray();
        ModeloReportes modeloR = new ModeloReportes();

        for (Reporte r : modeloR.getAllReportes(anio)) {
            JSONObject subdata = new JSONObject();

            subdata.put("fecha", r.getFecha());
            subdata.put("totalVentas", r.getTotalVentas());

            subdata.put("ventaBruto", r.getTotalVentaBruto());
            subdata.put("costoTransporte", r.getTotalCostoTransporte());
            subdata.put("comision", r.getTotalComision());
            subdata.put("perididaFruta", r.getTotalPerdidaFruta());
            subdata.put("liquido", r.getTotalLiquido());
//            subdata.put("Actualizar", "<button id=\"" + r.getIdSolicitud() + "\" name=\"actualizar\" type=\"button\" class=\"btn btn-info\">Actualizar</button>\n");
//            subdata.put("Borrar", "<button id=\"" + r.getIdSolicitud() + "\" name=\"eliminar\" type=\"button\" class=\"btn btn-danger\">Borrar</button>\n");
            //   System.out.println(subdata);
            myArray.put(subdata);

        }
        //   System.out.println("myarra : "+ myArray);
        //return htmlcode;
        return myArray;
    }
}
