/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import include.Usuario;
import include.Combo2;
import include.ComboCom;
import include.ComboP;
import include.ComboPais;
import include.ComboRegion;
import include.variable28;
import include.variable7;
import java.sql.CallableStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Lee
 */

public class ModeloUsuarios extends Controlador.Conexion{
    
/*    public boolean crear_usuario(variable28 u){
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            String sql = "insert into T_USER(NOMBRE,PATERNO,MATERNO,DIRECCION,TELEFONO,TELEFONO2,MAIL,USUARIO,PASS,COMUNA,REGION,PROVINCIA,RUT,ESTADO,ROL,NOMBRE_EMPRESA,RUT_EMPRESA,PAIS_EMPRESA,DIRECCION_EMPRESA,TELEFONO_EMPRESA,CORREO_EMPRESA  , ID_PATENTE , ID_VEHICULO , ID_CAP_M3 , TONELADA , ID_NOMBRE_CONDU , ID_TIPO_LICENCIA  ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(sql);
    pst.setString(1, u.getVar1());
    pst.setString(2, u.getVar2());
    pst.setString(3, u.getVar3());
    pst.setString(4, u.getVar4());
    pst.setString(5, u.getVar5());
    pst.setString(6, u.getVar6());
    pst.setString(7, u.getVar7());
    pst.setString(8, u.getVar8());
    pst.setString(9, u.getVar9());
    pst.setString(10, u.getVar10());
    pst.setString(11, u.getVar11());
    pst.setString(12, u.getVar12());
    pst.setString(13, u.getVar13());
    pst.setString(14, u.getVar14());
    pst.setString(15, u.getVar15());
    pst.setString(16, u.getVar16());
    pst.setString(17, u.getVar17());
    pst.setString(18, u.getVar18());
    pst.setString(19, u.getVar19());
    pst.setString(20, u.getVar20());
    pst.setString(21, u.getVar21());
    pst.setString(22, u.getVar22());
    pst.setString(23, u.getVar23());
    pst.setString(24, u.getVar24());
    pst.setString(25, u.getVar25());
    pst.setString(26, u.getVar26());
    pst.setString(27, u.getVar27());
  
            
            
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
    }*/
    
    
     public boolean crear_usuario(variable28 v){
        CallableStatement cst = null;

        boolean flag = false;

        try {
            String sql = "call SP_CREAR_USUARIO(?,?,?,?,?,?,? , ?,?,?,?,?,?,? , ?,?,?,?,?,?,? , ?,?,?,?,?,?)";
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
    cst.setString(13, v.getVar13());
    cst.setString(14, v.getVar14());
    cst.setString(15, v.getVar15());
    cst.setString(16, v.getVar16());
    cst.setString(17, v.getVar17());
    cst.setString(18, v.getVar18());
    cst.setString(19, v.getVar19());
    cst.setString(20, v.getVar20());
    cst.setString(21, v.getVar21());
    cst.setString(22, v.getVar22());
    cst.setString(23, v.getVar23());
    cst.setString(24, v.getVar24());
    cst.setString(25, v.getVar25());
    cst.setString(26, v.getVar26());
    cst.setString(27, v.getVar27());

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
    
            
            
            
  /*  public static void main(String[] args) {
        ModeloUsuarios mu = new ModeloUsuarios();
        System.out.println( mu.crear_usuario(new Usuario("0134492444","Agustin","quelempan","valladares","setta","654321","wagner","954276710","duoc@gmail.com") ));  
    }*/

    public ArrayList<Usuario> getAllUsuarios(){
    
        ArrayList<Usuario> usuarios = new ArrayList<>();
        PreparedStatement pst = null ;
        ResultSet rs = null;
        
        try {
            String sql = "select * from T_USER WHERE ESTADO = 1";
            pst = getConexion().prepareCall(sql);
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
    
    
    
    public boolean update_usuario(Usuario up){
        PreparedStatement pst = null;
        boolean flag = false;
       System.out.println("get u : "+up.getID());
        try {
            String sql = "UPDATE  T_USER set  NOMBRE = ? , PATERNO = ? , MATERNO = ? , DIRECCION = ? , TELEFONO = ? , TELEFONO2 = ? , MAIL = ? , COMUNA  = ?, REGION = ? , PROVINCIA = ? , RUT = ? , NOMBRE_EMPRESA = ? , RUT_EMPRESA = ? , PAIS_EMPRESA = ? , DIRECCION_EMPRESA = ? , TELEFONO_EMPRESA = ? , CORREO_EMPRESA = ?    where ID = "+up.getID() ;  
            
            pst = getConexion().prepareStatement(sql);
            
            pst.setString(1, up.getNOMBRE());
            pst.setString(2, up.getPATERNO());
            pst.setString(3, up.getMATERNO());
            pst.setString(4, up.getDIRECCION());
            pst.setString(5, up.getTELEFONO());
            pst.setString(6, up.getTELEFONO2());
            pst.setString(7, up.getMAIL());
            pst.setString(8, up.getCOMUNA());
            pst.setString(9, up.getREGION());
            pst.setString(10, up.getPROVINCIA());
            pst.setString(11, up.getRUT());
            pst.setString(12, up.getNOMBRE_EMPRESA());
            pst.setString(13, up.getRUT_EMPRESA());
            pst.setString(14, up.getPAIS_EMPRESA());
            pst.setString(15, up.getDIRECCION_EMPRESA());
            pst.setString(16, up.getTELEFONO_EMPRESA());
            pst.setString(17, up.getCORREO_EMPRESA());

            System.out.println("query : "+ sql);
            System.out.println("pst : "+ pst);
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
    
    
    public boolean delete_usuario(String rut){
        PreparedStatement pst = null;
        boolean flag = false;
        System.out.println("get u : "+rut);
        try {
            String sql = "UPDATE  T_USER set ESTADO = 0  where RUT = ?" ;
            pst = getConexion().prepareStatement(sql);
            pst.setString(1, rut);

            System.out.println("query : "+ pst);
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
    
    
    public ArrayList<Combo2> getComboRol(){
    
        ArrayList<Combo2> comnoRol = new ArrayList<>();
        PreparedStatement pst = null ;
        ResultSet rs = null;
        
        try {
            String sql = "select * from T_ROL";
            pst = getConexion().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                comnoRol.add(new Combo2(rs.getInt("ID"), rs.getString("ROL")));
                
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
        
        return comnoRol;
    }
    
    
    public ArrayList<ComboPais> getComboPais(){
    
        ArrayList<ComboPais> comboPais = new ArrayList<>();
        PreparedStatement pst = null ;
        ResultSet rs = null;
        
        try {
            String sql = "SELECT * FROM T_PAIS";
            pst = getConexion().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                comboPais.add(new ComboPais(rs.getInt("ID_PAIS"), rs.getString("PAIS")));
                
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
        
        return comboPais;
    }    


 public ArrayList<ComboRegion> getComboRegion(){
    
        ArrayList<ComboRegion> comboregion = new ArrayList<>();
        PreparedStatement pst = null ;
        ResultSet rs = null;
        
        try {
            String sql = "SELECT * FROM T_REGION";
            pst = getConexion().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                comboregion.add(new ComboRegion(rs.getInt("ID_REGION"), rs.getString("REGION")));
                
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
        
        return comboregion;
    }   
 
 public ArrayList<ComboP> getComboProv(){
    
        ArrayList<ComboP> comboprov = new ArrayList<>();
        PreparedStatement pst = null ;
        ResultSet rs = null;
        
        try {
            String sql = "SELECT * FROM T_PROVINCIA";
            pst = getConexion().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                comboprov.add(new  ComboP(rs.getInt("ID_PROVINCIA"), rs.getString("PROVINCIA"), rs.getInt("ID_REGION")));
                
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
        
        return comboprov;
    }

 public ArrayList<ComboCom> getComboCom(){
    
        ArrayList<ComboCom> combocom = new ArrayList<>();
        PreparedStatement pst = null ;
        ResultSet rs = null;
        
        try {
            String sql = "SELECT * FROM T_COMUNA";
            pst = getConexion().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                combocom.add(new ComboCom(rs.getInt("ID_COMUNA"), rs.getString("COMUNA"), rs.getInt("ID_PROVINCIA")));
                
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
        
        return combocom;
    } 
 
 /*   public static void main(String[] args) {
        ModeloUsuarios mu = new ModeloUsuarios();
        for (Usuario u : mu.getAllUsuarios()){
            System.out.println(u.getNombre());
        }
    }
    */
}
