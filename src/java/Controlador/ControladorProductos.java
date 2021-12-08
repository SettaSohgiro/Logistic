/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloProductos;
import com.google.gson.Gson;
import include.Producto;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author me
 */
public class ControladorProductos {

    public boolean crearProducto(Producto p) {
        ModeloProductos modelop = new ModeloProductos();
        return modelop.crear_producto(p);
    }
    
    public String getviewProducto(int id){
        ModeloProductos mp = new ModeloProductos();
        Producto p = mp.getProducto(id);
        Gson gson = new Gson();
//        JSONObject jsonProducto = new JSONObject();
        Map <String, Object> map = new HashMap<String, Object>();
        
        map.put("idProducto",p.getId_producto());
        map.put("idNombre",p.getFruta().getIdFruta());
        map.put("idCalidad",p.getCalidad().getIdCalidad());
        map.put("cantidad",p.getCantidadKilos());
        map.put("precio",p.getPrecio());
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaProdString = dateFormat.format(p.getFechaProduccion());
        
        map.put("fechaProd",fechaProdString);

        String prodJsonString = gson.toJson(map);
        
        return prodJsonString;
    }

    public JSONArray getviewProductos(int idProductor) {

        JSONObject myObject = new JSONObject();

        JSONArray myArray = new JSONArray();
        ModeloProductos modelop = new ModeloProductos();
        int x = 0;
        for (Producto p : modelop.getAllProductos(idProductor)) {
            JSONObject subdata = new JSONObject();

            subdata.put("ID", p.getId_producto());
            subdata.put("Nombre", p.getFruta().getNombre());
            subdata.put("Calidad", p.getCalidad().getNombre());            
            subdata.put("Cantidad", p.getCantidadKilos());
            subdata.put("Precio", p.getPrecio());
            subdata.put("FechaProducción", p.getFechaProduccion());
            subdata.put("Actualizar", "<button id=\"" + p.getId_producto() + "\" name=\"actualizar\" type=\"button\" class=\"btn btn-info\">Actualizar</button>\n");
            subdata.put("Borrar", "<button id=\"" + p.getId_producto() + "\" name=\"eliminar\" type=\"button\" class=\"btn btn-danger\">Borrar</button>\n");
            //   System.out.println(subdata);
            myArray.put(subdata);

        }
        //   System.out.println("myarra : "+ myArray);
        //return htmlcode;
        return myArray;
    }

    public boolean updateProducto(Producto p) {
        ModeloProductos mp = new ModeloProductos();
        return mp.update_producto(p);
    }

    public boolean deleteProducto(int id) {
        ModeloProductos mp = new ModeloProductos();
        return mp.deleteProducto(id);
    }
}
