/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package include;

/**
 *
 * @author me
 */
public class DetalleSolicitud{
    private int idDetalleSolicitud;
    private float cantidad;
    private float presupuesto;
    private String embalaje;
    private int idFruta;
    private int idCalidad;
    private int idSolicitud;

    public DetalleSolicitud() {
    }

    public DetalleSolicitud(int idDetalleVenta, float cantidad, float presupuesto, String embalaje, int idFruta, int idCalidad, int idSolicitud) {
        this.idDetalleSolicitud = idDetalleVenta;
        this.cantidad = cantidad;
        this.presupuesto = presupuesto;
        this.embalaje = embalaje;
        this.idFruta = idFruta;
        this.idCalidad = idCalidad;
        this.idSolicitud = idSolicitud;
    }

    public int getIdDetalleSolicitud() {
        return idDetalleSolicitud;
    }

    public void setIdDetalleSolicitud(int idDetalleSolicitud) {
        this.idDetalleSolicitud = idDetalleSolicitud;
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

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }
    
    
}