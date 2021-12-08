/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Conexion;
import include.Calidad;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author me
 */
public class ModeloCalidad extends Conexion {

    public ArrayList<Calidad> getAllCalidades() {

        ArrayList<Calidad> calidades = new ArrayList<>();
        CallableStatement cst = null;
        ResultSet rs = null;

        try {
//            String sql = "BEGIN selectAllProductos(); END;";
            String sql = "call selectAllCalidadesSP(?)";
//            String sql = "SELECT * FROM PRODUCTO";

            cst = getConexion().prepareCall(sql);
//            rs = pst.executeQuery();
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.executeQuery();
            rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                calidades.add(new Calidad(rs.getInt("ID_CALIDAD"), rs.getString("NOMBRE_CALIDAD")));
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

        return calidades;
    }

    public Calidad getCalidad(int idCalidad) {
        Calidad c = null;
        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            String sql = "call selectCalidadSP(?,?)";

            cst = getConexion().prepareCall(sql);
            cst.setInt(1, idCalidad);
            cst.registerOutParameter(2, OracleTypes.VARCHAR);

            cst.execute();

            String nombre = (String) cst.getObject(2);

            c = new Calidad(idCalidad, nombre);

        } catch (SQLException e) {
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

        return c;
    }
}
