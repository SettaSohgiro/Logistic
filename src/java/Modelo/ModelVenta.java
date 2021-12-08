/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import Controlador.Conexion;
import include.ComboVenta;
import include.Venta;
import include.variable12;
import include.variable16;
import include.variable6;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Lee
 */
public class ModelVenta extends Conexion{
    
    public ArrayList<Venta> tablestock(){
    
        ArrayList<Venta> ventas = new ArrayList<>();
    //    PreparedStatement pst = null ;
        CallableStatement cst = null;
        ResultSet rs = null;
        
        try {
            String sql = "CALL selectStockSP(?)";
            cst = getConexion().prepareCall(sql);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.executeQuery();
            rs = (ResultSet) cst.getObject(1);
//            rs = cst.executeQuery();
            while (rs.next()) {
               // System.out.println("get string : "+rs.getString("NOMBRE"));
                ventas.add(new Venta(   rs.getString("ID_PRODUCTO"),
                                            rs.getString("ID_FRUTA"),
                                            rs.getString("NOMBRE"),
                                            rs.getString("STOCK"),
                                            rs.getString("ID_CALIDAD"),
                                            rs.getString("CALIDAD"),
                                            rs.getString("PRECIO"),
                                            rs.getString("FECHA_CO"),
                                            rs.getString("VENTA_KILOS"),
                                            rs.getString("ESTADO")  ));
                
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

 public ArrayList<ComboVenta> comboClientes(){
     
             ArrayList<ComboVenta> ventas = new ArrayList<>();
    //    PreparedStatement pst = null ;
        CallableStatement cst = null;
        ResultSet rs = null;
    

        
        try {
            String sql = "CALL SP_COMBO_VENTA(?,?,?)";
            cst = getConexion().prepareCall(sql);
            cst.setInt(1,3);
            cst.setInt(2,4);
            cst.registerOutParameter(3, OracleTypes.CURSOR);
            
            cst.executeQuery();
            rs = (ResultSet) cst.getObject(3);
            while (rs.next()) {
            ///    System.out.println("get string : "+rs.getString("NOMBRE_EMPRESA"));
                ventas.add(new ComboVenta(rs.getInt("id"), rs.getString("nombre_empresa")));
                
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
 
  public ArrayList<ComboVenta> comboComprobante(){
     
             ArrayList<ComboVenta> comprobante = new ArrayList<>();
    //    PreparedStatement pst = null ;
        CallableStatement cst = null;
        ResultSet rs = null;
    

        
        try {
            String sql = "CALL SP_COMBO_COMPROBANTE(?)";
            cst = getConexion().prepareCall(sql);
          //  cst.setInt(1,3);
         //   cst.setInt(2,4);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            
            cst.executeQuery();
            rs = (ResultSet) cst.getObject(1);
            while (rs.next()) {
               // System.out.println("get string : "+rs.getString("COMPROBANTE"));
                comprobante.add(new ComboVenta(rs.getInt("ID_COMPROBANTE"), rs.getString("COMPROBANTE")));
                
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
        
        return comprobante;
    }
 public ArrayList<ComboVenta> Com_boleta_fact(String val){
     
             ArrayList<ComboVenta> ventas = new ArrayList<>();
    //    PreparedStatement pst = null ;
        CallableStatement cst = null;
        ResultSet rs = null;
            
        try {
            String sql = "CALL SP_SELECT_BOLETA_FACT(?,?)";
            cst = getConexion().prepareCall(sql);
            cst.setString(1,val);
            cst.registerOutParameter(2, OracleTypes.CURSOR);
            
            cst.executeQuery();
            rs = (ResultSet) cst.getObject(2);
            while (rs.next()) {
            ///    System.out.println("get string : "+rs.getString("NOMBRE_EMPRESA"));
                ventas.add(new ComboVenta(rs.getInt("id"),val));                
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
  
  
   public boolean insertVenta(variable12 v){
CallableStatement cst = null;

        boolean flag = false;

        try {
            String sql = "call SP_INSERT_VENTAS(?,?,?,?,?,?,?,?,?,?,?,?)";
            cst = getConexion().prepareCall(sql);

        //    java.sql.Date sqlDate = new java.sql.Date(s.getFechaSolicitud().getTime());
            cst.setString(1, v.getVar1());
            cst.setString(2, v.getVar2());
            cst.setString(3, v.getVar3());
            cst.setString(4, v.getVar4());
            cst.setString(5, v.getVar5());
            cst.setString(6, v.getVar6());
            cst.setString(7, v.getVar7());
            cst.setString(8, v.getVar8());
            cst.setString(9, v.getVar9());
            cst.setString(10, v.getVar10());
            cst.setString(11, v.getVar11());
            cst.setString(12, v.getVar12());

            
            
      

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
    
   public boolean insertVentaDetalle(variable6 v6){
CallableStatement cst = null;

        boolean flag = false;

        try {
            String sql = "call SP_INSERT_DETALLE_VENTA(?,?,?,?,?,?)";
            cst = getConexion().prepareCall(sql);

        //    java.sql.Date sqlDate = new java.sql.Date(s.getFechaSolicitud().getTime());
            cst.setString(1, v6.getVar1());
            cst.setString(2, v6.getVar2());
            cst.setString(3, v6.getVar3());
            cst.setString(4, v6.getVar4());
            cst.setString(5, v6.getVar5());
            cst.setString(6, v6.getVar6());
    

            
            
      

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
   
   
      public ArrayList<variable16> tablaUsuario(){
    
        ArrayList<variable16> tableventas = new ArrayList<>();
    //    PreparedStatement pst = null ;
        CallableStatement cst = null;
        ResultSet rs = null;
        
        try {
            String sql = "CALL SP_SELECT_VENTA(?)";
            cst = getConexion().prepareCall(sql);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.executeQuery();
            rs = (ResultSet) cst.getObject(1);
//            rs = cst.executeQuery();
            while (rs.next()) {
               // System.out.println("get string : "+rs.getString("NOMBRE"));
                tableventas.add(new variable16(   rs.getString("usernom"),
                                            rs.getString("iduser"),
                                            rs.getString("nbolf"),
                                            rs.getString("tipo_com"),
                                            rs.getString("comprobante"),
                                            rs.getString("impuesto"),
                                            rs.getString("totalim"),
                                            rs.getString("pago"),
                                            rs.getString("vuelto"),
                                            rs.getString("cod_trans"),
                                            rs.getString("cliente"),
                                            rs.getString("formapago"),
                                            rs.getString("estado"),
                                            rs.getString("estadopago"),
                                            rs.getString("id_venta"),
                                            rs.getString("fechaventa")
                                             
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
        
        return tableventas;
    }
  
}
