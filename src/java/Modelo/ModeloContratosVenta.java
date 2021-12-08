/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Conexion;
import include.ContratoVenta;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author me
 */
public class ModeloContratosVenta extends Conexion {

    public boolean crearContratoVenta(ContratoVenta c) {
        CallableStatement cst = null;

        boolean flag = false;

        try {
            String sql = "call insertContratoVentaSP(?,?,?,?,?,?,?,?)";
            cst = getConexion().prepareCall(sql);

            java.sql.Date fechaInicioSQL = new java.sql.Date(c.getFechaInicio().getTime());
            cst.setDate(1, fechaInicioSQL);

            java.sql.Date fechaTerminoSQL = new java.sql.Date(c.getFechaTermino().getTime());
            cst.setDate(2, fechaTerminoSQL);

            cst.setString(3, c.getNombreContrato());
            cst.setInt(4, c.getIdEstado());
            cst.setInt(5, c.getIdCliente());
            cst.setInt(6, c.getIdSoliciutd());
            cst.setInt(7, c.getIdTransporte());
            cst.setInt(8, c.getIdResumenVenta());

//            pst.executeQuery();
            int i = cst.executeUpdate();
            System.out.println(i);

            if (i == 1) {
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

        return flag;
    }

    public ArrayList<ContratoVenta> getAllContratosVenta(int option, int idCliEx) {
        ArrayList<ContratoVenta> contratos = new ArrayList<>();
        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            String sql = "call selectAllContratosVentaSP(?,?,?,?)";

            cst = getConexion().prepareCall(sql);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setInt(2, option);
            cst.setInt(3, idCliEx);
            cst.setInt(4, -1);

            cst.executeQuery();
            rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                contratos.add(new ContratoVenta(rs.getInt("ID_CONTRATO_VENTA"), rs.getDate("FECHA_INICIO"), rs.getDate("FECHA_TERMINO"), rs.getString("NOMBRE_CONTRATO"), rs.getInt("ID_ESTADO"), rs.getInt("ID_CLIENTE"), rs.getInt("ID_SOLICITUD"), rs.getInt("ID_TRANSPORTE"),rs.getInt("ID_RESUMEN_VENTA")));
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

        return contratos;
    }
}
