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
public class Productor {
    private int id_productor;
    private String nombre_productor;
    private String direccion;
    private String telefono;
    private String fk_rut_usuario;

    public Productor() {
    }

    public Productor(int id_productor, String nombre_productor, String direccion, String telefono, String fk_rut_usuario) {
        this.id_productor = id_productor;
        this.nombre_productor = nombre_productor;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fk_rut_usuario = fk_rut_usuario;
    }

    public int getId_productor() {
        return id_productor;
    }

    public void setId_productor(int id_productor) {
        this.id_productor = id_productor;
    }

    public String getNombre_productor() {
        return nombre_productor;
    }

    public void setNombre_productor(String nombre_productor) {
        this.nombre_productor = nombre_productor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFk_rut_usuario() {
        return fk_rut_usuario;
    }

    public void setFk_rut_usuario(String fk_rut_usuario) {
        this.fk_rut_usuario = fk_rut_usuario;
    }
    
}
