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
public class Calidad {
    private int idCalidad;
    private String nombre;

    public Calidad(){
    }
    
    public Calidad(int idCalidad, String nombre) {
        this.idCalidad = idCalidad;
        this.nombre = nombre;
    }

    public int getIdCalidad() {
        return idCalidad;
    }

    public void setIdCalidad(int idCalidad) {
        this.idCalidad = idCalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
