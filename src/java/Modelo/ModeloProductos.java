/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Conexion;
import include.Calidad;
import include.Fruta;
import include.Producto;
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
public class ModeloProductos extends Conexion {

    //FUNCIONA
    public boolean crear_producto(Producto p) {
        CallableStatement pst = null;

        boolean flag = false;

        try {
            String sql = "call insertProductoSP(?,?,?,?,?,?)";
            pst = getConexion().prepareCall(sql);
            pst.setFloat(1, p.getCantidadKilos());
            pst.setFloat(2, p.getPrecio());

            java.sql.Date sqlDate = new java.sql.Date(p.getFechaProduccion().getTime());

            pst.setDate(3, sqlDate);
            pst.setInt(4, p.getFruta().getIdFruta());
            pst.setInt(5, p.getCalidad().getIdCalidad());
            pst.setInt(6, p.getIdProductor());

//            pst.executeQuery();
            int i = pst.executeUpdate();
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
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }

        return flag;
    }

    public ArrayList<Producto> getAllProductos(int idProductor) {
        ArrayList<Producto> productos = new ArrayList<>();
        CallableStatement cst = null;
        ResultSet rs = null;

        try {
//            String sql = "BEGIN selectAllProductos(); END;";
            String sql = "call selectAllProductosSP(?)";
//            String sql = "SELECT * FROM PRODUCTO";

            cst = getConexion().prepareCall(sql);
//            rs = pst.executeQuery();
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.executeQuery();
            rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                Fruta f = new Fruta(rs.getInt("ID_FRUTA"), rs.getString("NOMBRE"));
                Calidad c = new Calidad(rs.getInt("ID_CALIDAD"), rs.getString("NOMBRE_CALIDAD"));
                productos.add(new Producto(rs.getInt("ID_PRODUCTO"), rs.getFloat("CANTIDAD_KILOS"), rs.getFloat("PRECIO"), rs.getDate("FECHA_PRODUCCION"), f, c, idProductor));
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

        return productos;
    }

    public Producto getProducto(int idProducto) {
        Producto producto = null;
        CallableStatement cst = null;
//        PreparedStatement cst = null;
        ResultSet rs = null;

        try {
            String sql = "call selectProductoSP(?,?,?,?,?,?,?,?)";
//            String sql = "select * from producto where ID_PRODUCTO = ?";

            cst = getConexion().prepareCall(sql);
            cst.setInt(1, idProducto);
//            cst.registerOutParameter(1, OracleTypes.INTEGER);            
            cst.registerOutParameter(2, OracleTypes.FLOAT);
            cst.registerOutParameter(3, OracleTypes.FLOAT);
            cst.registerOutParameter(4, OracleTypes.DATE);
            cst.registerOutParameter(5, OracleTypes.INTEGER);
            cst.registerOutParameter(6, OracleTypes.INTEGER);
            cst.registerOutParameter(7, OracleTypes.VARCHAR);
            cst.registerOutParameter(8, OracleTypes.VARCHAR);

            cst.execute();
//            rs = (ResultSet) cst.getResultSet();
            float cantidad = (float) ((double)cst.getObject(2));
            float precio = (float) ((double) cst.getObject(3));
            java.sql.Date fechaSql = (java.sql.Date) cst.getObject(4);
            java.util.Date fechaProd = new java.util.Date(fechaSql.getTime());
            int idFruta = (int) cst.getObject(5);
            int idCalidad = (int) cst.getObject(6);
            String nombreFruta = (String) cst.getObject(7);
            String nombreCalidad = (String) cst.getObject(8);

            Fruta f = new Fruta(idFruta, nombreFruta);
            Calidad c = new Calidad(idCalidad, nombreCalidad);
            producto = new Producto(idProducto, cantidad, precio, fechaProd, f, c, -1);

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

        return producto;
    }

    public boolean deleteProducto(int idProducto) {
        boolean flag = false;
        CallableStatement cst = null;

        try {
            String sql = "call deleteProductoSP(?)";

            cst = getConexion().prepareCall(sql);

            cst.setInt(1, idProducto);
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

    public boolean update_producto(Producto p) {
        CallableStatement cst = null;

        boolean flag = false;

        try {
            String sql = "call modificarProductoSP(?,?,?,?,?,?)";
            cst = getConexion().prepareCall(sql);
            cst.setInt(1, p.getId_producto());
            cst.setFloat(2, p.getCantidadKilos());
            cst.setFloat(3, p.getPrecio());

            java.sql.Date sqlDate = new java.sql.Date(p.getFechaProduccion().getTime());

            cst.setDate(4, sqlDate);
            cst.setInt(5, p.getFruta().getIdFruta());
            cst.setInt(6, p.getCalidad().getIdCalidad());

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
