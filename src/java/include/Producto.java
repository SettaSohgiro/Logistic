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
public class Producto {
    private int id_producto;
    private float cantidadKilos;
    private float precio;
    private Date fechaProduccion;
    private Fruta fruta;
    private Calidad calidad;
    private int idProductor;

    public Producto(){
    }
    
    public Producto(int id_producto, float cantidadKilos, float precio, Date fechaProduccion, Fruta fruta, Calidad calidad, int idProductor) {
        this.id_producto = id_producto;
        this.cantidadKilos = cantidadKilos;
        this.precio = precio;
        this.fechaProduccion = fechaProduccion;
        this.fruta = fruta;
        this.calidad = calidad;
        this.idProductor = idProductor;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public float getCantidadKilos() {
        return cantidadKilos;
    }

    public void setCantidadKilos(float cantidadKilos) {
        this.cantidadKilos = cantidadKilos;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getFechaProduccion() {
        return fechaProduccion;
    }

    public void setFechaProduccion(Date fechaProduccion) {
        this.fechaProduccion = fechaProduccion;
    }

    public Fruta getFruta() {
        return fruta;
    }

    public void setFruta(Fruta fruta) {
        this.fruta = fruta;
    }

    public Calidad getCalidad() {
        return calidad;
    }

    public void setCalidad(Calidad calidad) {
        this.calidad = calidad;
    }

    public int getIdProductor() {
        return idProductor;
    }

    public void setIdProductor(int idProductor) {
        this.idProductor = idProductor;
    }
    
}
