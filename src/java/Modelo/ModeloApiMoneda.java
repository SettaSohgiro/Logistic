/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import include.apimoneda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Lee
 */
public class ModeloApiMoneda extends Controlador.Conexion {

    public boolean crear_moneda(apimoneda u){
         PreparedStatement pst = null;
        boolean flag = false;
        System.out.println("la fecha :"+u.getFecha());
        try {
            String sql = "INSERT INTO t_moneda  select '"+u.getMoneda()+"' , "+u.getValor()+" ,'"+u.getFecha()+"' from t_moneda where (select max(fecha) from t_moneda) <   '"+u.getFecha()+"'";
            System.out.println("sql : "+ sql);
            pst = getConexion().prepareStatement(sql);

            
            
            if(pst.executeUpdate() == 1){
                flag = true;
            }
            
        } catch (Exception e) {
            System.err.println("error " + e);
        }finally{
            try {
                if(getConexion() != null) {getConexion().close();}
                if(pst != null){ pst.close();}
            } catch (Exception e) {
                System.err.println("error " + e);
            }
        }
        return flag;
    
    }


}
