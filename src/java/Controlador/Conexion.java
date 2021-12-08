/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lee
 */
public class Conexion {
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String user = "usuario";
    String pass = "porta23";
    private Connection con;
    
    public Conexion(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection(url,user,pass);            
        System.out.println("coneccion exitosa ");
        } catch (ClassNotFoundException e ) {
            System.err.println("error"+e);
        } catch(SQLException e){
            System.err.println("error"+e);
        }
    }
    
    public Connection getConexion(){
        return con;
    }
    
  /*  public static void main(String[] args){
        Conexion con = new Conexion();
    }*/
    
}
