/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Conexion;
import include.Seguro;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author me
 */
public class ModeloSeguros extends Conexion {

    public boolean crearSeguro(Seguro s) {
        CallableStatement pst = null;

        boolean flag = false;

        try {
            String sql = "call insertSeguroSP(?,?,?,?)";
            pst = getConexion().prepareCall(sql);
            pst.setString(1, s.getNombre());
            pst.setFloat(2, s.getCosto());
            pst.setString(3, s.getEstado());
            pst.setInt(4, s.getIdEmbarque());

//            pst.executeQuery();
            int i = pst.executeUpdate();
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
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }

        return flag;
    }

    public ArrayList<Seguro> getAllSeguros() {
        ArrayList<Seguro> seguros = new ArrayList<>();
        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            String sql = "call selectAllSegurosSP(?)";

            cst = getConexion().prepareCall(sql);
            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.executeQuery();
            rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                seguros.add(new Seguro(rs.getInt("id_seguro"),
                        rs.getString("nombre"),
                        rs.getFloat("costo"),
                        rs.getString("estado"),
                        rs.getInt("id_embarque")
                ));

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

        return seguros;
    }

    public boolean deleteSeguro(int idSeguro) {
        boolean flag = false;
        CallableStatement cst = null;

        try {
            String sql = "call deleteSeguroSP(?)";

            cst = getConexion().prepareCall(sql);

            cst.setInt(1, idSeguro);
            if (cst.executeUpdate() == 1) {
                flag = true;
            }

            flag = true;

        } catch (Exception e) {
            System.err.println("error " + e);
            flag = false;

        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (cst != null) {
                    cst.close();
                }
            } catch (Exception e) {
                System.err.println("error " + e);
            }
        }

        return flag;
    }
    
    
}
