/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Conexion;
import include.Fruta;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author me
 */
public class ModeloFrutas extends Conexion {

    public ArrayList<Fruta> getAllFrutas() {

        ArrayList<Fruta> frutas = new ArrayList<>();
        CallableStatement cst = null;
        ResultSet rs = null;

        try {
//            String sql = "BEGIN selectAllProductos(); END;";
            String sql = "call selectAllFrutasSP(?)";
//            String sql = "SELECT * FROM PRODUCTO";

            cst = getConexion().prepareCall(sql);
//            rs = pst.executeQuery();
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.executeQuery();
            rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                frutas.add(new Fruta(rs.getInt("ID_FRUTA"), rs.getString("NOMBRE")));
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

        return frutas;
    }

    public Fruta getFruta(int idFruta) {
        Fruta f = null;
        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            String sql = "call selectFrutaSP(?,?)";

            cst = getConexion().prepareCall(sql);
            cst.setInt(1, idFruta);
            cst.registerOutParameter(2, OracleTypes.VARCHAR);

            cst.execute();

            String nombre = (String) cst.getObject(2);

            f = new Fruta(idFruta, nombre);

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

        return f;
    }

}
