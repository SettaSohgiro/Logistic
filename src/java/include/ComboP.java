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
public class ComboP {
    
    private int id_prov;
    private String provincia;
    private int id_reg;

    public ComboP() {
    }

    public ComboP(int id_prov, String provincia, int id_reg) {
        this.id_prov = id_prov;
        this.provincia = provincia;
        this.id_reg = id_reg;
    }

    public int getId_prov() {
        return id_prov;
    }

    public void setId_prov(int id_prov) {
        this.id_prov = id_prov;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getId_reg() {
        return id_reg;
    }

    public void setId_reg(int id_reg) {
        this.id_reg = id_reg;
    }
    
     
}
