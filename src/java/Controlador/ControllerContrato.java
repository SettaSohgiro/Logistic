/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelContrato;
import include.variable1;
import include.variable11;
import include.variable10;
import include.variable5;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Lee
 */
public class ControllerContrato {
    
    public JSONArray tablecontrato() {
        String val = "";
        JSONObject myObject = new JSONObject();

        JSONArray myArray = new JSONArray();
        ModelContrato modelv = new ModelContrato();
        int x = 0;
        for (variable11 u : modelv.tablecontrato()) {
            JSONObject subdata = new JSONObject();
            //<button class='btn btn-warning btn-xs' onclick='mostrar(20)' <i class='fa fa-eye'></i></button> >
               //     if(u.getVar10() != "7"){val = "<button id='btn_anularContrato'  name='"+u.getVar11()+"'  class='btn btn-danger btn-xs' title='AnularContrato'>X</button> <button id='btn_pdf_descargar' name='"+u.getVar11()+"' class='btn btn-info btn-xs' title='Descargar PDF'><i class='fa fa-file'></i></button>";}
               //     else{val = "<button id='btn_pdf_descargar' name='"+u.getVar11()+"' class='btn btn-info btn-xs' title='Descargar PDF'><i class='fa fa-file'></i></button>";}
                    subdata.put("Opciones","<button id='btn_anularContrato'  name='"+u.getVar11()+"'  class='btn btn-danger btn-xs' title='AnularContrato'>X</button> <button id='btn_pdf_descargar' name='"+u.getVar11()+"' class='btn btn-info btn-xs' title='Descargar PDF'><i class='fa fa-file'></i></button>");
                    subdata.put("fechaventa",u.getVar1());
                    subdata.put("cliente",u.getVar2());
                    subdata.put("nombre",u.getVar3());
                    subdata.put("paterno",u.getVar4());
                    subdata.put("usernom",u.getVar5());
                    subdata.put("iduser",u.getVar6());
                    subdata.put("tipo_com",u.getVar7());
                    subdata.put("comprobante",u.getVar8());
                    subdata.put("totalim",u.getVar9());
                    subdata.put("estado",u.getVar10());
                    subdata.put("id_venta",u.getVar11());

         //   subdata.put("Borrar", "<button id=\""+ u.getRUT() + "\" name=\"eliminar\"   type=\"button\" class=\"btn btn-danger\" data-toggle=\"modal\" data-target=\"#ModalBorrar\">Borrar</button>");
           
          // subdata.put("Borrar", "<button id=\"" + u.getRUT() + "\" name=\"eliminar\" type=\"button\" class=\"btn btn-danger\">Borrar</button>\n");
            //   System.out.println(subdata);
            myArray.put(subdata);

        }
        //   System.out.println("myarra : "+ myArray);
        //return htmlcode;
        return myArray;
    }  
    
    
      public JSONArray llenadoFactura(String val) {

        JSONArray myArray = new JSONArray();
        ModelContrato modelou = new ModelContrato();
        int x = 0;
        for (variable10 ub : modelou.llenadoFactura(val)) {
            JSONObject subdata = new JSONObject();

            subdata.put("id_venta", ub.getVar1());
            subdata.put("cliente", ub.getVar2());
            subdata.put("usernom", ub.getVar3());
            subdata.put("fechaventa", ub.getVar4());
            subdata.put("totalim", ub.getVar5());
            subdata.put("impuesto", ub.getVar6());
            subdata.put("nombre", ub.getVar7());
            subdata.put("paterno", ub.getVar8());
            subdata.put("materno", ub.getVar9());
            subdata.put("numBF", ub.getVar10());
            
            //   System.out.println(subdata);
            myArray.put(subdata);

        }
        //   System.out.println("myarra : "+ myArray);
        //return htmlcode;
        return myArray;
    }
      
      
    public JSONArray detalleFactura(String val) {

        JSONArray myArray = new JSONArray();
        ModelContrato modelou = new ModelContrato();
        int x = 0;
        for (variable5 ub : modelou.detalleFactura(val)) {
            JSONObject subdata = new JSONObject();

            subdata.put("descripcion", ub.getVar1());
            subdata.put("cantidad", ub.getVar2());
            subdata.put("precio", ub.getVar3());
            subdata.put("total", ub.getVar4());
            subdata.put("id_venta", ub.getVar5());

            
            //   System.out.println(subdata);
            myArray.put(subdata);

        }
        //   System.out.println("myarra : "+ myArray);
        //return htmlcode;
        return myArray;
    }  
   
    
    public boolean anularContrato(variable1 v1) {
        ModelContrato modelou = new ModelContrato();
        return modelou.anularContrato(v1);
    }
      
    
}
