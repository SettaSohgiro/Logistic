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
public class Fruta {
    private int idFruta;
    private String nombre;

    public Fruta(){
    }
    
    public Fruta(int idFruta, String nombre) {
        this.idFruta = idFruta;
        this.nombre = nombre;
    }

    public int getIdFruta() {
        return idFruta;
    }

    public void setIdFruta(int idFruta) {
        this.idFruta = idFruta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
