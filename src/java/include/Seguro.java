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
public class Seguro {
    private int idSeguro;
    private String nombre;
    private float costo;
    private String estado;
    private int idEmbarque;

    public Seguro() {
    }

    public Seguro(int idSeguro, String nombre, float costo, String estado, int idEmbarque) {
        this.idSeguro = idSeguro;
        this.nombre = nombre;
        this.costo = costo;
        this.estado = estado;
        this.idEmbarque = idEmbarque;
    }

    public int getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(int idSeguro) {
        this.idSeguro = idSeguro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdEmbarque() {
        return idEmbarque;
    }

    public void setIdEmbarque(int idEmbarque) {
        this.idEmbarque = idEmbarque;
    }
    
    
}
