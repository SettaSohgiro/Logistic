/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Conexion;
import include.Calidad;
import include.Fruta;
import include.Solicitud;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author me
 */
public class ModeloSolicitudes extends Conexion {
    //FUNCIONA

    public boolean crearSolicitud(Solicitud s) {
        CallableStatement cst = null;

        boolean flag = false;

        try {
            String sql = "call insertSolicitudSP(?,?,?,?,?,?,?,?)";
            cst = getConexion().prepareCall(sql);

            java.sql.Date sqlDate = new java.sql.Date(s.getFechaSolicitud().getTime());

            cst.setDate(1, sqlDate);
            cst.setFloat(2, s.getCantidad());
            cst.setFloat(3, s.getPresupuesto());
            cst.setString(4, s.getEmbalaje());
            cst.setInt(5, s.getIdFruta());
            cst.setInt(6, s.getIdCalidad());
            cst.setInt(7, s.getIdProcesoVenta());
            cst.setInt(8, s.getIdUsuario());

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

    public ArrayList<Solicitud> getAllSolicitudes(int option, int idCliEx) {
        ArrayList<Solicitud> solicitudes = new ArrayList<>();
        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            String sql = "call selectAllSolicitudesSP(?,?,?,?)";

            cst = getConexion().prepareCall(sql);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setInt(2, option);
            cst.setInt(3, idCliEx);
            cst.setInt(4, -1);

            cst.executeQuery();
            rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                solicitudes.add(new Solicitud(rs.getInt("ID_SOLICITUD"), rs.getDate("FECHA_SOLICITUD"), rs.getFloat("CANTIDAD"), rs.getFloat("PRESUPUESTO"), rs.getString("EMBALAJE"), rs.getInt("ID_FRUTA"), rs.getInt("ID_CALIDAD"), rs.getInt("ID_PROCESO_VENTA"), rs.getInt("ID_USUARIO")));
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

        return solicitudes;
    }

    public Solicitud getSolicitud(int idSolicitud) {
        Solicitud s = null;
        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            String sql = "call selectSolicitudSP(?,?,?,?,?,?,?,?,?)";

            cst = getConexion().prepareCall(sql);
            cst.setInt(1, idSolicitud);
            cst.registerOutParameter(2, OracleTypes.DATE);
            cst.registerOutParameter(3, OracleTypes.FLOAT);
            cst.registerOutParameter(4, OracleTypes.FLOAT);
            cst.registerOutParameter(5, OracleTypes.VARCHAR);
            cst.registerOutParameter(6, OracleTypes.INTEGER);
            cst.registerOutParameter(7, OracleTypes.INTEGER);
            cst.registerOutParameter(8, OracleTypes.INTEGER);
            cst.registerOutParameter(9, OracleTypes.INTEGER);

            cst.execute();

            java.sql.Date fechaSql = (java.sql.Date) cst.getObject(2);
            java.util.Date fechaSol = new java.util.Date(fechaSql.getTime());
            float cantidad = (float) ((double) cst.getObject(3));
            float presupuesto = (float) ((double) cst.getObject(4));
            String embalaje = (String) cst.getObject(5);
            int idFruta = (int) cst.getObject(6);
            int idCalidad = (int) cst.getObject(7);
            int idProcesoVenta = (int) cst.getObject(8);
            int idUsuario = (int) cst.getObject(9);

            s = new Solicitud(idSolicitud, fechaSol, cantidad, presupuesto, embalaje, idFruta, idCalidad, idProcesoVenta, idUsuario);

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

        return s;
    }

    public boolean deleteSolicitud(int idSolicitud) {
        boolean flag = false;
        CallableStatement cst = null;

        try {
            String sql = "call deleteSolicitudSP(?)";

            cst = getConexion().prepareCall(sql);

            cst.setInt(1, idSolicitud);
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

    public boolean updateSolicitud(Solicitud s) {
        CallableStatement cst = null;

        boolean flag = false;

        try {
            String sql = "call modificarSolicitudSP(?,?,?,?,?,?,?,?,?)";
            cst = getConexion().prepareCall(sql);

            cst.setInt(1, s.getIdSolicitud());
            java.sql.Date sqlDate = new java.sql.Date(s.getFechaSolicitud().getTime());
            cst.setDate(2, sqlDate);
            cst.setFloat(3, s.getCantidad());
            cst.setFloat(4, s.getPresupuesto());
            cst.setString(5, s.getEmbalaje());
            cst.setInt(6, s.getIdFruta());
            cst.setInt(7, s.getIdCalidad());
            cst.setInt(8, s.getIdProcesoVenta());
            cst.setInt(9, s.getIdUsuario());

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

        return flag;
    }

    public static void main(String[] args) {
//        Fruta f = new Fruta(0, "Manzana Fuji");
//        Calidad c = new Calidad(0, "Nacional");
//        System.out.println(mp.crear_producto(new Producto(0, 4500, 1000, null, f, c)));
        ModeloProductos mp = new ModeloProductos();

        System.out.println(mp.getProducto(11));
//        for (Producto p : mp.getAllProductos()) {
//            System.out.println(p.getNombre());
//        }
    }
}
