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
public class ContratoVenta {

    private int idContratoVenta;
    private Date fechaInicio;
    private Date fechaTermino;
    private String nombreContrato;
    private int idEstado;
    private int idCliente;
    private int idSoliciutd;
    private int idTransporte;
    private int idResumenVenta;
    
    public ContratoVenta(){
    }

    public ContratoVenta(int idContratoVenta, Date fechaInicio, Date fechaTermino, String nombreContrato, int idEstado, int idCliente, int idSoliciutd, int idTransporte, int idResumenVenta) {
        this.idContratoVenta = idContratoVenta;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.nombreContrato = nombreContrato;
        this.idEstado = idEstado;
        this.idCliente = idCliente;
        this.idSoliciutd = idSoliciutd;
        this.idTransporte = idTransporte;
        this.idResumenVenta = idResumenVenta;
    }

    public int getIdContratoVenta() {
        return idContratoVenta;
    }

    public void setIdContratoVenta(int idContratoVenta) {
        this.idContratoVenta = idContratoVenta;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getNombreContrato() {
        return nombreContrato;
    }

    public void setNombreContrato(String nombreContrato) {
        this.nombreContrato = nombreContrato;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdSoliciutd() {
        return idSoliciutd;
    }

    public void setIdSoliciutd(int idSoliciutd) {
        this.idSoliciutd = idSoliciutd;
    }

    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public int getIdResumenVenta() {
        return idResumenVenta;
    }

    public void setIdResumenVenta(int idResumenVenta) {
        this.idResumenVenta = idResumenVenta;
    }
    
}
