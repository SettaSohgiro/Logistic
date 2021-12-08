/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloSeguros;
import include.Seguro;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author me
 */
public class ControladorSeguros {

    public boolean crearSeguro(Seguro s) {
        ModeloSeguros modelos = new ModeloSeguros();
        return modelos.crearSeguro(s);
    }

    public JSONArray getviewSeguros() {

        JSONObject myObject = new JSONObject();

        JSONArray myArray = new JSONArray();
        ModeloSeguros modelop = new ModeloSeguros();

        for (Seguro s : modelop.getAllSeguros()) {
            JSONObject subdata = new JSONObject();

            subdata.put("ID", s.getIdSeguro());
            subdata.put("Nombre", s.getNombre());
            subdata.put("Costo", s.getCosto());
            subdata.put("Estado", s.getEstado());
            subdata.put("IdEmbarque", s.getIdEmbarque());
//            subdata.put("Actualizar", "<button id=\"" + s.getId_producto() + "\" name=\"actualizar\" type=\"button\" class=\"btn btn-info\">Actualizar</button>\n");
            subdata.put("Eliminar", "<button id=\"" + s.getIdSeguro() + "\" name=\"eliminarSeguro\" type=\"button\" class=\"btn btn-danger\">Eliminar</button>\n");
            //   System.out.println(subdata);
            myArray.put(subdata);

        }
        //   System.out.println("myarra : "+ myArray);
        //return htmlcode;
        return myArray;
    }

    public boolean deleteSeguro(int id) {
        ModeloSeguros ms = new ModeloSeguros();
        return ms.deleteSeguro(id);
    }
}
