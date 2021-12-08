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
public class ComboRegion {
    
    private int ID_REGION;
    private String REGION;

    public ComboRegion() {
    }

    public ComboRegion(int ID_REGION, String REGION) {
        this.ID_REGION = ID_REGION;
        this.REGION = REGION;
    }

    public int getID_REGION() {
        return ID_REGION;
    }

    public void setID_REGION(int ID_REGION) {
        this.ID_REGION = ID_REGION;
    }

    public String getREGION() {
        return REGION;
    }

    public void setREGION(String REGION) {
        this.REGION = REGION;
    }
    
    
}
