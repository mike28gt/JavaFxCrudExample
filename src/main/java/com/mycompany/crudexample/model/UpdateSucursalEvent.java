/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudexample.model;

/**
 *
 * @author miguelcatalan
 */
public class UpdateSucursalEvent {
    
    private Sucursal sucursal;
    
    public UpdateSucursalEvent(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
    public Sucursal getSucursal() {
        return sucursal;
    }
}   
