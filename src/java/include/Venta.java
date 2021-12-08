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
public class Venta {
    
private String	ID_PRODUCTO	;
private String	ID_FRUTA	;
private String	NOMBRE	;
private String	STOCK	;
private String	ID_CALIDAD	;
private String	CALIDAD	;
private String	PRECIO	;
private String	FECHA_CO	;
private String	VENTA_KILOS	;
private String	ESTADO	;

    public Venta() {
    }

    public Venta(String ID_PRODUCTO, String ID_FRUTA, String NOMBRE, String STOCK, String ID_CALIDAD, String CALIDAD, String PRECIO, String FECHA_CO, String VENTA_KILOS, String ESTADO) {
        this.ID_PRODUCTO = ID_PRODUCTO;
        this.ID_FRUTA = ID_FRUTA;
        this.NOMBRE = NOMBRE;
        this.STOCK = STOCK;
        this.ID_CALIDAD = ID_CALIDAD;
        this.CALIDAD = CALIDAD;
        this.PRECIO = PRECIO;
        this.FECHA_CO = FECHA_CO;
        this.VENTA_KILOS = VENTA_KILOS;
        this.ESTADO = ESTADO;
    }

    public String getID_PRODUCTO() {
        return ID_PRODUCTO;
    }

    public void setID_PRODUCTO(String ID_PRODUCTO) {
        this.ID_PRODUCTO = ID_PRODUCTO;
    }

    public String getID_FRUTA() {
        return ID_FRUTA;
    }

    public void setID_FRUTA(String ID_FRUTA) {
        this.ID_FRUTA = ID_FRUTA;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getSTOCK() {
        return STOCK;
    }

    public void setSTOCK(String STOCK) {
        this.STOCK = STOCK;
    }

    public String getID_CALIDAD() {
        return ID_CALIDAD;
    }

    public void setID_CALIDAD(String ID_CALIDAD) {
        this.ID_CALIDAD = ID_CALIDAD;
    }

    public String getCALIDAD() {
        return CALIDAD;
    }

    public void setCALIDAD(String CALIDAD) {
        this.CALIDAD = CALIDAD;
    }

    public String getPRECIO() {
        return PRECIO;
    }

    public void setPRECIO(String PRECIO) {
        this.PRECIO = PRECIO;
    }

    public String getFECHA_CO() {
        return FECHA_CO;
    }

    public void setFECHA_CO(String FECHA_CO) {
        this.FECHA_CO = FECHA_CO;
    }

    public String getVENTA_KILOS() {
        return VENTA_KILOS;
    }

    public void setVENTA_KILOS(String VENTA_KILOS) {
        this.VENTA_KILOS = VENTA_KILOS;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }




    
}
