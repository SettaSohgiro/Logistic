/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Conexion;
import include.variable1;
import include.variable11;
import include.variable10;
import include.variable5;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Lee
 */
public class ModelContrato extends Conexion{
    
          public ArrayList<variable11> tablecontrato(){
    
        ArrayList<variable11> tablecon = new ArrayList<>();
    //    PreparedStatement pst = null ;
        CallableStatement cst = null;
        ResultSet rs = null;
        
        try {
            String sql = "CALL SP_SELECT_TABLECONTRATO(?)";
            cst = getConexion().prepareCall(sql);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.executeQuery();
            rs = (ResultSet) cst.getObject(1);
//            rs = cst.executeQuery();
            while (rs.next()) {
               // System.out.println("get string : "+rs.getString("NOMBRE"));
                tablecon.add(new variable11(rs.getString("fechaventa"),
                                            rs.getString("cliente"),
                                            rs.getString("nombre"),
                                            rs.getString("paterno"),
                                            rs.getString("usernom"),
                                            rs.getString("iduser"),
                                            rs.getString("tipo_com"),
                                            rs.getString("comprobante"),
                                            rs.getString("totalim"),
                                            rs.getString("estado"),
                                            rs.getString("id_venta")
                                             
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
        
        return tablecon;
    }
          
          
  public ArrayList<variable10> llenadoFactura(String val){
     
             ArrayList<variable10> ventas = new ArrayList<>();
    //    PreparedStatement pst = null ;
        CallableStatement cst = null;
        ResultSet rs = null;
    

        
        try {
            String sql = "CALL SP_LLENADO_FACTURA(?,?)";
            cst = getConexion().prepareCall(sql);
            cst.setString(1,val);
       
            cst.registerOutParameter(2, OracleTypes.CURSOR);
            
            cst.executeQuery();
            rs = (ResultSet) cst.getObject(2);
            while (rs.next()) {
            ///    System.out.println("get string : "+rs.getString("NOMBRE_EMPRESA"));
                ventas.add(new variable10(
                        rs.getString("id_venta"), 
                        rs.getString("cliente"),
                        rs.getString("usernom"),
                        rs.getString("fechaventa"),
                        rs.getString("totalim"),
                        rs.getString("impuesto"),
                        rs.getString("nombre"),
                        rs.getString("paterno"),
                        rs.getString("materno"),  
                        rs.getString("nbolf")
                
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
        
        return ventas;
    }                
                  
 public ArrayList<variable5> detalleFactura(String val){
     
             ArrayList<variable5> ventas = new ArrayList<>();
    //    PreparedStatement pst = null ;
        CallableStatement cst = null;
        ResultSet rs = null;
    

        
        try {
            String sql = "CALL SP_LLENADO_FACTURA_LLENADO(?,?)";
            cst = getConexion().prepareCall(sql);
            cst.setString(1,val);
       
            cst.registerOutParameter(2, OracleTypes.CURSOR);
            
            cst.executeQuery();
            rs = (ResultSet) cst.getObject(2);
            while (rs.next()) {
            ///    System.out.println("get string : "+rs.getString("NOMBRE_EMPRESA"));
                ventas.add(new variable5(
                        rs.getString("descripcion"), 
                        rs.getString("cantidad"),
                        rs.getString("precio"),
                        rs.getString("total"),
                        rs.getString("id_venta")
               
                
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
        
        return ventas;
    }      
 
 
    public boolean anularContrato(variable1 v){
CallableStatement cst = null;

        boolean flag = false;

        try {
            String sql = "call SP_CAMBIO_ESTADO_CONTRATO(?)";
            cst = getConexion().prepareCall(sql);

        //    java.sql.Date sqlDate = new java.sql.Date(s.getFechaSolicitud().getTime());
            cst.setString(1, v.getVar1());
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
                    
    
}
