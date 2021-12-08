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
public class ComboCom {
    
    
    private int id_comuna;
    private String comuna;
    private int id_prov;

    public ComboCom() {
    }

    public ComboCom(int id_comuna, String comuna, int id_prov) {
        this.id_comuna = id_comuna;
        this.comuna = comuna;
        this.id_prov = id_prov;
    }

    public int getId_comuna() {
        return id_comuna;
    }

    public void setId_comuna(int id_comuna) {
        this.id_comuna = id_comuna;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public int getId_prov() {
        return id_prov;
    }

    public void setId_prov(int id_prov) {
        this.id_prov = id_prov;
    }
    
    
    
    
}
