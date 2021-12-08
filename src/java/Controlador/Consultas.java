/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import include.Usuario;
import java.sql.CallableStatement;
import java.util.ArrayList;

/**
 *
 * @author Lee
 */
public class Consultas extends Conexion{
    
    public boolean autenticacion(String usuario , String contraseña){
        PreparedStatement pst = null;
      //  CallableStatement pst = null;
        ResultSet rs = null;
        String resp = null;
        try {
            System.out.println("autentificacion use pas : " + usuario +" - "+contraseña);
            String consulta = "select * from T_USER where usuario = ? and pass = ?";
         //  String consulta="select COUNT(*) as cantidad from t_user where usuario = ? and pass = ?;";
           pst = getConexion().prepareStatement(consulta);
            pst.setString(1,usuario);
            pst.setString(2,contraseña);
            rs = pst.executeQuery();

            if(rs.next()){
                System.out.println("Existe el registro");
                return true;
            }else{
                System.out.println("no existe ");
            }
   
        } catch (SQLException e) {
            System.err.println("error " + e);
        } finally{
            try {
                if(getConexion() != null) {getConexion().close();}
                if(pst != null){ pst.close();}
                if(rs != null){rs.close();}
            } catch (SQLException e) {
                System.err.println("error " + e);
            }    
            
        }
    return false;
    }
    
    public ArrayList<Usuario> autenticacion2(String usuario , String contraseña){
    
        ArrayList<Usuario> usuarios = new ArrayList<>();
        PreparedStatement pst = null ;
        ResultSet rs = null;
        
        try {
            String sql = "select * from T_USER WHERE USUARIO = ? and PASS = ?";
            pst = getConexion().prepareCall(sql);
            pst.setString(1,usuario);
            pst.setString(2,contraseña);
            rs = pst.executeQuery();
            while (rs.next()) {
                usuarios.add(new Usuario(   rs.getString("ID"),
                                            rs.getString("NOMBRE"),
                                            rs.getString("PATERNO"),
                                            rs.getString("MATERNO"),
                                            rs.getString("DIRECCION"),
                                            rs.getString("TELEFONO"),
                                            rs.getString("TELEFONO2"),
                                            rs.getString("MAIL"),
                                            rs.getString("USUARIO"),
                                            rs.getString("PASS"),
                                            rs.getString("COMUNA"),
                                            rs.getString("REGION"),
                                            rs.getString("PROVINCIA"),
                                            rs.getString("RUT"),
                                            rs.getString("ESTADO"),
                                            rs.getString("ROL"),
                                            rs.getString("NOMBRE_EMPRESA"),
                                            rs.getString("RUT_EMPRESA"),
                                            rs.getString("PAIS_EMPRESA"),
                                            rs.getString("DIRECCION_EMPRESA"),
                                            rs.getString("TELEFONO_EMPRESA"),
                                            rs.getString("CORREO_EMPRESA")  ));
                
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
        
        return usuarios;
    }
    
    
    public boolean  registrar(String  rut , String  nombre , String a_paterno, String a_materno, String usuario, String pass ){
        
        PreparedStatement pst = null;
        
        try {
            String consulta = "INSERT INTO T_USER (rut, nombre,a_apellido,m_apellido,usuario,pass) VALUES (?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, rut);
            pst.setString(2, nombre);
            pst.setString(3,a_paterno );
            pst.setString(4,a_materno);
            pst.setString(5,usuario );
            pst.setString(6,pass );
            
            if(pst.executeUpdate() == 1){
            
                return true;
            }
            
            
        } catch (Exception e) {
            System.out.println("Error :_ " + e);
        }finally{
            try {
                if(getConexion() != null){getConexion().close();}
                if(pst != null){pst.close();}
            } catch (Exception e) {
            }
        }
    
        return false;
    }
    
    
    
    
    
 /*   public static void main(String[] args) {
        Consultas co = new Consultas();
        System.out.println(co.autenticacion("setta", "123456"));
    //    System.out.println(co.registrar("0013364369","Lientur", "Quelempan", "Valladares", "shishio", "1234"));
        
    }
       */

}
