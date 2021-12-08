/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloCalidad;
import Modelo.ModeloContratosVenta;
import Modelo.ModeloFrutas;
import com.google.gson.Gson;
import include.Calidad;
import include.Fruta;
import include.ContratoVenta;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author me
 */
public class ControladorContratosVenta {
        public boolean crearContratoVenta(ContratoVenta cv) {
            ModeloContratosVenta modelocv = new ModeloContratosVenta();
        return modelocv.crearContratoVenta(cv);
    }

//    public String getviewSolicitud(int id) {
//        ModeloSolicitudes ms = new ModeloSolicitudes();
//        Solicitud s = ms.getSolicitud(id);
//        Gson gson = new Gson();
////        JSONObject jsonProducto = new JSONObject();
//        Map<String, Object> map = new HashMap<String, Object>();
//
//        map.put("idSolicitud", id);
//
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String fechaSolString = dateFormat.format(s.getFechaSolicitud());
//        map.put("fechaSoli", fechaSolString);
//
//        map.put("idFruta", s.getIdFruta());
//        map.put("idCalidad", s.getIdCalidad());
//        map.put("cantidad", s.getCantidad());
//        map.put("presupuesto", s.getPresupuesto());
//        map.put("embalaje", s.getEmbalaje());
//
//        String prodJsonString = gson.toJson(map);
//
//        return prodJsonString;
//    }
//
    public JSONArray getviewContratosVenta() {

        JSONObject myObject = new JSONObject();

        JSONArray myArray = new JSONArray();
        ModeloContratosVenta modeloCV = new ModeloContratosVenta();
        int x = 0;

        for (ContratoVenta cv : modeloCV.getAllContratosVenta(0, -1)) {
            JSONObject subdata = new JSONObject();

            subdata.put("ID", cv.getIdContratoVenta());
            subdata.put("FechaInicio", cv.getFechaInicio());
            subdata.put("FechaTermino", cv.getFechaTermino());
            subdata.put("NombreContrato", cv.getNombreContrato());
            subdata.put("Estado", cv.getIdEstado());
            subdata.put("Cliente", cv.getIdCliente());
            subdata.put("Solicitud", cv.getIdSoliciutd());
            subdata.put("Transporte", cv.getIdTransporte());
            subdata.put("ResumenVenta", cv.getIdResumenVenta());
            subdata.put("ActualizarContrato", "<button id=\"" + cv.getIdContratoVenta()+ "\" name=\"actualizar\" type=\"button\" class=\"btn btn-info\">Actualizar</button>\n");
//            subdata.put("Borrar", "<button id=\"" + cv.getIdContratoVenta()+ "\" name=\"eliminar\" type=\"button\" class=\"btn btn-danger\">Borrar</button>\n");
            myArray.put(subdata);

        }
        //   System.out.println("myarra : "+ myArray);
        //return htmlcode;
        return myArray;
    }
//
//    public JSONArray getviewSolicitudesAdmin() {
//
//        JSONObject myObject = new JSONObject();
//
//        JSONArray myArray = new JSONArray();
//        ModeloSolicitudes modeloS = new ModeloSolicitudes();
//        int x = 0;
//
//        for (Solicitud s : modeloS.getAllSolicitudes()) {
//            JSONObject subdata = new JSONObject();
//
//            subdata.put("ID", s.getIdSolicitud());
//            subdata.put("FechaSolicitud", s.getFechaSolicitud());
//
//            Fruta f = new ModeloFrutas().getFruta(s.getIdFruta());
//            Calidad c = new ModeloCalidad().getCalidad(s.getIdCalidad());
//
//            subdata.put("Fruta", f.getNombre());
//            subdata.put("Calidad", c.getNombre());
//            subdata.put("Cantidad", s.getCantidad());
//            subdata.put("Presupuesto", s.getPresupuesto());
//            subdata.put("Embalaje", s.getEmbalaje());
//            subdata.put("Publicar_Contrato", "<button id=\"" + s.getIdSolicitud() + "\" name=\"publicarContrato\" type=\"button\" class=\"btn btn-info\">Publicar Contrato</button>\n");
//            
//            myArray.put(subdata);
//
//        }
//        //   System.out.println("myarra : "+ myArray);
//        //return htmlcode;
//        return myArray;
//    }
//
//    public boolean updateSolicitud(Solicitud s) {
//        ModeloSolicitudes mp = new ModeloSolicitudes();
//        return mp.updateSolicitud(s);
//    }
//
//    public boolean deleteSolicitud(int id) {
//        ModeloSolicitudes ms = new ModeloSolicitudes();
//        return ms.deleteSolicitud(id);
//    }
}
