/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package include;

import java.util.Date;

/**
 *
 * @author me
 */
public class Solicitud {

    private int idSolicitud;
    private Date fechaSolicitud;
    private float cantidad;
    private float presupuesto;
    private String embalaje;
    private int idFruta;
    private int idCalidad;
    private int idProcesoVenta;
    private int idUsuario;

    public Solicitud() {
    }

    public Solicitud(int idSolicitud, Date fechaSolicitud, float cantidad, float presupuesto, String embalaje, int idFruta, int idCalidad, int idProcesoVenta, int idUsuario) {
        this.idSolicitud = idSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.cantidad = cantidad;
        this.presupuesto = presupuesto;
        this.embalaje = embalaje;
        this.idFruta = idFruta;
        this.idCalidad = idCalidad;
        this.idProcesoVenta = idProcesoVenta;
        this.idUsuario = idUsuario;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(float presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getEmbalaje() {
        return embalaje;
    }

    public void setEmbalaje(String embalaje) {
        this.embalaje = embalaje;
    }

    public int getIdFruta() {
        return idFruta;
    }

    public void setIdFruta(int idFruta) {
        this.idFruta = idFruta;
    }

    public int getIdCalidad() {
        return idCalidad;
    }

    public void setIdCalidad(int idCalidad) {
        this.idCalidad = idCalidad;
    }

    public int getIdProcesoVenta() {
        return idProcesoVenta;
    }

    public void setIdProcesoVenta(int idProcesoVenta) {
        this.idProcesoVenta = idProcesoVenta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
