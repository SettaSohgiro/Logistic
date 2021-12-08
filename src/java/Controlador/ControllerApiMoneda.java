/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.ModeloApiMoneda;
import include.apimoneda;

/**
 *
 * @author Lee
 */
public class ControllerApiMoneda {
    
        public boolean crear_Apimoneda(apimoneda u) {
        ModeloApiMoneda modelapi = new ModeloApiMoneda();
        return modelapi.crear_moneda(u);
        
    }
        
}
