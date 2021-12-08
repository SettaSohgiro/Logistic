/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloCalidad;
import Modelo.ModeloFrutas;
import Modelo.ModeloSolicitudes2;
import com.google.gson.Gson;
import include.Calidad;
import include.Fruta;
import include.Solicitud2;
import include.DetalleSolicitud;
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
public class ControladorSolicitudes2 {

    public boolean crearSolicitud(Solicitud2 s, ArrayList<DetalleSolicitud> detalles) {
        ModeloSolicitudes2 modelop = new ModeloSolicitudes2();
        return modelop.crearSolicitud(s, detalles);
    }

    public String getviewSolicitud(int id) {
        ModeloSolicitudes2 ms = new ModeloSolicitudes2();
        Solicitud2 s = ms.getSolicitud(id);
        Gson gson = new Gson();
//        JSONObject jsonProducto = new JSONObject();
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("idSolicitud", id);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaSolString = dateFormat.format(s.getFechaSolicitud());
        map.put("fechaSoli", fechaSolString);
        map.put("presupuesto", s.getPresupuesto());
        map.put("idVenta", s.getIdVenta());
        map.put("idUsuario", s.getIdVenta());

        String prodJsonString = gson.toJson(map);

        return prodJsonString;
    }

    public JSONArray getviewDetallesSolicitud(int idSolicitud) {
        ModeloSolicitudes2 ms = new ModeloSolicitudes2();

        //OBTENER DATOS DE DETALLE SOLCIITUD
        ArrayList<DetalleSolicitud> detalles = ms.getAllDetallesSolicitudes(idSolicitud);

        JSONObject myObject = new JSONObject();
        JSONArray myArray = new JSONArray();

        for (DetalleSolicitud detalle : detalles) {
            JSONObject subdata = new JSONObject();

            Fruta f = new ModeloFrutas().getFruta(detalle.getIdFruta());
            Calidad c = new ModeloCalidad().getCalidad(detalle.getIdCalidad());
            
            subdata.put("ID", detalle.getIdDetalleSolicitud());
            subdata.put("IdFruta", f.getIdFruta());
            subdata.put("Fruta", f.getNombre());
            subdata.put("IdCalidad", c.getIdCalidad());
            subdata.put("Calidad", c.getNombre());            
            subdata.put("Cantidad", detalle.getCantidad());
            subdata.put("Embalaje", detalle.getEmbalaje());
            
            subdata.put("Presupuesto", detalle.getPresupuesto());
            subdata.put("IdSolicitud", detalle.getIdCalidad());

            myArray.put(subdata);
        }

        return myArray;
    }

    public JSONArray getviewSolicitudes(int option, int cliExtId) {

//        JSONObject myObject = new JSONObject();
        JSONArray myArray = new JSONArray();
        ModeloSolicitudes2 modeloS = new ModeloSolicitudes2();

        for (Solicitud2 s : modeloS.getAllSolicitudes(option, cliExtId)) {
            JSONObject subdata = new JSONObject();

            subdata.put("ID", s.getIdSolicitud());
            subdata.put("FechaSolicitud", s.getFechaSolicitud());

            subdata.put("Presupuesto", s.getPresupuesto());
            subdata.put("Venta", s.getIdVenta());
            subdata.put("Usuario", s.getIdUsuario());
            if (option == 0) {
                subdata.put("Actualizar", "<button id=\"" + s.getIdSolicitud() + "\" name=\"actualizar\" type=\"button\" class=\"btn btn-info\">Actualizar</button>\n");
                subdata.put("Cancelar", "<button id=\"" + s.getIdSolicitud() + "\" name=\"eliminar\" type=\"button\" class=\"btn btn-danger\">Cancelar</button>\n");
            }

            myArray.put(subdata);
        }
        //   System.out.println("myarra : "+ myArray);
        //return htmlcode;
        return myArray;
    }

    public boolean updateSolicitud(Solicitud2 s) {
        ModeloSolicitudes2 mp = new ModeloSolicitudes2();
        return mp.updateSolicitud(s);
    }

    public boolean deleteSolicitud(int id) {
        ModeloSolicitudes2 ms = new ModeloSolicitudes2();
        return ms.deleteSolicitud(id);
    }
}
