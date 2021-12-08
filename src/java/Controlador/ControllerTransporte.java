/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelTransporte;
import include.variable10;
import include.variable6;
import include.variable7;
import include.variable8;
import include.variable9;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Lee
 */
public class ControllerTransporte {
    
    
        public JSONArray tabletransporte() {

        JSONObject myObject = new JSONObject();

        JSONArray myArray = new JSONArray();
        ModelTransporte modelv = new ModelTransporte();
        int x = 0;
        for (variable10 u : modelv.tabletransporte()) {
            JSONObject subdata = new JSONObject();
                    subdata.put("Opciones","<button id='btn_apdate_T'  name=''  class='btn btn-info btn-xs  ' title='Actualizar Vehiculo'>A</button> ");
                    subdata.put("ID",u.getVar1());
                    subdata.put("patente",u.getVar2());
                    subdata.put("tipo_vehiculo",u.getVar3());
                    subdata.put("capacidad_m3",u.getVar4());
                    subdata.put("capacidad_tonelada",u.getVar5());
                    subdata.put("nombre_conductor",u.getVar6());
                    subdata.put("tipo_licencia",u.getVar7());
                    subdata.put("region",u.getVar8());
                    subdata.put("direccion",u.getVar9());
                    subdata.put("estado",u.getVar10());
            

            //   System.out.println(subdata);
            myArray.put(subdata);

        }
        //   System.out.println("myarra : "+ myArray);
        //return htmlcode;
        return myArray;
    
        }
        
     public boolean updateTransporte(variable7 v) {
        ModelTransporte modelou = new ModelTransporte();
        return modelou.updateTransporte(v);
    }  
        
        
        public JSONArray tableseleccion() {

        JSONObject myObject = new JSONObject();

        JSONArray myArray = new JSONArray();
        ModelTransporte modelv = new ModelTransporte();
        int x = 0;
        for (variable9 u : modelv.tableseleccion()) {
            JSONObject subdata = new JSONObject();
                    subdata.put("Opciones","<button id='btn_apdate_T'  name=''  class='btn btn-info btn-xs  ' title='Actualizar Vehiculo'>A</button> ");
                    subdata.put("id",u.getVar1());
                    subdata.put("nombre_empresa",u.getVar2());
                    subdata.put("rut_empresa",u.getVar3());
                    subdata.put("direccion_empresa",u.getVar4());
                    subdata.put("region",u.getVar5());
                    subdata.put("total_kg",u.getVar6());
                    subdata.put("nbolf",u.getVar7());
                    subdata.put("tipo_com",u.getVar8());
                    subdata.put("rol",u.getVar9());
 
            

             System.out.println(subdata);
            myArray.put(subdata);

        }
        //   System.out.println("myarra : "+ myArray);
        //return htmlcode;
        return myArray;
    }


        
        
        
}
