/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Conexion;
import include.Productor;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author me
 */
public class ModeloProductores extends Conexion{
        public boolean crear_productor(Productor pr){
        CallableStatement cst = null;

        boolean flag = false;
        
        try {
            String sql = "call insertProducto(?,?,?,?,?,?,?,?)";
            cst = getConexion().prepareCall(sql);
//            pst.setInt(1, p.getId());
            cst.setString(1, pr.getNombre_productor());
            cst.setString(2, pr.getDireccion());
            cst.setString(3, pr.getTelefono());
            
//            pst.executeQuery();
            int i = cst.executeUpdate();
            System.out.println(i);
            
            if(i == 1){
                flag = true;
            }

//            IMPORTANTE EL COMMIT
//            getConnection().setAutoCommit(true);

//            if(pst.executeUpdate() == 1){
//                flag = true;                
//            }
            flag = true;

        } catch (Exception e) {
//            try {
//                getConnection().rollback();
//            } catch (SQLException ex) {
//                Logger.getLogger(ModeloProductos.class.getName()).log(Level.SEVERE, null, ex);
//            }

            System.err.println("Error: " + e);
            e.printStackTrace();
        }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(cst != null) cst.close();
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        
        return flag;
    }
    
    public ArrayList<Productor> getAllProductores(){
        ArrayList<Productor> productores = new ArrayList<>();
        CallableStatement cst = null;
        ResultSet rs = null;

        try {
//            String sql = "BEGIN selectAllProductos(); END;";
            String sql = "call selectAllProductos(?)";
//            String sql = "SELECT * FROM PRODUCTO";

            cst = getConexion().prepareCall(sql);
//            rs = pst.executeQuery();
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.executeQuery();
            rs = (ResultSet) cst.getObject(1);
            
            while(rs.next()){
                productores.add(new Productor(rs.getInt("ID_PRODUCTO"), rs.getString("NOMBRE_PRODUCTOR"), rs.getString("DIRECCION"), rs.getString("TELEFONO"), rs.getString("FK_USUARIO_RUT_USUARIO")));
            }
        } catch (Exception e) {
            System.err.println("error " + e);
        }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(cst != null) cst.close();                
                if(rs != null) rs.close();
            } catch (Exception e) {
                    System.err.println("error " + e);
            }
        }
        
        return productores;
    }
    
    public Productor getProductor(int idProducto){
        Productor productor = null;
        CallableStatement cst = null;
//        PreparedStatement cst = null;
        ResultSet rs = null;

        try {
            String sql = "call seleccionarProducto(?,?,?,?,?)";
//            String sql = "select * from producto where ID_PRODUCTO = ?";
            
            cst = getConexion().prepareCall(sql);
            cst.setInt(1, idProducto);
//            cst.registerOutParameter(1, OracleTypes.INTEGER);            
            cst.registerOutParameter(2, OracleTypes.VARCHAR);
            cst.registerOutParameter(3, OracleTypes.NUMBER);
            cst.registerOutParameter(4, OracleTypes.VARCHAR);
            cst.registerOutParameter(5, OracleTypes.FLOAT);

            cst.execute();
//            rs = (ResultSet) cst.getResultSet();
            String i = (String)cst.getObject(2);
            System.out.println(i);

//            cst.setInt(1, idProducto);
//            rs = cst.executeQuery();
            
            while(rs.next()){
                productor = new Productor(rs.getInt("ID_PRODUCTO"), rs.getString("NOMBRE_PRODUCTOR"), rs.getString("DIRECCION"), rs.getString("TELEFONO"), rs.getString("FK_USUARIO_RUT_USUARIO"));
            }
            
        } catch (SQLException e) {
            System.err.println("error " + e);
        }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(cst != null) cst.close();                
                if(rs != null) rs.close();
            } catch (Exception e) {
                    System.err.println("error " + e);
            }
        }
        
        return productor;
    }
    
    public boolean deleteProductor(int idProductor){
        boolean flag = false;
        PreparedStatement cst = null;

        try {
            String sql = "call deleteProducto(?)";
            
            cst = getConexion().prepareCall(sql);

            cst.setInt(1, idProductor);
            if(cst.executeUpdate() == 1){
                flag = true;
            }
            
        } catch (Exception e) {
            System.err.println("error " + e);
        }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(cst != null) cst.close();                
            } catch (Exception e) {
                    System.err.println("error " + e);
            }
        }
        
        return flag;
    }
    
    public boolean update_productor(Productor pr){
        CallableStatement pst = null;

        boolean flag = false;
        
        try {
            String sql = "call modificarProducto(?,?,?,?,?)";
            pst = getConexion().prepareCall(sql);
            pst.setInt(1, pr.getId_productor());
            pst.setString(2, pr.getNombre_productor());
            pst.setString(3, pr.getDireccion());
            pst.setString(4, pr.getTelefono());
            
//            pst.executeQuery();
            int i = pst.executeUpdate();
            System.out.println(i);
            
            if(i == 1){
                flag = true;
            }

            flag = true;

        } catch (Exception e) {

            System.err.println("Error: " + e);
            e.printStackTrace();
        }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        
        return flag;
    }
    
    
    
    public static void main(String[] args) {
        ModeloProductos mp = new ModeloProductos();
        System.out.println(mp.getProducto(8));
//        for (Producto p : mp.getAllProductores()) {
//            System.out.println(p.getNombre());
//        }
    }
}
