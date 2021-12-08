/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Conexion;
import include.Reporte;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author me
 */
public class ModeloReportes extends Conexion {

    public ArrayList<Reporte> getAllReportes(String anio) {
        ArrayList<Reporte> reportes = new ArrayList<>();
        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            String sql = "call selectAllReportes(?,?)";

            cst = getConexion().prepareCall(sql);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setString(2, anio);

            cst.executeQuery();
            rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                reportes.add(new Reporte(rs.getString("fecha"), 
                        rs.getInt("total_ventas"),
                        rs.getFloat("total_venta_bruto"),
                        rs.getFloat("total_costo_transporte"),
                        rs.getFloat("total_comision"),
                        rs.getFloat("total_perdida_fruta"),
                        rs.getFloat("total_liquido")));
                
            }

        } catch (Exception e) {
            System.err.println("error " + e);
        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (cst != null) {
                    cst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("error " + e);
            }
        }

        return reportes;
    }
    
    public static void main(String[] args) {
        ModeloReportes mr = new ModeloReportes();
        ArrayList<Reporte> reps = mr.getAllReportes("2021");
        
        for (Reporte rep : reps) {
            System.out.print(rep.getFecha());
        }
    }
}
