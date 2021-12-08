/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Conexion;
import include.variable10;
import include.variable6;
import include.variable7;
import include.variable8;
import include.variable9;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Lee
 */
public class ModelTransporte extends Conexion{
    
    
       public ArrayList<variable10> tabletransporte(){
    
        ArrayList<variable10> transporte = new ArrayList<>();
    //    PreparedStatement pst = null ;
        CallableStatement cst = null;
        ResultSet rs = null;
        
        try {
            String sql = "CALL SP_LLENADO_TABLE_TRANSPORTE(?)";
            cst = getConexion().prepareCall(sql);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.executeQuery();
            rs = (ResultSet) cst.getObject(1);
//            rs = cst.executeQuery();
            while (rs.next()) {
               System.out.println("get string : "+rs.getString("tipo_vehiculo"));
                transporte.add(new variable10(   
                                            rs.getString("id"),
                                            rs.getString("patente"),
                                            rs.getString("tipo_vehiculo"),
                                            rs.getString("capacidad_m3"),
                                            rs.getString("capacidad_tonelada"),
                                            rs.getString("nombre_conductor"),
                                            rs.getString("tipo_licencia"),
                                            rs.getString("region"),
                                            rs.getString("direccion"),
                                            rs.getString("estado")));
                
            }
            
        } catch (Exception e) {
            System.err.println("error " + e);
        }finally{
            try {
                if(getConexion() != null) {getConexion().close();}
                if(cst != null){ cst.close();}
            } catch (Exception e) {
                System.err.println("error " + e);
            }
        }
           System.out.println("table : "+transporte);
        return transporte;
    }  
       
       
        public boolean updateTransporte(variable7 v){
        CallableStatement cst = null;

        boolean flag = false;

        try {
            String sql = "call SP_UPDATE_TRANSPORTE(?,?,?,?,?,?,?)";
            cst = getConexion().prepareCall(sql);

        //    java.sql.Date sqlDate = new java.sql.Date(s.getFechaSolicitud().getTime());
            cst.setString(1, v.getVar1());
            cst.setString(2, v.getVar2());
            cst.setString(3, v.getVar3());
            cst.setString(4, v.getVar4());
            cst.setString(5, v.getVar5());
            cst.setString(6, v.getVar6());
            cst.setString(7, v.getVar7());

//            pst.executeQuery();
            int i = cst.executeUpdate();
            System.out.println(i);

            if (i == 1) {
                flag = true;
            }

            flag = true;

        } catch (Exception e) {
            System.err.println("Error: " + e);
            e.printStackTrace();
        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (cst != null) {
                    cst.close();
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
       System.out.println("flag : "+flag);
        return flag;
    }
        
        
       public ArrayList<variable9> tableseleccion(){
    
        ArrayList<variable9> transportes = new ArrayList<>();
    //    PreparedStatement pst = null ;
        CallableStatement cst = null;
        ResultSet rs = null;
        
        try {
            String sql = "CALL SP_SELECT_TABLA_SELECCION(?)";
            cst = getConexion().prepareCall(sql);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.executeQuery();
            rs = (ResultSet) cst.getObject(1);
//            rs = cst.executeQuery();
            while (rs.next()) {
               System.out.println("get string : "+rs.getString("nombre_empresa"));
                transportes.add(new variable9(   
                                            rs.getString("id"),
                                            rs.getString("nombre_empresa"),
                                            rs.getString("rut_empresa"),
                                            rs.getString("direccion_empresa"),
                                            rs.getString("region"),
                                            rs.getString("total_kg"),
                                            rs.getString("nbolf"),
                                            rs.getString("tipo_com"),
                                            rs.getString("rol")
                ));
                
            }
            
        } catch (Exception e) {
            System.err.println("error " + e);
        }finally{
            try {
                if(getConexion() != null) {getConexion().close();}
                if(cst != null){ cst.close();}
            } catch (Exception e) {
                System.err.println("error " + e);
            }
        }
           System.out.println("table : "+transportes);
        return transportes;
        
    }          
        
        
        
    
}
