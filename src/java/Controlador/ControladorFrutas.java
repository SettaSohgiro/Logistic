/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloCalidad;
import Modelo.ModeloFrutas;
import com.google.gson.Gson;
import include.Calidad;
import include.Fruta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author me
 */
public class ControladorFrutas {

    public String getviewFrutas() {
//        String htmlcode = "";
//
//        ModeloFrutas modelof = new ModeloFrutas();
//
//        htmlcode += "<option value=''>--Seleccione--</option>\n";
//
//        for (Fruta f : modelof.getAllFrutas()) {
//
//            htmlcode += "<option value='" + f.getIdFruta() + "'>" + f.getNombre() + "</option>";
//
//        }
//
//        return htmlcode;
        
        ModeloFrutas mf = new ModeloFrutas();
        ArrayList<Fruta> fs = mf.getAllFrutas();
        Gson gson = new Gson();
//        JSONObject jsonProducto = new JSONObject();
        Map <Integer, Object> frutaMap = new HashMap<Integer, Object>();
        
        for (int i = 0; i < fs.size(); i++) {
            frutaMap.put(i, fs.get(i).getNombre());
        }
        
        ModeloCalidad mc = new ModeloCalidad();
        ArrayList<Calidad> cls = mc.getAllCalidades();
        
        Map <Integer, Object> calidadMap = new HashMap<Integer, Object>();
        
        for (int i = 0; i < cls.size(); i++) {
            calidadMap.put(i, cls.get(i).getNombre());
        }
        
        Map <String, Object> map = new HashMap<String, Object>();

        map.put("frutas", frutaMap);
        map.put("calidades", calidadMap);
        
        String prodJsonString = gson.toJson(map);
        
        return prodJsonString;
    }
}
