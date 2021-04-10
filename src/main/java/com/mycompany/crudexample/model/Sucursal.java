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
public class Sucursal {
    private int codigo;
    private String nombre;
    private String ciudad;

    public Sucursal(int codigo, String nombre, String ciudad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "codigo=" + codigo + ", nombre=" + nombre + ", ciudad=" + ciudad + '}';
    }
}
