/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package include;

/**
 *
 * @author Lee
 */
public class ComboPais {
    
    private int ID_PAIS;
    private String PAIS;

    public ComboPais() {
    }

    public ComboPais(int ID_PAIS, String PAIS) {
        this.ID_PAIS = ID_PAIS;
        this.PAIS = PAIS;
    }

    public int getID_PAIS() {
        return ID_PAIS;
    }

    public void setID_PAIS(int ID_PAIS) {
        this.ID_PAIS = ID_PAIS;
    }

    public String getPAIS() {
        return PAIS;
    }

    public void setPAIS(String PAIS) {
        this.PAIS = PAIS;
    }
    
    
    
}
