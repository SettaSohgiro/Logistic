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
public class Reporte {
    private String fecha;
    private int totalVentas;
    private float totalVentaBruto;
    private float totalCostoTransporte;
    private float totalComision;
    private float totalPerdidaFruta;
    private float totalLiquido;

    public Reporte(String fecha, int totalVentas, float totalVentaBruto, float totalCostoTransporte, float totalComision, float totalPerdidaFruta, float totalLiquido) {
        this.fecha = fecha;
        this.totalVentas = totalVentas;
        this.totalVentaBruto = totalVentaBruto;
        this.totalCostoTransporte = totalCostoTransporte;
        this.totalComision = totalComision;
        this.totalPerdidaFruta = totalPerdidaFruta;
        this.totalLiquido = totalLiquido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(int totalVentas) {
        this.totalVentas = totalVentas;
    }

    public float getTotalVentaBruto() {
        return totalVentaBruto;
    }

    public void setTotalVentaBruto(float totalVentaBruto) {
        this.totalVentaBruto = totalVentaBruto;
    }

    public float getTotalCostoTransporte() {
        return totalCostoTransporte;
    }

    public void setTotalCostoTransporte(float totalCostoTransporte) {
        this.totalCostoTransporte = totalCostoTransporte;
    }

    public float getTotalComision() {
        return totalComision;
    }

    public void setTotalComision(float totalComision) {
        this.totalComision = totalComision;
    }

    public float getTotalPerdidaFruta() {
        return totalPerdidaFruta;
    }

    public void setTotalPerdidaFruta(float totalPerdidaFruta) {
        this.totalPerdidaFruta = totalPerdidaFruta;
    }

    public float getTotalLiquido() {
        return totalLiquido;
    }

    public void setTotalLiquido(float totalLiquido) {
        this.totalLiquido = totalLiquido;
    }
    
    
    
}
