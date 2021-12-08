/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Conexion;
import include.Calidad;
import include.DetalleSolicitud;
import include.Fruta;
import include.Solicitud2;
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
public class ModeloSolicitudes2 extends Conexion {

    public boolean crearSolicitud(Solicitud2 s, ArrayList<DetalleSolicitud> detalles) {
        CallableStatement cst = null;
        ResultSet rs = null;

        boolean flag = false;

        try {
            String sql = "call insertSolicitud2SP(?,?,?,?,?)";
            cst = getConexion().prepareCall(sql);

            java.sql.Date sqlDate = new java.sql.Date(s.getFechaSolicitud().getTime());

            cst.setDate(1, sqlDate);
            cst.setFloat(2, s.getPresupuesto());
            cst.setInt(3, s.getIdVenta());
            cst.setInt(4, s.getIdUsuario());
            cst.registerOutParameter(5, OracleTypes.INTEGER);

//            pst.executeQuery();
            cst.executeQuery();

            int solicitudId = (int)cst.getObject(5);
            System.out.println("solicitudId: " + solicitudId);

            String queryDetalles = "INSERT INTO T_DETALLE_SOLICITUD(CANTIDAD, PRESUPUESTO, EMBALAJE, ID_FRUTA, ID_CALIDAD, ID_SOLICITUD) "
                    + "VALUES(?,?,?,?,?,?)";

            try {
                PreparedStatement statement = getConexion().prepareStatement(queryDetalles);
                int count = 0;

                for (DetalleSolicitud detalle : detalles) {
                    statement.setFloat(1, detalle.getCantidad());
                    statement.setFloat(2, detalle.getPresupuesto());
                    statement.setString(3, detalle.getEmbalaje());
                    statement.setInt(4, detalle.getIdFruta());
                    statement.setInt(5, detalle.getIdCalidad());
                    statement.setInt(6, solicitudId);

                    statement.addBatch();
                    count++;

                    if (count % 100 == 0 || count == detalles.size()) {
                        statement.executeBatch();
                    }
                }

            } catch (Exception e) {
                System.err.println(e.getMessage());
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

    public ArrayList<Solicitud2> getAllSolicitudes(int option, int idCliEx) {
        ArrayList<Solicitud2> solicitudes = new ArrayList<>();
        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            String sql = "call selectAllSolicitudes2SP(?,?,?,?)";

            cst = getConexion().prepareCall(sql);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setInt(2, option);
            cst.setInt(3, idCliEx);
            cst.setInt(4, -1);

            cst.executeQuery();
            rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                solicitudes.add(new Solicitud2(rs.getInt("ID_SOLICITUD"), rs.getDate("FECHA_SOLICITUD"), rs.getFloat("PRESUPUESTO"), rs.getInt("ID_PROCESO_VENTA"), rs.getInt("ID_USUARIO")));
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

    public ArrayList<DetalleSolicitud> getAllDetallesSolicitudes(int idSolicitud) {
        ArrayList<DetalleSolicitud> detalles = new ArrayList<>();
        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            String sql = "call selectAllDetallesFromSolicitudSP(?,?)";

            cst = getConexion().prepareCall(sql);
            cst.setInt(1, idSolicitud);
            cst.registerOutParameter(2, OracleTypes.CURSOR);

            cst.executeQuery();
            rs = (ResultSet) cst.getObject(2);

            while (rs.next()) {
                detalles.add(new DetalleSolicitud(
                        rs.getInt("ID_DETALLE_SOLICITUD"),
                        rs.getFloat("CANTIDAD"),
                        rs.getFloat("PRESUPUESTO"),
                        rs.getString("EMBALAJE"),
                        rs.getInt("ID_FRUTA"),
                        rs.getInt("ID_CALIDAD"),
                        rs.getInt("ID_SOLICITUD")));
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

        return detalles;
    }

    public Solicitud2 getSolicitud(int idSolicitud) {
        Solicitud2 s = null;
        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            String sql = "call selectSolicitud2SP(?,?,?,?,?)";

            cst = getConexion().prepareCall(sql);
            cst.setInt(1, idSolicitud);
            cst.registerOutParameter(2, OracleTypes.DATE);
            cst.registerOutParameter(3, OracleTypes.FLOAT);
            cst.registerOutParameter(4, OracleTypes.INTEGER);
            cst.registerOutParameter(5, OracleTypes.INTEGER);

            cst.execute();

            java.sql.Date fechaSql = (java.sql.Date) cst.getObject(2);
            java.util.Date fechaSol = new java.util.Date(fechaSql.getTime());
            float presupuesto = (float) ((double) cst.getObject(3));
            int idProcesoVenta = (int) cst.getObject(4);
            int idUsuario = (int) cst.getObject(5);

            s = new Solicitud2(idSolicitud, fechaSol, presupuesto, idProcesoVenta, idUsuario);

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
            String sql = "call deleteSolicitud2SP(?)";

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

    public boolean updateSolicitud(Solicitud2 s) {
        CallableStatement cst = null;

        boolean flag = false;

        try {
            String sql = "call modificarSolicitud2SP(?,?,?,?,?)";
            cst = getConexion().prepareCall(sql);

            cst.setInt(1, s.getIdSolicitud());
            java.sql.Date sqlDate = new java.sql.Date(s.getFechaSolicitud().getTime());
            cst.setDate(2, sqlDate);
            cst.setFloat(3, s.getPresupuesto());
            cst.setInt(4, s.getIdVenta());
            cst.setInt(5, s.getIdUsuario());

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
}
