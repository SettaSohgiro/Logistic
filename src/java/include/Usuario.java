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
public class Usuario {

    public Usuario(){} 

    private String  	ID	;
    private String  	NOMBRE	;
private String  	PATERNO	;
private String  	MATERNO	;
private String  	DIRECCION	;
private String  	TELEFONO	;
private String  	TELEFONO2	;
private String  	MAIL	;
private String  	USUARIO	;
private String  	PASS	;
private String  	COMUNA	;
private String  	REGION	;
private String  	PROVINCIA	;
private String  	RUT	;
private String  	ESTADO	;
private String  	ROL	;
private String  	NOMBRE_EMPRESA	;
private String  	RUT_EMPRESA	;
private String  	PAIS_EMPRESA	;
private String  	DIRECCION_EMPRESA	;
private String  	TELEFONO_EMPRESA	;
private String  	CORREO_EMPRESA	;

    public Usuario(String ID, String NOMBRE, String PATERNO, String MATERNO, String DIRECCION, String TELEFONO, String TELEFONO2, String MAIL, String USUARIO, String PASS, String COMUNA, String REGION, String PROVINCIA, String RUT, String ESTADO, String ROL, String NOMBRE_EMPRESA, String RUT_EMPRESA, String PAIS_EMPRESA, String DIRECCION_EMPRESA, String TELEFONO_EMPRESA, String CORREO_EMPRESA) {
        this.ID = ID;
        this.NOMBRE = NOMBRE;
        this.PATERNO = PATERNO;
        this.MATERNO = MATERNO;
        this.DIRECCION = DIRECCION;
        this.TELEFONO = TELEFONO;
        this.TELEFONO2 = TELEFONO2;
        this.MAIL = MAIL;
        this.USUARIO = USUARIO;
        this.PASS = PASS;
        this.COMUNA = COMUNA;
        this.REGION = REGION;
        this.PROVINCIA = PROVINCIA;
        this.RUT = RUT;
        this.ESTADO = ESTADO;
        this.ROL = ROL;
        this.NOMBRE_EMPRESA = NOMBRE_EMPRESA;
        this.RUT_EMPRESA = RUT_EMPRESA;
        this.PAIS_EMPRESA = PAIS_EMPRESA;
        this.DIRECCION_EMPRESA = DIRECCION_EMPRESA;
        this.TELEFONO_EMPRESA = TELEFONO_EMPRESA;
        this.CORREO_EMPRESA = CORREO_EMPRESA;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getPATERNO() {
        return PATERNO;
    }

    public void setPATERNO(String PATERNO) {
        this.PATERNO = PATERNO;
    }

    public String getMATERNO() {
        return MATERNO;
    }

    public void setMATERNO(String MATERNO) {
        this.MATERNO = MATERNO;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public String getTELEFONO2() {
        return TELEFONO2;
    }

    public void setTELEFONO2(String TELEFONO2) {
        this.TELEFONO2 = TELEFONO2;
    }

    public String getMAIL() {
        return MAIL;
    }

    public void setMAIL(String MAIL) {
        this.MAIL = MAIL;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    public String getPASS() {
        return PASS;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }

    public String getCOMUNA() {
        return COMUNA;
    }

    public void setCOMUNA(String COMUNA) {
        this.COMUNA = COMUNA;
    }

    public String getREGION() {
        return REGION;
    }

    public void setREGION(String REGION) {
        this.REGION = REGION;
    }

    public String getPROVINCIA() {
        return PROVINCIA;
    }

    public void setPROVINCIA(String PROVINCIA) {
        this.PROVINCIA = PROVINCIA;
    }

    public String getRUT() {
        return RUT;
    }

    public void setRUT(String RUT) {
        this.RUT = RUT;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

    public String getROL() {
        return ROL;
    }

    public void setROL(String ROL) {
        this.ROL = ROL;
    }

    public String getNOMBRE_EMPRESA() {
        return NOMBRE_EMPRESA;
    }

    public void setNOMBRE_EMPRESA(String NOMBRE_EMPRESA) {
        this.NOMBRE_EMPRESA = NOMBRE_EMPRESA;
    }

    public String getRUT_EMPRESA() {
        return RUT_EMPRESA;
    }

    public void setRUT_EMPRESA(String RUT_EMPRESA) {
        this.RUT_EMPRESA = RUT_EMPRESA;
    }

    public String getPAIS_EMPRESA() {
        return PAIS_EMPRESA;
    }

    public void setPAIS_EMPRESA(String PAIS_EMPRESA) {
        this.PAIS_EMPRESA = PAIS_EMPRESA;
    }

    public String getDIRECCION_EMPRESA() {
        return DIRECCION_EMPRESA;
    }

    public void setDIRECCION_EMPRESA(String DIRECCION_EMPRESA) {
        this.DIRECCION_EMPRESA = DIRECCION_EMPRESA;
    }

    public String getTELEFONO_EMPRESA() {
        return TELEFONO_EMPRESA;
    }

    public void setTELEFONO_EMPRESA(String TELEFONO_EMPRESA) {
        this.TELEFONO_EMPRESA = TELEFONO_EMPRESA;
    }

    public String getCORREO_EMPRESA() {
        return CORREO_EMPRESA;
    }

    public void setCORREO_EMPRESA(String CORREO_EMPRESA) {
        this.CORREO_EMPRESA = CORREO_EMPRESA;
    }

  

   
}
